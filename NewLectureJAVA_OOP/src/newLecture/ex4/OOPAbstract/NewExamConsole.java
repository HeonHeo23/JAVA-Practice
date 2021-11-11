package newLecture.ex4.OOPAbstract;

import java.util.Scanner;

public class NewExamConsole extends ExamConsole {

	@Override
	protected Exam makeExam() {
		return new NewExam();
	}

	@Override
	protected void onInput(Exam exam) {
		
		NewExam newExam =(NewExam) exam;
		
		Scanner scan = new Scanner(System.in);
		int com;
		do {
			System.out.print("���� ����:");
			com = scan.nextInt();
			if(com<0||com>100) {
				System.out.println("������ 1~100 ������ ���� �Է��ϼ���.");
			}
		} while(com<0||com>100);
		
		newExam.setCom(com);
	}

	@Override
	protected void onPrint(Exam exam) {
				
	}

}
