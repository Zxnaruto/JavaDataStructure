package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 半数集问题：
 *     给定一个自然数n，由n开始可以依次产生半数集set(n)中的数如下：
 *     (1)n属于set(n)
 *     (2)在n的左边加上一个自然数，但该数不能超过最近添加数的一半
 *     (3)按此规则进行处理，直到不能再添加自然数为止。
 *     例如：输入n=6;
 *     set(n)={6,16,26,126,36,136}
 * 
 * 解决办法：
 *     采用分治法，由问题可知：
 *     (1)首先，该问题的规模缩小到一定程度可以很容易的解决，比如，n=1,2,3
 *     (2)可以将这个问题细分为很多很小的部分，例如：给出一个n=6,我们先求其的1/2(按其1/2的个数for循环,后面也是一样)，看其1/2还有
 *     没有它的1/2，这样一直下去，直到n=1;并且只要
 *     
 */
public class halfOfTheSet {

	public static int count=0;//静态变量，放在公共储存中，公用，可以使其值不断增加。
	//找个数方法
	public static int HalfOfTheSet(int n) {
		
	   
		if(n<=0){
			System.out.println("输入有误!!!");
		}else {
			
		for(int i=1;i<=n/2;i++) {
				count++;
				if(i/2>=1) {
					HalfOfTheSet(i);
				}
			}
		
	
		}	
		
		
		return count+1;//加1是因为算上其本身
		
	}
	//入口函数
    public static void main(String[] args)throws IOException {
    	String str;
    	int n;
    	BufferedReader buf;
    	buf=new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("请输入一个数求其半数集的个数：");
    	str=buf.readLine();
    	n=Integer.parseInt(str);
    	System.out.println(n+"的半数集个数为："+HalfOfTheSet(n));
    	
    }
}
