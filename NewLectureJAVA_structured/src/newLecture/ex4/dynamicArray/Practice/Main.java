package newLecture.ex4.dynamicArray.Practice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ExamList list = new ExamList();
		list.exams = new Exam[0];
		list.current = 0;
		
		boolean loop = true;
		
		while(loop) {
			
			int menu = inputMenu();
			
			switch(menu) {
			case 1:
				input(list);
				break;
				
			case 2:
				print(list);
				break;
				
			case 3:
				loop = exit();
				break;
				
			default:
				System.out.println("1~3 사이의 숫자를 입력하세요.");
			}
			
		}
		

	}

	private static void print(ExamList list) {
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		Exam[] exams = list.exams;
		int size = list.current;
		
		for(int i=0; i<size; i++) {
			
			Exam exam = exams[i];
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;
			
			System.out.printf("국어: %d\n", kor);
			System.out.printf("영어: %d\n", eng);
			System.out.printf("수학: %d\n", math);
			
			int sum = kor+eng+math;
			float avg = sum / 3.0f;
			
			System.out.printf("총점 : %3d\n", sum);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
		
	}

	private static void input(ExamList list) {
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);		
		
		int kor, eng, math;
		
		do {
			System.out.print("국어 성적:");
			kor = scan.nextInt();
			
			if (kor<0 && kor>100) {
				System.out.println("성적은 1~100 사이의 수만 입력하세요.");
			}
			
		} while (kor<0 && kor>100);
		
		do {
			System.out.print("영어 성적:");
			eng = scan.nextInt();
			
			if (eng<0 && eng>100) {
				System.out.println("성적은 1~100 사이의 수만 입력하세요.");
			}
			
		} while (eng<0 && eng>100);
		
		do {
			System.out.print("수학 성적:");
			math = scan.nextInt();
			
			if (math<0 && math>100) {
				System.out.println("성적은 1~100 사이의 수만 입력하세요.");
			}
			
		} while (math<0 && math>100);
		
		Exam exam = new Exam();
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		
		Exam[] exams = list.exams;
		int current = list.current;
		
		if(exams.length == current) {
			Exam[] temp = new Exam[current+3];
			for(int i=0; i<current; i++) {
				temp[i] = exams[i]; 
			}
			list.exams = temp;
		}
		
		list.exams[current] = exam;
		list.current++;
		
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
