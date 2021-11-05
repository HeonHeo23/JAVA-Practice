/**
 * Practice bit operation
 * https://www.youtube.com/watch?v=yHBYeguDR0A&ab_channel=%EC%97%94%EC%A7%80%EB%8B%88%EC%96%B4%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD
 */
package bitOperation;

import javax.swing.JOptionPane;

public class Main {

	/**
	 * @param args
	 */
	static int input(String a, String b) {
		String c = "Please type the " + a + " you want to " + b + ".";
		return Integer.parseInt(JOptionPane.showInputDialog(c));
	}
	
	static boolean getBit(int num, int i) {
		//get bit of number at index i		
		return (num & (1 << i)) != 0;
	}
	static int setBit(int num, int i) {
		//set bit of number at index i 1
		return num | (1 << i);
	}
	static int clearBit(int num, int i) {
		//clear bit of number at index i
		return num & ~(1 << i);
	}
	static int clearLeftBits(int num, int i) {
		/* ex
		 * num 11001
		 * i 3
		 * 1 << 3
		 * 1000
		 * 1000 - 1
		 * 0111
		 * 11001 & 00111
		 * 00001
		 * */
		return num & ((1 << i) - 1);
	}
	static int clearRightBits(int num, int i) {
		/* num 10101
		 * i 3
		 * i + 1 = 4
		 * -1 11111
		 * -1 << 4
		 * 10000 & 10101
		 * 10000
		 * */
		return num & ((-1 << (i + 1)));
	}
	static int updateBit(int num, int i, boolean val) {
		/* num 10101
		 * i 2
		 * 1 << 2
		 * ~1000
		 * 11011
		 * 10101 & 11011
		 * 10001
		 * 1:0 << 2
		 * 100:000
		 * 00100|10001 : 00000|10001
		 * 10101:10001
		 * */
		return num & ~(1 << i) | ((val? 1:0) << i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while (true) {
			int a = input("number", "check");
			int b = input("index", "check");
			System.out.println(getBit(a,b));
			
			a = input("number", "set");
			b = input("index", "set");
			System.out.println(setBit(a,b));
			
			a = input("number", "clear");
			b = input("index", "clear");
			System.out.println(clearBit(a,b));
			
			a = input("number", "clearLeft");
			b = input("index", "clearLeft");
			System.out.println(clearLeftBits(a,b));
			
			a = input("number", "clearRights");
			b = input("index", "clearRights");
			System.out.println(clearRightBits(a,b));
			
			a = input("number", "update");
			b = input("index", "update");
			boolean c = input("boolean", "update") != 0;
			System.out.println(updateBit(a,b,c));
		//}
	}

}
