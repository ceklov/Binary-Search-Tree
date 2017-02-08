package BSTMain;

public class BST {
	private BSTNode root;
	
	public BST() {
		root = null;
	}
	
	public void insert(String firstName, String lastName, String phoneNumber, String email) {
		String newNodeKey = createKey(firstName, lastName);
		String newNodeValue = createValue(phoneNumber, email);
		BSTNode newNode = new BSTNode(newNodeKey, newNodeValue);

		System.out.println("Attempting to insert " + newNodeKey + "...");
		if (root == null) {
			root = newNode; //CE: if no root node here, create it
			System.out.println("Entry inserted for " + newNodeKey + " (root)");
		}
		else {
			BSTNode currentNode = root;
			BSTNode parentNode = root;
			
			while (true) {
				String currentNodeKey = currentNode.getKey();
				parentNode = currentNode;
				
				if (newNodeKey.equals(currentNodeKey)) {
					System.out.println("Entry already exists for " + newNodeKey);
					return;
				}
				else if (newNodeKey.compareTo(currentNodeKey) < 0) {
					currentNode = currentNode.getLeftChild();
					if (currentNode == null) {
						parentNode.setLeftChild(newNode);
						newNode.setParent(parentNode);
						System.out.println("Entry inserted for " + newNodeKey + " (left)");
						return;
					} //CE: end if
					else {
						parentNode = currentNode;
						//CE: debug System.out.println("To the left...");
					} //CE: end else
				} //CE: end else if
				else if (newNodeKey.compareTo(currentNodeKey) > 0) {
					currentNode = currentNode.getRightChild();
					if (currentNode == null) {
						parentNode.setRightChild(newNode);
						newNode.setParent(parentNode);
						System.out.println("Entry inserted for " + newNodeKey + " (right)");
						return;
					} //CE: end if
					else {
						parentNode = currentNode;
						//CE: debug System.out.println("To the right...");
					} //CE: end else
				} //CE: end else if
			} //CE: end while
		} //CE: end outer else
	} //CE: end insert(BSTNode, BSTNode)
	
	public void lookup(String firstName, String lastName) {
		String key = createKey(firstName, lastName);
		BSTNode currentNode = root;
		String currentNodeKey = currentNode.getKey();
		System.out.println("Attempting to look up " + key + "...");
		
		while (!key.equals(currentNodeKey)) {
			currentNodeKey = currentNode.getKey();
			if (key.compareTo(currentNodeKey) < 0) {
					//CE: debug System.out.println("To the left...");
					currentNode = currentNode.getLeftChild();
			} //CE: end outer if
			else if (key.compareTo(currentNodeKey) > 0) {
					//CE: debug System.out.println("To the right...");
					currentNode = currentNode.getRightChild();
				} //CE: end else if
			if (currentNode == null) {
				System.out.println("Cannot find: no entry for " + key);
				return;
			} //CE: end if
		} //CE: end while
		System.out.println("Entry found for " + key + ": " + currentNode.getValue());
	} //CE: end lookup()
	
	public void delete(String firstName, String lastName) {
		String key = createKey(firstName, lastName);
		System.out.println("Attempting to delete " + key + "...");
		BSTNode currentNode = root;
		boolean isLeft = true;
		
		if (root == null) {
			System.out.println("No entry found for " + key + " (tree is empty)");
		}
		//CE: while loop traverses to find correct node, its parent, and whether or not it is a left child
		while (!currentNode.getKey().equals(key)) {
			 //CE: debug System.out.print("... through " + currentNode.getKey());
			 if (key.compareTo(currentNode.getKey()) < 0) {
				 isLeft = true;
				 currentNode = currentNode.getLeftChild();
			 } //CE: end if
			 else { //CE: if (key.compareTo(currentNode.getKey()) > 0)
				 isLeft = false;
				 currentNode = currentNode.getRightChild();
			 } //CE: end else
			 if (currentNode == null) {
				 System.out.println("Cannot delete: no entry for " + key);
				 return;
			 } //CE: end if
		} //CE: end while
		
		BSTNode parentNode = currentNode.getParent();
		BSTNode leftChild = currentNode.getLeftChild();
		BSTNode rightChild = currentNode.getRightChild();
		
		//----CE: if it is a parent of two children----
		if ((currentNode.hasLeftChild()) && (currentNode.hasRightChild())) {
			BSTNode replacementNode = getMinNode(rightChild);
			//CE: need this? BSTNode parentOfReplacementNode = replacementNode.getParent();
			if (currentNode == root)
				root = replacementNode;
			else if (isLeft) {
				parentNode.getLeftChild().setKey(replacementNode.getKey());
				parentNode.getLeftChild().setValue(replacementNode.getValue());
				replacementNode = null;
			}
			else {
				parentNode.getRightChild().setKey(replacementNode.getKey());
				parentNode.getRightChild().setValue(replacementNode.getValue());
				replacementNode = null;
			}
		} //CE: end if
		
		//----CE: if it has only a left child----
		else if ((currentNode.hasLeftChild()) && (!currentNode.hasRightChild())) {
			if (currentNode == root)
				root = leftChild;
			else if (isLeft) {
				parentNode.setLeftChild(leftChild);
				leftChild.setParent(parentNode);
				currentNode = null;
			}
			else {
				parentNode.setRightChild(leftChild);
				leftChild.setParent(parentNode);
				currentNode = null;
			}
		} //CE: end else if
		
		//----CE: if it has only a right child----
		else if ((!currentNode.hasLeftChild()) && (currentNode.hasRightChild())) {
			if (currentNode == root) {
				root = rightChild;
			} //CE: end if
			else if (isLeft) {
				parentNode.setLeftChild(rightChild);
				rightChild.setParent(parentNode);
				currentNode = null;
			} //CE: end else if
			else {
				parentNode.setRightChild(rightChild);
				rightChild.setParent(parentNode);
				currentNode = null;
			} //CE: end else
		} //CE: end else if
		
		//----CE: it is a leaf----
		else if ((!currentNode.hasLeftChild()) && (!currentNode.hasRightChild())) {
			if (currentNode == root) {
				root = null;
			} //CE: end if
			else if (isLeft) {
				parentNode.setLeftChild(null);
				currentNode = null;
			}
			else {
				parentNode.setRightChild(null);
				currentNode = null;
			}
		} //CE: end else if

		System.out.println("Successfully deleted " + key);
	} //CE: end delete()
	
	public BSTNode getMinNode(BSTNode nodeToReplace) {
		if (nodeToReplace.getLeftChild() == null)
			return nodeToReplace;
		else
			return getMinNode(nodeToReplace.getLeftChild());
	} //CE: end getMinValue()
	
	public String createKey(String firstName, String lastName) {
		String key = (firstName + " " + lastName).toUpperCase();
		return key;
	} //CE: end createKey()
	
	public String createValue(String phoneNumber, String email) {
		String value = phoneNumber + " " + email;
		return value;
	} //CE: end createValue()

	//----CE: to see if tree is implemented correctly, it should be in alphabetical order, with no missing names
	public void inOrderTraverse() {
		System.out.println("\nPrinting tree using Inorder traverse...");
		inOrderTraverse(root);
	}
	
	private void inOrderTraverse(BSTNode currentNode) {
		if (currentNode != null) {
			inOrderTraverse(currentNode.getLeftChild());
			System.out.println(currentNode.getKey());
			inOrderTraverse(currentNode.getRightChild());
		}
	}
}
