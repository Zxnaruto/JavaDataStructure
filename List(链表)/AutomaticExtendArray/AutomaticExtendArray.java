/**
 * @author XiaoHuZiXianShengZx
 * 
 * ����������
 *     ����һ���������ȵ����飬�������ʼ����Ϊ10���������10��������������������������鳤�ȡ�
 * ����취��
 *     ��whileѭ������ʼ�����飬�����鳤�ȴ��ڳ�ʼ���鳤��ʱ����������������������Ҳ���Լ������룬�������˳�ʱ���˳����룬���
 *     ����Ԫ�ء�
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AutomaticExtendArray {

     public static int[] automaticExtendArray()throws IOException {
    	 String str = null;
    	 int elem,length=10,i=0;//length ���鳤�ȣ�elem��������Ԫ�أ�i���鳤�ȿ�������
    	 BufferedReader buf;
    	 buf=new BufferedReader(new InputStreamReader(System.in));
    	 boolean flag=true;//while����
    	 int[] Array=new int[length];//��ʼ������
    	 System.out.println("����������Ԫ��(�����˳�����)��");
    	 while(flag) {
    		 str=buf.readLine();
    		 if(str.equals("�˳�")) {//�˳��ж�
    			 flag=false;
    			 break;
    		 }
    		 elem=Integer.parseInt(str);
    		 Array[i]=elem;
    		 i++;
    		 if(i>Array.length-1) {//�ж��Ƿ񳬹�ԭ����ĳ���
    			 System.out.println("���ڿ�ʼ��������");//���������֤��������
    			 int newArray[]=new int[Array.length*2];
    			 for(int j=0;j<Array.length;j++) {
    				 newArray[j]=Array[j];
    			 }
    			 Array=newArray;//��������
    		 }
    	 }
    	System.out.println("����Ԫ�أ�");
    	return Array;
     }
     //��ں���
     public static void main(String[] args) throws IOException {
    	
    	 for(int elem:automaticExtendArray()) {
    		 System.out.print(elem+" ");
    	 }
    	
    	 
    	 
     }
}
