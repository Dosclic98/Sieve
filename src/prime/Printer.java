package prime;

public class Printer {
	public static void printMatrixCmpl(int[][] arr, int n) {
		for(int i=0;i<n;i++) {
			System.out.println("[" + arr[i][0] + ", " + arr[i][1] + "]");
		}
	}
	public static void printMatrixPrime(int[][] arr, int n) {
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(arr[i][1] == 0) {
				System.out.print("[" + arr[i][0] + "]" + ", ");
				cnt++;
				if((cnt%5) == 0) {
					System.out.println("");
				}
			}
		}
	}
}
