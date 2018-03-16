import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * ������������У���ʱ�临�Ӷ������Եġ�
 * ʱ�临�Ӷȣ�O(N)
 * �����൱�������鳤��һ�εݼ���ÿ�εݼ�������ʼλ��+1��Ȼ�����ÿһ���е����ֵ�����Ӷ�ͨ���Ƚ����
 * ���ֵ��
 *
 */
public class linearTimeMaxmumSubsequence {

	//����������е�ֵ
	public static int maxSubSum(int[] Array) {
		int maxSum=0,thisSum=0;
		for(int i=0;i<Array.length;i++) {
			thisSum+=Array[i];
			if(thisSum>maxSum) {
				maxSum=thisSum;
			}else {
				thisSum=0;
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
