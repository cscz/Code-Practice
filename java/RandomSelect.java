import java.util.*;
import java.lang.*;
public class RandomSelect {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		while(input.hasNext()) {
			list.add(input.next());
		}
		System.out.println(select(list));
	}

	public static String select(List<String> list) {
		if(list.size() == 0) {
			return "";
		}
		String res = "";
		Random rand = new Random();
		for(int i = 0; i < list.size(); i++) {
			int r = rand.nextInt(i + 1);
			if(r == 0) {
				res = list.get(i);	
			}
			System.out.println("r = " + r + " , res = " + res);
		}
		return res;
	}
}
