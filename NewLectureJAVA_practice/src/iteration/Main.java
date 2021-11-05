package iteration;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("%c",'¡Ù');
			}
			System.out.println();
		}
		
		for(int i = 1; i < 11; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%c",'¡Ù');
			}
			System.out.println();
		}
		
		for(int i = 10; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%c",'¡Ù');
			}
			System.out.println();
		}
		
		for(int i=0; i<5; i++)
			if(i==4)
				System.out.printf("%c",'A'+i);
			else if(i%2==1)
				System.out.printf(" , ");
			else
				System.out.printf("%c, ",'A'+i);
		System.out.println();
		
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				System.out.printf("%d ", y*3+x+1);
			}
			System.out.println();
		}
		
	}

}
