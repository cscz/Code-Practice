import java.lang.*;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors = null;
    
    public Node() {}
    
    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

public class GraphSearch {
    public static void main(String args[]) {
        Node node1 = new Node(1, new LinkedList<Node>());
        Node node2 = new Node(2, new LinkedList<Node>());
        Node node3 = new Node(3, new LinkedList<Node>());
        Node node4 = new Node(4, new LinkedList<Node>());
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);
	
	GraphSearch a = new GraphSearch();
	System.out.println("DFS results:");
	a.dfs(node1);
	System.out.println("BFS results:");
	a.bfs(node1);
    }
    
    public void dfs(Node start) {
        if(start == null) {
            return;
        }
        
        Stack<Node> stack = new Stack<>();
        Set<Node> seen = new HashSet<>();
        
        stack.push(start);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            for(Node neighbor : curr.neighbors) {
                if(!seen.contains(neighbor)) {
                    stack.push(neighbor);
                    seen.add(neighbor);
                }
            }
            System.out.println(curr.val);
        }
    }
    
    public void bfs(Node start) {
        if(start == null) {
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        Set<Node> seen = new HashSet<>();
        
        queue.offer(start);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.println(curr.val);
            for(Node neighbor : curr.neighbors) {
                if(!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }
}
