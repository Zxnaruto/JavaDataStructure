package DiYiZhang;
/*原因：每次剩下的数都放在数组的最后，所以要倒叙输出才会得到大堆逆序，小堆正序*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinHeapSort {
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
	   long EndTime = System.nanoTime();
	   System.out.println("最大堆排序结果：");
	   for(int i=N-1;i>=0;i--) {
		   System.out.print(a[i]+" ");
	   }
		System.out.println("\n"+"时间：" + (EndTime - StartTime) + "ns");

	}
    //堆排序，就是把最上面的根元素取出，剩下的元素再次构建堆，然后在取出最上面的，直到i=1,取出的序列即为排好序的
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
    //最小堆顶层元素下滤
	public static void PercolateDown(int[] array, int index, int length) {
		int min;
		while (index * 2 + 1 < length) {
			min = index * 2 + 1;//左节点
			if (index * 2 + 2 < length) {
				if (array[min] > array[index * 2 + 2]) {
					min = index * 2 + 2;//右节点
				}
			}
			if (array[index] < array[min]) {//如果左右节点中有一个值大于其根节点则对出
				break;
			} else {
				Swap(array, index, min);//把小的子节点与大的（根）交换
				index = min;//下移一层继续，直到全部完成
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
