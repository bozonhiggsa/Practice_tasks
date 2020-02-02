package ua.examples.practice.practice6;

public class Tree<E extends Comparable<E>> implements Cloneable {
	
	private static final String INDENT = "   ";

	private Node<E> root = null;
	
	public boolean remove(E e) {

		boolean result = false;

		if(root == null) return false;

		if(e.compareTo(root.getValue()) == 0 && root.getToMore() != null && root.getPrevious() != null){
			if(root.getToMore() != root.getNext() && root.getToMore().getOrigin() != root.getNext()){
				result = false;
			}
			else if(root.getToMore() != root.getNext() && root.getToMore().getNext() != null){
				result = false;
			}
			else {
				root.getPrevious().setOrigin(root.getToMore());
				root.getToLess().setToMore(root.getToMore());
				root.getToMore().setPrevious(root.getPrevious());
				root.getToMore().setToLess(root.getToLess());
				root.getToMore().setOrigin(null);
				if(root.getToMore() != root.getNext()){
					root.getToMore().setNext(root.getNext());
					root.getNext().setOrigin(root.getToMore());
				}
				root = root.getToMore();
				root.setNumberOfAncestors(0);
				result = true;
			}
		}
		if(e.compareTo(root.getValue()) != 0){
			Node<E> leftEdge = searchLeftEdge(root);
			if(e.compareTo(leftEdge.getValue()) == 0){
				if(removeNodeWithoutChilds(leftEdge)){
					result = true;
				}
			}
			Node<E> tempNode = leftEdge.getToMore();
			while(tempNode != null && e.compareTo(tempNode.getValue()) >= 0){
				if(e.compareTo(tempNode.getValue()) == 0){
					if(removeNodeWithoutChilds(tempNode)){
						result = true;
					}
					break;
				}
				else{
					tempNode = tempNode.getToMore();
				}
			}
		}
		return result;
	}
	
	public void add(E[] elements) {

		for (E elem: elements) {
			add(elem);
		}
	}
	
	public boolean add(E e) {

		if(root == null){
			root = new Node<>(e);
			return true;
		}

		Node<E> tempRoot = root;
		while(true){
			if(e.compareTo(tempRoot.getValue()) == 0){
				return false;
			}
			if(e.compareTo(tempRoot.getValue()) < 0 && tempRoot.getPrevious() == null){
				Node<E> newNode = new Node<E>(e);
				tempRoot.setPrevious(newNode);
				newNode.setOrigin(tempRoot);
				lessMore(newNode);
				newNode.setNumberOfAncestors(determineNumberOfAncestors(newNode));
				return true;
			}
			else if(e.compareTo(tempRoot.getValue()) < 0 && tempRoot.getPrevious() != null) {
				tempRoot = tempRoot.getPrevious();
			}
			else if(e.compareTo(tempRoot.getValue()) > 0 && tempRoot.getNext() == null){
				Node<E> newNode = new Node<E>(e);
				tempRoot.setNext(newNode);
				newNode.setOrigin(tempRoot);
				lessMore(newNode);
				newNode.setNumberOfAncestors(determineNumberOfAncestors(newNode));
				return true;
			}
			else if(e.compareTo(tempRoot.getValue()) > 0 && tempRoot.getNext() != null) {
				tempRoot = tempRoot.getNext();
			}
		}
	}

	public void print(){

		Node<E> leftEdge = searchLeftEdge(root);
		System.out.println(getIndent(determineNumberOfAncestors(leftEdge)) + leftEdge.getValue());
		while(leftEdge.getToMore() != null){
			leftEdge = leftEdge.getToMore();
			System.out.println(getIndent(determineNumberOfAncestors(leftEdge)) + leftEdge.getValue());
		}
	}

	private Node<E> searchLeftEdge(Node<E> tempRoot){

		while(tempRoot.getPrevious() != null){
			tempRoot = tempRoot.getPrevious();
		}
		return tempRoot;
	}

	private int determineNumberOfAncestors(Node<E> node){

		int result = 0;
		if(node.getOrigin() == null){
			return result;
		}
		while(node.getOrigin() != null){
			node = node.getOrigin();
			result++;
		}
    	return result;
	}

	private String getIndent(int numberOfAncestors){

		String result = "";
		for(int i = 0; i < numberOfAncestors; i++){
			result += INDENT;
		}
		return result;
	}

	private void lessMore(Node<E> node){

		if(node.getValue().compareTo(root.getValue()) < 0){
			Node<E> tempNode = root;
			while(tempNode.getToLess() != null && node.getValue().compareTo(tempNode.getToLess().getValue()) < 0){
				tempNode = tempNode.getToLess();
			}
			if(tempNode.getToLess() != null){
				tempNode.getToLess().setToMore(node);
			}
			node.setToLess(tempNode.getToLess());
			tempNode.setToLess(node);
			node.setToMore(tempNode);
		}
		if(node.getValue().compareTo(root.getValue()) > 0){
			Node<E> tempNode = root;
			while(tempNode.getToMore() != null && node.getValue().compareTo(tempNode.getToMore().getValue()) > 0){
				tempNode = tempNode.getToMore();
			}
			if(tempNode.getToMore() != null){
				tempNode.getToMore().setToLess(node);
			}
			node.setToMore(tempNode.getToMore());
			tempNode.setToMore(node);
			node.setToLess(tempNode);
		}
	}

	private boolean removeNodeWithoutChilds(Node<E> node){

		boolean result = false;
		if(node.getPrevious() == null && node.getNext() == null){
			if(node.getValue().compareTo(node.getOrigin().getValue()) < 0){
				node.getOrigin().setPrevious(null);
			}
			else if(node.getValue().compareTo(node.getOrigin().getValue()) > 0){
				node.getOrigin().setNext(null);
			}
			if(node.getToLess() != null && node.getToMore() != null){
				node.getToLess().setToMore(node.getToMore());
				node.getToMore().setToLess(node.getToLess());
			}
			if(node.getToLess() != null && node.getToMore() == null){
				node.getToLess().setToMore(null);
			}
			if(node.getToLess() == null && node.getToMore() != null){
				node.getToMore().setToLess(null);
			}
			result = true;
		}
		return result;
	}

	public Node<E> getRoot() {
		return root;
	}

	public static class Node<E> {
		private E value;
		private Node<E> origin;
		private Node<E> next;
		private Node<E> previous;
		private Node<E> toLess;
		private Node<E> toMore;
		private int numberOfAncestors;

		public Node(E value) {
			this.value = value;
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrevious() {
			return previous;
		}

		public void setPrevious(Node<E> previous) {
			this.previous = previous;
		}

		public Node<E> getOrigin() {
			return origin;
		}

		public void setOrigin(Node<E> origin) {
			this.origin = origin;
		}

		@Override
		public String toString() {
			return value.toString();
		}

		public void setNumberOfAncestors(int numberOfAncestors) {
			this.numberOfAncestors = numberOfAncestors;
		}

		public int getNumberOfAncestors() {
			return numberOfAncestors;
		}

		public Node<E> getToLess() {
			return toLess;
		}

		public void setToLess(Node<E> toLess) {
			this.toLess = toLess;
		}

		public Node<E> getToMore() {
			return toMore;
		}

		public void setToMore(Node<E> toMore) {
			this.toMore = toMore;
		}
	}
}
