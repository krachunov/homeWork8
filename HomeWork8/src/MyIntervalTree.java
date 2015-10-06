public class MyIntervalTree<T extends Comparable<T>> {

	@SuppressWarnings("unused")
	private class Node {
		private T min;
		private T max;
		private Node leftChild;
		private Node rightChild;

		public Node(T min, T max) {
			setMin(min);
			setMax(max);
		}

		public T getMin() {
			return min;
		}

		public void setMin(T min) {
			this.min = min;
		}

		public T getMax() {
			return max;
		}

		public void setMax(T max) {
			this.max = max;
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

	public void add(T min, T max) {
		add(this.root, min, max);
	}

	public void add(Node parent, T min, T max) {
		if (getRoot() == null) {
			Node newElement = new Node(min, max);

			setRoot(newElement);
		} else {
			if (parent == null) {
				Node newElement = new Node(min, max);
				parent = newElement;
				return;

			} else if (parent.getMin().compareTo(min) <= 0) {
				if (parent.getRightChild() != null) {
					add(parent.getRightChild(), min, max);
				} else {
					Node newRightElement = new Node(min, max);
					parent.setRightChild(newRightElement);

					return;
				}

			} else {
				if (parent.getLeftChild() != null) {
					add(parent.getLeftChild(), min, max);
				} else {
					Node newLeftElement = new Node(min, max);
					parent.setLeftChild(newLeftElement);

					return;
				}

			}
		}

	}

	private Node rotateRight(Node root) {
		Node rootLeft = root.getLeftChild();
		Node rootLeftRight = rootLeft.getRightChild();

		rootLeft.setRightChild(root);
		root.setLeftChild(rootLeftRight);
		return rootLeft;

	}

	private Node rotateLeft(Node lt) {
		Node rt = lt.getRightChild();
		Node q = rt.getLeftChild();

		rt.setLeftChild(lt);
		lt.setRightChild(q);
		return rt;

	}
}
