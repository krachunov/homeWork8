
public class MyIntervalTree<T extends Comparable<T>> {

	@SuppressWarnings("unused")
	private class Node {
		private T min;
		private Node leftChild;
		private Node rightChild;

		public Node(T value, Node left, Node right) {
			setValue(value);
			setLeftChild(left);
			setRightChild(right);

		}

		public Node(T value) {
			this(value, null, null);
		}

		public T getValue() {
			return min;
		}

		public void setValue(T value) {
			this.min = value;
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

	}

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public MyIntervalTree() {
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

					return;
				}

			} else {
				if (parent.getLeftChild() != null) {
					add(parent.getLeftChild(), element);
				} else {
					Node newLeftElement = new Node(element);
					parent.setLeftChild(newLeftElement);

					return;
				}

			}
		}

	}

	private Node rotateRight(Node rt) {
		Node lt = rt.getLeftChild();
		Node q = lt.getRightChild();

		lt.setRightChild(rt);
		rt.setLeftChild(q);
		return lt;

	}

	private Node rotateLeft(Node lt) {
		Node rt = lt.getRightChild();
		Node q = rt.getLeftChild();

		rt.setLeftChild(lt);
		lt.setRightChild(q);
		return rt;

	}
}
