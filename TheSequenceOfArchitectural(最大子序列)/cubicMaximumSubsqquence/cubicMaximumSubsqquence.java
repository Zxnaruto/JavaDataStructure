import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * ��������У�һ��������ȡ�����������ǰ����������ģ���ͣ�ȡ�����ĺ�ֵ��������п���Ϊһ��������Ϊ������������顣
 * ����һ���򵥵�����������еĳ��򣬸��㷨��ʱ�临�Ӷ�ΪO(n^3)
 *
 *��һ��forѭ�����ƣ�������ʼ�͵�λ�ã���0--n-1
 *�ڶ������ƺ͵����ĸ���
 *���������
 *if���ƺ͵����ֵ���������һ��ѭ���ĺʹ�����һ�εģ���������ֵ
 *ѭ����ϣ��������ֵ
 */
public class cubicMaximumSubsqquence {

	//����������е�ֵ
	public static int maxSubSum(int[] Array) {
		int maxSum=0;//�ٽ�ֵ��ȡ��������ֵ
		for(int i=0;i<Array.length;i++) {
			for(int j=i;j<Array.length;j++) {
				int thisSum=0;
				for(int k=i;k<=j;k++) {
					thisSum+=Array[k];
				}
				if(thisSum>maxSum) {
					maxSum=thisSum;
				}
			}
		}
		return maxSum;
	}
	//��ں���
	public static void main(String[] args) throws IOException{
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		int array[];
		int length;//���鳤��
		System.out.println("����������ĳ��ȣ�");
		str=buf.readLine();
		length=Integer.parseInt(str);
		array=new int[length];
		System.out.println("����������Ԫ�أ�");
		for(int i=0;i<length;i++) {
			str1=buf.readLine();
			array[i]=Integer.parseInt(str1);
		}
		System.out.println("���������Ϊ��");
		for(int i=0;i<length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.print("\n"+"��������е�ֵΪ��"+ maxSubSum(array));
		
	}
}
