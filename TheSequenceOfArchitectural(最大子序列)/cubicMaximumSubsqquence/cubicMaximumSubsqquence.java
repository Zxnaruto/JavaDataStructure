import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 最大子序列：一个数组中取若干数（数是按数组连续的）求和，取出最大的和值，这个序列可能为一个，可能为多个或整个数组。
 * 这是一个简单的求最大子序列的程序，该算法的时间复杂度为O(n^3)
 *
 *第一层for循环控制，序列起始和的位置，从0--n-1
 *第二个控制和的数的个数
 *第三个求和
 *if控制和的最大值，如果有下一次循环的和大于上一次的，则更新最大值
 *循环完毕，返回最大值
 */
public class cubicMaximumSubsqquence {

	//求最大子序列的值
	public static int maxSubSum(int[] Array) {
		int maxSum=0;//临界值，取和中最大的值
		for(int i=0;i<Array.length;i++) {
			for(int j=i;j<Array.length;j++) {
				int thisSum=0;
				for(int k=i;k<=j;k++) {
					thisSum+=Array[k];
				}
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
