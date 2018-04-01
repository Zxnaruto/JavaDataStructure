package test;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     任意给出一个集合，求出里面的众数及其出现次数。
 * 解决方法：
 *     用一个临时数组用来存放每个数出现次数的值，然后找出最多的次数即为最多的次数。
 *     然后通过对临时数组进行比大小，求出最大次数及其在原数组中的位置，然后输出次数
 *     和该数。
 * 时间复杂度：
 *    Mode(): O(N^2)+2O(N)
 * 不足：
 *    就是对于多个数中有相同个数的两个数或多个数的话（例如：{2，2，3，3}），不会输出正确结果，还需改进。
 *    同时，算法也可以改进。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class modeProblem {

	public static void Mode(int[] Array) {
		int max = 0;//重数的最大值
		int smax=0;//在数组中的位置
		int num=0;
		int[] temp=new int[Array.length];//定义临时数组存储计算的个数值
		//计算每个数在集合中的个数
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
			System.out.println("每一个数都是众数");
			System.exit(0);
		}else {
		
		
		//求最大的数
		for(int i=1;i<temp.length;i++) {//i从零开始，为了防止输入一个数
			if(temp[0]<=temp[i]) {
				temp[0]=temp[i];
				max=temp[0];
				smax=i;
			
			}
		
			
			
		}
		
		System.out.println("众数是："+Array[smax]+" "+"重数是："+max);}
		
	}
	//入口函数
	public static void main(String[] args)throws IOException {
		String str,str1;
		int[] numbers;
		int length;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入数组长度：");
		str=buf.readLine();
		length=Integer.parseInt(str);
		numbers=new int[length];
		System.out.println("请输入数组元素：");
		for(int i=0;i<numbers.length;i++) {
			str1=buf.readLine();
			numbers[i]=Integer.parseInt(str1);
		}
		
		Mode(numbers);
	}
}
