package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����϶���⣺
 * 
 * ����������
 *     ����һ�����������һ�������е�ÿһ�������бȽϣ���ֵ����Ϊ����϶��
 *     ���磺
 *         ���� 5
 *         �����뼯�� 5 8 9
 *         ������϶Ϊ 4
 * ����ʵ�֣�
 *     �����������飬�����ǵĲ���д���̨�Ƚϣ��ҳ�����϶
 * ʱ�临�Ӷȷ�����
 *     ���ʱ�临�Ӷ�����ֻ��һ��forѭ��������ʱ�临�Ӷ�Ϊ��O(N)  ����ָ����MaxSpan������ʱ�临�Ӷ�
 *       
 */
public class maxSpan {

	//MaxSpan ���ڲ�Ϊ����
	public static long MaxSpan(long x,long[] Array) {
		long temp=Array[0]-x;
		long StartTime=System.nanoTime();
		for(int i=1;i<Array.length;i++) {
		    if(temp<(Array[i]-x)) {
		    	temp=Array[i]-x;
	
		    }
		}
		long EndTime=System.nanoTime();
		System.out.println("�㷨����ʱ��Ϊ��"+(EndTime-StartTime)+"ns");
		return temp;
	}
	//��ں���
	public static void main(String[] args)throws IOException {
		String str,str1,str2;
		BufferedReader buf;
		
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������Ҫ�Ƚϵ�����");
		str=buf.readLine();
		long temp=Long.parseLong(str);
		System.out.print("������Ҫ�Ƚϵ�����ĳ��ȣ�");
		str1=buf.readLine();
		int length=Integer.parseInt(str1);
		long array[]=new long[length];
		System.out.println("���������飺");
		for(int i=0;i<length;i++) {
			str2=buf.readLine();
			array[i]=Long.parseLong(str2);
			
		}
		
		System.out.println("����϶Ϊ��"+MaxSpan(temp,array));
	}
}
