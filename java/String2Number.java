/*
 * Transfer input String to number by characters
 */

import java.lang.*;
public class String2Number {

	public static void main(String args[]) {
		for(String s : args) {
			char[] str = s.toCharArray();
			System.out.print(s.toUpperCase() + "\t");
			for(char c : str) {
				if(c >= 'a' && c <= 'z') {
					System.out.print(c + 1 - 'a' + " ");
				}
				if(c >= 'A' && c <= 'Z') {
					System.out.print(c + 1 - 'A' + " ");
				}
			}
			System.out.println(); 
		}
	}
}
