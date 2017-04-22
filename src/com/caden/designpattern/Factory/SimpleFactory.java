package com.caden.designpattern.Factory;

public class SimpleFactory {

    abstract class BMW {

    }
    class BMW320 extends BMW {
        public BMW320() {
            System.out.println("BMW 320 manufactured");
        }
    }
    class BMW520 extends BMW {
        public BMW520() {
            System.out.println("BMW 520 manufactured");
        }
    }

    class Factory {
        public BMW createCar(int type) {
            if (type == 320) {
                return new BMW320();
            } else if (type == 520) {
                return new BMW520();
            } else {
                return null;
            }
        }
    }


    public static void main(String[] args) {
//        Factory factory = new Factory();
//        BMW bmw320 = factory.createCar(320);
//        BMW bmw520 = factory.createCar(520);
    }
}


