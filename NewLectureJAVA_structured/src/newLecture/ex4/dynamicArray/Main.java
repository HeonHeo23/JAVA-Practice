package newLecture.ex4.dynamicArray;

import java.util.Scanner;

import newLecture.ex4.dynamicArray.Exam;

public class Main {
	
	public static void main(String[] args) {
		
		ExamList list = new ExamList();
		list.exams = new Exam[3];
		list.current = 0;
		
		boolean loop = true;
		
		while(loop) {
		
			int menu = inputMenu();
			
			switch(menu) {
			case 1:
				inputList(list);
				break;
				
			case 2:
				printList(list);
				break;
				
			case 3:
				loop = exit();
				break;
				
			default:
				System.out.println("잘못된 값을 입력했습니다. 1~3의 숫자를 입력해주세요.");
				
			}
			
		}
		
	}

	private static boolean exit() {
		System.out.println("이용해주셔서 감사합니다.");
		return false;
	}

	private static void inputList(ExamList list) {	
		
		Scanner scan = new Scanner(System.in);
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		int kor, eng, math;
		
		do {
			System.out.printf("국어: ");
			kor = scan.nextInt();
			
			if(kor < 0 || 100 < kor)
				System.out.println("국어 성적은 0~100까지의 범위만 입력하세요");
			
		} while(kor < 0 || 100 < kor);
		
		do {
			System.out.printf("영어: ");
			eng = scan.nextInt();
			
			if(eng < 0 || 100 < eng)
				System.out.println("영어 성적은 0~100까지의 범위만 입력하세요");
			
		} while(eng < 0 || 100 < eng);
		
		do {
			System.out.printf("수학: ");
			math = scan.nextInt();
			
			if(math < 0 || 100 < math)
				System.out.println("수학 성적은 0~100까지의 범위만 입력하세요");
			
		} while(math < 0 || 100 < math);
		
		Exam exam = new Exam();
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		
		Exam[] exams = list.exams;
		int size = list.current;
		
		if(exams.length == size) {
			Exam[] temp = new Exam[size+5];
			for(int i=0; i<size;i++) {
				temp[i] = exams[i];
			}
			list.exams = temp;
		}
		
		list.exams[list.current] = exam;
		list.current++;
		
	}

	private static void printList(ExamList list) {
		
		Exam[] exams = list.exams;
		int size = list.current;
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		
		for (int i=0; i<size; i++) {
			Exam exam = exams[i];
			
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;
			
			System.out.printf("국어: %3d\n", kor);
			System.out.printf("영어: %3d\n", eng);
			System.out.printf("수학: %3d\n", math);
	
			int total = kor + math + eng;
			float avg = total/3.0f;
			
			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
		
	}

	private static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌────────────────────────┐");
		System.out.println("│      메 인   메 뉴                       │");
		System.out.println("└────────────────────────┘");
		System.out.println("\t1. 성적 입력");
		System.out.println("\t2. 성적 출력");
		System.out.println("\t3. 종료");
		System.out.println("\t선택 >");
		
		return scan.nextInt();
	}
	
	

}

