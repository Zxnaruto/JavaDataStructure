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
    
    4.时间复杂度中对数的实例：<br>
      (1)Binary Search(折半查找)：里面包含代码，运行结果，算法解释及时间复杂度分析<br>
         这里给出时间复杂度分析：
         
         * @author XiaoHuZiXianShengZx
         * 
         * binary search(折半查找)：对已经排好序的元素，取中间的数与要查找的数进行比较，如果该数
         * 大于中间的数则把范围定到后半部分，然后再取后半部分的中间值，继续此步骤，直到找到或没找
         * 到。（如果小于反过来也是一样的）
         * 
         * 算法时间复杂度分析：
         * whlie循环循环的条件是：high-low>=-1
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
      <br>
      (2)Euclid Algorithm(欧几里得算法)：求两个数中的最大公因数，包含代码，运行结果，算法解释及时间复杂度分析。<br>
      (3)Power Operation(幂运算)：求一个结果较大的整数的幂，包含代码，运行结果，算法解释及时间复杂度分析。
      
      
    5.数字统计问题：<br>
        统计1-n个数中，0-9数字的个数。内涵代码，运行结果，算法及时间复杂度分析。<br>
    6.最多约束问题：<br>
        在a和b两个正整数中（a<=b）,求出其中约数最多的次数。包含其代码，运行结果，算法解释及时间复杂度分析。<br>
    7.字典序问题：<br>
        求一个字符串在字典中的顺序即位置，包含其代码，运行结果，算法解释及时间复杂度分析。<br>
    8.罚金问题：<br>
        根据罚金规律，计算N天后的罚金数，以及给出罚金计算天数。包含其代码，运行结果，算法解释及时间复杂度分析。<br>
