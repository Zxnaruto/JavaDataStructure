package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *这是时间复杂度为O(n^2)
 *输入个数为N的一个数组
 *采用简单的冒泡排序，或选择排序求k=N/2
 *并计算其运行时间
 */
public class selectionProblem01 {
	public static String str,str1;
	public static BufferedReader buf;
	public static int N;
	public static int[] a;
	
	public static void main(String[] args)throws IOException {
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入你想输入数组的长度:");
		str=buf.readLine();
		N=Integer.parseInt(str);
		System.out.println("请输入数组：");
		a=new int[N];
		for(int i=0;i<N;i++) {
			str1=buf.readLine();
			a[i]=Integer.parseInt(str1);
		}
		Msort(a,N,N/2);
		System.out.println("\n"+"-------------------------------");
		Csort(a,N,N/2);
	}
	//冒泡排序
	public static void Msort(int[] array,int length,int k) {

		int temp;
		long StartTime=System.nanoTime();
		for(int i=0;i<length-1;i++) {
			for(int j=0;j<length-1-i;j++) {
				if(array[j]<array[j+1]) {
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
			
		}
		System.out.println("第"+k+"个值为："+array[k-1]);
		long EndTime=System.nanoTime();
		System.out.println("冒泡时间为："+(EndTime-StartTime)+"ns");
		System.out.println("冒泡排序后结果：");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	//选择排序
	public static void Csort(int[] array,int length,int k) {
		int temp,t;
		long StartTime=System.nanoTime();
		for(int i=0;i<length-1;i++) {
			t=i;
			for(int j=1+i;j<length;j++) {
				if(array[j]>array[t]) {
					t=j;
					temp=array[t];
					array[t]=array[i];
					array[i]=temp;
					
				}
			}
		}
		
		System.out.println("\n"+"第"+k+"个值为："+array[k-1]);
		long EndTime=System.nanoTime();
		System.out.println("选择时间为："+(EndTime-StartTime)+"ns");
		System.out.println("选择排序后结果：");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
	}
}





