package omok;

public class Main {
	
	public static void main(String[] args) {
		
		for(int y=1; y<=10; y++) {
			for (int x=1; x<=10; x++) {
				if(x==4&&y==3)
					System.out.printf("%c",'¡Û');
				else if(x==1&&y==1) {
					System.out.printf("%c",'¦£');
				}
				else if(x==10&&y==1) {
					System.out.printf("%c",'¦¤');
				}
				else if(x==1&&y==10) {
					System.out.printf("%c",'¦¦');
				}
				else if(x==10&&y==10) {
					System.out.printf("%c",'¦¥');
				}
				else if(x==1) {
					System.out.printf("%c",'¦§');
				}
				else if(y==1) {
					System.out.printf("%c",'¦¨');
				}
				else if(x==10) {
					System.out.printf("%c",'¦©');
				}
				else if(y==10) {
					System.out.printf("%c",'¦ª');
				}
				else
					System.out.printf("%c",'¦«');
			}
			
			System.out.println();
		}
		
	}
	
}
