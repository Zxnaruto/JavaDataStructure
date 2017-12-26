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
		System.out.print("���������鳤�ȣ�");
		str = buf.readLine();
		N = Integer.parseInt(str);
		System.out.println("����������Ԫ�أ�");
		a = new int[N];
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		SelectionSortImprovement(a,N);
		System.out.print("ѡ������Ľ�������");
		for (int i = 0; i < N; i++) {
			System.out.print(a[i] + " ");
		}
	}
	// �Ľ�ѡ������,��Ԫѡ�����򷨣�һ��ѭ��ѡ��һ�����ֵ��һ����Сֵ���������ͷ��β
		public static void SelectionSortImprovement(int[] array, int length) {
			int max, min, i, j, temp;
			for (i = 0; i <length/2; i++) {
				min = i;
				max = i;
				
				for (j = i+1; j <=length-i-1; j++) {
					if (array[j] > array[max]) {
						max = j;
						continue;//�ҵ���ǰ�˵����ֵ����ѭ��������һ��ȥ��ֵ
					}
					if (array[j] < array[min]) {//�ҵ���ǰ����Сֵ
						min = j;
					}
				}
			
				temp=array[i];
				array[i]=array[min];
			     array[min]=temp;
			     /*
			      *if �����ã�ÿһ��ѭ������������ҵ����Ǹ�max��λ�ò�����i����԰���
			      *ԭ���Ĵ��ֵ��n-1,С��ֵ��0�������max==i,����������֮ǰ��a[i]�ı仯�����Ѿ�
			      *����ԭ�����Ǹ�ֵ�ˣ����ԣ�Ϊ�˽�ԭ�����Ǹ�ֵ����a[n-1],����if���жϡ�
			      *֮������������ԭ�������������һ��ͬʱ������ֵ��һ����� ��һ����С��
			      *�������С�Ǹ�ֵʱ�ı���ԭ���ҵ������ֵ������������ִ�������
			      *��Ȼ�����ʼλ�ò�ͬ����Ͱ�else�ߣ�����һ�����������Ϊ���Ͻ������Լ��ϵġ� 
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
