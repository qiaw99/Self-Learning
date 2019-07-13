/**
Teilequelle: https://github.com/StriverLi/Data-Structures-and-Algorithms-in-Java/blob/master/src/tree/BinaryTreeNode.java
*/

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
	
	public k min(TreeNode node){	//遍历二叉树获取最小值
		TreeNode temp=root;
		while(temp.left!=null){
			temp=temp.left;
		}
		return temp.key;
	}
	
	public int depthOfBinaryTree(TreeNode root){	//树的深度
        if (null == root){
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null){
            left = depthOfBinaryTree(root.left);
        }
        if (root.right != null){
            right = depthOfBinaryTree(root.right);
        }
        return ((left > right) ? left : right) + 1;
    }
	
	public boolean isBanlancedTree(TreeNode root){	//判断树是否平衡
        if (root==null){
            return false;
        }
        int left = depthOfBinaryTree(root.left);
        int right = depthOfBinaryTree(root.right);
        int diff = Math.abs(left - right);
        if (diff > 1){
            return false;
        }
        return isBanlancedTree(root.left) && isBanlancedTree(root.right);
    }
	
	public int numOfLeavesInRecursion(TreeNode root){ // 获取二叉树叶子节点的个数的递归算法
		if(root == null)
			return 0;
		if(root.left == null && root.right== null)
			return 1;
		return numOfLeavesInRecursion(root.left) + numOfLeavesInRecursion(root.right);
	}
	
	public TreeNode mirrorOfBinaryTree(TreeNode root){ // 反转二叉树
		TreeNode temp;
		if(root != null){
			mirrorOfBinaryTree(root.left);
			mirrorOfBinaryTree(root.right);
			temp = root.left;
			root.left=root.right;
			root.right=temp;
		}
		return root;
	}
}

public class test{
	public static void main(String args[]){   //test Aufgaben von Klausuren
		Number[]nums=new Integer[6];    //upcasting
		ArrayList<? extends Number> ls=new ArrayList<Double>(9);
		System.out.println("j");
	}
}
