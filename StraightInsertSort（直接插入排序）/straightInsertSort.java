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
		System.out.println("请输入数组长度：");
		str = buf.readLine();
		N = Integer.parseInt(str);
		System.out.println("请输入数组：");
		a = new int[N];
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		InsertSort(a,N);
		System.out.println("插入排序后结果：");
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}

	}

	public static void InsertSort(int[] array, int length) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {//如果前面的大于后面的则交换位置，否则位置不变
				int j = i - 1;
				int x = array[i];// 复制哨兵，防止在插入时数组越界
				array[i] = array[i - 1];//先后移一个元素，类似与临时temp的作用，留出一个空位，留给插入或传递的元素
				/*循环比较前临时数组中的数将其排序*/
				while (x < array[j]) {//和所取哨兵进行比较，如果大于哨兵则后移，直到不大于哨兵
					array[j + 1] = array[j];
					j--;//元素移动，向前走，判断前面还有没有大于哨兵的
				}
				array[j + 1] = x;//将哨兵放到正确位置，+1是因为前面的循环多减了个1
			}
		}
	}
}
