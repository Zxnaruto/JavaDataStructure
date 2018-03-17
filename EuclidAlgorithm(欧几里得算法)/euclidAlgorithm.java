import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ŷ������㷨��������������������������������ͬʱ����������������������
 * ͨ���ô�����С������ȡ������ֱ������Ϊ��ʱ���õ������һ��
 * �ķ��������������������������
 * 
 * �㷨ʱ�临�Ӷȷ�����
 * ��whileѭ���У�ÿһ�ε�ʱ�临�Ӷ�ΪO(1),
 * ����ֵռһ��ʱ�䵥Ԫ����ʱ�临�ӶȵĽǶȣ���Щ�����Ժ��ԣ�
 * ���Թؼ�����while��ѭ����������һ����ȡ����������еĳ��ȡ�
 * ���������ǰ��������ӵݼ��ģ����Բ�̫���㣬����ѭ������O(1),��
 * ѭ�����������N��˵������һ���֣����Դ�Ź��Ƹ��㷨��ʱ�临�Ӷ�ΪO(logN)
 * 
 */
public class euclidAlgorithm {

	//�㷨
	public static long gcd(long m,long n) {
		while(n!=0) {
			/*���m<n���򽻻�m��n��ֵ
			  �ô�����С��ȡ�ֱ࣬��ȡ�����һ��
			  ��Ϊ���������Ϊ���������
			  ���ڴ�����С��ȡ��֮����������������������е�����һ����
			  ����С�������������������������տ��Եõ������*/
			long rem=m%n;
			m=n;         
			n=rem;
		}
		return m;
	}
	//��ں���
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������m=");
		str=buf.readLine();
		long m=Long.parseLong(str);
		System.out.print("������n=");
		str1=buf.readLine();
		long n=Long.parseLong(str1);
		
		System.out.println("m��n���������Ϊ��"+gcd(m,n));
	}
}
