package list.circulardoublylinkedlist.implementation;

public class CDNode<E> {
	public E data;
	public CDNode<E> leftLink;
	public CDNode<E> rightLink;
	
	public CDNode(CDNode leftLink, E data, CDNode rightLink) {
		this.leftLink = leftLink;
		this.data = data;
		this.rightLink = rightLink;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public CDNode<E> getLeftLink() {
		return leftLink;
	}

	public void setLeftLink(CDNode<E> leftLink) {
		this.leftLink = leftLink;
	}

	public CDNode<E> getRightLink() {
		return rightLink;
	}

	public void setRightLink(CDNode<E> rightLink) {
		this.rightLink = rightLink;
	}
	
}
