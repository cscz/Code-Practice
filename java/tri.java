//Euler No.12
public class tri {
	public static void main(String args[]) { 
		long n = 1, max = 0, num = 0, count = 0;
		while(count < 1000) {
			count = 0;
			num = n * (n + 1) / 2;
			int i = 1;
			for(; i < Math.sqrt(num); i++) {
				if(num % i == 0) {
					count++;
				}	
			}
			count = 2 * count;
			if(i * i == num)  count++;
			if(count > max) {
				max = count;
				System.out.println("num = " + num + " , count = " + count);
			}
			n++;
		}
		System.out.println("n = " + n + " , num = " + num);
	}
}
