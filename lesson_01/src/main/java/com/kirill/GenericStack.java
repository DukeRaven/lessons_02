package com.kirill;

import java.util.Collection;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by Kirill on 04.04.2016.
 */
public class GenericStack<E> implements IStack<E> {

    Stack<E> stack = new Stack<>();

    @Override
    public void push(E element) throws StackException {
        if (isFull())
            throw new StackException("Stack is full");
        stack.push(element);
    }

    @Override
    public E pop() throws StackException {
        if (isFull())
            throw new StackException("Stack is empty");
        return stack.pop();
    }

    @Override
    public E peek() {
        return stack.peek();
    }

    @Override
    public int getSize() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return (stack.size() == 10);
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {
        for (E element : src ) {
            push(element);
        }
    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    public GenericStack() {};
}
