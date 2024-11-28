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


    public void Queue (Queue[] list){
        Node result=first;
        if(!isEmpty()){
            first=first.getNext();
            if(isEmpty()){
                last=null;
            }
            last.setNext(first.getNext)
        }
    }


}


//Q4 List Queue
//Write the method void removeAll(Queue[] list)
// which removes all elements in the queues in the list from the original queue.
//You are not allowed to use enqueue, dequeue isEmpty functions.
//Solve for list implementation.



//Q3 Array Queue
//Write another constructor method
//public void Queue (Queue[] list)
//which constructs a new array based queue by adding the elements in the list of queues one by one
//So, the first k elements of the original queue will be constructed with the first elements of the k queues in the list.
//The second k elements of the orıginal queue will be constructed with the second elements of the k queues in the list etc.
// The elements from the queues should be recreated, not copied from the queues.
//You are not allowed to use enqueue, dequeue pr isempty functions.
//solve for array implementation

//Q6
//List Hash
// Write a static method
// int [] union(int[] list1, int[] list2)
//to find the union of the elements in two arrays and return a new array.
//The union array should contain only that many items not more not less.
// Your method should run in O(N) time.
// Dont use any external data structures or arrays except the resulting array and an external hash table.


//Q2 Tree Tree
// Write the non-recursive method
//int product() in Tree class that computes the prodcuts of all keys in a binary search tree by using stack


//Q5 List Hash
//Write the static method in hash class
// boolean sumOfFourK(int[] array,int K)
// takes an array of integers as a parameter and returns true if the sum of four elements in the array is K
// The method should run in O(N) time.
//You are only allowed to use an external array and external hash table.



//Q1 Tree Tree
//T1 and T2 are two binary Trees, Write the recursive method
// boolean isIdentical(TreeNode T1, TreeNode T2)
// in Tree ciass to determine if T1 is identical to T2