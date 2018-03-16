import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 计算最大子序列，其时间复杂度是线性的。
 * 时间复杂度：O(N)
 * 即：相当于以数组长度一次递减（每次递减数组起始位置+1，然后计算每一趟中的最大值），从而通过比较求出
 * 最大值。
 *
 */
public class linearTimeMaxmumSubsequence {

	//求最大子序列的值
	public static int maxSubSum(int[] Array) {
		int maxSum=0,thisSum=0;
		for(int i=0;i<Array.length;i++) {
			thisSum+=Array[i];
			if(thisSum>maxSum) {
				maxSum=thisSum;
			}else {
				thisSum=0;
			}
		}
		return maxSum;
	}
	//入口函数
	public static void main(String[] args) throws IOException{
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		int array[];
		int length;//数组长度
		System.out.println("请输入数组的长度：");
		str=buf.readLine();
		length=Integer.parseInt(str);
		array=new int[length];
		System.out.println("请输入数组元素：");
		for(int i=0;i<length;i++) {
			str1=buf.readLine();
			array[i]=Integer.parseInt(str1);
		}
		System.out.println("输入的数组为：");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("\n"+"最大子序列的值为："+ maxSubSum(array));
		
	}
}
