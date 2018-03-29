package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 罚金问题:
 *     （1）罚金随天数的变化其值为：2 4 16 256 65536........ 要根据天数计算罚金
 *     （2）根据输入金额，判断罚金天数
 * 问题解决：
 *     从给出的数，我们可以找到规律：money=2^2^(day-1)，即通过算法来实现这个规律，我是用的两个for循环来控制
 *     第一个for循环用来计算上面那个2^(day-1),下面的for则计算整个式子的值，即money.
 *     
 *     而根据上面我们可以知道总金额，在与输入的金额对比如果输入的金额刚好小于等于计算的总金额时，则该时的天数即为罚金的天数
 * 时间复杂度分析：
 *     计算罚金：
 *         当day=N时，第一个for的时间复杂度为O(N-1),第二个for的时间复杂度为：O(2^2^(N-1))
 *         所以综合得 时间复杂度为：O(2^2^(N-1))
 *     输出天数：
 *         while循环，O(N), for循环 O((2^2^(N-1)/2))
 *         所以综合得 时间复杂度为：O((2^2^(N-1)/2))
 */  
public class fine {

	//计算罚金
	public static int Fine(int day) {
		int x=1;
		int fine=1;
		for(int i=0;i<day-1;i++) {
			x*=2;
		}
		for(int i=0;i<x;i++) {
			fine*=2;
		}
		
		return fine;
	}
	//给出金额计算天数
	public static int days(int menoy) {
    boolean flag=true;
    int x=1;
    int fine=1;
    int day=0;
	while(flag) {
		day++;//天数
		x*=2;//计算总金额媒介
	    for(int i=0;i<x/2;i++) {
			fine*=2;//总金额
			if(menoy<=fine) {
				flag=false;//找到退出循环	
			}
		}
	}
		
		return day;
	}
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入罚金天数：");
		str=buf.readLine();
		int N=Integer.parseInt(str);
		System.out.print("罚金金额为："+"$"+Fine(N)+"\n");
		
		System.out.print("罚金为：");
		str1=buf.readLine();
		int M=Integer.parseInt(str1);
		System.out.println("天数为："+days(M));
		
	}
}
