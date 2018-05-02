/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     创建一个自增长度的数组，该数组初始长度为10，如果超过10，会以现有数组的两倍扩充数组长度。
 * 解决办法：
 *     用while循环来初始化数组，当数组长度大于初始数组长度时，进行数组容量的扩增，也可以继续输入，当输入退出时，退出输入，输出
 *     数组元素。
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AutomaticExtendArray {

     public static int[] automaticExtendArray()throws IOException {
    	 String str = null;
    	 int elem,length=10,i=0;//length 数组长度，elem输入数组元素，i数组长度控制条件
    	 BufferedReader buf;
    	 buf=new BufferedReader(new InputStreamReader(System.in));
    	 boolean flag=true;//while条件
    	 int[] Array=new int[length];//初始化数组
    	 System.out.println("请输入数组元素(输入退出结束)：");
    	 while(flag) {
    		 str=buf.readLine();
    		 if(str.equals("退出")) {//退出判断
    			 flag=false;
    			 break;
    		 }
    		 elem=Integer.parseInt(str);
    		 Array[i]=elem;
    		 i++;
    		 if(i>Array.length-1) {//判断是否超过原数组的长度
    			 System.out.println("现在开始扩充数组");//标记用来验证数组扩充
    			 int newArray[]=new int[Array.length*2];
    			 for(int j=0;j<Array.length;j++) {
    				 newArray[j]=Array[j];
    			 }
    			 Array=newArray;//扩充数组
    		 }
    	 }
    	System.out.println("数组元素：");
    	return Array;
     }
     //入口函数
     public static void main(String[] args) throws IOException {
    	
    	 for(int elem:automaticExtendArray()) {
    		 System.out.print(elem+" ");
    	 }
    	
    	 
    	 
     }
}
