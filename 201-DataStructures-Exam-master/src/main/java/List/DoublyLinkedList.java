package List;

public class DoublyLinkedList extends LinkedList{

    public void insertLast(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious((DoublyNode) tail);
        tail = newNode;
    }

    public void deleteLast(){
        tail = ((DoublyNode)tail).getPrevious();
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    public boolean isValid() {
        for (int i = 0; i < N; i++) {
            Node current = table[i].getHead();

            while (current != null) {
                Node checker = current.getNext();
                while (checker != null) {
                    if (checker.getData() == current.getData()) {
                        return false;
                    }
                    checker = checker.getNext();
                }
                current = current.getNext();
            }
        }
        return true;
    }

    public static boolean sumOfTwoK(int[] array, int K) {
        Hash hash = new Hash(array.length * 2);

        for (int value : array) {
            int complement = K - value;
            if (hash.search(complement) != null) {
                return true;
            }
            hash.insert(value);
        }

        return false;
    }

    public static int[] intersection(int[] list1, int[] list2) {
        Hash hash = new Hash(list2.length);

        for (int value : list2) {
            hash.insert(value);
        }

        int count = 0;
        for (int value : list1) {
            if (hash.search(value) != null) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int value : list1) {
            if (hash.search(value) != null) {
                result[index++] = value;
                hash.insert(-1);
            }
        }

        return result;
    }

    public static int[] sortByHashing(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        Hash hash = new Hash(max + 1);

        for (int value : array) {
            hash.insert(value);
        }

        int[] result = new int[array.length];
        int index = 0;


        for (int i = 0; i <= max; i++) {
            if (hash.search(i) != null) {
                result[index++] = i;
            }
        }
        return result;
    }

    public static int numberOfExtras(int[] array) {
        Hash hash = new Hash(array.length * 2); w
        int extras = 0;

        for (int value : array) {
            if (hash.search(value) == null) {
                hash.insert(value);
            } else {
                extras++;
            }
        }
        return extras;
    }

    public boolean perfectMap() {
        for (int i = 0; i < N; i++) {
            Node current = table[i].getHead();

            if (current != null && current.getNext() != null) {
                return false;
            }
        }
        return true;
    }

    public int numberOfClusters() {
        int clusters = 0;
        boolean inCluster = false;

        for (int i = 0; i < N; i++) {
            if (table[i] != null && !deleted[i]) {
                if (!inCluster) {
                    clusters++;
                    inCluster = true;
                }
            } else {
                inCluster = false;
            }
        }
        return clusters;
    }








}
