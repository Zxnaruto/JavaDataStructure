package DiYiZhang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class simpleSelectionSortImprove {

	public static void main(String[] args) throws IOException {
		String str, str1;
		int N;
		int[] a;
		BufferedReader buf;
		buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入数组长度：");
		str = buf.readLine();
		N = Integer.parseInt(str);
		System.out.println("请输入数组元素：");
		a = new int[N];
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		SelectionSortImprovement(a,N);
		System.out.print("选择排序改进后结果：");
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
	}
	// 改进选择排序,二元选择排序法，一次循环选出一个最大值和一个最小值放在数组的头与尾
		public static void SelectionSortImprovement(int[] array, int length) {
			int max, min, i, j, temp;
			for (i = 0; i <length/2; i++) {
				min = i;
				max = i;
				
				for (j = i+1; j <=length-i-1; j++) {
					if (array[j] > array[max]) {
						max = j;
						continue;//找到当前趟的最大值，当循环完了这一次去赋值
					}
					if (array[j] < array[min]) {//找到当前趟最小值
						min = j;
					}
				}
			
				temp=array[i];
				array[i]=array[min];
			     array[min]=temp;
			     /*
			      *if 的作用，每一次循环交换，如果找到的那个max的位置不等于i则可以按照
			      *原来的大的值给n-1,小的值给0，但如果max==i,则由于在这之前有a[i]的变化，它已经
			      *不是原来的那个值了，所以，为了将原来的那个值赋给a[n-1],就用if做判断。
			      *之所以这样做的原因是这个排序是一次同时找两个值，一个最大 ，一个最小。
			      *如果在最小那赋值时改变了原有找到的最大值的情况，则会出现错误结果。
			      *当然如果起始位置不同，则就按else走，这是一种特殊情况，为了严谨，所以加上的。 
			      */
			     if(max==i) {
			    	 temp=array[length-i-1];
			    	 array[length-i-1]=array[min];
			    	 array[min]=temp;
			     }else {
			    	 temp=array[length-i-1];
			    	 array[length-i-1]=array[max];
			    	 array[max]=temp;
			     }
				
				
				
			}
		}
		
		
}
