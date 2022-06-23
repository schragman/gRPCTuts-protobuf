package net.schrage.protobuf;

import net.schrage.models.BodyStyle;
import net.schrage.models.Car;
import net.schrage.models.Dealer;

public class MapDemo {

  public static void main(String[] args) {
    Car passat = Car.newBuilder()
        .setMake("VW")
        .setModel("Passat")
        .setBodyStyle(BodyStyle.COUPE)
        .setYear(2011)
        .build();

    Car derby = Car.newBuilder()
        .setMake("VW")
        .setModel("Derby")
        .setBodyStyle(BodyStyle.SEDAN)
        .setYear(2003)
        .build();

    Dealer dealer = Dealer.newBuilder()
        .putModel(2011, passat)
        .putModel(2003, derby)
        .build();

    System.out.println(dealer.getModelOrThrow(2003).getBodyStyle());


  }

}
