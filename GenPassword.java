import java.util.Random;

/**
 * The class <code>GenPassword</code> generates a random password 
 * composed of consonants, vowels and numbers (containing no other 
 * printable characters).
 *
 * @author  Szilassy, Bertalan
 * @version 1-001
 * @since   2018/06/11
 */

public class GenPassword 
{    
    private int    genPwLen    = 0 ;
    private String generatedPw = "" ;
    private char[] vowels      = { 'a', 'e', 'i', 'o', 'u' 
                                 } ;
    private char[] consonants  = { 'b', 'c', 'd', 'f', 'g', 
                                   'h', 'j', 'k', 'l', 'm',
                                   'n', 'p', 'q', 'r', 's',
                                   't', 'v', 'w', 'x', 'y', 
                                   'z' 
                                 } ;
    private char[] numbers     = { '0', '1', '2', '3', '4',
                                   '5', '6', '7', '8', '9' 
                                 } ;   
    
    public static void main(String[] args)     
    {
        GenPassword gp = new GenPassword() ;

        System.out.println("            minLen   maxLen   numbers  capitalisation") ;
        System.out.println("                 4       20       YES             YES") ;
        System.out.println(gp.getGenPassword(4,      20,     false,          false)) ;
        
    }   //  end of method main()

    /**
     * The method <code>getGenPassword()</code> generates password as a sequence of
     * consonants, vowels and numbers in a definit order: consonant | vowel | number. 
     * The consonants and vowels will randomly be capitalised, if the parameter
     * <code>capitalisationNeeded</code> value is <code>true</code>. 
     * 
     * @author  Szilassy, Bertalan
     * @version 1-001
     * @param   minLen  the minimal length of the the generated password
     * @param   maxLen the maximal length of the the generated password 
     * @param   containsNumber the generated password must contain numbers as well
     * @param   mixedCapitalisation the letters (consonants and vowels) must be
     * randomly capitalised
     * @return  password the generated password as a Java String variable 
     * 
     * @since   2018/06/11
     */
    public  String getGenPassword(int     minLen, 
                                  int     maxLen,
                                  boolean containsNumber,
                                  boolean mixedCapitalisation)
    {
        int genPwLenLimit = getRandomValue(minLen, maxLen) ;
        for ( ;  ; )
        {
            if (appendLetter(consonants, 
                             mixedCapitalisation, 
                             genPwLenLimit
                            ) == true)
            {
                break ;
            }
   
            if (appendLetter(vowels, 
                             mixedCapitalisation, 
                             genPwLenLimit
                            ) == true)
            {
                break ;
            }
      
            if (containsNumber == true)
            {
                generatedPw = generatedPw + 
                              numbers[    getRandomValue(0, numbers.length - 1) ] ;

                if (++genPwLen >= genPwLenLimit) 
                {
                    break ;
                }
            }
            
        }   //  end of for-cycle 

        return (generatedPw) ;
        
    }   //  end of method getGenPassword()
    
    /**
     * The method <code>appendLetter()</code> appends a consonant or a vowel 
     * to the generatedPw being generated. The letters is capitalised depending
     * on the input argument <code>capitalisationNeeded</code>.
     * 
     * @author  Szilassy, Bertalan
     * @version 1-001
     * @param   <code>letters</code>  containing vowels or consonants
     * @param   <code>capitalisationNeeded</code> <code>true</code> or <code>false</code> 
     * @param   <code>pwLenLimit</code> maximal password length actually generated  
     * @return  <code>true</code> or <code>false</code> - depending on wether the 
     * desirable password length has been achieved (<code>true</code>, if the limit
     * has been achieved, otherwise <code>false</code>)
     * @since   2018/06/11
     */
    public boolean appendLetter(char[]    letters,
                                 boolean  capitalisationNeeded,
                                 int      pwLenLimit
                                )
    {
        String  currentlyAppendedChar = "" ;
        boolean limitAchieved         = true ;
        
        currentlyAppendedChar = currentlyAppendedChar + 
                                letters[getRandomValue(0, letters.length - 1) ] ;

        if (capitalisationNeeded == true)
        {
            int     capitalisation        = 0 ;
            
            capitalisation = getRandomValue(0, 1) ;
            
            if (capitalisation > 0)
            {
                generatedPw = generatedPw + currentlyAppendedChar.toUpperCase(); 
            }
            else
            {
                generatedPw = generatedPw + currentlyAppendedChar ; 
            }
        }
        else
        {
            generatedPw = generatedPw + currentlyAppendedChar ; 
        }
    
        if (++genPwLen >= pwLenLimit) 
        {
            limitAchieved = true ;
        }
        else
        {
            limitAchieved = false ;
        }

        return  limitAchieved ;
        
    }   //  end of method appendLetter()
    
    /**
     * The method <code>getRandomNum()</code> returns a random integer. The 
     * input arguments <code>minValue</code> and <code>maxValue</code>
     * are tested, whether <code>maxValue</code> is greater than or equal to
     * <code>minValue</code> (if not, <code>IllegalArgumentException</code>
     * will be thrown 
     * 
     * The generated integer interval is <code>[minValue..maxValue]</code>
     * 
     * @author  Szilassy, Bertalan
     * @version 1-001
     * @param   maxValue  maximal value of the generated random integer (inclusive)
     * @param   minValue  minimal value of the generated random integer (inclusive)
     * @return  generated random integer
     * @throws  IllegalArgumentException will be thrown if minValue is greater than maxValue
     * @see     <a href="https://www.mkyong.com/java/java-generate-random-integers-in-a-range/">URL</a>
     * @since   2018/06/11
     */
    public int getRandomValue(int minValue,
                              int maxValue) throws IllegalArgumentException
    {
        final String  illegalArgumentMsg = 
                      "maxValue maxValue must be greater than minValue" ;
        
              int     randomValue        = 0 ;
              Random  rnd                = new Random() ;
        
        if (maxValue < minValue) 
        {
            throw new IllegalArgumentException(illegalArgumentMsg);
        }
        
        randomValue = rnd.nextInt((maxValue - minValue) + 1) + minValue ;
        
        return  randomValue ;        
        
    }   // end of methode getRandomValue()
    
}   // end of class getGenPassword()
