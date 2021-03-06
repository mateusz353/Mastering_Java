import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class MinimalBST {
	
	private static Integer atomicCounter = 0;

	public static void printMinimalBST(int[] sortedValues) {
		Node root = createNode(sortedValues, sortedValues.length/2, 0, sortedValues.length - 1);
	
		List<Integer> sequence = new ArrayList<>(sortedValues.length);
		inOrderTraversal(sequence, root, 0);
		sequence.stream().forEach(System.out::println);
		System.out.println("Nodes: " + Node.counter);
		System.out.println("Depht of the tree: " + atomicCounter);
		System.out.println("Is tree perfectly balanced: " + checkBalanced(root, new AtomicInteger(0)));
	}

	public static boolean checkBalanced(Node node, AtomicInteger depth) {
		if (node == null)
			return true;
		
		AtomicInteger depthRight = new AtomicInteger(depth.get() + 1);
		AtomicInteger depthLeft = new AtomicInteger(depth.get() + 1);
		boolean left = checkBalanced(node.l, depthLeft);
		boolean right = checkBalanced(node.r, depthRight);
		
		if (!left || !right || Math.abs(depthLeft.get() - depthRight.get()) != 0)
			return false;

		depth.addAndGet(Math.max(depthLeft.get(), depthRight.get()));
		return true;
	}

	public static String stringify(Node node) {
		return preOrderStringify(node, new LinkedList<>()).stream().map(n -> n != null ? String.valueOf(n.v) : "X").collect(Collectors.joining(" "));
	}

	public static boolean isSubtree(Node superTree, Node subTree) {
		Node node = superTree;
		while ((node = find(node, subTree.v)) != null) {
			if (stringify(node).equals(stringify(subTree)))
				return true;
			node = node.v < subTree.v ? node.r : node.l;
		}
		return false;
	}

	public static Node find(Node node, int v) {
		if (node == null)
			return null;

		if (node.v == v)
			return node;

		return node.v < v ? find(node.r, v) : find(node.l, v);
	}

	private static LinkedList<Node> preOrderStringify(Node node, LinkedList<Node> seq) {
		seq.addLast(node);

		if (node == null)
			return seq;

		preOrderStringify(node.l, seq);
		preOrderStringify(node.r, seq);
		return seq;
	}

	private static void inOrderTraversal(List<Integer> sequence, Node node, int depth) {
		if (node == null)
			return;
		setAtomicCounter(depth);
		inOrderTraversal(sequence, node.l, depth + 1);
		sequence.add(node.v);
		inOrderTraversal(sequence, node.r, depth + 1);
	}

	private static Node createNode(int[] values, int index, int min, int max) {
		if (min > max)
			return null;

		return new Node(values[index], createNode(values, min + (index-min)/2, min, index-1), createNode(values, index + 1 + (max-index)/2, index+1, max));
	}

	private static void setAtomicCounter(int n) {
		if (n > atomicCounter )
			atomicCounter = n;
	}

	public static class Node {
		static int counter;
		int v;
		Node r;
		Node l;

		Node(int v, Node l, Node r) {
			counter++;
			this.v = v;
			this.r = r;
			this.l = l;
		}
	}
}
