import java.util.*;

class BinarySearchTree<k extends Comparable<k>>{
	private TreeNode root;
	public BinarySearchTree(){
		root=null;
	}
	public boolean contains(k key){
		TreeNode current=root;
		if(key.compareTo(root.key)==0){
			return true;
		}else{
			while(current.left==null && current.right==null){
				if(key.compareTo(current.key)<0){
					current=current.left;
				}else if(key.compareTo(current.key)>0){
					current=current.right;
				}else{
					return true;
				}
			}
			return false;
		}
	}
	public boolean twoChildren(TreeNode node){	//Have both 2 children or is just leaves
		if(node==root){
			return (root.left==null)||(root.right==null);
		}else if(node.left==null && node.right==null){
			return true;
		}else{
			return twoChildren(node.left)^twoChildren(node.right);
		}
	}
	private class TreeNode{
		private k key;
		private TreeNode left,right;
		public TreeNode(k key){
			this.key=key;
		}
	}
}

public class test{
	public static void main(String args[]){   //test Aufgaben von Klausuren
		Number[]nums=new Integer[6];    //upcasting
		ArrayList<? extends Number> ls=new ArrayList<Double>(9);
		System.out.println("j");
	}
}
