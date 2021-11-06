package newLecture.ex3.Struct;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Exam[] exams = new Exam[3];
		boolean loop = true;
		
		while(loop) {
		
			int menu = inputMenu();
			
			switch(menu) {
			case 1:
				inputList(exams);
				break;
				
			case 2:
				print(exams);
				break;
				
			case 3:
				loop = exit();
				break;
				
			default:
				System.out.println("�߸��� ���� �Է��߽��ϴ�. 1~3�� ���ڸ� �Է����ּ���.");
				
			}
			
		}
		
	}

	private static boolean exit() {
		System.out.println("�̿����ּż� �����մϴ�.");
		return false;
	}

	private static void inputList(Exam[] exams) {	
		
		Scanner scan = new Scanner(System.in);
		System.out.println("����������������������������������������");
		System.out.println("��     ���� �Է�                ��");
		System.out.println("����������������������������������������");
		System.out.println();
		
		for(int i=0; i<exams.length; i++) {
			
			Exam exam = new Exam();
		
			int kor, eng, math;
			
			do {
				System.out.printf("����: ");
				kor = scan.nextInt();
				
				if(kor < 0 || 100 < kor)
					System.out.println("���� ������ 0~100������ ������ �Է��ϼ���");
				
			} while(kor < 0 || 100 < kor);
			
			do {
				System.out.printf("����: ");
				eng = scan.nextInt();
				
				if(eng < 0 || 100 < eng)
					System.out.println("���� ������ 0~100������ ������ �Է��ϼ���");
				
			} while(eng < 0 || 100 < eng);
			
			do {
				System.out.printf("����: ");
				math = scan.nextInt();
				
				if(math < 0 || 100 < math)
					System.out.println("���� ������ 0~100������ ������ �Է��ϼ���");
				
			} while(math < 0 || 100 < math);
			
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;
			exams[i] = exam;
		}
		
	}

	private static void print(Exam[] exams) {
		
		System.out.println("����������������������������������������");
		System.out.println("��     ���� ���                ��");
		System.out.println("����������������������������������������");
		System.out.println();
		
		for (int i=0; i<3; i++) {
			Exam exam = exams[i];
			
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;
			
			System.out.printf("����: %3d\n", kor);
			System.out.printf("����: %3d\n", eng);
			System.out.printf("����: %3d\n", math);
	
			int total = kor + math + eng;
			float avg = total/3.0f;
			
			System.out.printf("���� : %3d\n", total);
			System.out.printf("��� : %6.2f\n", avg);
			System.out.println("������������������������������������������������");
		}
		
	}

	private static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("����������������������������������������������������");
		System.out.println("��      �� ��   �� ��                       ��");
		System.out.println("����������������������������������������������������");
		System.out.println("\t1. ���� �Է�");
		System.out.println("\t2. ���� ���");
		System.out.println("\t3. ����");
		System.out.println("\t���� >");
		
		return scan.nextInt();
	}
	
	

}
