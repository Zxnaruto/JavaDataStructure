package DiYiZhang;
/*希尔排序改进，这里是代码行数的缩减,其核心思想不变
 * 即还是通过一个增量k控制初始位置的值与目标位置（初始位置加增量值的位置值）的值交换，直到增量k等于1之后，进行最后一次
 * 插入排序，得到结果。
 *  @author XiaoHuZiXianShengZx 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellSortImprove {
	public static String str, str1;
	public static int N, k;
	public static int[] a;
	public static BufferedReader buf;

	public static void main(String[] args) throws IOException {

		buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入你想输入的数组长度：");
		str = buf.readLine();
		N = Integer.parseInt(str);
		a = new int[N];
		System.out.println("请输入数组：");
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		long StartTime=System.nanoTime();
		ShellSortImprove(a,N);
		long EndTime=System.nanoTime();
		System.out.println("结果：");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("\n"+"花费时间："+(EndTime-StartTime)+"ns");
	}
	//
	public static void ShellSortImprove(int[] array,int length) {
		int k;//增量
		int i,j,temp;
		for(k=length/2;k>0;k/=2) {//从k/2开始
			for(i=k;i<length;i++) {//控制位置，初始位置和目标位置
				for(j=i-k;j>=0&&array[j]>array[j+k];j-=k) {
					/*直接交换位置*/
				     temp = array[j];
					array[j] = array[j+k];
					array[j+k] = temp;
				}
			}
		}
		
	}
	
	
	

}
