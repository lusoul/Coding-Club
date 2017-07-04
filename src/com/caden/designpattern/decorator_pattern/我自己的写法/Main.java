package com.caden.designpattern.decorator_pattern.我自己的写法;

//我自己写法直接不需要Decorator这个父类了
public class Main {
    public static void main(String[] args) {
        Component c = new ConcreteComponent();
        Component c1 = new ConcreteDecorator1(c);
        Component c2 = new ConcreteDecorator2(c1);

        c2.doSomething();
    }
}

interface Component {
    void doSomething();
}

class ConcreteComponent implements Component {
    @Override
    public void doSomething() {
        System.out.println("do 1...");
    }
}


class ConcreteDecorator1 implements Component {
    private Component comp;
    public ConcreteDecorator1(Component comp) {
        this.comp = comp;
    }

    @Override
    public void doSomething() {
        this.comp.doSomething();
        this.doAnotherthing();
    }
    private void doAnotherthing() {
        System.out.println("do 2...");
    }
}
class ConcreteDecorator2 implements Component {
    private Component comp;
    public ConcreteDecorator2(Component comp) {
        this.comp = comp;
    }

    @Override
    public void doSomething() {
        this.comp.doSomething();
        this.doAnotherthing();
    }
    private void doAnotherthing() {
        System.out.println("do 3...");
    }
}