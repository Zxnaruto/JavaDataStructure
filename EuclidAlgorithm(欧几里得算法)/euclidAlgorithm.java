import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 欧几里得算法：求两个数的最大公因数（最大公因数：能同时被两个数整除的最大的数）
 * 通过用大数对小数不断取余数，直到余数为零时，得到的最后一个
 * 的非零余数就是两个数的最大公因数
 * 
 * 算法时间复杂度分析：
 * 在while循环中，每一次的时间复杂度为O(1),
 * 返回值占一个时间单元，从时间复杂度的角度，这些都可以忽略，
 * 所以关键在于while的循环次数，即一个数取余的余数序列的长度。
 * 但它并不是按常数因子递减的，所以不太好算，由于循环中有O(1),且
 * 循环次数相对于N来说会削减一部分，所以大概估计该算法的时间复杂度为O(logN)
 * 
 */
public class euclidAlgorithm {

	//算法
	public static long gcd(long m,long n) {
		while(n!=0) {
			/*如果m<n，则交换m与n的值
			  用大数除小数取余，直到取到最后一个
			  不为零的数，则为最大公因数。
			  由于大数除小数取余之后，余数不会大于这两个数中的任意一个，
			  再用小数继续除以余数得余数，最终可以得到结果。*/
			long rem=m%n;
			m=n;         
			n=rem;
		}
		return m;
	}
	//入口函数
	public static void main(String[] args)throws IOException {
		String str,str1;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入m=");
		str=buf.readLine();
		long m=Long.parseLong(str);
		System.out.print("请输入n=");
		str1=buf.readLine();
		long n=Long.parseLong(str1);
		
		System.out.println("m与n的最大公因数为："+gcd(m,n));
	}
}
