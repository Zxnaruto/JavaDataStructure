package DiYiZhang;
/**
 * ��������
 * @author XiaoHuZiXianShengZx
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quickSort {
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
		QuickSort(a,0,N-1);
		System.out.println("�����");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
	public static int[]  QuickSort(int[] array,int low,int high) {
		
		if(low>=high) {//�ж������������
			return array;
		}
		int diserve=Chick(array,low,high);//������Key��λ��,�����е�һ������
		QuickSort(array,low,diserve-1);//��Key�ָ�����
		QuickSort(array,diserve+1,high);
		return array;
		
	}
	
	public static int Chick(int[] array,int low,int high) {
		int Key=array[low];
		while(low<high) {
			while(low<high&&array[high]>=Key) {//��С��Key�ķŵ�Key��ǰ��
				high--;}
			array[low]=array[high];
			while(low<high&&array[low]<=Key) {//������Key�ķŵ�Key�ĺ���
				low++;}
			array[high]=array[low];
		}
		array[low]=Key;//���Ŀ�λ��Keyֵ
		return low;//������ʱ�Ľ���λ�õ�ֵ����ɵ�һ������
		           // �������Ϊ��KeyΪ�ָ��������������QuickSort(array,low,diserve-1);Ϊǰһ�룬�ٴε����Լ�
	}              //�����һ���������յݹ��������ź��ˡ�
}
