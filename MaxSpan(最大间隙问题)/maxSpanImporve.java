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
 *     �������Ϊ���֣�
 *     1.�����Ϊ��������������������ҲΪ��������ֱ�������
 *     2.����ΪΪ��������������������Ϊ����������������ȥ������
 *     3.�����Ϊ��������������������Ϊ����������������ȥ������
 *     4.��Ϊ������������Ǳ�Ϊ�����������
 *     
 *     ����ֻ�Ǵ��Եķ���һ�£�
 *     ������������Ϊ������������Ϊ����������0���õ�������
 *     
 *     Ȼ�����ۺϴ���̨�ķ������ȿ�����������ϵ�����϶
 * ʱ�临�Ӷȷ�����
 *     ����Ҳֻ��һ��forѭ��������ʱ�临�Ӷ�ΪO(N)
 *     
 *     ��˵��ǰ����Ǹ�ֻ�����ķ�Χ�����������ʱ�临�Ӷ�Ҳ��O(N),��Ƚ��������Ĵ���Ҫ���Ǹ�����һЩ���ǲ����������ϵĲ��
 *     ����ʱ�临�Ӷ�Ҳ��O(N)
 */
public class maxSpanImporve {

	//MaxSpanImporve
	public static long MaxSpanImporve(long x,long[] Array) {
		//�׶�һ: �ѱȽ�ֱ��Ϊ����
		//temp�����̨����Ļ������൱��a[0],temp1�൱�������е���������result��Ϊ��Ҫ���صĽ��
		long temp1=0,temp = 0;
		long StartTime=System.nanoTime();
		//����������������Ϊ����
	    if(x>=0&&Array[0]>=0) {
	    	temp=Array[0]-x;
	    	if(temp<0) {
	    		temp=0-temp;
	    	}
	    }
	    if(x<0&&Array[0]>=0) {
	    	temp=Array[0]-x;
	    }
	    if(x>=0&&Array[0]<0) {
	    	temp=x-Array[0];
	    }
	    if(x<0&&Array[0]<0) {
	    	temp=0-x-Array[0];
	    }
		//��Ҫ�Ƚϵ�������Ϊ�����������Ƚ�
		for(int i=1;i<Array.length;i++) {
		
			if(x>=0&&Array[i]>=0) {
		    	temp1=Array[i]-x;
		    	if(temp1<0) {
		    		temp1=0-temp1;
		    	}
		    }else if(x<0&&Array[i]>=0) {
		    	temp1=Array[0]-x;
		    }else if(x>=0&&Array[i]<0) {
		    	temp1=x-Array[i];
		    }else{
		    	temp1=(0-Array[i])-(0-x);
		    	if(temp1<0) {
		    		temp1=0-temp1;
		    	}
		    }
		    
		    if(temp<temp1) {
		    	temp=temp1;
		    
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
			
			System.out.println("����϶Ϊ��"+MaxSpanImporve(temp,array));
		}
}
