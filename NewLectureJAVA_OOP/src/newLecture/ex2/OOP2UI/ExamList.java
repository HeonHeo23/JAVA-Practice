package newLecture.ex2.OOP2UI;

public class ExamList {
	private Exam[] exams;
	private int current;
	
	public ExamList() {
		this(0);
	}
	
	public ExamList(int size){
		this.exams = new Exam[size];
		this.current = 0;
	}
	
	public Exam get(int i) {
		return this.exams[i];
	}
	
	public void add(Exam exam) {

		int size = this.getCurrent();
		Exam[] exams = this.getExams();
		
		if(size == exams.length) {
			Exam[] temp = new Exam[size + 3];
			for(int i=0;i<exams.length;i++) {
				temp[i] = exams[i];
			}
			exams = temp;
		}
		
		exams[size] = exam;
		this.setExams(exams);
		size++;
		this.setCurrent(size);
		
	}
	
	public Exam[] getExams() {
		return exams;
	}
	public void setExams(Exam[] exams) {
		this.exams = exams;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}

	
}
