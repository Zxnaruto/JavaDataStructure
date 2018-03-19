import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 通过递归来高效的求幂运算的结果
 * 
 * 具体做法举个例子：
 *     n=偶数：x^n=x^(n/2)*x^(n/2)
 *      x^8=x*x*x^2*x^4;只需要乘三次,原来需要7次相乘
 *     n=奇数：x^n=x^(n-1/2)*x^(n-1/2)*x
 *     x^9=x*x*x^2*x^4*x;需要乘四次，原来需要8次相乘
 *     注：一次相乘是O(1)
 *     
 *     都比原来N-1少一半左右，所以时间复杂度为O(logN)
 *
 */
public class powerOperation {

	//递归求乘积的方法
	public static long pow(long x,int n) {
		if(n==0) {
			return 1;
		}
		if(n==1) {
			return x;
		}
		if(isEven(n)==0) {
			return pow(x*x,n/2);
		}else {
			return pow(x*x,n/2)*x;
		}
	}
	//判断n的奇偶性
	public static long isEven(int a) {
		
		if(a%2==0) {
			return 0;
		}else {
			return 1;
		}
		
	}
	//入口函数
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入底数：");
		str=buf.readLine();
		long x=Long.parseLong(str);
		System.out.print("请输入幂数：");
		str1=buf.readLine();
		int n=Integer.parseInt(str1);
		System.out.print(x+"的"+n+"次方="+pow(x,n));
		
	}
}
