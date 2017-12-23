package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ��N��Ԫ�ض������飬Ȼ��Ը�����ִ��BuildHeap�㷨�����ǽ���
 *  N��Ԫ�ؽ��н��ѣ���ȻҲ���Ա߶����߽��ѣ����Ӹö�����ȡ��kԪ�ؾ��Ǵ𰸡�
 *  �Ƚ�����С�ѣ���ν��С�Ѿ��Ǹ��ڵ��ֵС���ӽڵ�Ķ�������Ȼ������ѽ��н�������
 *  ͨ�����ڵ�ı任�����ӽڵ������Ĵ��棬����ʹ�öѽ���2�������Եõ�����
 * ���㷨��ʱ�临�Ӷ�ΪO(N)
 */
public class selectionProblem03 {
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
		long StartTime = System.nanoTime();
		BuildHeap(a, N);
		HeapSort(a, N);
		k = N / 2;
		System.out.println("�����" + a[k - 1]);
		long EndTime = System.nanoTime();
		System.out.println("ʱ�䣺" + (EndTime - StartTime) + "ns");

	}
    //������
	public static void HeapSort(int[] array, int length) {
		BuildHeap(array, length);
		for (int i = length - 1; i >= 1; i--) {
			Swap(array, 0, i);
			length--;
			PercolateDown(array, 0, length);
		}
	}
    //������С��
	public static void BuildHeap(int[] array, int length) {
		for (int i = length / 2 - 1; i >= 0; i--) {
			PercolateDown(array, i, length);

		}
	}
    //����Ԫ������
	public static void PercolateDown(int[] array, int index, int length) {
		int min;
		while (index * 2 + 1 < length) {
			min = index * 2 + 1;
			if (index * 2 + 2 < length) {
				if (array[min] > array[index * 2 + 2]) {
					min = index * 2 + 2;
				}
			}
			if (array[index] < array[min]) {
				break;
			} else {
				Swap(array, index, min);
				index = min;
			}
		}
	}
    //����
	public static void Swap(int[] array, int a, int b) {
		int temp;
		temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
}
