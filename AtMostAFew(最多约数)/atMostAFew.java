package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     ������������(a,b)��Լ�����ĵ���������a<=b
 *     ������x��Լ������������x����������
 *     
 * ʱ�临�Ӷ�Ϊ��
 *     ���b��������a,��ʱ�临�Ӷ�Ϊ��O(N)
 *     ����ʱ�临�Ӷ�Ϊ��2O(N)
 */
public class atMostAFew {

	public static int mostFew(int a,int b)throws IOException {
		int number=0;
		int anumber=0;
		int bnumber=0;
		if(a>b) {
			System.out.println("����������ȷ����Ϊa<=b,���������룺");
			String str,str1;
			BufferedReader buf;
			buf=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("������������a=");
	        str=buf.readLine();
	        a=Integer.parseInt(str);
	        System.out.print("������������b=");
	        str1=buf.readLine();
	       b=Integer.parseInt(str1);
	        
		}
		//���b������a����b��Լ��Ҫ����a
		if(b%a==0) {
			for(int i=1;i<=b;i++){
				if(b%i==0) {
					number++;
				}
			}
		}else {
			for(int i=1;i<=a;i++) {
				if(a%i==0) {
					anumber++;
				}
			}
			for(int j=1;j<=b;j++) {
				if(b%j==0) {
					bnumber++;
				}
			}
			if(anumber>bnumber) {
				number=anumber;
			}else {
				number=bnumber;
			}
		}
		
		return number;
		
	}
	//��ں���
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������������a=");
        str=buf.readLine();
        int a=Integer.parseInt(str);
        System.out.print("������������b=");
        str1=buf.readLine();
        int b=Integer.parseInt(str1);
        System.out.println("���Լ���ĸ���Ϊ��"+mostFew(a,b));
        
	}
}
