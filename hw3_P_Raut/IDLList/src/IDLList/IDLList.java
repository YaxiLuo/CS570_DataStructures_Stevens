package IDLList;
import java.util.ArrayList;
import java.util.*;
import java.util.StringTokenizer;
public class IDLList<E> {

// a private child class Node<E> 
	
	private class Node<E> {

        private E data;
        private Node<E> next; //dll with next pointer to node
        private Node<E> prev; //dll with previous pointer to node

     // default constructor
        public Node(E data) {
            this.data = data;
            next = null;
            prev = null;
        }

      //parameterized constructor
        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }
// declare parent class IDLL variables and initialize  
    private Node<E> head; //head pointer
    private Node<E> tail; //tail pointer
    private int size;
    private ArrayList<Node<E>> indices; // array list of references to node to access to elements

  //create an empty doubly linked list
    public IDLList() {
        head = null;
        tail = null;
        size = 0; //size of list initially null 
        indices = new ArrayList<Node<E>>(); // creating and initializing indices list 
    }

 // add element at indices 
    public boolean add(int index, E elem) {
        if ( index > size || index<0) {
            throw new IndexOutOfBoundsException();
        }
      //add to head
      		/*if (index==0)
      		{
      			add(elem);
      			return true;
      		}
      		//add to tail
      		if(index==size)
      		{
      			append(elem);
      			return true;
      			
      		}*/
        if (index!= 0) { 
            //add(elem);
        	//insert a new node
        	Node<E> curr = indices.get(index);
            Node<E> newcurr = new Node<>(elem, curr, curr.prev);
            curr.prev.next = newcurr;
            curr.prev = newcurr;
            size++;
            indices.add(index, newcurr);
        } else {
           
        	add(elem);
        }
        return true;
    }
    
  //method to  add element to head
    public boolean add(E elem) {
        if (head == null) { //if list is empty 
            head = new Node<E>(elem, null, null);
            tail = head;
        } else if (head == tail) { 
            head = new Node<E>(elem, tail, null);
            tail.prev = head;
        } else {
            head = new Node<E>(elem, head, null);
            head.next.prev = head;
        }

        indices.add(0, head);
        size++;
        return true;
    }
  
  //method to  append an element at the end of list
    public boolean append(E elem) {
        if (head == null) { // checks if list is empty 
            head = new Node<E>(elem, null, null);
            tail = head;
            size++;
            return indices.add(head);
        }

        if (head == tail) { 
            tail = new Node<E>(elem, null, head);
            head.next = tail;
            size++;
            return indices.add(tail);
        }
        tail.next = new Node<E>(elem, null, tail);
        tail = tail.next;
        size++;
        return indices.add(tail);
    }
    /* method returns the object at position index from the head. It uses the index 
	for fast access. Indexing starts from 0, thus get(0) returns the head element of the list.*/
    public E get(int index) {
         return indices.get(index).data;
    }

  // method returns object at the head
    public E getHead() {
        if (head == null)
            throw new IllegalStateException();
            return head.data;
    }
  // method returns object at the tail
    public E getLast() {
        if (tail == null)
            throw new IllegalStateException();
        return tail.data;
    }
    //method returns list (indices) size 
    public int size() {
    	
        return size;
    }
     //method to remove and return element at head 
    public E remove() {
        if (head == null) {
            throw new IllegalStateException();
        }

        if (head == tail) {
            Node<E> T = head;
            head = null;
            tail = null;
            size--;
            indices.clear();
            return T.data;
        }

        Node<E> T = head;
        head = head.next;
        indices.remove(0);
        size--;
        return T.data;
    }
  // method to remove and return element at tail 
    public E removeLast() {
        if (head == null) {
            throw new IllegalStateException();
        }

        if (head == tail) {
            Node<E> T = tail;
            head = null;
            tail = null;
            size = 0;
            indices.clear();
            return T.data;
        }

        Node<E> T = tail;
        tail = tail.prev;
        tail.next = null;
        indices.remove(size - 1);
        size--;
        return T.data;
    }
     // method to remove element at an index
    public E removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IllegalStateException("index: " + index);
        }

        if (index == 0) { //remove first
            return remove();
        }

        if (index == size - 1) { //remove last
            return removeLast();
        }

        // remove an element between the first and the last
        Node<E> curr = indices.remove(index);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
        return curr.data;
    }
    /*method  removes the first occurrence of element is in the list and returns 
	true. Return false if element  was not in the list.*/
    public boolean remove(E elem) {

        if (elem.equals(head.data)) { // remove  first 
            remove();
            return true;
        }

        if (elem.equals(tail.data)) { // remove last 
            removeLast();
            return true;
        }

        Node<E> curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data.equals(elem)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                indices.remove(index);
                size--;
                return true;
            }
            curr = curr.next;
            index++;
        }
        return false;
    }
//method presents string representation of list
    public String toString() {
        Node<E> curr = head;
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        while (curr != null) {
            str.append(curr.data.toString() + ", ");
            curr = curr.next;
        }
        str.append("]");
        return str.toString();
    }

   
}