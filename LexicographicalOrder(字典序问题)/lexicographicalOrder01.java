package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     �����ݼ��ܺ�����ѹ���г�����Ҫ��������ַ������б��룬��������ĸ��A��26��Сд��Ӣ����ĸ��ɣ�
 *     ����ĸ������������ַ�����ָ�ַ�������ĸ�����ҳ��ֵĴ�������ĸ����ĸ���г��ֵĴ�����ͬ����
 *     ÿ���ַ�������1�Σ��������ⳤ�Ȳ�����6�������ַ���Ѹ�ټ���������ֵ��еı��롣
 * �ѵ㣺
 *     ����ĸ����������ϣ��Լ���εó��ֵ���
 * ���������
 *     ���½�һ���ַ������飬����a-z��Ȼ�����������ַ���˳���ҳ��Ȳ�����6������ϣ������õ�forѭ��
 *     ��������ϡ��ֱ�Ϊһ�����������������ĸ�������������ַ�Ϊһ�顣Ȼ����бȽϣ����������ڽ��з�
 *     ���ʱ��ͽ��бȽϣ�����ҵ����˳����򣬲����������ѭ�������Ч�ʡ�
 *     ����������count��������������������ڵ�1��ѭ����û���������ѭ���Ĵ��������������ҵ�ʱ��λ��
 *     �Ϳ��Եó��ֵ���
 *     ��ĸ���飺����ÿ��ѭ���ĵ�һ����ĸΪ��׼����������ĸ��
 * �㷨��ʱ�临�Ӷȷ�����
 *   1.ͨ��forѭ����ѭ��Ƕ�ף�
 *     һ����ĸΪһ��ʱ��Ȼһ��for������N��ѭ��������N=26����
 *     
 *     ������ĸʱ������������ϣ���Ҫ����for�������ҪN-1��(���һ����ĸ����Ϊ����ĸ)���ڲ���Ҫ��i��
 *     �仯�������ڶ�����ĸ��ʲô����aΪ��һ��ʱ���ڶ���ֻ����b�Ժ�ģ����Եڶ����е�jҪ����һ����
 *     ����i�ı仯����һ������ΪҪ��ϵ����һ����ĸ�������ڲ�ѭ���Ŀ�������Ҫ��N��
 *     
 *     ������ĸ���ʱ����Ҫ����for,�������ҪN-2��(���һ������ĸΪ����������)���м��Ҳ��Ҫͨ��i������
 *     ��һ����ĸ��ʲô������ѭ������������С��N-1��������Ϊ���ǵڶ�����ĸ������ȡ������ĵ����ڶ�������
 *     ��������ȡ��(����Ͳ��ǰ�˳����)�����һ����Ҫ��һ���j�������������Լ�ѭ����������С��N
 *     
 *     ͨ�������������ǿ��Եõ����¹��ɣ�
 *      //������ĸ
		for(int i=0;i<N;i++)
		
		//������ĸ
		for(int i=0;i<N-1;i++)
		for(int j=i+1;j<N;j++)
		
		//������ĸ
		for(int i=0;i<N-2;i++)
	    for(int j=1+i;j<N-1;j++)
		for(int k=1+j;k<N;k++) 
		
		...........
		//x����ĸ
		��Ҫx��for,
		�����ѭ��������N-(x-1)
		�ڲ�ѭ��������N-(x-1-1.......) ֱ�������еĵ���0
		
		ǰ�����������
		0
		j=i+1
		k=j+1
		l=k+1
		........
		����ǰ��+1
	 2.ʱ�临�Ӷȣ�
	   	һ����ĸO(N)
	   	������ĸ��N-1+N-2+N-3.....+N-N
	   	       lim=N^2-2N
	   	       O(N^2)
	   	�������ƣ�
	   	������ĸO(N^3)
	   	�ĸ���ĸO(N^4)
	   	�����ĸO(N^5)
	   	������ĸO(N^6)
	   	
	   	���ԣ��ۺϣ����T(N)=O(N),�T(N)=O(N^6)
	   	���Ƕ�N�����ȵ��ַ��������Բ�����6����ĸ������Ե�
 *         
 *     
 *
 */
