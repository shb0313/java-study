package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
		
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		stateCode = 1;
	}
	
	public void print() {
		System.out.println("책 제목: " + getBookNo() + ", 작가: " + getTitle() + "대여 유무: " + ((stateCode == 0) ? "대여중" : "재고있음") );
	}
		
	public void rent(int bookNo) {
		if( stateCode == 1) {
			stateCode = 0;
			System.out.println(getTitle() + "이(가) 대여되었습니다.");
		}else {
			System.out.println(getTitle() + "이(가) 대여중입니다.");
		}
	}
	
	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
