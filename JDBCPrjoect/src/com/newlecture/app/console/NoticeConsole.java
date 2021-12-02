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
		
		System.out.println("───────────────────────");
		System.out.printf("<공지사항> 총 %d 게시글\n", count);
		System.out.println("───────────────────────");
		
		for(Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n",
					n.getId(), 
					n.getTitle(),
					n.getWriterID(),
					n.getRegDate());
		}
		
		System.out.println("───────────────────────");
		System.out.printf("          %d/%d pages\n", page, lastPage);
	}

	public int inputNoticeMenu() throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.상세 조회/ 2. 이전/ 3. 다음/ 4. 글쓰기 / 5. 검색 / 6. 종료>");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		return menu;
		
	}

	public void movePrevList() {
		if (page == 1) {
			System.out.println("이전 페이지가 없습니다.\n");
			return;
		}
		page--;
	}

	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count/10;
		lastPage = count%10>0?lastPage+1:lastPage;
		
		if (page == lastPage) {
			System.out.println("다음 페이지가 없습니다.\n");
			return;
		}
		
		page++;
	}

	public void inputSearchMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색 범주(title/content/writerID)중에 하나를 입력하세요\n");
		searchField = scan.nextLine();
		System.out.println("검색어 >");
		searchWord = scan.nextLine();
	}

}
