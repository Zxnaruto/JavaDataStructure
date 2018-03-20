package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 问题描述：
 *     一本书有1--n页，统计所有页数中出现的0-9的数字的个数（页数中没有01，001，001...等表示法）
 * 算法描述：
 *     输入一个总页数，利用for循环，以及字符分割函数，字符的匹配，从而使得匹配的字符个数自增,最后的到结果
 * 算法时间复杂度分析：
 *     首先最外层的for循环的时间复杂度为：O(N)
 *     里面的那个for，当外层为1位，它循环N
 *     当外层位2位，它循环2N
 *     当外层位3位，它循环3N
 *     .....
 *     依次类推它的时间复杂度为mO(N),m是一个常数
 *     
 *     所以两个合起来就是：mO(N^2)
 *     最后得时间复杂度：O(N^2)
 *     
 */
public class bookNumber {

	public static int[] NumberStatistics(int pages) {
		//普通赋值写法
		/*int zero=0;
		int one=0;
		int two=0;
		int three=0;
		int four=0;
		int five=0;
		int six=0;
		int seven=0;
		int eight=0;
		int nine=0;*/
		//简短代码，利用数组,number[0]-number[9]代表0-9
		int[] number= {0,0,0,0,0,0,0,0,0,0};
		char[] compare;
		for(int i=1;i<=pages;i++) {
			String str=String.valueOf(i);//把int型转化为字符串
			compare=str.toCharArray();//分割字符串
			for(int j=0;j<compare.length;j++) {
				if(compare[j]=='9') {
					number[9]++;
				}
				if(compare[j]=='8') {
					number[8]++;
				}
				if(compare[j]=='7') {
					number[7]++;
				}
				if(compare[j]=='6') {
					number[6]++;
				}
				if(compare[j]=='5') {
					number[5]++;
				}
				if(compare[j]=='4') {
					number[4]++;
				}
				if(compare[j]=='3') {
					number[3]++;
				}
				if(compare[j]=='2') {
					number[2]++;
				}
				if(compare[j]=='1') {
					number[1]++;
				}
				if(compare[j]=='0') {
					number[0]++;
				}
				
			}
		}
	 return number;
		
		
	}
	public static void main(String[] args)throws IOException {
		
		String str;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入总页数：");
		str=buf.readLine();
		int page=Integer.parseInt(str);
		int[] result=NumberStatistics(page);
		System.out.println("0-9数字的个数为：----------------------");
		System.out.println("0: "+result[0]);
		System.out.println("1: "+result[1]);
		System.out.println("2: "+result[2]);
		System.out.println("3: "+result[3]);
		System.out.println("4: "+result[4]);
		System.out.println("5: "+result[5]);
		System.out.println("6: "+result[6]);
		System.out.println("7: "+result[7]);
		System.out.println("8: "+result[8]);
		System.out.println("9: "+result[9]);
		
		
	}
}
