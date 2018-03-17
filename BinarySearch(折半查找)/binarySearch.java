import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * binary search(折半查找)：对已经排好序的元素，取中间的数与要查找的数进行比较，如果该数
 * 大于中间的数则把范围定到后半部分，然后再取后半部分的中间值，继续此步骤，直到找到或没找
 * 到。（如果小于反过来也是一样的）
 * 
 * 算法时间复杂度分析：
 * whlie循环循环的条件是：high-low>-1
 * 由于循环内的执行时间为O(1),所以关键要看循环次数。
 * 举个例子：一个16个数的数组需要循环（0-15）：
 *          15->7
 *          7->3
 *          3->1     
 *          1->0
 *          0->-1
 *          需要五次    2^(5-1)=16   
 *          一个8个数的数组：
 *          7->3
 *          3->1
 *          1->0
 *          0->-1
 *          需要四次   2^(4-1)=8
 *          
 *          所以以此类推 N=2^(k-1) 
 *          k=log(N-1)
 *          
 *          又由于赋值语句时间为O(1)
 *          所以 T(N)=log(N-1)+2
 *          
 *          简化得时间复杂度：logN
 */
public class binarySearch {

	//折半查找方法
	public static int bSearch(int[] Array,int x) {
		int low=0,high=Array.length-1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(Array[mid]<x) {
				low=mid+1;
			}else if(Array[mid]>x) {
				high=mid-1;
			}else {
				return mid;//找到了
			}
			
		}
		return -1;//没找到
	}
	//入口
	public static  void main(String[] args) throws IOException{
	
		int[] array= {1,2,3,4,5,6};
		String str;
		BufferedReader buf;
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入要查找的数：");
		str=buf.readLine();
		int x=Integer.parseInt(str);
		System.out.println("结果（找到返回这个数的位置没有则返回-1）："+bSearch(array,x));
		
		
	}
}
