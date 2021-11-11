package newLecture.ex1.OOP1;

import java.util.Scanner;

public class ExamList {
	private Exam[] exams;
	private int current;
	
	public ExamList() {
		this(0);
	}
	
	public ExamList(int size){
		this.exams = new Exam[size];
		this.current = 0;
	}
	
	void printList() {
		this.printList(this.getCurrent()); 
	}
	
	void printList(int size) {
		System.out.println("┌──────────────────┐");
		System.out.println("│     성적 출력                │");
		System.out.println("└──────────────────┘");
		System.out.println();
		
		Exam[] exams = this.getExams();
		
		for(int i=0; i<size; i++) {
			
			Exam exam = exams[i];
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
		
		int size = this.getCurrent();
		Exam[] exams = this.getExams();
		
		if(size == exams.length) {
			Exam[] temp = new Exam[size + 3];
			for(int i=0;i<exams.length;i++) {
				temp[i] = exams[i];
			}
			exams = temp;
		}
		
		exams[size] = exam;
		this.setExams(exams);
		size++;
		this.setCurrent(size);
		
	}
	
	static public void inputList(ExamList list){
		
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
		
		Exam exam = new Exam();
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
		
		int size = list.getCurrent();
		Exam[] exams = list.getExams();
		
		if(size == exams.length) {
			Exam[] temp = new Exam[size + 3];
			for(int i=0;i<exams.length;i++) {
				temp[i] = exams[i];
			}
			exams = temp;
		}
		
		list.exams[size] = exam;
		list.current++;
		
	}
	
	
	public Exam[] getExams() {
		return exams;
	}
	public void setExams(Exam[] exams) {
		this.exams = exams;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}

	
}
