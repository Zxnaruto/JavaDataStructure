package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 最大间隙问题：
 * 
 * 问题描述：
 *     输入一个数和输入的一个数组中的每一个数进行比较，差值最大的为最大间隙。
 *     例如：
 *         输入 5
 *         再输入集合 5 8 9
 *         则最大间隙为 4
 * 问题实现：
 *     输入数和数组，将它们的差进行打擂台比较，找出最大间隙 
 *     将情况分为四种：
 *     1.输入的为正数，数组中遇到的数也为正数，则直接相减。
 *     2.输入为为正数，数组中遇见的数为负数，则用正数减去正数。
 *     3.输入的为负数，数组中遇到的数为正数，则用正数减去正数。
 *     4.都为负数，则把它们变为正数在相减。
 *     
 *     如上只是粗略的分了一下：
 *     如果两个数相减为负数，则将它变为正数，即用0减得到的数。
 *     
 *     然后在综合打擂台的方法，既可以求出数轴上的最大间隙
 * 时间复杂度分析：
 *     由于也只有一个for循环，所以时间复杂度为O(N)
 *     
 *     虽说较前面的那个只能求差的范围在正数的情况时间复杂度也是O(N),相比较这个程序的代码要比那个复杂一些但是并非数量级上的差别，
 *     所以时间复杂度也是O(N)
 */
public class maxSpanImporve {

	//MaxSpanImporve
	public static long MaxSpanImporve(long x,long[] Array) {
		//阶段一: 把比较直化为正数
		//temp存放擂台所需的基数即相当于a[0],temp1相当于数组中的其他数，result即为所要返回的结果
		long temp1=0,temp = 0;
		long StartTime=System.nanoTime();
		//在数轴上两个数分为四类
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
		//把要比较的数都化为正数，轮流比较
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
		System.out.println("算法运行时间为："+(EndTime-StartTime)+"ns");
		return temp;
	}
	
	//入口函数
		public static void main(String[] args)throws IOException {
			String str,str1,str2;
			BufferedReader buf;
			buf=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("请输入要比较的数：");
			str=buf.readLine();
			long temp=Long.parseLong(str);
			System.out.print("请输入要比较的数组的长度：");
			str1=buf.readLine();
			int length=Integer.parseInt(str1);
			long array[]=new long[length];
			System.out.println("请输入数组：");
			for(int i=0;i<length;i++) {
				str2=buf.readLine();
				array[i]=Long.parseLong(str2);
				
			}
			
			System.out.println("最大间隙为："+MaxSpanImporve(temp,array));
		}
}
