package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *����һ���򵥵�ѡ������ 
 * 
 */
public class simpleSelectionSort {

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
		SelectionSort(a,N);
		System.out.print("ѡ����������");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
	public static void SelectionSort(int[] array,int length) {
		int temp,t;
		for(int i=0;i<length-1;i++) {
			t=i;//ÿһ��Ҫ��ֵ��λ�ã���һ��array[0]...array[length-1]
			for(int j=1+i;j<length;j++) {
				if(array[j]<array[t]) {
					t=j;
					temp=array[t];
					array[t]=array[i];
					array[i]=temp;
					
				}
			}
		}
	}
}
