package test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Administrator
 * 
 * ����������
 *     ���һ���㷨����Ĳ�����Χ��1~n��m�����������Ҫ����m�������������ͬ��
 * ���������
 *     ����ǰ������������������������Ͻ����������ֵ���η�������array,ÿ�η���ǰ������Ƿ����������е�����ͬ�������ͬ�����룬�����ͬ
 *     ���룬ֱ�����������
 *     ����ͨ��for��while�������ɲ��ظ���ֵ��1~n֮�䣬�����0���������ʼ��ʱֵ0�������ڱȽϵ�ʱ���Ѿ����������ˣ��Ͳ��õ���������ˡ�
 *     1.x�������ֵ(�������ɵ�������ı�)��
 *     2.k while������������������Ԫ�ظ���Ϊ�����Ա������ɵ��������ԭ�����Ƿ����ظ���
 *     3.j�����±��1��ʼΪ�˷�ֹ��whileѭ�����±�Խ�磬�������ĵ�������Ҫ��1��ʼ������
 *     4.n��Χ��m����
 *     5.a,b������������ɴ�����������a<b��ʾ���������Ԫ��û���ظ��ģ�a>b��ʾ���ظ�����ʱ���鲻��ֵ�������ı䣬Ȼ����һ��ѭ������������ڱȽ�
 * ʱ�临�Ӷȷ���:
 *     
 */
public class RandomTest {
 public static void main(String[] args)throws IOException {
	 
	 int n,m,k,a = 0,b,x,j=1;
	 String str,str1;
	 BufferedReader buf;
	 buf=new BufferedReader(new InputStreamReader(System.in));
	 NotSpillRandomGenerator test=new  NotSpillRandomGenerator();//�����������Ķ���
	 System.out.print("������ķ�ΧΪ(1~n)��������n =");
	 str=buf.readLine();
	 n=Integer.parseInt(str);
	 System.out.print("������Ҫ������������ĸ���(m<n)m =");
	 str1=buf.readLine();
	 m=Integer.parseInt(str1);
	 int[] array=new int[m+1];//��ֹ�����±�Խ�硣
	 System.out.print(m+"��������Ľ��Ϊ��");
	 for(int i=0;i<m;i++) {//����������Ĵ���������m�ı䣬��m�����Ƿ����ظ�ֵ���ı䡣
		b=m;//��������
	    k=1;//ÿ�ζ����¸�ֵ1
	    x=test.randomInt()%n;//���������
	    while(k<=j) {
	    	if(x==array[k]) {
	    		m=m+1;//�������ȵ����ѭ��һ��
	    		a=m;//��������
	    		break;
	    	}
	    	k++;
	    }
	    if(a>b) {//�ж�m�Ƿ�ı�
	    	continue;
	    }else {
	    	array[j]=x;//��������
	    	j++;
	    }
      }
	//���
    for(int i=1;i<array.length;i++) {
     System.out.print(array[i]+" ");
	}
	
 }
 
}
