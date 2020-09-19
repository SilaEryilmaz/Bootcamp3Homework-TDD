package org.kodluyoruz.bootcamp3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.kodluyoruz.bootcamp3.exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.InstanceOfAssertFactories.INTEGER;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CaseStudyStack<T> {

    StackExample sut = new StackExample();



    @BeforeEach
    public <T> void setup(){
        List<T> list = new ArrayList<>();

        T value1= (T) Integer.valueOf(1);
        T value2= (T) Integer.valueOf(2);
        T value3= (T) Integer.valueOf(3);
        list.add(value1);
        list.add(value2);
        list.add(value3);
        sut.setArr(list);
    }

    @Test
    public void pushItem_whenNewItemAdded_ShouldReturnCorrectSize(){
        //Act
        sut.pushItem(2);
        //Verify
        assertThat(sut.getSize()).isEqualTo(4);
    }

    @Test
    public void popItem_whenItemDeleted_ShouldReturnCorrectSize(){
        //Act
        sut.pushItem(2);
        sut.popItem();
        //Verify
        assertThat(sut.getSize()).isEqualTo(3);
    }

    @Test
    public void pop_whenItemDeleted_ShouldDeleteFromTop(){
        //Act
        sut.pushItem(2);
        sut.popItem();
        //Verify
        T expectedResult = (T) sut.getArr().get(sut.getSize()-1);
        assertThat(expectedResult).isEqualTo(expectedResult);
    }

    @Test
    public void peekOnStack_ShouldReturnItemFromTheTop(){
        //Act
        sut.pushItem(2);
        sut.pushItem(3);
        T expectedResult = (T) sut.peek();
        //verify
        assertThat(expectedResult).isEqualTo(3);
    }

    @Test
    public void countList_ShouldReturnCountOfTheList(){
        //Act
        sut.pushItem(2);
        sut.pushItem(3);
        int count = sut.getSize();
        //verify
        assertThat(count).isEqualTo(5);
    }

    @Test
    public void whenListEmpty_ShouldReturnEmptyListException(){
        popItemForXTimes(3);
        //Act
        Throwable throwable = catchThrowable(() -> sut.popItem());
        //verify
        assertThat(sut.getArr()).isNotNull();
        assertThat(throwable).isInstanceOf(EmptyListException.class).hasMessage("List is empty!");

    }

    @Test
    public void peek_whenThereAreNoArgument_ShouldThrowNullPointerException(){
        //Arrange
        sut.setArr(null);
        //Act
        Throwable throwable = catchThrowable(() -> sut.peek());
        //Verify
        assertThat(throwable).isInstanceOf(NullPointerException.class);
    }



    public void popItemForXTimes(int count){
        for(int i=0; i<count ; i++){
            sut.popItem();
        }
    }
}
