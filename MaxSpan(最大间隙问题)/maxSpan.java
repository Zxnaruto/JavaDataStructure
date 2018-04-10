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
 * 时间复杂度分析：
 *     这个时间复杂度由于只有一个for循环，所以时间复杂度为：O(N)  这里指的是MaxSpan方法的时间复杂度
 *       
 */
public class maxSpan {

	//MaxSpan 对于差为正数
	public static long MaxSpan(long x,long[] Array) {
		long temp=Array[0]-x;
		long StartTime=System.nanoTime();
		for(int i=1;i<Array.length;i++) {
		    if(temp<(Array[i]-x)) {
		    	temp=Array[i]-x;
	
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
		
		System.out.println("最大间隙为："+MaxSpan(temp,array));
	}
}
