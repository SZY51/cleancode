package com.szilassy.eu.java.linkedlist.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.szilassy.eu.java.linkedlist.LinkedList_szy;

class LinkedList_szy_Junit_test
{
    LinkedList_szy<String> linkedList = new LinkedList_szy<>() ;

    @BeforeEach
    void setUp() throws Exception
    {
        ; 
    }

    @Test
    void test_addFirst()
    {
        /**
         *  given -------------------------------------------------------------
         */
        String item_1 = "pinea" ;
        String item_2 = "avocado" ;
        String item_3 = "endeavour" ;
        String item_4 = "Holly Night" ;
        
        /**
         *  when  -------------------------------------------------------------
         */
        linkedList.addFirst(item_1) ;
        linkedList.addFirst(item_2) ;
        linkedList.addFirst(item_3) ;
        linkedList.addFirst(item_4) ;

        /**
         *  then  -------------------------------------------------------------
         */
        assertAll(
                     ()-> assertTrue(linkedList.contains(item_1)) ,
                     ()-> assertTrue(linkedList.contains(item_2)) ,
                     ()-> assertTrue(linkedList.contains(item_3)) ,
                     ()-> assertTrue(linkedList.contains(item_4)) ,
                     
                     ()-> assertEquals(linkedList.getLast(),  item_1) , 
                     ()-> assertEquals(linkedList.getFirst(), item_4) 
                 ) ;
        
    }   //  end of method test_addFirst()

    @Test
    void test_addLast()
    {
        /**
         *  given -------------------------------------------------------------
         */
        String item_1 = "Eclipse" ;
        String item_2 = "applied cryptography" ;
        String item_3 = "systems engineering" ;
        String item_4 = "aspect oriented programing" ;
        
        
        /**
         *  when  -------------------------------------------------------------
         */
        linkedList.addLast(item_1) ;
        linkedList.addLast(item_2) ;
        linkedList.addLast(item_3) ;
        linkedList.addLast(item_4) ;

        /**
         *  then  -------------------------------------------------------------
         */
        assertAll(
                     ()-> assertTrue(linkedList.contains(item_1)) ,
                     ()-> assertTrue(linkedList.contains(item_2)) ,
                     ()-> assertTrue(linkedList.contains(item_3)) ,
                     ()-> assertTrue(linkedList.contains(item_4)) ,
                     
                     ()-> assertEquals(linkedList.getLast(),  item_4) , 
                     ()-> assertEquals(linkedList.getFirst(), item_1) 
                 ) ;
        
    }   //  end of method test_addLast()

    @Test
    void test_remove()
    {
        /**
         *  given -------------------------------------------------------------
         */
        String item_1 = "paternal mtDNA" ;
        String item_2 = "microbialDNA" ;
        String item_3 = "hemagglutinin" ;
        String item_4 = "mitochondria" ;
        String item_5 = "guanine nucleotide" ;
        String item_6 = "mutagenized cells" ;
        String item_7 = "residual response" ;

        /**
         *  when  -------------------------------------------------------------
         */
        linkedList.addFirst(item_1) ;
        linkedList.addFirst(item_2) ;
        linkedList.addFirst(item_3) ;
        linkedList.addFirst(item_4) ;
        linkedList.addFirst(item_5) ;
        linkedList.addFirst(item_6) ;
        linkedList.addFirst(item_7) ;

        /**
         *  Should be true, because it was added just now
         */
        boolean recommended_1 = linkedList.contains(item_5) ;
        
                                linkedList.remove(  item_5) ;
        /**
         *  Should be false, because it was removed just now
         */
        boolean recommended_2 = linkedList.contains(item_5) ;
        
        /**
         *  then  -------------------------------------------------------------
         */
        assertAll(
                     ()-> assertTrue( recommended_1) ,
                     ()-> assertFalse(recommended_2) 
                 ) ;
        
    }   //  end of method test_remove()

    @Test
    void test_reverse()
    {
        /**
         *  given -------------------------------------------------------------
         */
        String item_First = "cytotoxic lymphocytes" ;
        String item_2     = "proteolytic activation" ;
        String item_3     = "antitumor immunity" ;
        String item_4     = "lung-infiltrating NK cells" ;
        String item_5     = "tissue residency marker" ;
        String item_6     = "7C6-DANA mutant antibody" ;
        String item_Last  = "7C6-mIgG2a antibody" ;

        /**
         *  when  -------------------------------------------------------------
         */
        linkedList.addFirst(item_First) ;
        linkedList.addFirst(item_2) ;
        linkedList.addFirst(item_3) ;
        linkedList.addFirst(item_4) ;
        linkedList.addFirst(item_5) ;
        linkedList.addFirst(item_6) ;
        linkedList.addFirst(item_Last) ;

        LinkedList_szy<String> reversedLinkedList = linkedList.reverse();

        /**
         *  then  -------------------------------------------------------------
         */
        assertAll(
                     ()-> assertEquals(reversedLinkedList.getFirst(), item_First) ,
                     ()-> assertEquals(reversedLinkedList.getLast(),  item_Last )
                 ) ;
        
    }   //  end of method test_reverse()

}   //  end of class LinkedList_szy_Junit_test
