package test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Administrator
 * 
 * 问题描述：
 *     设计一个算法随机的产生范围在1~n的m个随机数，且要求这m个随机数互不相同。
 * 解决方法：
 *     算上前面的随机数生成器，在其基础上将随机产生的值依次放入数组array,每次放入前都检测是否与数组已有的数相同，如果相同不放入，如果不同
 *     放入，直到所需个数。
 *     这里通过for和while控制生成不重复且值在1~n之间，特殊的0由于数组初始化时值0，所以在比较的时候已经算在里面了，就不用单独提出来了。
 *     1.x随机数的值(避免生成的随机数改变)，
 *     2.k while的条件，以数组已有元素个数为次数对比新生成的随机数与原数组是否有重复，
 *     3.j数组下标从1开始为了防止在while循环中下标越界，所以最后的到的数组要从1开始遍历。
 *     4.n范围，m个数
 *     5.a,b控制随机数生成次数的条件，a<b表示现有数组的元素没有重复的，a>b表示有重复的这时数组不赋值，即不改变，然后再一次循环生成随机数在比较
 * 时间复杂度分析:
 *     
 */
public class RandomTest {
 public static void main(String[] args)throws IOException {
	 
	 int n,m,k,a = 0,b,x,j=1;
	 String str,str1;
	 BufferedReader buf;
	 buf=new BufferedReader(new InputStreamReader(System.in));
	 NotSpillRandomGenerator test=new  NotSpillRandomGenerator();//创建随机数类的对象
	 System.out.print("随机数的范围为(1~n)，请输入n =");
	 str=buf.readLine();
	 n=Integer.parseInt(str);
	 System.out.print("请输入要产生的随机数的个数(m<n)m =");
	 str1=buf.readLine();
	 m=Integer.parseInt(str1);
	 int[] array=new int[m+1];//防止数组下标越界。
	 System.out.print(m+"个随机数的结果为：");
	 for(int i=0;i<m;i++) {//产生随机数的次数，根据m改变，而m根据是否有重复值而改变。
		b=m;//控制条件
	    k=1;//每次都重新赋值1
	    x=test.randomInt()%n;//生成随机数
	    while(k<=j) {
	    	if(x==array[k]) {
	    		m=m+1;//如果有相等的则多循环一次
	    		a=m;//控制条件
	    		break;
	    	}
	    	k++;
	    }
	    if(a>b) {//判断m是否改变
	    	continue;
	    }else {
	    	array[j]=x;//放入数组
	    	j++;
	    }
      }
	//输出
    for(int i=1;i<array.length;i++) {
     System.out.print(array[i]+" ");
	}
	
 }
 
}
