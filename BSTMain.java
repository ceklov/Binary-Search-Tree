package BSTMain;

public class BSTMain {

	public static void main(String[] args) {
		BST testTree = new BST();
		testTree.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		testTree.insert("Jane", "Williams", "555-235-1112", "jw@something.com");
		testTree.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		testTree.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		testTree.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		testTree.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
		testTree.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
		testTree.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
		testTree.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		testTree.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		testTree.lookup("Pat", "Jones");
		testTree.lookup("Billy", "Kidd");
		testTree.delete("John", "Doe");
		testTree.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		testTree.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		testTree.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
		testTree.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
		testTree.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		testTree.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		testTree.lookup("Jack", "Jones");
		testTree.lookup("Nadezhda", "Kanachekhovskaya");
		testTree.delete("Jill", "Jones");
		testTree.delete("John", "Doe");
		testTree.lookup("Jill", "Jones");
		testTree.lookup("John", "Doe");
		
		//CE: debug testTree.inOrderTraverse();
		
		/*----CE: further testing----
		//CE: test for correct deletion of parent of right child (Jill Jones)
		testTree.lookup("Millard", "Fillmore");
		testTree.lookup("Jo", "Wu");
		
		//CE: test for correct deletion of parent of left child (Billy Kidd)
		testTree.insert("A", "A", "A", "A");
		testTree.delete("Billy", "Kidd");
		testTree.lookup("A", "A");
		
		//CE: test for correct deletion of parent of two children (H. Houdini)
		testTree.delete("H.", "Houdini");
		testTree.lookup("Bob", "vanDyke");
		testTree.inOrderTraverse();
		*/
	}

}
