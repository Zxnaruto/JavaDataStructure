import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 对最大子序列算法的改进，时间复杂度为O(N^2)
 * 第一层for循环控制和的起始位置，开始时从下标为0开始求和
 * 第二层为求和的数的个数
 * 返回最大和值
 */
public class quadraticMaximumSubsequence {
	//求最大子序列
	public static int maxSubSum(int[] Array) {
		int maxSum=0;//临界值，初始为0，取和中最大值
		for(int i=0;i<Array.length;i++) {
			int thisSum=0;//每一轮初始为0，哪一轮值最大则结果就是它
			for(int j=i;j<Array.length;j++) {
				thisSum+=Array[j];
				if(thisSum>maxSum) {
					maxSum=thisSum;
				}
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
