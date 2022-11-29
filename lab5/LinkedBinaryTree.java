public class LinkedBinaryTree<E,T> implements BinaryTreeInterface<T> {     	
	protected static class Node<E> {
		private E element; 		// an element stored at this node
		private Node<E> parent; 	// a reference to the parent node (if any)
		private Node<E> left; 	// a reference to the left child 
		private Node<E> right; 	// a reference to the right child
	
		// Constructs a node with the given element and neighbors. ∗/
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
			// Sinh viên hoàn thiện phương thức
		}
	}
    private Node<E> root;
	//update methods
	public Node<E> addRoot(E element) {
        // Add element to root of an empty tree
		root.element = element;
        return root;
	}
	
	public Node<E> addLeft(Node p, E element) {		
		// Add element to left child node of p if empty
        if (p.left == null) {
            p.left = new Node<E>(element, p, null, null);
        }
        return p.left;
	}
	
	public Node<E> addRight(Node p, E element) {
		// Add element to right child node of p if empty
        if (p.right == null) {
            p.right = new Node<E>(element, p, null, null);
        }
        return p.right;
	}
	
	public void set(Node p, E element) {
		p.element = element;
	}

    @Override
    public T root() {
        return (T)root;
    }

    @Override
    public int size() {        
        if (isEmpty()) return 0;
        return subTreeSize(root);
    }

    private int subTreeSize(Node<E> node) {
        int result = 0;        
        if (node.left != null) result += subTreeSize(node.left) + 1;
        if (node.right != null) result += subTreeSize(node.right) + 1;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int numChildren(T p) {
        Node<E> temp = (Node<E>)p;
        int child_count = 0;
        if (temp.left != null) child_count++;
        if (temp.right != null) child_count++;
        return child_count;
    }

    @Override
    public T parent(T p) {
        Node<E> child = (Node<E>)p;
        return (T)child.parent;
    }

    @Override
    public T left(T p) {
        Node<E> child = (Node<E>)p;
        return (T)child.left;
    }

    @Override
    public T right(T p) {
        Node<E> child = (Node<E>)p;
        return (T)child.right;
    }

    @Override
    public T sibling(T p) {
        Node<E> parent = (Node<E>)parent(p);
        if (parent.left.equals((Node<E>)p)) return (T)parent.right;
        return (T)parent.left;
    }
}