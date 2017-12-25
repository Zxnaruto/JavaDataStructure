package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *冒泡排序与其两种改进
 */
public class BubbleSort {

	public static void main(String[] args)throws IOException {
		String str,str1;
		int N;
		int[] a;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入数组长度：");
		str=buf.readLine();
		N=Integer.parseInt(str);
		System.out.println("请输入数组元素：");
		a=new int[N];
		for(int i=0;i<N;i++) {
			str1=buf.readLine();
			a[i]=Integer.parseInt(str1);
		}
		long StartTime=System.nanoTime();
		bubbleSort(a,N);
		long EndTime=System.nanoTime();
		System.out.println();
		long StartTime1=System.nanoTime();
		bubbleSortG1(a,N);
		long EndTime1=System.nanoTime();
		System.out.println();
		long StartTime2=System.nanoTime();
		bubbleSortG2(a,N);
		long EndTime2=System.nanoTime();
		System.out.println();
		System.out.println("原始算法时间："+(EndTime-StartTime));
		System.out.println("改进1算法时间："+(EndTime1-StartTime1));
		System.out.println("改进2算法时间："+(EndTime2-StartTime2));
	}
	//原始冒泡排序升序
	public static void bubbleSort(int[] array,int length) {
		int temp;
		for(int i=0;i<length-1;i++) {
			for(int j=0;j<length-1-i;j++) {
				if(array[j]>array[j+1]) {
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
			}
		System.out.print("结果1：");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	//改进1，设置标志位，防止不必要的循环
    public static void bubbleSortG1(int[] array,int length) {
    	int temp;
    	int i=length-1;
		while(i>0) {
			int pos=0;//每趟开始无记录交换
			for(int j=0;j<i;j++) {
				if(array[j]>array[j+1]) {
					pos=j;//记录交换位置
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
			i=pos;//为下一趟做准备
		}
		System.out.print("结果2：");
		for(int x=0;x<length;x++) {
			System.out.print(array[x]+" ");
		}
	}
    //改进2，一次选出两个值
    public static void bubbleSortG2(int[] array,int length) {
		int max=length-1;
		int min=0;
		int temp;
		while(min<max) {
			for(int j=min;j<max;j++) {//正向找到最大者
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			--max;//向上移
			for(int j=max;j>min;--j) {//反向找到最小这
				if(array[j]<array[j-1]) {
					temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
			++min;//向下移
		}
		System.out.print("结果3：");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
		}
	}


