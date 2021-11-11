package newLecture.ex4.OOPAbstract;

public abstract class Exam {
	private int kor, eng, math;

	public Exam() {
		this(0,0,0);
	}
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	public abstract int total();
	
	public int onTotal() {
		return getKor()+getEng()+getMath();
	}
	
	public abstract float avg();
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}
