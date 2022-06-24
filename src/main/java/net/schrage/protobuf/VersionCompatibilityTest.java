package net.schrage.protobuf;

import net.schrage.models.Television;
import net.schrage.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

  public static void main(String[] args) throws IOException {

    Path pathV1 = Paths.get("tv-v1");
    Path pathV2 = Paths.get("tv-v2");
    /*Television television = Television.newBuilder()
        .setBrand("sony")
        //.setYear(2015)
        .setModel(2016)
        .setType(Type.OLED)
        .build();

    Files.write(pathV2, television.toByteArray());*/

    //Deserialization
    byte[] bytes = Files.readAllBytes(pathV2);

    System.out.println(Television.parseFrom(bytes));

  }

}
