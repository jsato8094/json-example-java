/*
 * Copyright 2016. Junichi Sato
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package json.sandbox;

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