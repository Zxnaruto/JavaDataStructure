package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ���������⣺
 *     ����һ����Ȼ��n����n��ʼ�������β���������set(n)�е������£�
 *     (1)n����set(n)
 *     (2)��n����߼���һ����Ȼ�������������ܳ�������������һ��
 *     (3)���˹�����д���ֱ�������������Ȼ��Ϊֹ��
 *     ���磺����n=6;
 *     set(n)={6,16,26,126,36,136}
 * 
 * ����취��
 *     ���÷��η����������֪��
 *     (1)���ȣ�������Ĺ�ģ��С��һ���̶ȿ��Ժ����׵Ľ�������磬n=1,2,3
 *     (2)���Խ��������ϸ��Ϊ�ܶ��С�Ĳ��֣����磺����һ��n=6,�����������1/2(����1/2�ĸ���forѭ��,����Ҳ��һ��)������1/2����
 *     û������1/2������һֱ��ȥ��ֱ��n=1;����ֻҪ
 *     
 */
public class halfOfTheSet {

	public static int count=0;//��̬���������ڹ��������У����ã�����ʹ��ֵ�������ӡ�
	//�Ҹ�������
	public static int HalfOfTheSet(int n) {
		
	   
		if(n<=0){
			System.out.println("��������!!!");
		}else {
			
		for(int i=1;i<=n/2;i++) {
				count++;
				if(i/2>=1) {
					HalfOfTheSet(i);
				}
			}
		
	
		}	
		
		
		return count+1;//��1����Ϊ�����䱾��
		
	}
	//��ں���
    public static void main(String[] args)throws IOException {
    	String str;
    	int n;
    	BufferedReader buf;
    	buf=new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("������һ��������������ĸ�����");
    	str=buf.readLine();
    	n=Integer.parseInt(str);
    	System.out.println(n+"�İ���������Ϊ��"+HalfOfTheSet(n));
    	
    }
}
