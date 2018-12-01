
package com.szilassy.eu.java.linkedlist ;

import java.util.* ;

/**
 *  Re-implementation of the LinkedList with a private  
 *  static inner Node class. 
 *
 *  @author Szilassy, Bertalan
 *  @param <T> type of elements stored in the linked list 
 */
public class LinkedList_szy<T> implements Iterable<T>
{
    private Node<T> head ;
 
    /**
      *  Constructs an empty list 
      */
    public LinkedList_szy()
    {
        this.head = null ;
        
    }   //  end of constructor LinkedList_szy() 

    /**
     *  Inserts a new node at the beginning of the linked list.
     *  @param  item a new item will be added to the start of the linked list
     */
     public synchronized void addFirst(T item)
     {
         this.head = new Node<T>(item, this.head) ;
        
     }   //  end of method addFirst()

    /**
     *  Inserts a new node to the end of the linked list.
     *  @param  item a new item will be added to the end of the linked list
     */
    public synchronized void addLast(T item)
    {
        if (this.head == null)
        {
            addFirst(item) ;
        }
        else
        {
            Node<T> tmp = this.head ;
            
            while (tmp.next != null) 
            {
                tmp = tmp.next ;
            }
  
            tmp.next = new Node<T>(item, null) ;
        }

    }   //  end of method addLast()

    /**
      *  Removes all nodes from the linked list.
      */
    public synchronized void clear()
    {
        this.head = null ;
        
    }   //  end of method clear()

    /**
      *  Returns true if this list contains the specified element.
      *  @param  item the specified element
      *  @return true if the element could be found in the linked list, false otherwise
      */
    public synchronized boolean contains(T item)
    {
        for (T tmp : this)
        {
           if  (tmp.equals(item))
           {
               return true ;
           }
        }
  
        return false ;
        
    }   //  end of method contains()

    /**
      *  Returns a deep copy of the immutable list using a tail reference.
      *  @return the copy (equivalent duplicate) of the linked list
      *  or null if the copied linked list empty
      */
    public synchronized LinkedList_szy<T> copy()
    {
        LinkedList_szy<T> returnValue ;
        Node<T>           tmp = this.head ;
        LinkedList_szy<T> twin = new LinkedList_szy<T>() ;
        
        if (this.head == null)
        {
            returnValue = null ;
        }
        else
        {
            twin.head = new Node<T>(this.head.data, null) ;
            Node<T> tmpTwin = twin.head ;
            
            while (tmp.next != null)
            {
                tmp          = tmp.next ;
                tmpTwin.next = new Node<T>(tmp.data, null) ;
                tmpTwin      = tmpTwin.next ;
            }
            
            returnValue = twin ;
        }
  
        return returnValue ;
        
    }   //  end of method copy()

    /**
      *  Returns the data at the specified position in the list.
      *  @param  pos the specified position
      *  @return element from the linked list resides at the specified position
      *  @throws IndexOutOfBoundsException in case of an empty linked list has to be copied
      */
    public synchronized T get(int pos) throws IndexOutOfBoundsException
    {
        if (this.head == null) 
        {
            throw new IndexOutOfBoundsException() ;
        }
        else
        {
            Node<T> tmp = this.head ;
            
            for (int k = 0 ; k < pos ; k++) tmp = tmp.next ;
      
            if (tmp == null) throw new IndexOutOfBoundsException() ;
      
            return tmp.data ;
        }
        
    }   //  end of method get()

    /**
      *  Returns the first element from the list.
      *  @return the first element from the linked list 
      *  @throws NoSuchElementException in case of an empty linked list
      */
    public synchronized T getFirst() throws NoSuchElementException
    {
        if (this.head == null)
        {
            throw new NoSuchElementException() ;
        }
        else
        {
            return this.head.data ;
        }
        
    }   //  end of method getFirst()

    /**
      *  Returns the last element in the list.
      *  @return the last element from the linked list 
      *  @throws NoSuchElementException in case of an empty linked list
      */
    public synchronized T getLast() throws NoSuchElementException
    {
        if (this.head == null)
        {
            throw new NoSuchElementException() ;
        }
        else
        {
            Node<T> tmp = this.head ;
            
            while (tmp.next != null) 
            {
                tmp = tmp.next ;
            }
      
            return tmp.data ;
        }

    }   //  end of method getLast()

    /**
      *  Inserts a new element after a node containing the key.
      *  @param  key identifies the insertion point
      *  @param  hasToBeInserted the new element has to be inserted
      */
    public synchronized void insertAfter(T key, T hasToBeInserted)
    {
        Node<T> tmp = this.head ;
  
        while (tmp != null && !tmp.data.equals(key)) 
        {
            tmp = tmp.next ;
        }
  
        if (tmp != null)
        {
           tmp.next = new Node<T>(hasToBeInserted, tmp.next) ;
        }
        
    }   //  end of method insertAfter()

