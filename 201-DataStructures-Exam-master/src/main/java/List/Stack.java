package List;

public class Stack {
    private Node top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public Node peek(){
        return top;
    }

    public void push(Node node){
        node.setNext(top);
        top = node;
    }

    public Node pop(){
        Node topNode = top;
        top = top.next;
        return topNode;
    }

    void accumulateLeaves(int[] a, int[] index) {
        if (left == null && right == null) {
            a[index[0]++] = data;
            return;
        }

        if (left != null) {
            left.accumulateLeaves(a, index);
        }

        if (right != null) {
            right.accumulateLeaves(a, index);
        }
    }

    int[] collectNodes() {
        ArrayList<Integer> result = new ArrayList<>();
        collect(result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void collect(ArrayList<Integer> result) {
        if (left != null) {
            left.collect(result);
        }

        result.add(data);

        if (right != null) {
            right.collect(result);
        }
    }

    int sumOfNodesBetween(int p, int q) {
        if (this == null) {
            return 0;
        }

        int sum = 0;

        if (data > p) {
            sum += (left != null) ? left.sumOfNodesBetween(p, q) : 0;
        }

        if (data >= p && data <= q) {
            sum += data;
        }

        if (data < q) {
            sum += (right != null) ? right.sumOfNodesBetween(p, q) : 0;
        }

        return sum;
    }

    void accumulate(int[] a, int[] index) {
        if (left != null) {
            left.accumulate(a, index);
        }

        a[index[0]++] = data;

        if (right != null) {
            right.accumulate(a, index);
        }
    }



    double simulateSearch(int N) {
        TreeNode tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        int A = tmp.data;

        tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        int B = tmp.data;

        int count = 0;
        for (int i = 0; i < N; i++) {
            int key = new Random().nextInt(B - A + 1) + A;
            tmp = root;

            while (tmp != null) {
                count++;
                if (key < tmp.data) {
                    tmp = tmp.left;
                } else if (key > tmp.data) {
                    tmp = tmp.right;
                } else {
                    break;
                }
            }
        }
        return (double) count / N;
    }


    void accumulateLeafNodes(Queue queue) {
        if (left == null && right == null) {
            queue.enqueue(data); // Add the leaf node's data to the queue
            return;
        }

        if (left != null) {
            left.accumulateLeafNodes(queue); // Recurse on the left subtree
        }

        if (right != null) {
            right.accumulateLeafNodes(queue); // Recurse on the right subtree
        }
    }

    int sumOfPath(String path) {
        int sum = 0;
        TreeNode current = root;

        for (int i = 0; i < path.length(); i++) {
            if (current == null) {
                throw new IllegalArgumentException("Invalid path: node does not exist");
            }

            sum += current.data;

            if (path.charAt(i) == '0') {
                current = current.left;
            } else if (path.charAt(i) == '1') {
                current = current.right;
            } else {
                throw new IllegalArgumentException("Invalid path character: " + path.charAt(i));
            }
        }

        if (current != null) {
            sum += current.data;
        }

        return sum;
    }

    int averages() {
        int count = 0; // Initialize count of average nodes

        if (left != null && right != null) {
            if (2 * data == left.data + right.data) {
                count = 1; // Increment count if the node's data is the average of its children
            }
        }

        if (left != null) {
            count += left.averages(); // Recurse on the left subtree
        }

        if (right != null) {
            count += right.averages(); // Recurse on the right subtree
        }

        return count; // Return the total count
    }

    int[] pathList() {
        ArrayList<Integer> path = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            path.add(current.data);

            if (current.data % 2 == 1) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        int[] result = new int[path.size()];
        for (int i = 0; i < path.size(); i++) {
            result[i] = path.get(i);
        }

        return result;
    }






}
