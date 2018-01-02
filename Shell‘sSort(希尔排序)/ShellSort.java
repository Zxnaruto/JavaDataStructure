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
		System.out.print("������������������鳤�ȣ�");
		str = buf.readLine();
		N = Integer.parseInt(str);
		a = new int[N];
		System.out.println("���������飺");
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		long StartTime=System.nanoTime();
		ShellSort(a,N);
		long EndTime=System.nanoTime();
		System.out.println("�����");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("\n"+"����ʱ�䣺"+(EndTime-StartTime)+"ns");
	}
	public static void InsertSort(int[] array,int length,int k) {
		for (int i = k; i < array.length; i++) {
			if (array[i] < array[i - k]) {//���ǰ��Ĵ��ں�����򽻻�λ�ã�����λ�ò���
				int j = i - k;
				int x = array[i];// �����ڱ�����ֹ�ڲ���ʱ����Խ��
				array[i] = array[i - k];//�Ⱥ���һ��Ԫ�أ���������ʱtemp�����ã�����һ����λ����������򴫵ݵ�Ԫ��
				/*ѭ���Ƚ�ǰ��ʱ�����е�����������,j>=0��Ϊ�˷�ֹ�����±�Խ��*/
				while (j>=0&&x < array[j]) {//����ȡ�ڱ����бȽϣ���������ڱ�����ƣ�ֱ���������ڱ�
					array[j + k] = array[j];
					j-=k;
				}
				array[j + k] = x;//���ڱ��ŵ���ȷλ�ã�+k����Ϊǰ���ѭ������˸�k
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
