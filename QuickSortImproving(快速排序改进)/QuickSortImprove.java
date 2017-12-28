package DiYiZhang;
/**
 * ��������Ľ�����һ������ֵ����������ķ�����������鳤�ȴ��ڿ���ֵ��
 * �����һ�ο�������ʹ֮����Ȼ���ڽ��в�����������ʱ����������١�
 * ����ͽ��в�������
 * @author XiaoHuZiXianShengZx
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortImprove {
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
		QuickSortImp(a,N-1,5);
		System.out.println("�����");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
public static int[]  QuickSort(int[] array,int low,int high,int k) {
		if(high-low>k){//���ȴ���kʱ�ݹ�, kΪָ������ 
		if(low>=high) {//�ж������������
			return array;
		}
		int diserve=Chick(array,low,high);//������Key��λ��,�����е�һ������
		QuickSort(array,low,diserve-1,k);//��Key�ָ�����
		QuickSort(array,diserve+1,high,k);
		
		}
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
	
	public static void QuickSortImp(int[] array,int high,int k) {
		QuickSort(array,0,high,k);//�ȵ��øĽ��㷨ʹ����������� 

		//���ò�������Ի���������������  
		    for(int i=1; i<=high;i ++){  
		        int temp = array[i];   
		        int j=i-1;  
		        while(temp < array[j]){  
		            array[j+1]=array[j]; 
		            j--;
		        }  
		        array[j+1] = temp;  
		    }   
	}
}
