package DiYiZhang;
/*ϣ������Ľ��������Ǵ�������������,�����˼�벻��
 * ������ͨ��һ������k���Ƴ�ʼλ�õ�ֵ��Ŀ��λ�ã���ʼλ�ü�����ֵ��λ��ֵ����ֵ������ֱ������k����1֮�󣬽������һ��
 * �������򣬵õ������
 *  @author XiaoHuZiXianShengZx 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellSortImprove {
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
		long StartTime=System.nanoTime();
		ShellSortImprove(a,N);
		long EndTime=System.nanoTime();
		System.out.println("�����");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("\n"+"����ʱ�䣺"+(EndTime-StartTime)+"ns");
	}
	//
	public static void ShellSortImprove(int[] array,int length) {
		int k;//����
		int i,j,temp;
		for(k=length/2;k>0;k/=2) {//��k/2��ʼ
			for(i=k;i<length;i++) {//����λ�ã���ʼλ�ú�Ŀ��λ��
				for(j=i-k;j>=0&&array[j]>array[j+k];j-=k) {
					/*ֱ�ӽ���λ��*/
				     temp = array[j];
					array[j] = array[j+k];
					array[j+k] = temp;
				}
			}
		}
		
	}
	
	
	

}
