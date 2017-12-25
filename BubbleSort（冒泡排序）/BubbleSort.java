package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *ð�������������ָĽ�
 */
public class BubbleSort {

	public static void main(String[] args)throws IOException {
		String str,str1;
		int N;
		int[] a;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���������鳤�ȣ�");
		str=buf.readLine();
		N=Integer.parseInt(str);
		System.out.println("����������Ԫ�أ�");
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
		System.out.println("ԭʼ�㷨ʱ�䣺"+(EndTime-StartTime));
		System.out.println("�Ľ�1�㷨ʱ�䣺"+(EndTime1-StartTime1));
		System.out.println("�Ľ�2�㷨ʱ�䣺"+(EndTime2-StartTime2));
	}
	//ԭʼð����������
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
		System.out.print("���1��");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	//�Ľ�1�����ñ�־λ����ֹ����Ҫ��ѭ��
    public static void bubbleSortG1(int[] array,int length) {
    	int temp;
    	int i=length-1;
		while(i>0) {
			int pos=0;//ÿ�˿�ʼ�޼�¼����
			for(int j=0;j<i;j++) {
				if(array[j]>array[j+1]) {
					pos=j;//��¼����λ��
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
			i=pos;//Ϊ��һ����׼��
		}
		System.out.print("���2��");
		for(int x=0;x<length;x++) {
			System.out.print(array[x]+" ");
		}
	}
    //�Ľ�2��һ��ѡ������ֵ
    public static void bubbleSortG2(int[] array,int length) {
		int max=length-1;
		int min=0;
		int temp;
		while(min<max) {
			for(int j=min;j<max;j++) {//�����ҵ������
				if(array[j]>array[j+1]) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			--max;//������
			for(int j=max;j>min;--j) {//�����ҵ���С��
				if(array[j]<array[j-1]) {
					temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
			++min;//������
		}
		System.out.print("���3��");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
		}
	}


