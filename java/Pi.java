//Calculate Pi using Monte Carlo method.
import java.lang.*;
import java.util.*;

public class Pi {
	public static void main(String args[]) {
		double x = 0;
		double y = 0;
		double count = 0;
		long times = 1000;

		if(args.length != 0) {
			times = Long.parseLong(args[0]);
		}

		for(int i = 0; i < times; i++)  {
			x = Math.random();
			y = Math.random();
			if( (x * x + y * y) < 1) {
				count++;
			}
		}		
		System.out.println("Pi calculated in " + times + " random tests:");
		System.out.println("pi = " + 4 * count / times);
	}
}
