import java.util.*;

public class Main {

	public static void main(String[] args) {
	
		BST tree = new BST(10);
		tree.insert(5);
		tree.insert(1);
		tree.insert(3);
		tree.insert(11);
		tree.insert(16);
		tree.insert(15);
		tree.inOrder();

		tree.weave();
		System.out.println("Alternative:");
		tree.weaveAlt();
		//tree.weave(new LinkedList<>(Arrays.asList(1, 2, 3, 4)), new LinkedList<>(Arrays.asList(5, 6, 7, 8)));
	}
}
