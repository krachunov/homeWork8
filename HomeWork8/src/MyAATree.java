public class MyAATree<T extends Comparable<T>> {

	@SuppressWarnings("unused")
	private class Node {
		private T value;
		private Node leftChild;
		private Node rightChild;
		private boolean isRed;
		private int level;
		private static final int STARTING_LEVEL = 1;

		public Node(T value, Node left, Node right) {
			setValue(value);
			setLeftChild(left);
			setRightChild(right);
			setRed(false);
			setLevel(STARTING_LEVEL);
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
		add(this.root, element);
	}

	public void add(Node parent, T element) {
		if (getRoot() == null) {
			Node newElement = new Node(element);
			setRoot(newElement);
		} else {
			if (parent == null) {
				Node newElement = new Node(element);
				parent = newElement;
				return;

			} else if (parent.getValue().compareTo(element) <= 0) {
				if (parent.getRightChild() != null) {
					add(parent.getRightChild(), element);
				} else {
					Node newRightElement = new Node(element);
					parent.setRightChild(newRightElement);
					newRightElement.setRed(true);
					newRightElement.setLevel(parent.getLevel());
					return;
				}

			} else {
				if (parent.getLeftChild() != null) {
					add(parent.getLeftChild(), element);
				} else {
					Node newLeftElement = new Node(element);
					parent.setLeftChild(newLeftElement);
					int currentParentLevel = parent.getLevel();
					parent.setLevel(currentParentLevel + 1);
					return;
				}

			}
		}

	}
}
