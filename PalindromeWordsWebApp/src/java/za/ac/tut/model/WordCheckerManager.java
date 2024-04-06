/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

/**
 *
 * @author MemaniV
 */
public class WordCheckerManager implements WordCheckerInterface {

    @Override
    public boolean isWordAPalindrome(String word, String reverseForm) {
        boolean isPalindrome = false;
        
        if(reverseForm.equals(word)){
            isPalindrome = true;
        }
        
        return isPalindrome;
    }

    public String getWordReverseForm(String word) {
        String reverseWord = "";
        
        for(int i = word.length() -1; i >= 0; i--){
            char charAtIndex = word.charAt(i);
            reverseWord = reverseWord + Character.toString(charAtIndex);
        }
        
        return reverseWord;
    }
    
}
