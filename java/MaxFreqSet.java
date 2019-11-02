import java.util.*;
import java.lang.*;

public class MaxFreqSet {
	class Node {
		Node left;
		Node right;
		int freq;
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
				//Exchange current Node with its left
				exchange(cur.left, cur);
			}
		} else {
			cur = new Node();
			cur.freq = 1;
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
					//exchange current Node with its right	
					exchange(cur, cur.right);
				}
			}
		} 
	}

	public int getMaxFreq() {
		if(map.size() == 0) {	
			return 0;
		}
		return start.left.freq;
	}
	
	public static void exchange(Node a, Node b) {
		a.left.right = b;
		b.right.left = a;
		a.right = b.right;
		b.left = a.left;
		a.left = b;
		b.right = a;
	}
}
