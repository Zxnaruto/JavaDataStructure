package test1;

/**
 * @author XiaoHuZiXianShengZx
 * 
 * ��Դ�����·���㷨��
 *     ��Դ�㵽������������·����
 * ���������
 *     ����̰�ķ���ÿһ�ζ���ֲ����ţ�����ھֲ��������ҵ����ս������Դ�㿪ʼÿ��������֮������·����ͨ����ͺͱȽϣ�
 *     ���Դ�㵽����������·����
 *     dist[i]��ʾ��ǰ��Դ������i���������·������,prev[i]=j�����·���ж���i��ǰһ��������j
 *     
 *     ���ģ�����ͨ���ֲ�����̾������;ֲ�����̾���Ƚϣ��ҳ����յ����·�������磺1��2��3��4��5��3�ľ�����̣��������㶼�����
 *     �����ʱ��·��1-4���Ϳ�����ֱ��1-4��1-3-4��˭��·�����̡�
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class dijkstra_z {

	public static int max=Integer.MAX_VALUE;//���ޣ�����û������·��
	  //��ں���
	  public static void main(String[] args)throws IOException {
		  
		    String str,str1;
			int x,y;//���������յ�
			BufferedReader buf;
			buf=new BufferedReader(new InputStreamReader(System.in));
			//��ʼ������
	        int[][] array = { { max, max, max, max, max, max },
	                          { max, 0, 10, max, 30, 100 }, 
	                          { max, max, 0, 50, max, max },
	                          { max, max, max, 0, max, 10 }, 
	                          { max, max, max, 20, 0, 60 },
	                          { max, max, max, max, max, 0 } };
	        int n = array.length;
	        int[] dist = new int[n];
	        int[] prev = new int[n];
	        
	        System.out.print("���������(��Ӧ���ͼ)��");
	        str=buf.readLine();
	        x=Integer.parseInt(str);
	        dijkstra(x, array, dist, prev);
	        System.out.print("�������յ㣺");
	        str1=buf.readLine();
	        y=Integer.parseInt(str1);
	        System.out.println(x+"�㵽"+y+"������·����");
	        trace(prev, y);
	       
	    }
	
	public static void dijkstra(int x, int[][] array, int[] dist, int[] prev) {
        // x��Դ�㣬dist[i]��ʾ��ǰ��Դ������i���������·������,prev[i]=j�����·���ж���i��ǰһ��������j������������
        int n = dist.length - 1;// �ڵ����
        if (x < 1 || x > n)
            return;
        boolean[] s = new boolean[n + 1];
        // ��ʼ�����ҳ�Դ�㵽������ľ���(��·����Ϊ���룬��·��Ϊ����)
        for (int i = 1; i <= n; i++) {
            dist[i] = array[x][i];
           
            s[i] = false;
            if (dist[i] == Integer.MAX_VALUE)
                prev[i] = 0;
            else
                prev[i] = x;
            
           
        }
        dist[x] = 0;
        s[x] = true;//��Դ����뼯��
        
        //�����Դ������ĵ㣬��Ҫ��Ϊ��������㿪ʼ����һ����
        for (int i = 1; i < n; i++) {// ѭ��n-1��
            int temp = Integer.MAX_VALUE;
            int u = x;
            for (int j = 1; j <= n; j++) {// Ѱ�Ҳ��ڼ������Ҿ��뼯������Ľڵ�j
                if ((!s[j]) && (dist[j] < temp)) {
                    u = j;// ��¼�ڵ�
                    temp = dist[j];// ��¼�������·������
                    
                }
               
            }
           
            s[u] = true;// ���ڵ�u���뼯��
            
            //���ҵ����Ǹ���Ϊ����������������Ϊǰ������һ���ڵ����̾��룬֮��������ȽϿ���ֱ�ӵ��̣������ж���ĵ����
            for (int j = 1; j <= n; j++) {// ��������dist[]��prev[]��ֵ
                if ((!s[j]) && (array[u][j] < Integer.MAX_VALUE)) {// Ѱ�Ҳ��ڼ����ڣ��ҿɴ�Ľڵ�
                    int newdist = dist[u] + array[u][j];
                    if (newdist < dist[j]) { // ���ֵ���бȽϣ�����С��ֵ
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
			
			System.out.print("�������ά�������������");
			str=buf.readLine();
			cow=Integer.parseInt(str);
			//��ʼ����ά����
			int array[][]=new int[cow][cow];
			for(int i=0;i<cow;i++) {
				for(int j=0;j<cow;j++) {
					array[i][j]=max;
				}
			}
			
			System.out.println("����������Ԫ�أ�");
			
		}*/
}
