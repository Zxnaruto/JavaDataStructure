package MyLinkList;

/**
 * @author XiaoHuZiXianShengZx
 *
 * 对MyLinkedList调用
 *
 */
import java.util.Iterator;

public class MyLinkedListTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		MyLinkedList test=new MyLinkedList();//创建MyLinkedList对象test，此时构造函数初始化
		//add调用
		test.add(0, 1);
		test.add(1, 2);
		test.add(2, 3);
		test.add(3, 4);
		test.add(4, 5);
		System.out.print("add调用:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//size()调用
		System.out.print("\n"+"链表长度为："+test.size());
		//isEmpty()调用
		System.out.print("\n"+"链表是否为空："+test.isEmpty());
		//尾部插入
		test.add(6);
		System.out.print("\n"+"add尾部插入调用:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//任意插入
		test.add(2,0);
		System.out.print("\n"+"add任意插入调用:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//remove
		test.remove(2);
		System.out.print("\n"+"remove调用:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//get
		System.out.print("\n"+"get调用:"+test.get(3));
		//set
		System.out.print("\n"+"set调用:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		
		//迭代器
		Iterator MyIterator=test.iterator();
		System.out.print("\n"+"迭代器调用:");
		while(MyIterator.hasNext()) {
			System.out.print(MyIterator.next()+" ");
		}
	}
}
