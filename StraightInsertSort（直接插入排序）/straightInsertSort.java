package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class straightInsertSort {

	public static void main(String[] args) throws IOException {
		String str, str1;
		int N;
		int[] a;
		BufferedReader buf;
		buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���������鳤�ȣ�");
		str = buf.readLine();
		N = Integer.parseInt(str);
		System.out.println("���������飺");
		a = new int[N];
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		InsertSort(a,N);
		System.out.println("�������������");
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public static void InsertSort(int[] array, int length) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {//���ǰ��Ĵ��ں�����򽻻�λ�ã�����λ�ò���
				int j = i - 1;
				int x = array[i];// �����ڱ�����ֹ�ڲ���ʱ����Խ��
				array[i] = array[i - 1];//�Ⱥ���һ��Ԫ�أ���������ʱtemp�����ã�����һ����λ����������򴫵ݵ�Ԫ��
				/*ѭ���Ƚ�ǰ��ʱ�����е�����������*/
				while (x < array[j]) {//����ȡ�ڱ����бȽϣ���������ڱ�����ƣ�ֱ���������ڱ�
					array[j + 1] = array[j];
					j--;//Ԫ���ƶ�����ǰ�ߣ��ж�ǰ�滹��û�д����ڱ���
				}
				array[j + 1] = x;//���ڱ��ŵ���ȷλ�ã�+1����Ϊǰ���ѭ������˸�1
			}
		}
	}
}
