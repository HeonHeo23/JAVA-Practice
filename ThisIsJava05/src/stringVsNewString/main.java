package stringVsNewString;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVar1 = "��ö��";
		String strVar2 = "��ö��";
		
		System.out.println(strVar1 == strVar2);
		System.out.println(strVar1.equals(strVar2));
		
		String strVar3 = new String("��ö��");
		String strVar4 = new String("��ö��");
		
		System.out.println(strVar3 == strVar4);
		System.out.println(strVar3.equals(strVar4));
	}

}
