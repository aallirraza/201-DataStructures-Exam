package List;

import com.sun.crypto.provider.DHKeyFactory;

public class Queue {

    protected Node first;
    protected Node last;

    public Queue() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Node newNode) {
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    public Node dequeue() {
        Node result = first;
        if (!isEmpty()) {
            first = first.getNext();
            if (isEmpty()) {
                last = null;
            }
        }
        return result;
    }

  public int largest(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        Queue tempQueue=new Queue();
        int max=Integer.MIN_VALUE;
        while(!isEmpty()){
            Element current=dequeue();
            if(current.getValue()>max){
                max=current.getValue();
            }
            tempQueue.enqueue(current);
        }
        while(!tempQueue.isEmpty()){
            enqueue(tempQueue.dequeue());
        }
        return max;
  }

}