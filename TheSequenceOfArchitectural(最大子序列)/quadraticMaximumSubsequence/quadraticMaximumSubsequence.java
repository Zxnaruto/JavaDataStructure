import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * ������������㷨�ĸĽ���ʱ�临�Ӷ�ΪO(N^2)
 * ��һ��forѭ�����ƺ͵���ʼλ�ã���ʼʱ���±�Ϊ0��ʼ���
 * �ڶ���Ϊ��͵����ĸ���
 * ��������ֵ
 */
public class quadraticMaximumSubsequence {
	//�����������
	public static int maxSubSum(int[] Array) {
		int maxSum=0;//�ٽ�ֵ����ʼΪ0��ȡ�������ֵ
		for(int i=0;i<Array.length;i++) {
			int thisSum=0;//ÿһ�ֳ�ʼΪ0����һ��ֵ�������������
			for(int j=i;j<Array.length;j++) {
				thisSum+=Array[j];
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
