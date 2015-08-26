public class MyAATree<T extends Comparable<T>> {

	@SuppressWarnings("unused")
	private class Node {
		private T value;
		private Node leftChild;
		private Node rightChild;
		private boolean isRed;
		private int level;

		public Node(T value, Node left, Node right) {
			setValue(value);
			setLeftChild(left);
			setRightChild(right);
			setRed(false);
		}

		public Node(T value) {
			this(value, null, null);
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}

		public boolean isRed() {
			return isRed;
		}

		public void setRed(boolean isRed) {
			this.isRed = isRed;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

	}

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public MyAATree() {
		setRoot(null);
	}

	public void add(T element) {
		if (getRoot() == null) {
			root = new Node(element);
			root.setLevel(1);
		}
	}
}
