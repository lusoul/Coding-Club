package com.caden.designpattern.decorator_pattern.标准写法;

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

class Decorator implements Component {

    private Component comp;
    public Decorator(Component comp) {
        this.comp = comp;
    }

    @Override
    public void doSomething() {
        this.comp.doSomething();
    }
}

class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component comp) {
        super(comp);
    }

    public void doSomething() {
        super.doSomething();//写成this.comp.doSomething()呢？,但是父类的Component是private的，无法集成，所以没有
        this.doAnotherthing();
    }
    private void doAnotherthing() {
        System.out.println("do 2...");
    }
}

class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component comp) {
        super(comp);
    }

    public void doSomething() {
        super.doSomething();
        this.doAnotherthing();
    }
    private void doAnotherthing() {
        System.out.println("do 3...");
    }
}