package prime;

public class Eratostene {
	
	/* Defines all'prime numbers up to a given one using sieve of Erathostenes*/
	public static int[][] sieve(int n) {
		int[][] seq = new int[n][2];
		
		for(int i=0;i<n;i++) {
			seq[i][0] = i+1;
		}
		for(int j=1;j<n;j++) {
			if(seq[j][1]==-1) {
				continue;
			}
			for(int k=j+1;k<n;k++) {
				if((seq[k][0] % seq[j][0]) == 0) {
					seq[k][1] = -1;
				}
			}
		}
		return seq;
	}
}
