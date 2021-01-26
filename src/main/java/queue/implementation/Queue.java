package queue.implementation;


/**
 * @Queue
 * 특징 : Stack 과 반대로 FIFO(FirstInFirstOut) 이다.
 * 
 * */
/**
 * <pre>
 * 개요:
 * </pre>
 * @author <a href="mailto:hkj5455@gmail.com">김진혁</a><br>
 * @date 2021. 1. 25. 
 * @version 
 * @since 
 */
public interface Queue<E> {

	
	/**
	  *
	  * <pre>
	  * 개요: 큐의 가장 마지막에 요소를 추가.
	  * </pre>
	  * @param e 큐에 추가할 요소
	  * @return 큐에 요소가 정상적으로 추가되었을 경우 true 반환
	  *
	 */
	boolean offer(E e);
	
	/**
	  *
	  * <pre>
	  * 개요: 큐의 첫번째 요소를 삭제하고 삭제 된 요소를 반환
	  * </pre>
	  * @return 삭제 된 요소를 반환
	  *
	 */
	E poll();
	
	
	/**
	  *
	  * <pre>
	  * 개요: 큐의 첫번째 요소를 반환
	  * </pre>
	  * @return 큐의 첫번째 요소 반환
	  *
	 */
	E peek();
}
