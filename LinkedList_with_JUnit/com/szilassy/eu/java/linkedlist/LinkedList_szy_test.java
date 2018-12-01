
package com.szilassy.eu.java.linkedlist ;

import java.util.Iterator ;

public class LinkedList_szy_test 
{
    public static void main(String[] args)
    {
        System.out.println("0 % 2 is " + 0 % 2) ;
        
        
        LinkedList_szy<String> list = new LinkedList_szy<>() ;
        list.addFirst("pins") ;
        list.addFirst("avocado") ;
        list.addFirst("endeavor") ;
        list.addFirst("holly") ;
        
        System.out.println("you should read the linked list like that:") ;
        System.out.println("holly endeavor avocado pins") ;
        
        System.out.println("\nthe linked list' content") ;        
        System.out.println(list) ;
        System.out.println("") ;
        
        list.addLast("sculpture") ;
        System.out.println("Added \"sculpture\" with addLast()") ;
        System.out.println(list) ;
        System.out.println("") ;

        System.out.println("Added \"Suisse\" after \"endeavor\" with insertAfter()") ;
        list.insertAfter("endeavor", "Suisse") ;
        System.out.println(list) ;
        System.out.println("") ;

        System.out.println("Added \"Darmstadt\" before \"endeavor\" with insertBefore()") ;
        list.insertBefore("endeavor", "Darmstadt") ;
        System.out.println(list) ;
        System.out.println("") ;

        System.out.println("Remove \"endeavor\" with remove()") ;
        list.remove("endeavor") ;
        System.out.println(list) ;
        System.out.println("") ;
        
        System.out.println("Reverse the linked list above with reverse()") ;
        LinkedList_szy<String> reverseList = new LinkedList_szy<>() ; 
        reverseList = list.reverse() ;
        System.out.println(reverseList) ;
        System.out.println("") ;
        
        System.out.println("However the original remained unchanged :)") ;
        System.out.println(list) ;
        System.out.println("") ;
        
        System.out.println("Reverse the original linked list with reverseSelf()") ;
        list.reverseSelf() ;
        System.out.println(list) ;
        System.out.println("") ;
        
    }   //  end of main()

}   //  end of LinkedList_szy_test

