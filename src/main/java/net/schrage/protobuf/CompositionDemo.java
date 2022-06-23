package net.schrage.protobuf;

import net.schrage.models.Address;
import net.schrage.models.Car;
import net.schrage.models.Person;

public class CompositionDemo {

  public static void main(String[] args) {

    Address address = Address.newBuilder()
        .setPostbox(123)
        .setStreet("Fultonstraße")
        .setCity("Bremen")
        .build();

    Car car = Car.newBuilder()
        .setMake("VW")
        .setModel("Passat")
        .setYear(2011)
        .build();

    Person person = Person.newBuilder()
        .setName("Michael")
        .setAge(53)
        .setCar(car)
        .setAddress(address)
        .build();

    System.out.println(person);


  }

}
