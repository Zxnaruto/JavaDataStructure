import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ͨ���ݹ�����Ч����������Ľ��
 * 
 * ���������ٸ����ӣ�
 *     n=ż����x^n=x^(n/2)*x^(n/2)
 *      x^8=x*x*x^2*x^4;ֻ��Ҫ������,ԭ����Ҫ7�����
 *     n=������x^n=x^(n-1/2)*x^(n-1/2)*x
 *     x^9=x*x*x^2*x^4*x;��Ҫ���ĴΣ�ԭ����Ҫ8�����
 *     ע��һ�������O(1)
 *     
 *     ����ԭ��N-1��һ�����ң�����ʱ�临�Ӷ�ΪO(logN)
 *
 */
public class powerOperation {

	//�ݹ���˻��ķ���
	public static long pow(long x,int n) {
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return x;
		}
		if(isEven(n)==0) {
			return pow(x*x,n/2);
		}else {
			return pow(x*x,n/2)*x;
		}
	}
	//�ж�n����ż��
	public static long isEven(int a) {
		
		if(a%2==0) {
			return 0;
		}else {
			return 1;
		}
		
	}
	//��ں���
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�����������");
		str=buf.readLine();
		long x=Long.parseLong(str);
		System.out.print("������������");
		str1=buf.readLine();
		int n=Integer.parseInt(str1);
		System.out.print(x+"��"+n+"�η�="+pow(x,n));
		
	}
}
