package newLecture.ex1.BottomUp;

import java.util.Scanner;

public class Main {

	public static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[] kors = new int[3];
		
		boolean keepLoop = true;
		int menu;
		
		while(keepLoop) {
			menu = inputMenu();
			
			switch(menu) {
			case 1:
				inputScores(kors);
				break;
			case 2:
				outputScores(kors);
				break;
			case 3:
				System.out.println("Bye~~");
				
				keepLoop = false;
				break;
				
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
			
		}
		
	}
	
	static int inputMenu() {

		System.out.println("┌────────────────────────┐");
		System.out.println("│      메 인   메 뉴                       │");
		System.out.println("└────────────────────────┘");
		System.out.println("\t1. 성적 입력");
		System.out.println("\t2. 성적 출력");
		System.out.println("\t3. 종료");
		System.out.println("\t선택 >");
		
		return scan.nextInt();
	}
	
	static void inputScores(int[] kors) {	
		
		int kor;
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		for(int i = 0; i < 3; i++) {
			do {
				System.out.printf("국어%d : ", i+1);
				kor = scan.nextInt();
				
				if(kor < 0 || 100 < kor)
				{
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			} while(kor<0 || 100 < kor);
			
			kors[i] = kor;
		}
		
		System.out.println("────────────────────────");
		
	}
	
	static void outputScores(int[] kors) {
		
		int total = 0;
		float avg;
		
		for(int i = 0; i < 3; i++) {
			total += kors[i];
		}
		avg = total / 3.0f;
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력            │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		for(int i = 0; i < 3; i++) {
			System.out.printf("국어 %d : %3d\n", 3-i, kors[i]);
		}
		System.out.printf("총점 : %3d\n", total);
		System.out.printf("평균 : %6.2f\n", avg);
		System.out.println("────────────────────────");
		
	}

}
