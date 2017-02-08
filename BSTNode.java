package BSTMain;

public class BSTNode {
	private String key;
	private String value;
	private BSTNode leftChild;
	private BSTNode rightChild;
	private BSTNode parent;
	
	public BSTNode(String key, String value) {
		this.key = key;
		this.value = value;
		leftChild = null;
		rightChild = null;
		parent = null;
	} //CE: end constructor
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	public BSTNode getLeftChild() {
		return leftChild;
	}
	
	public BSTNode getRightChild() {
		return rightChild;
	}
	
	public BSTNode getParent() {
		return parent;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setParent(BSTNode parent) {
		this.parent = parent;
	}
	
	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
} //CE: end BSTNode
