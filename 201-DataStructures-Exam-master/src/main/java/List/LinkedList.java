package List;

public class LinkedList {

    protected Node head;
    protected Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Node getHead(){
        return head;
    }

    public void insertFirst(Node newNode) {
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public Node search(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (value == tmp.getData()) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }
    public void deleteFirst(){
        head = head.getNext();
        if (isEmpty()){
            tail = null;
        }
    }
    
    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

    public Queue[] divideQueue(int k) {
        Queue[] result = new Queue[k];
        for (int i = 0; i < k; i++) {
            result[i] = new Queue();
        }

        Node current = first;
        int index = 0;

        while (current != null) {
            Node newNode = new Node(current.getValue());
            if (result[index].last == null) {
                result[index].first = result[index].last = newNode;
            } else {
                result[index].last.setNext(newNode);
                result[index].last = newNode;
            }

            current = current.getNext();
            index = (index + 1) % k;
        }

        return result;
    }

    //Array Implentation

    public void cutPaste(Queue dest, int p, int q) {
        int start = (first + p - 1) % N;
        int end = (first + q - 1) % N;

        for (int i = start; i != (end + 1) % N; i = (i + 1) % N) {
            dest.array[dest.last] = array[i];
            dest.last = (dest.last + 1) % dest.N;
        }

        for (int i = end + 1; i != last; i = (i + 1) % N) {
            array[start] = array[i];
            start = (start + 1) % N;
        }

        last = start;
    }



    public Queue(Queue[] list) {
        first = null;
        last = null;

        for (Queue q : list) {
            Node current = q.first;
            while (current != null) {
                Node newNode = new Node(current.getValue());
                if (last == null) {
                    first = last = newNode;
                } else {
                    last.setNext(newNode);
                    last = newNode;
                }
                current = current.getNext();
            }
        }
    }


//array implementation
    public void copyPaste(Queue src, int index) {
        int insertPos = (first + index) % N;
        int srcSize = (src.last - src.first + src.N) % src.N;

        for (int i = last; i != insertPos; i = (i - 1 + N) % N) {
            array[(i + srcSize) % N] = array[i];
        }


        for (int i = 0; i < srcSize; i++) {
            array[(insertPos + i) % N] = src.array[(src.first + i) % src.N];
        }

        last = (last + srcSize) % N;
    }



    public Node dequeue(int k) {
        if (k < 1 || first == null) {
            return null;
        }

        Node current = first;
        Node previous = null;

        for (int i = 1; i < k; i++) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            first = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }

        if (current == last) {
            last = previous;
        }

        return current;
    }

    //array
    public Element dequeue(int k) {
        if (isEmpty() || k < 1 || k > size()) {
            return null; // Invalid index
        }

        int targetIndex = (first + k - 1) % N;
        Element removedElement = array[targetIndex];

        // Shift elements to fill the gap
        for (int i = targetIndex; i != last; i = (i + 1) % N) {
            array[i] = array[(i + 1) % N];
        }

        last = (last - 1 + N) % N;
        return removedElement;
    }

    public void removeOddIndexed() {
        Queue tempQueue = new Queue(N);
        int index = 1;

        while (!isEmpty()) {
            Element element = dequeue();
            if (index % 2 == 0) {
                tempQueue.enqueue(element);
            }
            index++;
        }


        while (!tempQueue.isEmpty()) {
            enqueue(tempQueue.dequeue());
        }
    }
//array
    public Queue divideQueue() {
        Queue newQueue = new Queue(N);
        int index = 1; /
        int tempFirst = first;

        // Traverse the queue
        while (tempFirst != last) {
            if (index % 2 == 0) {
                newQueue.array[newQueue.last] = array[tempFirst];
                newQueue.last = (newQueue.last + 1) % newQueue.N;
            }
            tempFirst = (tempFirst + 1) % N;
            index++;
        }

        return newQueue;
    }


    public Queue divideQueue() {
        Queue newQueue = new Queue();
        int index = 1;
        Node current = first;

        while (current != null) {
            if (index % 2 == 0) {
                Node newNode = new Node(current.getValue());
                if (newQueue.last == null) {
                    newQueue.first = newQueue.last = newNode;
                } else {
                    newQueue.last.setNext(newNode);
                    newQueue.last = newNode;
                }
            }
            current = current.getNext();
            index++;
        }

        return newQueue;
    }

    public void copyPaste(Queue src, int index) {
        if (src.first == null || index < 0) {
            return;
        }
        Node srcCurrent = src.first;
        Node destCurrent = first;
        Node destPrev = null;
        int position = 0;

        while (destCurrent != null && position < index) {
            destPrev = destCurrent;
            destCurrent = destCurrent.getNext();
            position++;
        }

        while (srcCurrent != null) {
            Node newNode = new Node(srcCurrent.getValue());
            if (destPrev == null) {
                newNode.setNext(first);
                first = newNode;
            } else {
                newNode.setNext(destPrev.getNext());
                destPrev.setNext(newNode);
            }
            destPrev = newNode;
            srcCurrent = srcCurrent.getNext();
        }

        if (destPrev != null && destCurrent == null) {
            last = destPrev;
        }
    }












}
