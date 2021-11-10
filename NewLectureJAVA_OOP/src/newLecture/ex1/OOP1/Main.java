package newLecture.ex1.OOP1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ExamList list = new ExamList();
		
		int menu;
		boolean loop = true;
		
		while(loop) {
			menu = inputMenu();
			
			switch(menu) {
			case 1:
				list.inputList();
				break;
			case 2:
				list.printList(list.getCurrent());
				break;
			case 3:
				loop = exit();
				break;
			default:
				System.out.println("1~3 사이의 숫자를 입력하세요.");
			}
		}
		
	}

	private static boolean exit() {
		System.out.println("성적 관리 시스템을 종료합니다. 이용해주셔서 감사합니다.");
		return false;
	}

	private static int inputMenu() {
		
		System.out.println("┌────────────────────────┐");
		System.out.println("│      메 인   메 뉴                       │");
		System.out.println("└────────────────────────┘");
		System.out.println("\t1. 성적 입력");
		System.out.println("\t2. 성적 출력");
		System.out.println("\t3. 종료");
		System.out.println("\t선택 >");
		
		Scanner scan = new Scanner(System.in);
		
		return scan.nextInt();
	}

}