    /**
      *  Inserts a new node before a node containing the key.
      *  @param  key identifies the insertion point
      *  @param  hasToBeInserted the new element has to be inserted
      */
    public synchronized void insertBefore(T key, T hasToBeInserted)
    {
        if (this.head == null) return ;
  
        if (this.head.data.equals(key))
        {
            addFirst(hasToBeInserted) ;
            return ;
        }
  
        Node<T> prev = null ;
        Node<T> curr = this.head ;
  
        while (curr != null && !curr.data.equals(key))
        {
            prev = curr ;
            curr = curr.next ;
        }
        
        /**
         *  Inserting element between curr and previous
         */
        if (curr != null)
        {
            prev.next = new Node<T>(hasToBeInserted, curr) ;
        }
        
    }   //  end of method insertBefore()

    /**
      *  Returns true if the linked list is empty
      *  @return true if the linked list is empty, otherwise false
      */
    public synchronized boolean isEmpty()
    {
        return this.head == null ;
        
    }   //  end of method isEmpty()

    /**
     *  Defines an iterator over the linked list
     *  @return the iterator
     */
    public Iterator<T> iterator()
    {
        return new LinkedList_szyIterator() ;

    }   //  end of method iterator()
 
    /**
      *  Removes the first occurrence of the specified element in this list.
      *  @param  key identifies the elemeent which has to removed
      *  @throws RuntimeException in cases of inconsistent stages
      */
    public synchronized void remove(T key) throws RuntimeException
    {
        if (!contains(key) || this.head == null) 
        {
            /**
             *  key cannot be found in the LinkedList
             */
            return ; 
        }
        
        if (this.head.data.equals(key))
        {
            this.head = this.head.next ;
            return ;
        }
  
        Node<T> curr = this.head ;
        Node<T> prev = null ;
  
        while (curr != null && !curr.data.equals(key))
        {
            prev = curr ;
            curr = curr.next ;
        }
  
        if (curr == null)
        {
            throw new RuntimeException("cannot delete") ;
        }
  
        /**
         *  delete the current node
         */
        prev.next = curr.next ;
        
    }   //  end of method remove()

    /**
      *  Returns and removes the first element from the linked list.
      *  @return  the first element from the linked list
      */
    public synchronized T removeFirst()
    {
        T tmp = getFirst() ;
        this.head  = this.head.next ;
        
        return tmp ;

    }   //  end of method removeFirst()

    /**
     *  Reverses the linked list
     *  @return  the linked list in reversed stage
     */
   public synchronized LinkedList_szy<T> reverse()
   {
       LinkedList_szy<T> reverseList = new LinkedList_szy<T>() ;
       
       Node<T> tmp = this.head ;
       
       while (tmp != null)
       {
           reverseList.addFirst(tmp.data) ;
           tmp = tmp.next ;
       }
       
       return reverseList ;

   }   //  end of method reverse()

   /**
    *  Reverses the linked list in situ
    */
   public synchronized void reverseSelf()
   {
       this.head = reverse().head ;
       
   }   //  end of method reverseSelf()
  
    /**
      *  Returns a string representation
      *  @return the string representation of the linked list
      */
    public synchronized String toString()
    {
        StringBuffer result = new StringBuffer() ;
        
        for (T x : this)
        {
           result.append(x + " ") ;
        }
  
        return result.toString() ;

    }   //  end of method toString()

    /** 
     *  Each element of the linked list is comprising of two items: 
     *  the data and a reference to the next node.
     */
    private static class Node<T>
    {
        /**
         *  T contains the  d a t a  element in the linked list
         */
        private T data ;
        
        /**
         *  next contains the reference of the next node
         */
        private Node<T> next ;
  
        /**
         *  Constructor of the Node class
         *  @param data is the data element of the linked list
         *  @param next is the reference for the next node
         */
        public Node(T data, Node<T> next)
        {
            this.data = data ;
            this.next = next ;
        }

    }   //  end of static class Node
 
    /**
     *  The iterator over the linked list 
     */
    private class LinkedList_szyIterator implements Iterator<T>
    {
        private Node<T> nextNode ;
  
        public LinkedList_szyIterator()
        {
            nextNode = head ;
            
        }   //  end of constructor LinkedList_szyIterator()
  
        /**
         *  Returns true if the iteration has more elements. (In other words,
         *  returns true if next() would return an element rather than throwing 
         *  an exception.)
         *  @return  if the iteration has more elements, otherwise false
         */
        public synchronized boolean hasNext()
        {
            boolean returnValue  ;
            
            if (nextNode == null)
                return false ;
            else
                return true ;
            
        }   //  end of method hasNext()
  
        /** 
         *  Returns the next element in the iteration.
         *  @return the next element in the iteration
         *  @throws NoSuchElementException if the iteration has no more elements
         */
        public synchronized T next() throws NoSuchElementException
        {
            if (hasNext() == false) 
              throw new NoSuchElementException() ;
            
            T returnValue = nextNode.data ;
            nextNode      = nextNode.next ;
            
            return returnValue ;
            
        }   //  end of method next()
  
        /**  
         *  Not implemented
         *  @throws UnsupportedOperationException the remove operation is not 
         *  supported by this iterator
         */
        public synchronized void remove() throws UnsupportedOperationException
        { 
            throw new UnsupportedOperationException() ; 
          
        }   // end of method remove()
        
    }   //  end of private class LinkedList_szyIterator
    
}   //  end of class LinkedList_szy
  