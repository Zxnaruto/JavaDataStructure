package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *����ʱ�临�Ӷ�ΪO(n^2)
 *�������ΪN��һ������
 *���ü򵥵�ð�����򣬻�ѡ��������k=N/2
 *������������ʱ��
 */
public class selectionProblem01 {
	public static String str,str1;
	public static BufferedReader buf;
	public static int N;
	public static int[] a;
	
	public static void main(String[] args)throws IOException {
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������������������ĳ���:");
		str=buf.readLine();
		N=Integer.parseInt(str);
		System.out.println("���������飺");
		a=new int[N];
		for(int i=0;i<N;i++) {
			str1=buf.readLine();
			a[i]=Integer.parseInt(str1);
		}
		Msort(a,N,N/2);
		System.out.println("\n"+"-------------------------------");
		Csort(a,N,N/2);
	}
	//ð������
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
		System.out.println("��"+k+"��ֵΪ��"+array[k-1]);
		long EndTime=System.nanoTime();
		System.out.println("ð��ʱ��Ϊ��"+(EndTime-StartTime)+"ns");
		System.out.println("ð�����������");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	//ѡ������
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
		
		System.out.println("\n"+"��"+k+"��ֵΪ��"+array[k-1]);
		long EndTime=System.nanoTime();
		System.out.println("ѡ��ʱ��Ϊ��"+(EndTime-StartTime)+"ns");
		System.out.println("ѡ�����������");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
	}
}





