package ex1;

import java.sql.SQLException;

import com.newlecture.app.console.NoticeConsole;

public class Program5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		NoticeConsole console = new NoticeConsole();
		
		EXIT: while(true) {
			console.printNoticeList();
			int menu = console.inputNoticeMenu();
			
			switch(menu) {
			case 1:
				break;
			case 2:
				console.movePrevList();
				break;
			case 3:
				console.moveNextList();
				break;
			case 4:
				break;
			case 5:
				console.inputSearchMenu();
				break;
			case 6:
				break EXIT;
			default: 
				System.out.println("<<��� ���>> �޴��� 1~4������ �Է��� �� �ֽ��ϴ�");
			}
		}
		
	}

}
