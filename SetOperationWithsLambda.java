package set;

import java.util.Set;
import java.util.HashSet;

/**
 *  The class {@code SetOperation} contains methods to 
 *  provide primitive set operations, such as {@code union}, 
 *  {@code intersection}, {@code set extracting} and 
 *  {@code computing power}.
 *  
 *  <p>The methods were implemented with lambda expressions.
 *
 *  @version 1-001
 *  @since   2018/08/31
 *  @author  Szilassy, Bertalans
 */
public class SetOperationWithsLambda<T>
{
    /**
     * Produces intersect set: the set of all objects that are members 
     * of both set1 and set2.
     * 
     * @param set1 the first operand of the intersect operation
     * @param set2 the second operand of the intersect operation
     * @return a set produced as intersect of the sets set1 and set2
     */
    public Set<T> interSection(Set<T> set1, Set<T> set2)
    {
        Set<T> interSectionSet = new HashSet<>() ;
        
        set1.stream().filter((setElem) -> 
        (set2.contains(setElem) == true)).forEachOrdered(setElem -> 
                                          {
                                              interSectionSet.add(setElem) ;
                                          }
                                                        );
        return interSectionSet ;

    }   //  end of method interSection()
    
    /**
     * Produces of a set which is the set whose members are 
     * all of the possible subsets of the base set. 
     * 
     * @param set the base set 
     * @return the power set of the parameter set
     */
    public Set<Set<T>> powerset(Set<T> set) 
    {
        Set<Set<T>> powerSet = new HashSet<>() ;  

        Set<T> emptySet = new HashSet<>() ;
        
        //  start with the empty set
        powerSet.add(emptySet) ; 

        set.forEach((item) -> 
        {   
            //  add each item to all previous subsets
            Set<Set<T>> foundSets = new HashSet<>(powerSet) ;
            
            foundSets.stream().map(foundSet -> 
            new HashSet<>(foundSet)).map(newSet -> 
            {
                // Add each item to all previously found subsets.
                newSet.add(item) ;
                return newSet ;                
            }                           ).forEachOrdered(newSet -> 
                                          {
                                              //  add new subset to all subsets found
                                              powerSet.add(newSet) ;
                
                                          }             ) ; //  end of inner for-loop
        }          ) ; //  end of outer for-loop  
        
        return powerSet ;

    }   //  end of method powerset()

    /**
     * Produces the set of all members of set1 that are not members of set2.
     * 
     * @param set1 the diminuendo set
     * @param set2 the diminishing set
     * @return the set of difference
     */
    public Set<T> subtract(Set<T> set1, Set<T> set2)
    {
        Set<T> interSection = interSection(set1, set2) ;        
        Set<T> subtractSet  = new HashSet<>() ;

        set1.forEach(setElem -> subtractSet.add(setElem));
        interSection.forEach(setElem -> subtractSet.remove(setElem));
        
        return subtractSet ;

    }   //  end of method subtract()
    
    /**
     * Produces the set is of all objects that are a member of exactly one of 
     * set1 and set2 (elements which are in one of the sets, but not in both).
     * 
     * @param set1 the first operand of the symmetrical difference
     * @param set2 the second operand of the symmetrical difference
     * @return the set of symmetrical difference
     */
    public Set<T> symmetricalDiff(Set<T> set1, Set<T> set2)
    {
        Set<T> symmetricalDiffSet = union(set1, set2) ; 
        Set<T> interSection = interSection(set1, set2) ;
        
        interSection.forEach(setElem -> symmetricalDiffSet.remove(setElem)) ; 

        return symmetricalDiffSet ;

    }   //  end of method symmetricalDiff()

    /**
     * Produces is the set of all objects that 
     * are a member of set1, or set2, or both.
     * 
     * @param set1 the first operand of the union
     * @param set2 the second operand of the union
     * @return the set of union of set1 and set2
     */
    public Set<T> union(Set<T> set1, Set<T> set2)
    {
        Set<T> unionSet = new HashSet<>() ;
        
        set1.forEach(e -> unionSet.add(e)) ;
        set2.forEach(e -> unionSet.add(e));
        
        return unionSet ;

    }   //  end of method union()

}   //  end of class SetOperationWithsLambda
