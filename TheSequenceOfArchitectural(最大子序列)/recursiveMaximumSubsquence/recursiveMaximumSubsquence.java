import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 这是用分治思想的递归方法来求最大子序列的和
 * 
 * 起时间复杂度为：(两个for是O(N),两个递归是2T(N/2))
 *   T(1)=1,T(N)=N+2T(N/2)
 * 推导：
 *      T(2)=2+2T(1)=2*2=4        2^1=2, 2*(1+1)
 *      T(4)=4+2T(2)=4*3=12       2^2=4, 4*(2+1)
 *      T(8)=8+2T(4)==8*4=32      2^3=8, 8*(3+1)
 *      .......
 *      N=2^k,k=logN
 *      T(2^k)=2^k+2T(2^(k-1))=N*(k+1)=N+NlogN
 *      所以T(N)=NlogN
 * 
 * 
 * 通过把数组分为两个部分，分别对两个部分进行递归，并求出左边的最大值，右边的最大值，以及
 * 加上左右边界的最大值的和（即左边递归的部分加上右边递归的部分，该递归是从中间向两边依次求和的）
 * 然后再看这三个值那个最大，最大的值即为最大子序列的和的值
 * 
 * 缺点：目前这个算法只针对N为偶数，要是也可算奇数的话，还需改进。
 *
 */
public class recursiveMaximumSubsquence {

	//求两边最大子序列的和后，在与边界进行和
	private static int maxSumRec(int[] Array,int left,int right) {
		if(left==right) 
		if(left>0){//base case
			return Array[left];	
		}else {
			return 0;
		}
		
		int center= (left+right)/2;//最外层（除下面两个递归的最大值，即左、右两边的和的最大值）
		int maxLeftSum=maxSumRec(Array,left,center);//求出除了最大层的值的和（左边的和）
		int maxRightSum=maxSumRec(Array,center+1,right);//右边的和（循环的次数减一后的继续循环的值）
		int maxLeftBorderSum=0,leftBorderSum=0;
		for(int i=center;i>=left;i--) {//求出左边一半的最大值
			leftBorderSum+=Array[i];
			if(leftBorderSum>maxLeftBorderSum) {
				maxLeftBorderSum=leftBorderSum;
			}
		}
		
		int maxRightBorderSum=0,rightBorderSum=0;
		for(int i=center+1;i<=right;i++) {//求出右边一半的最大值
			rightBorderSum+=Array[i];
			if(rightBorderSum>maxRightBorderSum) {
				maxRightBorderSum=rightBorderSum;
			}
		}
		return compare(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);//maxLeftBorderSum+maxRightBorderSum是每次循环后算上最外层的和，即加上边界值的和
	}
	//求最大子序列的和
	public static int maxSubSum(int[] Array) {
		return maxSumRec(Array,0,Array.length-1);
	}
	//比较函数
	public static int compare(int a,int b,int c) {
		int max=0;
		if(a>=b&&a>=c) {
			max=a;
		}
		if(b>=a&&b>=c) {
			max=b;
		}
		if(c>=a&&c>=b) {
			max=c;
		}
		
		return max;
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
