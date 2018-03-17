# JavaDataStructure
#### 这是关于Java数据结构与算法分析的练习
    1.selection problem：里面有三种选择问题的解决办法，然后计算运行时间。<br>
    2.排序算法：<br>
     (1)插入排序：关于插入排序的原理，时间复杂度，稳定性和代码总结。<br>
     (2)冒泡排序：简单冒泡排序，以及两种对冒泡算法的改进和其运行时间对比。<br>
     (3)选择排序：简单的选择排序原理及代码。<br>
     (4)二元选择排序：是对选择排序的改进，包含原理解释及代码。<br>
     (5)快速排序：原理及代码。<br>
     (6)快速排序改进：在快速排序的基础上结合插入排序，使时间复杂度有所降低的原理和代码。<br>
     (7)堆排序：最大堆与最小堆的原理及代码。<br>
     (8)希尔排序：希尔排序的原理及代码<br>
     (9)希尔排序改进：在希尔排序的基础上，代码量缩减和效率有所提高。<br>
    3.最大子序列：<br>
      用不同的算法来求出最大子序列的和，其时间复杂度分别为：O(N^3)、O(N^2)、O(NlogN)、O(N)<br>
      举个例子(时间复杂度为O(NlogN))：<br>
      (1)代码：<br>
             
             
             public class recursiveMaximumSubsquence {
             //求两边最大子序列的和后，在与边界进行和，返回其中最大值
             private static int maxSumRec(int[] Array,int left,int right) {
              if(left==right) //数组只有一个元素
              if(left>0){
               return Array[left];	
              }else {
               return 0;
              }

              int center= (left+right)/2;//最外层（除下面两个递归的最大值，即左、右两边的和的最大值）
              int maxLeftSum=maxSumRec(Array,left,center);//求出除了最大层的值的和（左边的和）
              int maxRightSum=maxSumRec(Array,center+1,right);//右边的和（循环的次数减一后的继续循环的值）
              int maxLeftBorderSum=0,leftBorderSum=0;
              for(int i=center;i>=left;i--) {//求出左边一半的最大值
               leftBorderSum+=Array[i];
               if(leftBorderSum>maxLeftBorderSum) {
                maxLeftBorderSum=leftBorderSum;
               }
              }

              int maxRightBorderSum=0,rightBorderSum=0;
              for(int i=center+1;i<=right;i++) {//求出右边一半的最大值
               rightBorderSum+=Array[i];
               if(rightBorderSum>maxRightBorderSum) {
                maxRightBorderSum=rightBorderSum;
               }
              }
              //maxLeftBorderSum+maxRightBorderSum是每次循环后算上最外层的和，即加上边界值的和
              return compare(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);
             }
             //求最大子序列的和
             public static int maxSubSum(int[] Array) {
              return maxSumRec(Array,0,Array.length-1);

             }
             //比较函数
             public static int compare(int a,int b,int c) {
              int max=0;
              if(a>=b&&a>=c) {
               max=a;
              }
              if(b>=a&&b>=c) {
               max=b;
              }
              if(c>=a&&c>=b) {
               max=c;
              }

              return max;
             }

             //入口函数
             public static void main(String[] args) throws IOException{
              String str,str1;
              BufferedReader buf;
              buf=new BufferedReader(new InputStreamReader(System.in));
              int array[];
              int length;//数组长度
              System.out.println("请输入数组的长度：");
              str=buf.readLine();
              length=Integer.parseInt(str);
              array=new int[length];
              System.out.println("请输入数组元素：");
              for(int i=0;i<length;i++) {
               str1=buf.readLine();
               array[i]=Integer.parseInt(str1);
              }
              System.out.println("输入的数组为：");
              for(int i=0;i<length;i++) {
               System.out.print(array[i]+" ");
              }
              System.out.print("\n"+"最大子序列的值为："+ maxSubSum(array));

             }
             }
           
      (2)时间复杂度分析及代码解释：<br>
      
          * @author XiaoHuZiXianShengZx
          * <br>
          * 这是用分治思想的递归方法来求最大子序列的和
          * <br>
          * 起时间复杂度为：(两个for是O(N),两个递归是2T(N/2))
          *   T(1)=1,T(N)=N+2T(N/2)<br>
          * 推导：<br>
          *      T(2)=2+2T(1)=2*2=4        2^1=2, 2*(1+1)
          *      T(4)=4+2T(2)=4*3=12       2^2=4, 4*(2+1)
          *      T(8)=8+2T(4)==8*4=32      2^3=8, 8*(3+1)
          *      .......
          *      N=2^k,k=logN
          *      T(2^k)=2^k+2T(2^(k-1))=N*(k+1)=N+NlogN
          *      所以T(N)=NlogN
          * 
          * 
          * 通过把数组分为两个部分，分别对两个部分进行递归，并求出左边的最大值，右边的最大值，以及
          * 加上左右边界的最大值的和（即左边递归的部分加上右边递归的部分，该递归是从中间向两边依次求和的）
          * 然后再看这三个值那个最大，最大的值即为最大子序列的和的值
          * 
          * 缺点：目前这个算法只针对N为偶数，要是也可算奇数的话，还需改进。
  
      (3)运行结果：
         ![](https://github.com/Zxnaruto/JavaDataStructure/blob/master/TheSequenceOfArchitectural(最大子序列)/recursiveMaximumSubsquence/运行结果(recursiveMaximumSubsquence).png)
      
