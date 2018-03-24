package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author XiaoHuZiXianShengZx
 * 
 * 问题描述：
 *     在数据加密和数据压缩中常常需要对特殊的字符串进行编码，给定的字母表A由26个小写的英文字母组成，
 *     该字母表产生的升序字符串是指字符串中字母从左到右出现的次序与字母在字母表中出现的次序相同，且
 *     每个字符最多出现1次，对于任意长度不超过6的升序字符串迅速计算出它在字典中的编码。
 * 难点：
 *     给字母进行排序，组合，以及如何得出字典序。
 * 解决方法：
 *     先新建一个字符串数组，包含a-z，然后对数组里的字符按顺序且长度不超过6进行组合，这里用到for循环
 *     来进行组合。分别为一个，两个，三个，四个，五个，六个字符为一组。然后进行比较，我这里是在进行分
 *     组的时候就进行比较，如果找到就退出程序，不进行下面的循环，提高效率。
 *     计数则是用count来保存次数，如果输入的在第1个循环中没有则记下它循环的次数，加上下面找到时的位置
 *     就可以得出字典序。
 *     字母分组：是以每次循环的第一个字母为基准，向后添加字母。
 * 算法及时间复杂度分析：
 *   1.通过for循环的循环嵌套：
 *     一个字母为一组时自然一个for，进行N次循环（这里N=26）。
 *     
 *     两个字母时：由于两两组合，需要两个for，外层需要N-1次(最后一个字母不能为首字母)，内层需要随i的
 *     变化来决定第二个字母是什么，当a为第一个时，第二个只能是b以后的，所以第二层中的j要从下一个起，
 *     即随i的变化而加一，又因为要组合到最后一个字母，所以内层循环的控制条件要到N。
 *     
 *     三个字母组合时，需要三个for,最外层需要N-2次(最后一个首字母为倒数第三个)，中间层也需要通过i来控制
 *     后一个字母是什么。它的循环控制条件是小于N-1，这是因为它是第二个字母，极限取到数组的倒数第二个，不
 *     能再往下取了(否则就不是按顺序了)。最后一层需要上一层的j来控制条件，以及循环控制条件小于N
 *     
 *     通过上面三个我们可以得到以下规律：
 *      //单个字母
		for(int i=0;i<N;i++)
		
		//两个字母
		for(int i=0;i<N-1;i++)
		for(int j=i+1;j<N;j++)
		
		//三个字母
		for(int i=0;i<N-2;i++)
	    for(int j=1+i;j<N-1;j++)
		for(int k=1+j;k<N;k++) 
		
		...........
		//x个字母
		需要x个for,
		最外层循环次数：N-(x-1)
		内层循环次数：N-(x-1-1.......) 直到括号中的等于0
		
		前面控制条件：
		0
		j=i+1
		k=j+1
		l=k+1
		........
		都是前项+1
	 2.时间复杂度：
	   	一个字母O(N)
	   	两个字母：N-1+N-2+N-3.....+N-N
	   	       lim=N^2-2N
	   	       O(N^2)
	   	依次类推：
	   	三个字母O(N^3)
	   	四个字母O(N^4)
	   	五个字母O(N^5)
	   	六个字母O(N^6)
	   	
	   	所以，综合，最好T(N)=O(N),最坏T(N)=O(N^6)
	   	这是对N个长度的字符数组且以不超过6个字母排序而言的
 *         
 *     
 *
 */
public class lexicographicalOrder01 {

	
	public static void main(String[] args)throws IOException {
		
		String[] array= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","d","u","v","w","x","y","z"};
		String str1="abcdefghijklmnopqrstuvwxyz";
		int count=0,count1=0,count2=0,count3=0,count4=0,count5=0;//计数，
		boolean flag=true;
		
		BufferedReader buf;
		String str;
		
		buf=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入要查找的字符(a-g之间不重复的长度不超过6个的)：");
		str=buf.readLine();
		char[] length=str.toCharArray();//判断输入字符串长度
		for(int i=0;i<length.length;i++) {//判断输入是否正确
			if(str1.indexOf(length[i])<0) {
				System.out.println("所输入的有非字母的，输入有误！！！");
				System.exit(0);
			}
		}
		if(length.length>6||length.length<=0) {//长度大于6或小于等于0则l显示输入错误
			System.out.println("长度输入有误！！！");
		}else {
		
		//单个字母
		for(int i=0;i<26;i++) {
			count++;
			if(str.equals(array[i])) {//如果找到
				System.out.println(str+"的字典序为："+count);
				System.exit(0);//如果找到就跳出循环,也不用循环下面
			}
			
		}
		
		//两个字母
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				count1++;
				if(str.equals((array[i]+array[j]))) {
					System.out.println(str+"的字典序为："+(count+count1));
					System.exit(0);//如果找到就跳出循环,也不用循环下面
				}
			}
		}
		//三个字母
		for(int i=0;i<array.length-2;i++) {
			for(int j=1+i;j<array.length-1;j++) {
				for(int k=1+j;k<array.length;k++) {
					count2++;
					if(str.equals((array[i]+array[j]+array[k]))) {
						System.out.println(str+"的字典序为："+(count+count1+count2));
						System.exit(0);//如果找到就跳出循环,也不用循环下面
					}
				}
			}
		}
		//四个字母
		for(int i=0;i<array.length-3;i++) {
			for(int j=1+i;j<array.length-2;j++) {
				for(int k=1+j;k<array.length-1;k++) {
					for(int l=1+k;l<array.length;l++) {
						
						count3++;
						if(str.equals((array[i]+array[j]+array[k]+array[l]))) {
							System.out.println(str+"的字典序为："+(count+count1+count2+count3));
							System.exit(0);//如果找到就跳出循环,也不用循环下面
						}
						
					}
				
				}
			}
		}
		//五个字母
		for(int i=0;i<array.length-4;i++) {
			for(int j=1+i;j<array.length-3;j++) {
				for(int k=1+j;k<array.length-2;k++) {
					for(int l=1+k;l<array.length-1;l++) {
						for(int m=1+l;m<array.length;m++) {
							
							count4++;
							if(str.equals((array[i]+array[j]+array[k]+array[l]+array[m]))) {
								System.out.println(str+"的字典序为："+(count+count1+count2+count3+count4));
								System.exit(0);//如果找到就跳出循环,也不用循环下面
							}
							
						}
					
					}
				
				}
			}
		}
		//六个字母
		for(int i=0;i<array.length-5;i++) {
			for(int j=1+i;j<array.length-4;j++) {
				for(int k=1+j;k<array.length-3;k++) {
					for(int l=1+k;l<array.length-2;l++) {
						for(int m=1+l;m<array.length-1;m++) {
							for(int n=1+m;n<array.length;n++) {
								
								count5++;
								if(str.equals((array[i]+array[j]+array[k]+array[l]+array[m]+array[n]))) {
									System.out.println(str+"的字典序为："+(count+count1+count2+count3+count4+count5));
									System.exit(0);//如果找到就跳出循环,也不用循环下面
								}
							}
						
						}
					
					}
				
				}
			}
		}
		
		System.out.println("输入有误或该字符不在字典中！！！");
		}
		
		
	}
}
