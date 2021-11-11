package newLecture.ex3.OOP_interface;

public class A {
	private X x;
	
	public void setX(X x) {
		this.x = x;
	}

	public void print() {
		int total = x.total();
		System.out.printf("%d",total);
	}
	
}
