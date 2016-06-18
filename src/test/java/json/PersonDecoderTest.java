package json;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by jsato on 2016/06/18.
 */
public class PersonDecoderTest {
  @Test
  public void decode() throws Exception {
    int age = 20;
    String name = "jacob";
    Sex sex = Sex.MALE;
    String[] hobbies = {"Running", "Piano"};
    Language[] languages = {Language.GERMANY,Language.JAVA,Language.CLOJURE};

    Person person = new Person(age,name,sex,hobbies,languages);

    PersonEncoder encoder = new PersonEncoder();
    String json = encoder.encode(person);

    PersonDecoder decoder = new PersonDecoder();
    assertThat(decoder.decode(json),is(person));
  }

}