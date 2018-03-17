import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * binary search(�۰����)�����Ѿ��ź����Ԫ�أ�ȡ�м������Ҫ���ҵ������бȽϣ��������
 * �����м������ѷ�Χ������벿�֣�Ȼ����ȡ��벿�ֵ��м�ֵ�������˲��裬ֱ���ҵ���û��
 * ���������С�ڷ�����Ҳ��һ���ģ�
 * 
 * �㷨ʱ�临�Ӷȷ�����
 * whlieѭ��ѭ���������ǣ�high-low>-1
 * ����ѭ���ڵ�ִ��ʱ��ΪO(1),���Թؼ�Ҫ��ѭ��������
 * �ٸ����ӣ�һ��16������������Ҫѭ����0-15����
 *          15->7
 *          7->3
 *          3->1     
 *          1->0
 *          0->-1
 *          ��Ҫ���    2^(5-1)=16   
 *          һ��8���������飺
 *          7->3
 *          3->1
 *          1->0
 *          0->-1
 *          ��Ҫ�Ĵ�   2^(4-1)=8
 *          
 *          �����Դ����� N=2^(k-1) 
 *          k=log(N-1)
 *          
 *          �����ڸ�ֵ���ʱ��ΪO(1)
 *          ���� T(N)=log(N-1)+2
 *          
 *          �򻯵�ʱ�临�Ӷȣ�logN
 */
public class binarySearch {

	//�۰���ҷ���
	public static int bSearch(int[] Array,int x) {
		int low=0,high=Array.length-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(Array[mid]<x) {
				low=mid+1;
			}else if(Array[mid]>x) {
				high=mid-1;
			}else {
				return mid;//�ҵ���
			}
			
		}
		return -1;//û�ҵ�
	}
	//���
	public static  void main(String[] args) throws IOException{
	
		int[] array= {1,2,3,4,5,6};
		String str;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������Ҫ���ҵ�����");
		str=buf.readLine();
		int x=Integer.parseInt(str);
		System.out.println("������ҵ������������λ��û���򷵻�-1����"+bSearch(array,x));
		
		
	}
}
