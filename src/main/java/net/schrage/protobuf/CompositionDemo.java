package net.schrage.protobuf;

import com.google.protobuf.Int32Value;
import net.schrage.models.Address;
import net.schrage.models.Car;
import net.schrage.models.Person;

import java.util.ArrayList;

public class CompositionDemo {

  public static void main(String[] args) {

    Address address = Address.newBuilder()
        .setPostbox(123)
        .setStreet("Fultonstraße")
        .setCity("Bremen")
        .build();

    Car passat = Car.newBuilder()
        .setMake("VW")
        .setModel("Passat")
        .setYear(2011)
        .build();

    Car derby = Car.newBuilder()
        .setMake("VW")
        .setModel("Derby")
        .setYear(2003)
        .build();

    ArrayList<Car> cars = new ArrayList<>();
    cars.add(passat);
    cars.add(derby);

    Person person = Person.newBuilder()
        .setName("Michael")
        .setAge(Int32Value.newBuilder().setValue(53).build())
        .addAllCar(cars)
        /*.addCar(passat)
        .addCar(derby)*/
        .setAddress(address)
        .build();

    System.out.println(person);


  }

}
