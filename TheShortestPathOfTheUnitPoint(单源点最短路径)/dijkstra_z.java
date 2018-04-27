package test1;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * 单源点最短路径算法：
 *     求源点到其他个点的最短路径。
 * 解决方法：
 *     运用贪心法，每一次都求局部最优，最后在局部最优中找到最终结果。以源点开始每次找两点之间的最短路径，通过求和和比较，
 *     求出源点到各个点的最短路径。
 *     dist[i]表示当前从源到顶点i的最短特殊路径长度,prev[i]=j：最短路径中顶点i的前一个顶点是j
 *     
 *     核心：就是通过局部的最短距离来和局部的最短距离比较，找出最终的最短路径。例如：1到2，3，4，5中3的距离最短，其他各点都比其大，
 *     如果此时找路径1-4，就可以以直接1-4和1-3-4比谁的路径更短。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class dijkstra_z {

	public static int max=Integer.MAX_VALUE;//极限，代表没有这条路径
	  //入口函数
	  public static void main(String[] args)throws IOException {
		  
		    String str,str1;
			int x,y;//输入的起点终点
			BufferedReader buf;
			buf=new BufferedReader(new InputStreamReader(System.in));
			//初始化数组
	        int[][] array = { { max, max, max, max, max, max },
	                          { max, 0, 10, max, 30, 100 }, 
	                          { max, max, 0, 50, max, max },
	                          { max, max, max, 0, max, 10 }, 
	                          { max, max, max, 20, 0, 60 },
	                          { max, max, max, max, max, 0 } };
	        int n = array.length;
	        int[] dist = new int[n];
	        int[] prev = new int[n];
	        
	        System.out.print("请输入起点(对应与该图)：");
	        str=buf.readLine();
	        x=Integer.parseInt(str);
	        dijkstra(x, array, dist, prev);
	        System.out.print("请输入终点：");
	        str1=buf.readLine();
	        y=Integer.parseInt(str1);
	        System.out.println(x+"点到"+y+"点的最短路径：");
	        trace(prev, y);
	       
	    }
	
	public static void dijkstra(int x, int[][] array, int[] dist, int[] prev) {
        // x是源点，dist[i]表示当前从源到顶点i的最短特殊路径长度,prev[i]=j：最短路径中顶点i的前一个顶点是j，类似于链表
        int n = dist.length - 1;// 节点个数
        if (x < 1 || x > n)
            return;
        boolean[] s = new boolean[n + 1];
        // 初始化，找出源点到各个点的距离(有路径就为距离，无路径为极限)
        for (int i = 1; i <= n; i++) {
            dist[i] = array[x][i];
           
            s[i] = false;
            if (dist[i] == Integer.MAX_VALUE)
                prev[i] = 0;
            else
                prev[i] = x;
            
           
        }
        dist[x] = 0;
        s[x] = true;//将源点放入集合
        
        //求出离源点最近的点，主要是为了以这个点开始找下一个点
        for (int i = 1; i < n; i++) {// 循环n-1次
            int temp = Integer.MAX_VALUE;
            int u = x;
            for (int j = 1; j <= n; j++) {// 寻找不在集合内且距离集合最近的节点j
                if ((!s[j]) && (dist[j] < temp)) {
                    u = j;// 记录节点
                    temp = dist[j];// 记录最短特殊路径长度
                    
                }
               
            }
           
            s[u] = true;// 将节点u放入集合
            
            //以找到的那个点为基础，求出以这个点为前驱的下一个节点的最短距离，之后加起来比较看是直接到短，还是有多余的点最短
            for (int j = 1; j <= n; j++) {// 重新设置dist[]和prev[]的值
                if ((!s[j]) && (array[u][j] < Integer.MAX_VALUE)) {// 寻找不在集合内，且可达的节点
                    int newdist = dist[u] + array[u][j];
                    if (newdist < dist[j]) { // 与旧值进行比较，保留小的值
                        dist[j] = newdist;
                        prev[j] = u;
            
                    }
                }
            }
        }
       
    }
	
	 public static void trace(int[] prev, int n) {
	        if (n == 1) {
	            System.out.print(n + " ");
	            return;
	        }
	        trace(prev, prev[n]);
	        System.out.print(n + " ");
	    }


		/*public static void main(String[] args)throws IOException {
			String str,str1;
			int cow;
			BufferedReader buf;
			buf=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("请输入二维数组的行列数：");
			str=buf.readLine();
			cow=Integer.parseInt(str);
			//初始化二维数组
			int array[][]=new int[cow][cow];
			for(int i=0;i<cow;i++) {
				for(int j=0;j<cow;j++) {
					array[i][j]=max;
				}
			}
			
			System.out.println("请输入数组元素：");
			
		}*/
}
