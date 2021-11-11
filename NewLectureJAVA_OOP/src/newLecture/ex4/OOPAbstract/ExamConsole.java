package newLecture.ex4.OOPAbstract;

import java.util.Scanner;

public abstract class ExamConsole {
	
	private ExamList list = new ExamList();
	
	public void input(){
	
		System.out.println("����������������������������������������");
		System.out.println("��     ���� �Է�                ��");
		System.out.println("����������������������������������������");
		System.out.println();
		
		Scanner scan = new Scanner(System.in);		
		
		int kor, eng, math;
		do {
			System.out.print("���� ����:");
			kor = scan.nextInt();
			
			if(kor<0||kor>100) {
				System.out.println("������ 1~100 ������ ���� �Է��ϼ���.");
			}
		} while(kor<0||kor>100);
		
		do {
			System.out.print("���� ����:");
			eng = scan.nextInt();
			
			if(eng<0||eng>100) {
				System.out.println("������ 1~100 ������ ���� �Է��ϼ���.");
			}
		} while(eng<0||eng>100);
		
		do {
			System.out.print("���� ����:");
			math = scan.nextInt();
			
			if(math<0||math>100) {
				System.out.println("������ 1~100 ������ ���� �Է��ϼ���.");
			}
		} while(math<0||math>100);
		
		Exam exam = makeExam();
		exam.setKor(kor);
		exam.setEng(eng);
		exam.setMath(math);
		
		onInput(exam);
		
		list.add(exam);
		
	}
	
	protected abstract void onInput(Exam exam);

	protected abstract Exam makeExam();

	public void print() {
		this.print(list.getCurrent()); 
	}
	
	public void print(int size) {
		System.out.println("����������������������������������������");
		System.out.println("��     ���� ���                ��");
		System.out.println("����������������������������������������");
		System.out.println();
		
		for(int i=0; i<size; i++) {
			
			Exam exam = list.get(i);
			int kor = exam.getKor();
			int eng = exam.getEng();
			int math = exam.getMath();
			
			System.out.printf("����: %d\n", kor);
			System.out.printf("����: %d\n", eng);
			System.out.printf("����: %d\n", math);
			onPrint(exam);
			
			int sum = exam.total();
			float avg = exam.avg();
			
			System.out.printf("����: %d\n", sum);
			System.out.printf("���: %.2f\n", avg);
			System.out.println("������������������������������������������������");
			
		}
		
	}
	
	protected abstract void onPrint(Exam exam);
}
