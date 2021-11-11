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
			System.out.print("정보 성적:");
			com = scan.nextInt();
			if(com<0||com>100) {
				System.out.println("성적은 1~100 사이의 수만 입력하세요.");
			}
		} while(com<0||com>100);
		
		newExam.setCom(com);
	}

	@Override
	protected void onPrint(Exam exam) {
				
	}

}
