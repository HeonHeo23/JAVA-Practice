package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.serivce.NoticeService;

public class NoticeConsole {

	private NoticeService service;
	private int page;
	private String searchWord;
	private String searchField;
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
		searchField = "TITLE";
		searchWord = "";
	}
	
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		int count = service.getCount();
		int lastPage = count/10;
		lastPage = count%10>0?lastPage+1:lastPage;
		
		System.out.println("����������������������������������������������");
		System.out.printf("<��������> �� %d �Խñ�\n", count);
		System.out.println("����������������������������������������������");
		
		for(Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n",
					n.getId(), 
					n.getTitle(),
					n.getWriterID(),
					n.getRegDate());
		}
		
		System.out.println("����������������������������������������������");
		System.out.printf("          %d/%d pages\n", page, lastPage);
	}

	public int inputNoticeMenu() throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.�� ��ȸ/ 2. ����/ 3. ����/ 4. �۾��� / 5. �˻� / 6. ����>");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		return menu;
		
	}

	public void movePrevList() {
		if (page == 1) {
			System.out.println("���� �������� �����ϴ�.\n");
			return;
		}
		page--;
	}

	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count/10;
		lastPage = count%10>0?lastPage+1:lastPage;
		
		if (page == lastPage) {
			System.out.println("���� �������� �����ϴ�.\n");
			return;
		}
		
		page++;
	}

	public void inputSearchMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�˻� ����(title/content/writerID)�߿� �ϳ��� �Է��ϼ���\n");
		searchField = scan.nextLine();
		System.out.println("�˻��� >");
		searchWord = scan.nextLine();
	}

}
