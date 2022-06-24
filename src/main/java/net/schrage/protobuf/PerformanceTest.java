package net.schrage.protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import net.schrage.json.JPerson;
import net.schrage.models.Person;

public class PerformanceTest {

  public static void main(String[] args) {

    //json
    JPerson person = new JPerson();
    person.setName("sam");
    person.setAge(10);
    ObjectMapper mapper = new ObjectMapper();


    Runnable json = () -> {
      try {
        byte[] bytes =  mapper.writeValueAsBytes(person);
        JPerson person1 = mapper.readValue(bytes, JPerson.class);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };

    //protobuf
    Person sam = Person.newBuilder()
        .setName("sam")
        .setAge(Int32Value.newBuilder().setValue(53).build())
        .build();

    Runnable proto = () -> {
      try {
        byte[] bytes2 = sam.toByteArray();
        Person sam1 = Person.parseFrom(bytes2);
      } catch (InvalidProtocolBufferException e) {
        throw new RuntimeException(e);
      }
    };

    for (int i = 0; i < 5; i++) {
      runPerformanceTest(proto, "PROTO");
      runPerformanceTest(json, "JSON");
    }

  }

  public static void runPerformanceTest(Runnable runnable, String method) {

    long time1 = System.currentTimeMillis();
    for (int i = 0; i < 5_000_000; i++) {
      runnable.run();
    }
    long time2 = System.currentTimeMillis();

    System.out.println(method + ":" + (time2 - time1) + " ms");

  }

}
