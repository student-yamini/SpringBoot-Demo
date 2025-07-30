package com.example.productlist.Dependencies;

public class Car {
    private Engine eng;
    public  Car(Engine eng){
        this.eng=eng;
    }
    public void drive(){
        eng.start();
        System.out.println("Journey has started");
    }

    public static void main(String[] args) {
        Car car=new Car(new PetrolEngine());
        car.drive();
    }
}
