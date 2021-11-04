package enumerate2;

public class Main {

	public static void main(String[] args) {
		
		/* enum 실습
		 * enum에는 order가 있다
		 * */
		
		// name() : return String that enum possess
		Week today = Week.SUNDAY;
		String name = today.name(); //
		System.out.println(name);
		
		//ordinal() : return which order the value is in
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		//a.compareTo(b) : return the comparison of order e.g. 
		Week day1 = Week.MONDAY;
		Week day2 = Week.TUESDAY;
		int result1 = day1.compareTo(day2); //-1
		int result2 = day2.compareTo(day1); //1
		System.out.println(result1); 
		System.out.println(result2);
		
		//valueOf() : return the value that is identical to the parameter -> use when converting String to enum
		if(args.length == 1) {
			String strDay = args[0];
			Week weekDay = Week.valueOf(strDay);
			if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY) {
				System.out.println("주말 이군요");
			} else {
				System.out.println("평일 이군요");
			}
		}
		
		//values() : return all values as an array
		Week[] days = Week.values();
		for (Week day : days) {
			System.out.println(day);
		}
		
	}

}
