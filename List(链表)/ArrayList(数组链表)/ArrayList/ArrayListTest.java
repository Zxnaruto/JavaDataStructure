package ArrayList;

import java.util.Iterator;

/**
 * @author XiaoHuZiXianShengZx
 *
 * 测试MyArrayList类
 */
public class ArrayListTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		MyArrayList test=new MyArrayList();//创建MyArrayList对象 test
		System.out.println("初始数组的大小:"+test.size());
		System.out.println("初始数组是否为空："+test.isEmpty());
		//初始化数组元素
		test.add(0, 1);
		test.add(1, 2);
		test.add(2, 3);
		test.add(3, 4);
		test.add(4, 5);
		test.add(5, 6);
		test.add(6, 7);
		test.add(7, 8);
		test.add(8, 9);
		test.add(9, 10);
		//test.add(10, 11);
		System.out.println("数组元素为：");
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}

		System.out.println("\n"+"数组的大小:"+test.size());
		System.out.println("数组是否为空："+test.isEmpty());
		//调用set
		System.out.println("调用set:");
		test.set(6, 15);
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}
		//调用remove
		test.remove(6);
		System.out.println("\n"+"remove后的数组：");
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}
		
		//清除数组
		test.clear();
		System.out.println("\n"+"clear后的数组：");
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}
		System.out.println("数组是否为空："+test.isEmpty());
		
		
		
		
		//初始化数组元素
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);
		test.add(8);
		test.add(9);
		test.add(10);
		test.add(11);
		

     System.out.println("迭代器调用结果：");
     //迭代器调用
     Iterator ite=test.iterator();
     while(ite.hasNext()) {

     System.out.print(" "+ite.next());

       }
   //add插入
   		test.add(3,100);
   		System.out.println("\n"+"add后的数组：");
   		for(int i=0;i<test.size();i++) {
   			System.out.print(" "+test.get(i));
   		}
	}
}
