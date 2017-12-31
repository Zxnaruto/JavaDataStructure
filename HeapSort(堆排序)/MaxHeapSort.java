package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxHeapSort {
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
	   long EndTime = System.nanoTime();
	   System.out.println("������������");
	   for(int i=N-1;i>=0;i--) {
		   System.out.print(a[i]+" ");
	   }
		System.out.println("\n"+"ʱ�䣺" + (EndTime - StartTime) + "ns");

	}
    //�����򣬾��ǰ�������ĸ�Ԫ��ȡ����ʣ�µ�Ԫ���ٴι����ѣ�Ȼ����ȡ��������ģ�ֱ��i=1,ȡ�������м�Ϊ�ź����
	public static void HeapSort(int[] array, int length) {
		BuildHeap(array, length);
		for (int i = length - 1; i >= 1; i--) {
			Swap(array, 0, i);
			length--;
			PercolateDown(array, 0, length);
		}
	}
    //��������
	public static void BuildHeap(int[] array, int length) {
		for (int i = length / 2 - 1; i >= 0; i--) {
			PercolateDown(array, i, length);

		}
	}
    //���Ѷ���Ԫ������
	public static void PercolateDown(int[] array, int index, int length) {
		int max;
		while (index * 2 + 1 < length) {
			max = index * 2 + 1;//��ڵ�
			if (index * 2 + 2 < length) {
				if (array[max] < array[index * 2 + 2]) {
					max= index * 2 + 2;//�ҽڵ�
				}
			}
			if (array[index] > array[max]) {//������ڵ�����������˳�
				break;
			} else {
				Swap(array, index, max);//�Ѵ���ӽڵ���С�ģ���������,index���㿪ʼ
				index = max;//����һ�������ֱ��ȫ�����
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
