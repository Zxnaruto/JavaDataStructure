package test;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     �������һ�����ϣ�������������������ִ�����
 * ���������
 *     ��һ����ʱ�����������ÿ�������ִ�����ֵ��Ȼ���ҳ����Ĵ�����Ϊ���Ĵ�����
 *     Ȼ��ͨ������ʱ������бȴ�С�����������������ԭ�����е�λ�ã�Ȼ���������
 *     �͸�����
 * ʱ�临�Ӷȣ�
 *    Mode(): O(N^2)+2O(N)
 * ���㣺
 *    ���Ƕ��ڶ����������ͬ�������������������Ļ������磺{2��2��3��3}�������������ȷ���������Ľ���
 *    ͬʱ���㷨Ҳ���ԸĽ���
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class modeProblem {

	public static void Mode(int[] Array) {
		int max = 0;//���������ֵ
		int smax=0;//�������е�λ��
		int num=0;
		int[] temp=new int[Array.length];//������ʱ����洢����ĸ���ֵ
		//����ÿ�����ڼ����еĸ���
		for(int i=0;i<Array.length;i++) {
			for(int j=0;j<Array.length;j++) {
				if(Array[i]==Array[j]) {
					temp[i]++;
					
				}
			}
			
		}
		for(int i=0;i<temp.length;i++) {
			if(temp[i]==1) {
				num++;
			}
		}
		if(num==temp.length) {
			System.out.println("ÿһ������������");
			System.exit(0);
		}else {
		
		
		//��������
		for(int i=1;i<temp.length;i++) {//i���㿪ʼ��Ϊ�˷�ֹ����һ����
			if(temp[0]<=temp[i]) {
				temp[0]=temp[i];
				max=temp[0];
				smax=i;
			
			}
		
			
			
		}
		
		System.out.println("�����ǣ�"+Array[smax]+" "+"�����ǣ�"+max);}
		
	}
	//��ں���
	public static void main(String[] args)throws IOException {
		String str,str1;
		int[] numbers;
		int length;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���������鳤�ȣ�");
		str=buf.readLine();
		length=Integer.parseInt(str);
		numbers=new int[length];
		System.out.println("����������Ԫ�أ�");
		for(int i=0;i<numbers.length;i++) {
			str1=buf.readLine();
			numbers[i]=Integer.parseInt(str1);
		}
		
		Mode(numbers);
	}
}
