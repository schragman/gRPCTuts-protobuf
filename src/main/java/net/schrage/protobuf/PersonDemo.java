package net.schrage.protobuf;


import com.google.protobuf.Int32Value;
import net.schrage.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {

  public static void main(String[] args) throws IOException {

    Person sam1 = Person.newBuilder()
        .setName("sam")
        //.setAge(53)
        .setAge(Int32Value.newBuilder().setValue(53).build())
        .build();

    Path path = Paths.get("sam.ser");
    Files.write(path, sam1.toByteArray());

  }

  public static void read() throws IOException{
    Path path = Paths.get("sam.ser");

    byte[] bytes = Files.readAllBytes(path);
    Person newSam = Person.parseFrom(bytes);

    System.out.println(newSam);


  }

}
