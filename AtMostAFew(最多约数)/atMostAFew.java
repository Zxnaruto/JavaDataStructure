package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     求两个正数中(a,b)，约数最多的的数。其中a<=b
 *     正整数x的约束就是能整除x的正整数。
 *     
 * 时间复杂度为：
 *     如果b可以整除a,则时间复杂度为：O(N)
 *     否则，时间复杂度为：2O(N)
 */
public class atMostAFew {

	public static int mostFew(int a,int b)throws IOException {
		int number=0;
		int anumber=0;
		int bnumber=0;
		if(a>b) {
			System.out.println("输入有误，正确输入为a<=b,请重新输入：");
			String str,str1;
			BufferedReader buf;
			buf=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("请输入正整数a=");
	        str=buf.readLine();
	        a=Integer.parseInt(str);
	        System.out.print("请输入正整数b=");
	        str1=buf.readLine();
	       b=Integer.parseInt(str1);
	        
		}
		//如果b能整除a，则b的约束要大于a
		if(b%a==0) {
			for(int i=1;i<=b;i++){
				if(b%i==0) {
					number++;
				}
			}
		}else {
			for(int i=1;i<=a;i++) {
				if(a%i==0) {
					anumber++;
				}
			}
			for(int j=1;j<=b;j++) {
				if(b%j==0) {
					bnumber++;
				}
			}
			if(anumber>bnumber) {
				number=anumber;
			}else {
				number=bnumber;
			}
		}
		
		return number;
		
	}
	//入口函数
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入正整数a=");
        str=buf.readLine();
        int a=Integer.parseInt(str);
        System.out.print("请输入正整数b=");
        str1=buf.readLine();
        int b=Integer.parseInt(str1);
        System.out.println("最大约束的个数为："+mostFew(a,b));
        
	}
}
