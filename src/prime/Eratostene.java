package prime;
import java.util.ArrayList;
public class Eratostene {
	
	/* Defines all'prime numbers up to a given one using sieve of Erathostenes*/
	public static ArrayList<Integer> sieve(int n) {
		ArrayList<Integer> seq;
		seq = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			seq.add(i+1);
		}
		for(int i=0;i<seq.size();i++) {
			for(int j=i+1;j<seq.size();j++) {
				if((seq.get(j) % seq.get(i)) == 0) {
					seq.remove(j);
				}
			}
		}
		
			
		return seq;
	}
}
