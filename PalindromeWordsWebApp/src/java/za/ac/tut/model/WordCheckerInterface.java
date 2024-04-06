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
public interface WordCheckerInterface {
    public String getWordReverseForm(String word);
    public boolean isWordAPalindrome(String word, String reverseForm);
}
