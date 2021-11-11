package newLecture.ex4.OOPAbstract;

public class NewExam extends Exam{
	private int com;
	
	public NewExam() {
		this(0,0,0,0);
	}
	
	public NewExam(int kor, int eng, int math, int com) {
		super(kor, eng, math);
		this.setCom(com);
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}
	
	
	@Override
	public int total() {
		return onTotal() + com;
	}
	
	@Override
	public float avg() {
		return this.total()/4.0f;
	}
}
