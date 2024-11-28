package Tree;

public class BTree {

    private BTreeNode root;

    public BTree(){
        root = null;
    }

    public BTreeNode search(int value){
        if (root != null){
            return root.search(value);
        }
        return null;
    }







    public boolean containsOnlyDuplicates() {
        Node current = head;
        while (current != null) {
            Node temp = head;
            int count = 0;

            // Count occurrences of current node's data
            while (temp != null) {
                if (temp.getData() == current.getData()) {
                    count++;
                }
                temp = temp.getNext();
            }

            if (count != 2) return false; // Return false if any data does not appear exactly twice
            current = current.getNext();
        }
        return true; // Return true if every data appears exactly twice
    }


    public LinkedList primeDivisors(int N) {
        LinkedList primes = new LinkedList();
        LinkedList divisors = new LinkedList();


        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;

            Node temp = primes.head;
            while (temp != null) {
                if (i % temp.getData() == 0) {
                    isPrime = false;
                    break;
                }
                temp = temp.getNext();
            }

            if (isPrime) {
                Node primeNode = new Node(i);
                if (primes.head == null) {
                    primes.head = primeNode;
                } else {
                    Node last = primes.head;
                    while (last.getNext() != null) {
                        last = last.getNext();
                    }
                    last.setNext(primeNode);
                }
            }
        }

        Node primeNode = primes.head;
        while (primeNode != null && N > 1) {
            int prime = primeNode.getData();


            while (N % prime == 0) {
                Node divisorNode = new Node(prime);
                if (divisors.head == null) {
                    divisors.head = divisorNode;
                } else {
                    Node last = divisors.head;
                    while (last.getNext() != null) {
                        last = last.getNext();
                    }
                    last.setNext(divisorNode);
                }
                N /= prime;
            }

            primeNode = primeNode.getNext();
        }

