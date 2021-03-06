package DiYiZhang;
/**
 * 快速排序改进，有一个控制值来控制排序的方法，如果数组长度大于控制值，
 * 则进行一次快速排序使之有序。然后在进行插入排序，这样时间会有所减少。
 * 否则就进行插入排序
 * @author XiaoHuZiXianShengZx
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortImprove {
	public static void main(String[] args) throws IOException {
		String str, str1;
		int N;
		int[] a;
		BufferedReader buf;
		buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入数组长度：");
		str = buf.readLine();
		N = Integer.parseInt(str);
		System.out.println("请输入数组元素：");
		a = new int[N];
		for (int i = 0; i < N; i++) {
			str1 = buf.readLine();
			a[i] = Integer.parseInt(str1);
		}
		QuickSortImp(a,N-1,5);
		System.out.println("结果：");
		for(int i=0;i<N;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
public static int[]  QuickSort(int[] array,int low,int high,int k) {
		if(high-low>k){//长度大于k时递归, k为指定的数 
		if(low>=high) {//判断输入数组情况
			return array;
		}
		int diserve=Chick(array,low,high);//返还的Key的位置,并进行第一次排序
		QuickSort(array,low,diserve-1,k);//以Key分割数组
		QuickSort(array,diserve+1,high,k);
		
		}
		return array;
	}
	
	public static int Chick(int[] array,int low,int high) {
		int Key=array[low];
		while(low<high) {
			while(low<high&&array[high]>=Key) {//把小于Key的放到Key的前面
				high--;}
			array[low]=array[high];
			while(low<high&&array[low]<=Key) {//将大于Key的放到Key的后面
				low++;}
			array[high]=array[low];
		}
		array[low]=Key;//最后的空位放Key值
		return low;//返还此时的交换位置的值，完成第一趟排序，
		           // 将数组分为以Key为分割点的两办如上面的QuickSort(array,low,diserve-1);为前一半，再次调用自己
	}              //完成下一趟排序，最终递归完则序排好了。
	
	public static void QuickSortImp(int[] array,int high,int k) {
		QuickSort(array,0,high,k);//先调用改进算法使数组基本有序 

		//再用插入排序对基本有序序列排序  
		    for(int i=1; i<=high;i ++){  
		        int temp = array[i];   
		        int j=i-1;  
		        while(temp < array[j]){  
		            array[j+1]=array[j]; 
		            j--;
		        }  
		        array[j+1] = temp;  
		    }   
	}
}
