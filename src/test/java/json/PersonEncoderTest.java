package json;

import org.junit.Test;

/**
 * Created by jsato on 2016/06/18.
 */
public class PersonEncoderTest {
  @Test
  public void encode() throws Exception {
    int age = 20;
    String name = "jacob";
    Sex sex = Sex.MALE;
    String[] hobbies = {"Running", "Piano"};
    Language[] languages = {Language.GERMANY,Language.JAVA,Language.CLOJURE};

    Person person = new Person(age,name,sex,hobbies,languages);

    PersonEncoder encoder = new PersonEncoder();
    System.out.println(encoder.encode(person));
  }

}