package Generics.JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<E> {

    public Deque<E> deque;

    public Jar(){
        this.deque = new ArrayDeque<>();
    }

    public void add(E element){
        this.deque.push(element);
    }

    public E remove(){
        return this.deque.pop();
    }
}
