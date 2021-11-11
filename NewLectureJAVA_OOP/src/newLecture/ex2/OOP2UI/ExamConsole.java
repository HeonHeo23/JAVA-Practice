package newLecture.ex2.OOP2UI;

import java.util.Scanner;

public class ExamConsole {
	
	private ExamList list = new ExamList();
	
	public void inputList(){
	
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 입력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);		
		
		int kor, eng, math;
		do {
			System.out.print("국어 성적:");
			kor = scan.nextInt();
			
			if(kor<0||kor>100) {
				System.out.println("성적은 1~100 사이의 수만 입력하세요.");
			}
		} while(kor<0||kor>100);
		
		do {
			System.out.print("영어 성적:");
			eng = scan.nextInt();
			
			if(eng<0||eng>100) {
				System.out.println("성적은 1~100 사이의 수만 입력하세요.");
			}
		} while(eng<0||eng>100);
		
		do {
			System.out.print("수학 성적:");
			math = scan.nextInt();
			
			if(math<0||math>100) {
				System.out.println("성적은 1~100 사이의 수만 입력하세요.");
			}
		} while(math<0||math>100);
		
		Exam exam = new Exam(kor,eng,math);
		
		list.add(exam);
		
	}
	
	public void printList() {
		this.printList(list.getCurrent()); 
	}
	
	public void printList(int size) {
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		for(int i=0; i<size; i++) {
			
			Exam exam = list.get(i);
			int kor = exam.getKor();
			int eng = exam.getEng();
			int math = exam.getMath();
			
			System.out.printf("국어: %d\n", kor);
			System.out.printf("영어: %d\n", eng);
			System.out.printf("수학: %d\n", math);
			
			int sum = exam.total();
			float avg = exam.avg();
			
			System.out.printf("총합: %d\n", sum);
			System.out.printf("평균: %.2f\n", avg);
			System.out.println("────────────────────────");
			
		}
		
	}
}
