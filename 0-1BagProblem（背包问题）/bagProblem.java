package test;
/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     ����һ���̶�����capacity�İ�������Ŀ(number)��������Ʒ��������Ʒ������ֵ���������ڸ���������ǰ���£�ʹ��װ����Ʒ�ļ�ֵ���
 *     �����װ����Ʒ������ֵ�Լ���װ����Ʒ����š�
 * ���������
 *     ���ö�̬�滮���ͻ��ݷ���������⣬���л��ݷ������������š���̬�滮���ĺ���˼����ͨ���Ѵ�������Ϊ�ܶ��С���⣬ͨ���ô������
 *     С����ĵ��ƹ�ϵ��С�������ˣ����յõ�������Ľ⡣��Ȼ����̬�滮�����ɼ����Եģ������ÿ�μ���Ľ�������������ȵ��õ���ʱ��ֱ
 *     �ӵ��ã����������˺ܶ��ظ����㡣��Ҳ�Ƕ�̬�滮������η�������
 *     
 *     ���Ͽ�֪�����ǿ��԰ѱ��������ÿһ�εĽ⣬��һ����ά��������棬Ȼ�������Ǹ������Ϊ����Ľ⡣
 *     
 *     ���ȣ�����һ����ά����wv[number][2],�������Ʒ�������ͼ�ֵ��֮����������������Ϊ�˷��㵥��ȡ�������ֵ��Ϊ��������
 *     ���磺
 *            w      v
 *            2      3
 *            3      4
 *            
 *            ȡ����ʱֱ��wv[0][i],ֻ��i�Ϳ����ˣ���ֵ���ơ��������������á�
 *     
 *     ��������������ʼ���������ᵽ�ı��sheet��������������������������к��С��ֱ���sheet[i][0]=0,��sheet[0][j]=0
 *     ���������зֱ������������Ϊ0ʱ����Ȼ��Ȼ��Ʒ�Ų���ȥ������Ϊ��ֵ0����һ����ʾ����������û����Ʒ�����Լ�ֵҲΪ0��
 *     ��Ժ����ʼ��������Ҫ�����������ֵ�������������Ϊ�����ġ�
 *     
 *     ��������ʽ��ʼ�����������������һ��˼·��������⣺
 *         (1)����Ʒ����������ʣ������ʱ����ʱ����ԭ��ֵ���䡣
 *         (2)����Ʒ������С��ʣ������ʱ����ʱ������Է��룬����ʱװ��Ҳ��һ������������ֵ�����Ծ�Ҫ�Ƚ�ԭ�еļ�ֵ�ͷ����ļ�ֵ��ѡȡ���š�
 *         
 *         ���������仰д��α��ɵ��������������Ǿ����������������sheet
 *            if(wv[i-1][0]>j) {
					sheet[i][j]=sheet[i-1][j];//��ʱ��ֵ���䣬ʣ������Ҳ���䣬��ԭ��һ��
				}else {
					sheet[i][j]=max(sheet[i-1][j],sheet[i-1][j-wv[i-1][0]]+wv[i-1][1]);//ѡȡ����
				}
				
				ע��wv[i-1][0]��ʾ���������Ʒ������j��ʾʣ��ɷ�����,wv[i-1][1]�����ֵ(֮����wv[i-1][0]����i-1����������������ά
				    ����sheet[][],��wv[][]��ʼ��ʱ��ϸ΢�Ĳ����������֤�����±겻Խ��)
			
			�����������������sheet,����sheet[number][capacity]��Ϊ����ֵ��(numberz��Ʒ������capacity�������)
			
	     �����������������ڸ�������������������û��ݷ����Ƶõ���ѡ������š�������ͨ��Find()�������Ұ������
	     ���ˣ��������������ֵ����ѡ�������ҳ����ˡ�
	     
    �㷨ʱ�临�Ӷȷ�����
      (1)��ʼ����Ʒ�����ͼ�ֵ: N
      (2)���(N+1)(capacity+1)
      (3)���¹���wv: 2N
      (4)���ݵݹ�: N
      (5)��������: N
      
          ��������� O(N)=O(cN)   (c�ǳ���)
      
      ��Ȼ�������Ż������磬����ȥ�����¹���wv�ȵȡ������Ľ���
 *         
 */ 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class bagProblem {
	
	//��ں���
	public static void main(String[] args)throws IOException {
		String str,str1,str2,str3;
		BufferedReader buf;
		int number;//��Ʒ��
		int capacity;//����
		
		buf=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("��������Ʒ������");
		
		str=buf.readLine();
		number=Integer.parseInt(str);
		System.out.print("��������������");
		str3=buf.readLine();
		capacity=Integer.parseInt(str3);
		int[][] wv=new int[number][2];
		System.out.println("��������Ʒ�������ͼ�ֵ��");
		//��ʼ����Ʒ�����ͼ�ֵ
		for(int i=0;i<number;i++) {
			for(int j=0;j<1;j++) {
				System.out.print("��"+(i+1)+"����Ʒ��������");
				str1=buf.readLine();
				wv[i][j]=Integer.parseInt(str1);
				System.out.print("��"+(i+1)+"����Ʒ�ļ�ֵ��");
				str2=buf.readLine();
				wv[i][j+1]=Integer.parseInt(str2);
			}
		}
       
		//���
		int sheet[][]=new int[number+1][capacity+1];
		//��ʼ��������
		for(int i=0;i<=number;i++) {
		   	sheet[i][0]=0;
		}
		for(int j=1;j<=capacity;j++) {
			sheet[0][j]=0;
		}
		//�����
		for(int i=1;i<=number;i++) {
			for(int j=1;j<=capacity;j++) {
				if(wv[i-1][0]>j) {
					sheet[i][j]=sheet[i-1][j];
				}else {
					sheet[i][j]=max(sheet[i-1][j],sheet[i-1][j-wv[i-1][0]]+wv[i-1][1]);
				}
			}
		}
		
	
		int temp[]=new int[number+1];//��ʼ��һ�����飬������ŷ��������Ʒ�����
		int temp_wv[][]=new int[number+1][3];//Ϊ������������ʱ�����õ����һ�£���������Խ��
		for(int i=0;i<number;i++) {
			for(int j=0;j<2;j++) {
				temp_wv[i+1][j+1]=wv[i][j];
			}
		}
	    Find(number,capacity,temp_wv,sheet,temp);//���û��ݺ�����������
		System.out.print("\n"+"���е���Ʒ�����Ϊ��");
	    for(int i=1;i<=number;i++) {
	    	if(temp[i]>0) {
	    		System.out.print(" "+temp[i]);
	    	}
	    }
	    System.out.print("\n"+"����ֵΪ��"+sheet[number][capacity]);
		
		
	}
	    //�ȽϺ���
		public static int max(int x,int y) {
			int max=0;
			if(x>=y) {
				max=x;
				
			}else {
				max=y;
			}
			return max;
		}
	    //���ݷ��Ұ������
		private static void Find(int x,int y,int[][] tempwv,int[][] tempsheet,int[] temp) {
			if(x>0) {
				if(tempsheet[x][y]==tempsheet[x-1][y]) {
					temp[x]=0;
					Find(x-1,y,tempwv,tempsheet,temp);
				}else if(y-tempwv[x][1]>=0&&tempsheet[x][y]==tempsheet[x-1][y-tempwv[x][1]]+tempwv[x][2]){
					temp[x]=x;
					Find(x-1,y-tempwv[x][1],tempwv,tempsheet,temp);
				}
			}
		}
	
}
