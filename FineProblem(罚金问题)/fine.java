package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ��������:
 *     ��1�������������ı仯��ֵΪ��2 4 16 256 65536........ Ҫ�����������㷣��
 *     ��2������������жϷ�������
 * ��������
 *     �Ӹ������������ǿ����ҵ����ɣ�money=2^2^(day-1)����ͨ���㷨��ʵ��������ɣ������õ�����forѭ��������
 *     ��һ��forѭ���������������Ǹ�2^(day-1),�����for���������ʽ�ӵ�ֵ����money.
 *     
 *     �������������ǿ���֪���ܽ���������Ľ��Ա��������Ľ��պ�С�ڵ��ڼ�����ܽ��ʱ�����ʱ��������Ϊ���������
 * ʱ�临�Ӷȷ�����
 *     ���㷣��
 *         ��day=Nʱ����һ��for��ʱ�临�Ӷ�ΪO(N-1),�ڶ���for��ʱ�临�Ӷ�Ϊ��O(2^2^(N-1))
 *         �����ۺϵ� ʱ�临�Ӷ�Ϊ��O(2^2^(N-1))
 *     ���������
 *         whileѭ����O(N), forѭ�� O((2^2^(N-1)/2))
 *         �����ۺϵ� ʱ�临�Ӷ�Ϊ��O((2^2^(N-1)/2))
 */  
public class fine {

	//���㷣��
	public static int Fine(int day) {
		int x=1;
		int fine=1;
		for(int i=0;i<day-1;i++) {
			x*=2;
		}
		for(int i=0;i<x;i++) {
			fine*=2;
		}
		
		return fine;
	}
	//��������������
	public static int days(int menoy) {
    boolean flag=true;
    int x=1;
    int fine=1;
    int day=0;
	while(flag) {
		day++;//����
		x*=2;//�����ܽ��ý��
	    for(int i=0;i<x/2;i++) {
			fine*=2;//�ܽ��
			if(menoy<=fine) {
				flag=false;//�ҵ��˳�ѭ��	
			}
		}
	}
		
		return day;
	}
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�����뷣��������");
		str=buf.readLine();
		int N=Integer.parseInt(str);
		System.out.print("������Ϊ��"+"$"+Fine(N)+"\n");
		
		System.out.print("����Ϊ��");
		str1=buf.readLine();
		int M=Integer.parseInt(str1);
		System.out.println("����Ϊ��"+days(M));
		
	}
}
