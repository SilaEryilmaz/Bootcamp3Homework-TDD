package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CaseStudyStack<T> {

   private  StackExample sut = new StackExample();

    @BeforeAll
    public static <T> void setup(){
        List<T> list = new ArrayList<>();
    }

    @Test
    public void pushItem_whenNewItemAdded_ShouldReturnCorrectSize(){
        StackExample sut = new StackExample();
        List<T> list = new ArrayList<>();
        sut.setArr(list);
        //Act
        sut.pushItem(2);
        //Verify
        assertThat(sut.getSize()).isEqualTo(1);
    }

    @Test
    public void popItem_whenItemDeleted_ShouldReturnCorrectSize(){
        //Arrange
        StackExample sut = new StackExample();
        List<T> list = new ArrayList<>();
        sut.setArr(list);
        //Act

        //Verify
    }

}
