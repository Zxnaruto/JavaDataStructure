package ArrayList;

import java.util.Iterator;

/**
 * @author XiaoHuZiXianShengZx
 *
 * ����MyArrayList��
 */
public class ArrayListTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		MyArrayList test=new MyArrayList();//����MyArrayList���� test
		System.out.println("��ʼ����Ĵ�С:"+test.size());
		System.out.println("��ʼ�����Ƿ�Ϊ�գ�"+test.isEmpty());
		//��ʼ������Ԫ��
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
		System.out.println("����Ԫ��Ϊ��");
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}

		System.out.println("\n"+"����Ĵ�С:"+test.size());
		System.out.println("�����Ƿ�Ϊ�գ�"+test.isEmpty());
		//����set
		System.out.println("����set:");
		test.set(6, 15);
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}
		//����remove
		test.remove(6);
		System.out.println("\n"+"remove������飺");
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}
		
		//�������
		test.clear();
		System.out.println("\n"+"clear������飺");
		for(int i=0;i<test.size();i++) {
			System.out.print(" "+test.get(i));
		}
		System.out.println("�����Ƿ�Ϊ�գ�"+test.isEmpty());
		
		
		
		
		//��ʼ������Ԫ��
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
		

     System.out.println("���������ý����");
     //����������
     Iterator ite=test.iterator();
     while(ite.hasNext()) {

     System.out.print(" "+ite.next());

       }
   //add����
   		test.add(3,100);
   		System.out.println("\n"+"add������飺");
   		for(int i=0;i<test.size();i++) {
   			System.out.print(" "+test.get(i));
   		}
	}
}
