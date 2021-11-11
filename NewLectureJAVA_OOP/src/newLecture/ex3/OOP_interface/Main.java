package newLecture.ex3.OOP_interface;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.setX(b);
		
		a.print();
	}

}