        return divisors;
    }

    public Node lastOneWins(int k) {
        if (head == null || k <= 0) return null;


        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(head);

        Node prev = null;
        current = head;

        while (current.getNext() != current) {
            for (int count = 1; count < k; count++) {
                prev = current;
                current = current.getNext();
            }
            prev.setNext(current.getNext());
            current = current.getNext();
        }

        current.setNext(null);
        return current;
    }

    public DoublyLinkedList sortElements() {
        if (head == null) return new DoublyLinkedList();
        int max = head.getData();
        DoublyNode temp = (DoublyNode) head;
        while (temp != null) {
            if (temp.getData() > max) {
                max = temp.getData();
            }
            temp = (DoublyNode) temp.getNext();
        }
        DoublyLinkedList sortedList = new DoublyLinkedList();
        for (int i = 1; i <= max; i++) {
            int count = 0;
            temp = (DoublyNode) head;

            while (temp != null) {
                if (temp.getData() == i) {
                    count++;
                }
                temp = (DoublyNode) temp.getNext();
            }
            for (int j = 0; j < count; j++) {
                DoublyNode newNode = new DoublyNode(i);
                if (sortedList.head == null) {
                    sortedList.head = newNode;
                    sortedList.tail = newNode;
                } else {
                    sortedList.tail.setNext(newNode);
                    newNode.setPrevious((DoublyNode) sortedList.tail);
                    sortedList.tail = newNode;
                }
            }
        }

        return sortedList;
    }

    public boolean evenOddSorted() {
        if (head == null) return true;
        Node odd = head;
        Node even = head.getNext();
        boolean oddSorted = true;
        boolean evenSorted = true;
        while (odd != null && odd.getNext() != null && odd.getNext().getNext() != null) {
            if (odd.getData() > odd.getNext().getNext().getData()) {
                oddSorted = false;
                break;
            }
            odd = odd.getNext().getNext();
        }
        while (even != null && even.getNext() != null && even.getNext().getNext() != null) {
            if (even.getData() < even.getNext().getNext().getData()) {
                evenSorted = false;
                break;
            }
            even = even.getNext().getNext();
        }
        return oddSorted && evenSorted;
    }

    public LinkedList intersec(LinkedList list1, LinkedList list2) {
        LinkedList intersectionList = new LinkedList();
        Node p1 = list1.head;
        Node p2 = list2.head;
        while (p1 != null && p2 != null) {
            if (p1.getData() == p2.getData()) {
                Node newNode = new Node(p1.getData());
                if (intersectionList.head == null) {
                    intersectionList.head = newNode;
                } else {
                    Node last = intersectionList.head;
                    while (last.getNext() != null) {
                        last = last.getNext();
                    }
                    last.setNext(newNode);
                }
                p1 = p1.getNext();
                p2 = p2.getNext();
            } else if (p1.getData() < p2.getData()) {
                p1 = p1.getNext();
            } else {
                p2 = p2.getNext();
            }
        }
        return intersectionList;
    }

    public boolean isPalindrom() {
        if (head == null) return true;

        DoublyNode p1 = (DoublyNode) head;
        DoublyNode p2 = (DoublyNode) tail;
        while (p1 != p2 && p1.getNext() != p2) {
            if (p1.getData() != p2.getData()) {
                return false;
            }
            p1 = (DoublyNode) p1.getNext();
            p2 = (DoublyNode) p2.getPrevious();
        }
        return true;
    }

    public void remove(LinkedList list2) {
        if (head == null || list2.head == null) return;

        Node current = head;
        Node prev = null;

        while (current != null) {
            boolean toDelete = false;
            Node temp = list2.head;
            while (temp != null) {
                if (current.getData() == temp.getData()) {
                    toDelete = true;
                    break;
                }
                temp = temp.getNext();
            }
            if (toDelete) {
                if (prev != null) {
                    prev.setNext(current.getNext());
                } else {
                    head = current.getNext();
                }
            } else {
                prev = current;
            }
            current = current.getNext();
        }
    }

    public void deleteEven() {
        while (head != null && head.getData() % 2 == 0) {
            head = head.getNext();
        }
        Node current = head;
        Node prev = null;   q
        while (current != null) {
            if (current.getData() % 2 == 0) {
                prev.setNext(current.getNext());
            } else {
                prev = current;
            }
            current = current.getNext();
        }
    }

    public LinkedList getIndexed(LinkedList indices) {
        LinkedList result = new LinkedList();
        Node current = head;
        Node indexNode = indices.head;
        int currentIndex = 1;
        while (current != null && indexNode != null) {
            if (currentIndex == indexNode.getData()) {
                Node newNode = new Node(current.getData());
                if (result.head == null) {
                    result.head = newNode;
                } else {
                    Node last = result.head;
                    while (last.getNext() != null) {
                        last = last.getNext();
                    }
                    last.setNext(newNode);
                }
                indexNode = indexNode.getNext();
            }
            current = current.getNext();
            currentIndex++;
        }
        return result;
    }


    public void removeKthBeforeLast(int K) {
        if (head == null || K <= 0) return; // Return if list is empty or K is invalid
        int count = 0;
        DoublyNode temp = (DoublyNode) head;
        while (temp != null) {
            count++;
            temp = (DoublyNode) temp.getNext();
        }
        int deleteIndex = count - K + 1;
        if (deleteIndex <= 0) return;
        temp = (DoublyNode) head;
        int index = 1;
        while (temp != null && index < deleteIndex) {
            temp = (DoublyNode) temp.getNext();
            index++;
        }
        if (temp == head) {
            head = temp.getNext();
            if (head != null) ((DoublyNode) head).setPrevious(null);
        } else if (temp == tail) {
            tail = temp.getPrevious();
            if (tail != null) tail.setNext(null);
        } else {
            temp.getPrevious().setNext(temp.getNext());
            ((DoublyNode) temp.getNext()).setPrevious(temp.getPrevious());
        }


        public LinkedList difference(LinkedList list1, LinkedList list2) {
            LinkedList differenceList = new LinkedList();
            Node p1 = list1.head;
            Node p2 = list2.head;
            while (p1 != null) {
                if (p2 == null || p1.getData() < p2.getData()) {
                    Node newNode = new Node(p1.getData());
                    if (differenceList.head == null) {
                        differenceList.head = newNode;
                    } else {
                        Node last = differenceList.head;
                        while (last.getNext() != null) {
                            last = last.getNext();
                        }
                        last.setNext(newNode);
                    }
                    p1 = p1.getNext();
                } else if (p1.getData() > p2.getData()) {
                    p2 = p2.getNext();
                } else {
                    p1 = p1.getNext();
                    p2 = p2.getNext();
                }
            }
            return differenceList;
        }

    }








}
