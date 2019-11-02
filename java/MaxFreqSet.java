import java.util.*;
import java.lang.*;

/*
 * Max Frequent Set 
 *  
 * Using doubly LinkedList and HashMap, always keep the most frequent value in the head of linkedlist, 
 * so we can get it in constant time; 
 *  
 * add element O(1) 
 * delete element O(1) 
 * get the most frequent element O(1)
 *  
 */

public class MaxFreqSet {
	class Node {
		Node left;
		Node right;
		int freq;
		int val;
	}

	Node start, end;
	Map<Integer, Node> map;

	MaxFreqSet() {
		map = new HashMap<>();
		start = new Node();
		end = new Node();
		start.right = end;
		end.left = start;
	}

	public void add(int a) {
		Node cur = map.get(a);
		if(cur != null) {
			cur.freq++;
			if(cur.left != start && cur.freq > cur.left.freq) {
				//Exchange current Node with its left most same frequency
				Node iter = cur.left;
				while(iter != start && iter.freq < cur.freq) {
					iter = iter.left;
				}
				exchange(iter.right, cur);
			}
		} else {
			cur = new Node();
			cur.freq = 1;
			cur.val = a;
			map.put(a, cur);
			//Append cur to the doublylinkedlist's tail
			cur.left = end.left;
			cur.right = end;
			end.left.right = cur;
			end.left = cur;
		}
	}

	public void del(int a) {
		Node cur = map.get(a);
		if(cur != null) {
			if(cur.freq == 1) {
				map.remove(cur);
				cur.left.right = cur.right;
				cur.right.left = cur.left;
			} else {
				cur.freq--;
				if(cur.right != end && cur.freq < cur.right.freq) {
					//Exchange current Node with its right most same frequency 	
					Node iter = cur.right;
					while(iter != end && iter.freq > cur.freq) {
						iter = iter.right;
					}
					exchange(cur, iter.left);
				}
			}
		} 
	}

	public int getMaxFreq() {
		if(map.size() == 0) {	
			return 0;
		}
		return start.left.val;
	}
	
	public static void exchange(Node a, Node b) {
		if(a != b) {
			Node al = a.left;
			Node ar = a.right;
			Node bl = b.left;
			Node br = b.right;
			a.left = bl;
			a.right = br;
			b.left = al;
			b.right = ar;
			al.right = b;
			ar.left = b;
			bl.right = a;
			br.left = a;
		}
	}
}
