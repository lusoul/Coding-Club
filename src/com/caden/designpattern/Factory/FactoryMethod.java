package com.caden.designpattern.Factory;

public class FactoryMethod {
    abstract class BMW {

    }
    class BMW320 extends BMW {
        public BMW320() {
            System.out.println("BMW 320 done");
        }
    }
    class BMW520 extends BMW {
        public BMW520() {
            System.out.println("BMW 520 done");
        }
    }
    interface FactoryBMW {
        BMW createCar();
    }
    class FactoryBMW320 implements FactoryBMW {
        @Override
        public BMW createCar() {
            return new BMW320();
        }
    }
    class FactoryBMW520 implements FactoryBMW {
        @Override
        public BMW createCar() {
            return new BMW520();
        }
    }

    public static void main(String[] args) {
//        FactoryBMW factoryBMW520 = new FactoryBMW520();
//        BMW bmw520 = factoryBMW520.createCar();
//
//        FactoryBMW factoryBMW320 = new FactoryBMW320();
//        BMW bmw320 = factoryBMW320.createCar();
    }
}