public class lexicographicalOrder01 {

	
	public static void main(String[] args)throws IOException {
		
		String[] array= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","d","u","v","w","x","y","z"};
		String str1="abcdefghijklmnopqrstuvwxyz";
		int count=0,count1=0,count2=0,count3=0,count4=0,count5=0;//������
		boolean flag=true;
		
		BufferedReader buf;
		String str;
		
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������Ҫ���ҵ��ַ�(a-g֮�䲻�ظ��ĳ��Ȳ�����6����)��");
		str=buf.readLine();
		char[] length=str.toCharArray();//�ж������ַ�������
		for(int i=0;i<length.length;i++) {//�ж������Ƿ���ȷ
			if(str1.indexOf(length[i])<0) {
				System.out.println("��������з���ĸ�ģ��������󣡣���");
				System.exit(0);
			}
		}
		if(length.length>6||length.length<=0) {//���ȴ���6��С�ڵ���0��l��ʾ�������
			System.out.println("�����������󣡣���");
		}else {
		
		//������ĸ
		for(int i=0;i<26;i++) {
			count++;
			if(str.equals(array[i])) {//����ҵ�
				System.out.println(str+"���ֵ���Ϊ��"+count);
				System.exit(0);//����ҵ�������ѭ��,Ҳ����ѭ������
			}
			
		}
		
		//������ĸ
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				count1++;
				if(str.equals((array[i]+array[j]))) {
					System.out.println(str+"���ֵ���Ϊ��"+(count+count1));
					System.exit(0);//����ҵ�������ѭ��,Ҳ����ѭ������
				}
			}
		}
		//������ĸ
		for(int i=0;i<array.length-2;i++) {
			for(int j=1+i;j<array.length-1;j++) {
				for(int k=1+j;k<array.length;k++) {
					count2++;
					if(str.equals((array[i]+array[j]+array[k]))) {
						System.out.println(str+"���ֵ���Ϊ��"+(count+count1+count2));
						System.exit(0);//����ҵ�������ѭ��,Ҳ����ѭ������
					}
				}
			}
		}
		//�ĸ���ĸ
		for(int i=0;i<array.length-3;i++) {
			for(int j=1+i;j<array.length-2;j++) {
				for(int k=1+j;k<array.length-1;k++) {
					for(int l=1+k;l<array.length;l++) {
						
						count3++;
						if(str.equals((array[i]+array[j]+array[k]+array[l]))) {
							System.out.println(str+"���ֵ���Ϊ��"+(count+count1+count2+count3));
							System.exit(0);//����ҵ�������ѭ��,Ҳ����ѭ������
						}
						
					}
				
				}
			}
		}
		//�����ĸ
		for(int i=0;i<array.length-4;i++) {
			for(int j=1+i;j<array.length-3;j++) {
				for(int k=1+j;k<array.length-2;k++) {
					for(int l=1+k;l<array.length-1;l++) {
						for(int m=1+l;m<array.length;m++) {
							
							count4++;
							if(str.equals((array[i]+array[j]+array[k]+array[l]+array[m]))) {
								System.out.println(str+"���ֵ���Ϊ��"+(count+count1+count2+count3+count4));
								System.exit(0);//����ҵ�������ѭ��,Ҳ����ѭ������
							}
							
						}
					
					}
				
				}
			}
		}
		//������ĸ
		for(int i=0;i<array.length-5;i++) {
			for(int j=1+i;j<array.length-4;j++) {
				for(int k=1+j;k<array.length-3;k++) {
					for(int l=1+k;l<array.length-2;l++) {
						for(int m=1+l;m<array.length-1;m++) {
							for(int n=1+m;n<array.length;n++) {
								
								count5++;
								if(str.equals((array[i]+array[j]+array[k]+array[l]+array[m]+array[n]))) {
									System.out.println(str+"���ֵ���Ϊ��"+(count+count1+count2+count3+count4+count5));
									System.exit(0);//����ҵ�������ѭ��,Ҳ����ѭ������
								}
							}
						
						}
					
					}
				
				}
			}
		}
		
		System.out.println("�����������ַ������ֵ��У�����");
		}
		
		
	}
}
