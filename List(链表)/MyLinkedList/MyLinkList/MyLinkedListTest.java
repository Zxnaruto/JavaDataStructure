package MyLinkList;

/**
 * @author XiaoHuZiXianShengZx
 *
 * ��MyLinkedList����
 *
 */
import java.util.Iterator;

public class MyLinkedListTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		MyLinkedList test=new MyLinkedList();//����MyLinkedList����test����ʱ���캯����ʼ��
		//add����
		test.add(0, 1);
		test.add(1, 2);
		test.add(2, 3);
		test.add(3, 4);
		test.add(4, 5);
		System.out.print("add����:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//size()����
		System.out.print("\n"+"������Ϊ��"+test.size());
		//isEmpty()����
		System.out.print("\n"+"�����Ƿ�Ϊ�գ�"+test.isEmpty());
		//β������
		test.add(6);
		System.out.print("\n"+"addβ���������:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//�������
		test.add(2,0);
		System.out.print("\n"+"add����������:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//remove
		test.remove(2);
		System.out.print("\n"+"remove����:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		//get
		System.out.print("\n"+"get����:"+test.get(3));
		//set
		System.out.print("\n"+"set����:");
		for(int i=0;i<test.size();i++) {
			System.out.print(test.get(i)+" ");
		}
		
		//������
		Iterator MyIterator=test.iterator();
		System.out.print("\n"+"����������:");
		while(MyIterator.hasNext()) {
			System.out.print(MyIterator.next()+" ");
		}
	}
}
