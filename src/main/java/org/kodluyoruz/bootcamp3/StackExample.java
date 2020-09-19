package org.kodluyoruz.bootcamp3;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.kodluyoruz.bootcamp3.exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;


public class StackExample <T>{

    private List<T> arr;
    private int size = 0;
    public StackExample() {
        arr = new ArrayList<>();
    }

    public List<T> getArr() {
        return arr;
    }

    public int getSize() {
        return arr.size();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArr(List<T> arr) {
        this.arr = arr;
    }

    public void pushItem(T value){
        arr.add(value);
    }


    public void popItem() {
        if(arr.size() == 0){
            throw new EmptyListException("List is empty!");
        }
        arr.remove(arr.size() - 1);
    }

    public <T> T peek() {

        T value = (T) arr.get(arr.size()-1);
        return value;
    }
}
