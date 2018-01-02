package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellSort {
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
		ShellSort(a,N);
		long EndTime=System.nanoTime();
		System.out.println("结果：");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("\n"+"花费时间："+(EndTime-StartTime)+"ns");
	}
	public static void InsertSort(int[] array,int length,int k) {
		for (int i = k; i < array.length; i++) {
			if (array[i] < array[i - k]) {//如果前面的大于后面的则交换位置，否则位置不变
				int j = i - k;
				int x = array[i];// 复制哨兵，防止在插入时数组越界
				array[i] = array[i - k];//先后移一个元素，类似与临时temp的作用，留出一个空位，留给插入或传递的元素
				/*循环比较前临时数组中的数将其排序,j>=0是为了防止数组下标越界*/
				while (j>=0&&x < array[j]) {//和所取哨兵进行比较，如果大于哨兵则后移，直到不大于哨兵
					array[j + k] = array[j];
					j-=k;
				}
				array[j + k] = x;//将哨兵放到正确位置，+k是因为前面的循环多减了个k
			}
		}
	}
	public static void ShellSort(int[] array,int length) {
		int k=length/2;
		while(k>=1) {
			InsertSort(array,length,k);
			k=k/2;
		}
	}
	
}
