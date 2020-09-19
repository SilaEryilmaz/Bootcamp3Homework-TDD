package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordCounterTests {

    @Test
    public void getCompiledString_whenItHasApostrophes_shouldRemoveApostrophes(){
        //Arrange
        Pattern sut = Pattern.compile("[a-zA-Z]+");
        String test = "Cho'Gath";
        String expectedResult = "Cho";
        String actualResult = null;
        //Act
        Matcher m = sut.matcher(test);
        if(m.find()){ actualResult = m.group(); }
        //Verify
        assertThat(actualResult).isNotNull();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void getUniqueWords_whenOneOfThemHasCapitalLetter_shouldReturnTwoDifferentWord(){
        //Arrange
        Pattern sut = Pattern.compile("[a-zA-Z]+");
        String test = "cem Cem";
        //Act
        Matcher m = sut.matcher(test);
        HashMap<String, Integer> hm = new HashMap<>();
        while (m.find())
        {
            String word = m.group();
            if(!hm.containsKey(word))
                hm.put(word, 1);
            else
                hm.put(word, hm.get(word) + 1);
        }
        //Verify
        assertThat(hm.size()).isEqualTo(2);
    }

    @Test
    public void getCompiledString_whenItHasPunctuations_shouldIgnorePunctuations(){
        //Arrange
        Pattern sut = Pattern.compile("[a-zA-Z]+");
        String test = "This,is,a.test , , ";
        //Act
        Matcher m = sut.matcher(test);
        HashMap<String, Integer> hm = new HashMap<>();
        while (m.find())
        {
            String word = m.group();
            if(!hm.containsKey(word))
                hm.put(word, 1);
            else
                hm.put(word, hm.get(word) + 1);
        }
        //Verify
        assertThat(hm.size()).isEqualTo(4);
    }

}
