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

package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jsato on 2016/06/18.
 */
public class PersonDecoder {

  public Person decode(final String jsonString) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    //return mapper.readValue(jsonString, Person.class);

    JsonNode node = mapper.readValue(jsonString, JsonNode.class);

    int age = node.get("age").asInt();
    String name = node.get("name").asText();

    Sex sex = Arrays.asList(Sex.values()).stream().filter(s -> s.getSex().equals(node.get("sex").asText())).findFirst().orElse(Sex.UNDEFINED);

    List<String> hobbies = new ArrayList<>();
    node.get("hobbies").forEach(n -> hobbies.add(n.asText()));

    List<Language> languages = new ArrayList<>();
    List<Language> languagesAll = Arrays.asList(Language.values());
    node.get("languages").forEach(n -> languages.add(languagesAll.stream().filter(l -> l.getName().equals(n.asText())).findFirst().orElse(Language.OTHER)));

    return new Person(age,name,sex,hobbies,languages);
  }

}
