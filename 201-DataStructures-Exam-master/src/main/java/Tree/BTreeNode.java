package Tree;

public class BTreeNode {

    private int[] K;
    private BTreeNode[] children;
    private int m;
    private int d;
    private boolean leaf;

    public BTreeNode(int d){
        m = 0;
        this.d = d;
        leaf = true;
        K = new int[2 * d + 1];
        children = new BTreeNode[2 * d + 1];
    }

    public BTreeNode search(int value){
        if (leaf){
            return this;
        }
        int childNo = position(value);
        if (childNo != -1){
            return children[childNo].search(value);
        }
        return null;
    }

    private int position(int value){
        if (m == 0){
            return -1;
        }
        if (value > K[m - 1]){
            return m;
        } else {
            for (int i = 0; i < m; i++){
                if (value <= K[i]){
                    return i;
                }
            }
        }
        return -1;
    }


    public void removeOddIndexed() {
        Stack tempStack = new Stack(); //
        int index = 1;

        while (!this.isEmpty()) {
            Node node = this.pop();
            if (index % 2 == 0) {
                tempStack.push(node);
            }
            index++;
        }

        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
    }

    public Node pop(int K) {
        Stack tempStack = new Stack();
        Node result = null;

        for (int i = 1; i < K; i++) {
            tempStack.push(this.pop());
        }

        result = this.pop();

        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }

        return result;
    }


    public void compress() {
        Stack tempStack = new Stack();

        while (!this.isEmpty()) {
            Node current = this.pop();
            if (tempStack.isEmpty() || tempStack.peek().getData() != current.getData()) {
                tempStack.push(current);
            }
        }

        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
    }


    public void push(int k, int data) {
        Stack tempStack = new Stack();
        Node newNode = new Node(data);

        for (int i = 1; i < k; i++) {
            if (!this.isEmpty()) {
                tempStack.push(this.pop());
            }
        }

        this.push(newNode);

        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
    }


    public void removeEvenIndexed() {
        Stack tempStack = new Stack();
        int index = 1;

        while (!this.isEmpty()) {
            Node node = this.pop();
            if (index % 2 != 0) {
                tempStack.push(node);
            }
            index++;
        }

        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
    }


    public LinkedList popBottomK(int k) {
        LinkedList result = new LinkedList();
        Node current = top;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        if (k >= size) {
            result.head = top;
            top = null;
            return result;
        }
        current = top;
        int stopAt = size - k;
        for (int i = 1; i < stopAt; i++) {
            current = current.getNext();
        }
        result.head = current.getNext();
        current.setNext(null);
        return result;
    }


    public static boolean isBalanced(int[] array) {
        Stack stack = new Stack(array.length);

        for (int num : array) {
            if (num < 10) {
                stack.push(new Element(num));
            } else {
                if (stack.isEmpty() || stack.pop().data + 10 != num) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public void addToStack(Stack s, int p, int q) {
        Stack tempStack = new Stack();
        int index = 1;
        while (!s.isEmpty() && index <= q) {
            Node node = s.pop();
            if (index >= p) {
                tempStack.push(new Node(node.getData()));
            }
            index++;
        }
        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
    }


    public void removeMiddle(Stack originalStack) {
        Stack tempStack = new Stack(); // External stack to temporarily hold elements
        int count = 0;
        int middleIndex = (originalStack.size() / 2); // Calculate middle index (assuming 0-based indexing)

        // Pop elements until we reach the middle element
        while (count != middleIndex) {
            tempStack.push(originalStack.pop()); // Push each popped element onto tempStack
            count++;
        }

        // Pop the middle element from the original stack and discard it
        originalStack.pop();

        // Push elements back from tempStack to the original stack to restore the order
        while (!tempStack.isEmpty()) {
            originalStack.push(tempStack.pop());
        }
    }

    public void removeBottomK(Stack originalStack, int K) {
        Stack tempStack = new Stack(); // External stack to temporarily hold elements
        int totalSize = originalStack.size();
        int elementsToKeep = totalSize - K; // Calculate the number of elements to keep

        // Pop elements to keep onto tempStack
        for (int i = 0; i < elementsToKeep; i++) {
            tempStack.push(originalStack.pop());
        }

        // Discard the bottom K elements by popping them from the original stack
        for (int i = 0; i < K; i++) {
            originalStack.pop();
        }

        // Restore the remaining elements back to the original stack
        while (!tempStack.isEmpty()) {
            originalStack.push(tempStack.pop());
        }
    }






}
