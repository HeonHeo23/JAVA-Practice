package newLecture.ex2.OOP2UI;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ExamConsole list = new ExamConsole();
		
		int menu;
		boolean loop = true;
		
		while(loop) {
			menu = inputMenu();
			
			switch(menu) {
			case 1:
				list.inputList();
				break;
			case 2:
				list.printList();
				break;
			case 3:
				loop = exit();
				break;
			default:
				System.out.println("1~3 ������ ���ڸ� �Է��ϼ���.");
			}
		}
		
	}

	private static boolean exit() {
		System.out.println("���� ���� �ý����� �����մϴ�. �̿����ּż� �����մϴ�.");
		return false;
	}

	private static int inputMenu() {
		
		System.out.println("����������������������������������������������������");
		System.out.println("��      �� ��   �� ��                       ��");
		System.out.println("����������������������������������������������������");
		System.out.println("\t1. ���� �Է�");
		System.out.println("\t2. ���� ���");
		System.out.println("\t3. ����");
		System.out.println("\t���� >");
		
		Scanner scan = new Scanner(System.in);
				
		return scan.nextInt();
	}

}
