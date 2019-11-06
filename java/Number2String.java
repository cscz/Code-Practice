/* 
 * Transfer input number to String
 */

import java.lang.*;

public class Number2String {
	public static void main(String args[]) {
		for(String s : args) {
			int cur = Integer.parseInt(s);
			//if(cur >= 0 && cur < 26) {
			if(cur >= 1 && cur <= 26) {
				//cur = 'A' + cur;
				cur = 'A' + cur - 1;
				System.out.print((char) cur);
				//System.out.print((char) cur + " ");
			}
		}
		System.out.println();
	}
}
