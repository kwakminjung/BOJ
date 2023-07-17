/*
백준 1068번 : 트리 (골드5)
알고리즘 분류 : 그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색
풀이 : https://cuckoobird.tistory.com/107
결과 : 맞았습니다 (메모리 14312KB | 시간 128ms | 코드 길이 2209B)
*/

import java.io.*;
import java.util.*;

public class Main {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(bf.readLine());
		Node root = null;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		ArrayList<Node> node = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			node.add(new Node(i));
		}
		
		for(int i = 0 ; i < n ; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(input != -1) {
				node.get(i).parentSet(node.get(input));
				node.get(input).childAdd(node.get(i));
			} else {
				root = node.get(i);
			}
		}
		
		int e = Integer.parseInt(bf.readLine());
		
		if(root.getData() == e) {
			bw.write("0");
		} else {
			Node removeNode = node.get(e);
			Node parentNode = removeNode.getParent();
			parentNode.getChildren().remove(removeNode);
			node.remove(removeNode);
			
			dfs(root);
			
			bw.write(Integer.toString(cnt));			
		}
		
		bf.close();
		bw.flush();
		bw.close();
	}
	
	private static void dfs(Node node) {
		node.setVisited(true);
		if(!node.IsChild()) {
			cnt ++;
			return;
		}
		ArrayList<Node> children = node.getChildren();
		for(Node child : children) {
			if(!child.isVisited()) {
				dfs(child);
			}
		}
	}
}

class Node {
	private ArrayList<Node> children;
	private int data;
	private Node parent;
	private boolean visited;
	
	public Node(int data) {
		this.data = data;
		this.children = new ArrayList<>();
		this.parent = null;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void childAdd(Node child) {
		children.add(child);
	}
	
	public void parentSet(Node parent) {
		this.parent = parent;
	}
	
	public boolean IsChild() {
		return children != null && !children.isEmpty();
	}
	
	public ArrayList<Node> getChildren() {
        return children;
    }
	
	public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public int getData() {
    	return data;
    }
}
