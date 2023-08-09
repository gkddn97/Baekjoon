package live;

import java.util.EmptyStackException;

public class LinkedListStack<E> implements IStack<E> {

	private Node<E> top = null;	// 더미노드 안씀 -> 처음은 공백
	
	@Override
	public void push(E e) {	// 첫 노드로 삽입
		top = new Node<>(e, top);
	}

	@Override
	public E pop() {	// 첫 노드 삭제 후 반환
		if(isEmpty()) {
			throw new EmptyStackException();	// runtime exception이라 throws 안해도 됨
		}
		Node<E> popNode = top;
		top = popNode.getLink();
		popNode.setLink(null);
		return popNode.getData();
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getData();
	}

	@Override
	public int size() {
		int size = 0;
		
		for(Node<E> temp = top; temp != null; temp = temp.getLink()) {
			++size;
		}
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

}
