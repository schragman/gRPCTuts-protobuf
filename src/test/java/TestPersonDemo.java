import com.google.common.annotations.VisibleForTesting;
import net.schrage.models.Person;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPersonDemo {

  @Test
  public void read() throws IOException {
    Path path = Paths.get("sam.ser");

    byte[] bytes = Files.readAllBytes(path);
    Person newSam = Person.parseFrom(bytes);

    System.out.println(newSam);


  }

}
