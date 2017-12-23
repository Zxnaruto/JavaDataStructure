package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 将N个元素读入数组，然后对该数组执行BuildHeap算法（就是将这
 *  N个元素进行建堆，当然也可以边读数边建堆）。从该堆中提取的k元素就是答案。
 *  先建立最小堆，所谓最小堆就是父节点的值小于子节点的二叉树。然后对最大堆进行降序排序。
 *  通过根节点的变换，其子节点中最大的代替，最终使得堆降到2，即可以得到排序。
 * 该算法的时间复杂度为O(N)
 */
public class selectionProblem03 {
	public static String str, str1;
	public static int N, k;
	public static int[] a;
	public static BufferedReader buf;

	public static void main(String[] args) throws IOException {

		buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入你想输入的数组长度：");
		str = buf.readLine();
		N = Integer.parseInt(str);
		a = new int[N];
		System.out.println("请输入数组：");
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		long StartTime = System.nanoTime();
		BuildHeap(a, N);
		HeapSort(a, N);
		k = N / 2;
		System.out.println("结果：" + a[k - 1]);
		long EndTime = System.nanoTime();
		System.out.println("时间：" + (EndTime - StartTime) + "ns");

	}
    //堆排序
	public static void HeapSort(int[] array, int length) {
		BuildHeap(array, length);
		for (int i = length - 1; i >= 1; i--) {
			Swap(array, 0, i);
			length--;
			PercolateDown(array, 0, length);
		}
	}
    //建立最小堆
	public static void BuildHeap(int[] array, int length) {
		for (int i = length / 2 - 1; i >= 0; i--) {
			PercolateDown(array, i, length);

		}
	}
    //顶层元素下滤
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
    //交换
	public static void Swap(int[] array, int a, int b) {
		int temp;
		temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
}
