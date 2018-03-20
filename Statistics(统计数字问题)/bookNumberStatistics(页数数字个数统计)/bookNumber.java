package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * ����������
 *     һ������1--nҳ��ͳ������ҳ���г��ֵ�0-9�����ֵĸ�����ҳ����û��01��001��001...�ȱ�ʾ����
 * �㷨������
 *     ����һ����ҳ��������forѭ�����Լ��ַ��ָ�����ַ���ƥ�䣬�Ӷ�ʹ��ƥ����ַ���������,���ĵ����
 * �㷨ʱ�临�Ӷȷ�����
 *     ����������forѭ����ʱ�临�Ӷ�Ϊ��O(N)
 *     ������Ǹ�for�������Ϊ1λ����ѭ��N
 *     �����λ2λ����ѭ��2N
 *     �����λ3λ����ѭ��3N
 *     .....
 *     ������������ʱ�临�Ӷ�ΪmO(N),m��һ������
 *     
 *     �����������������ǣ�mO(N^2)
 *     ����ʱ�临�Ӷȣ�O(N^2)
 *     
 */
public class bookNumber {

	public static int[] NumberStatistics(int pages) {
		//��ͨ��ֵд��
		/*int zero=0;
		int one=0;
		int two=0;
		int three=0;
		int four=0;
		int five=0;
		int six=0;
		int seven=0;
		int eight=0;
		int nine=0;*/
		//��̴��룬��������,number[0]-number[9]����0-9
		int[] number= {0,0,0,0,0,0,0,0,0,0};
		char[] compare;
		for(int i=1;i<=pages;i++) {
			String str=String.valueOf(i);//��int��ת��Ϊ�ַ���
			compare=str.toCharArray();//�ָ��ַ���
			for(int j=0;j<compare.length;j++) {
				if(compare[j]=='9') {
					number[9]++;
				}
				if(compare[j]=='8') {
					number[8]++;
				}
				if(compare[j]=='7') {
					number[7]++;
				}
				if(compare[j]=='6') {
					number[6]++;
				}
				if(compare[j]=='5') {
					number[5]++;
				}
				if(compare[j]=='4') {
					number[4]++;
				}
				if(compare[j]=='3') {
					number[3]++;
				}
				if(compare[j]=='2') {
					number[2]++;
				}
				if(compare[j]=='1') {
					number[1]++;
				}
				if(compare[j]=='0') {
					number[0]++;
				}
				
			}
		}
	 return number;
		
		
	}
	public static void main(String[] args)throws IOException {
		
		String str;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("��������ҳ����");
		str=buf.readLine();
		int page=Integer.parseInt(str);
		int[] result=NumberStatistics(page);
		System.out.println("0-9���ֵĸ���Ϊ��----------------------");
		System.out.println("0: "+result[0]);
		System.out.println("1: "+result[1]);
		System.out.println("2: "+result[2]);
		System.out.println("3: "+result[3]);
		System.out.println("4: "+result[4]);
		System.out.println("5: "+result[5]);
		System.out.println("6: "+result[6]);
		System.out.println("7: "+result[7]);
		System.out.println("8: "+result[8]);
		System.out.println("9: "+result[9]);
		
		
	}
}
