package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 *这是用另一种方法进行选择排序，
 *先将数组前k个元素读到一个临时数组，然后进行降序排序，
 *用后面的元素逐一与临时数组的最后一个比较，如果大于它则放到临时数组里，
 *同时去掉临时数组最后一个元素在排序。
 *直到所有元素比较结束，临时数组的第k个元素即为所要值。 
 *该算法的平均运行时间为O(N⋅k)，但是最差时间为O(N^2)
 */
public class selectionProblem02 {

	public static int[] a,temp;
	public static BufferedReader buf;
	public static String str,str1;
	public static int N,k,t,k1;
	public static void main(String[] args)throws IOException {
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入你想输入的数组长度：");
		str=buf.readLine();
		N=Integer.parseInt(str);
		a=new int[N];
		System.out.println("请输入数组：");
		for(int i=0;i<N;i++) {
			str1=buf.readLine();
			a[i]=Integer.parseInt(str1);
		}
		k=N/2;
		temp=new int[k];
		temp=Arrays.copyOf(a, k);
		sort(temp,k);
		
		long StartTime=System.nanoTime();
		for(int i=k;i<N;i++) {
			if(temp[k-1]<a[i]) {
			
				temp[k-1]=a[i];
				for(int j=k-1;j>0;j--) {
					if(a[i]>temp[j-1]) {
						temp[j]=temp[j-1];
						temp[j-1]=a[i];
					}
				}
				/*for(int j=0;j<k-1;j++) {
					k1=j;
					for(int l=j+1;l<k;l++) {
						if(temp[k1]<temp[l]) {
							k1=l;
							t=temp[k1];
							temp[k1]=temp[j];
							temp[j]=t;
						}
					}
				}*/
			}
		}
	
		System.out.println("第"+k+"个值为："+temp[k-1]);
		long EndTime=System.nanoTime();
		System.out.println("运行时间为："+(EndTime-StartTime)+"ns");
		
	}
	public static void sort(int[] array,int length) {
		int temp;
		for(int i=0;i<length-1;i++) {
			for(int j=0;j<length-1-i;j++) {
				if(array[j]<array[j+1]) {
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
		}
	}
	
}
