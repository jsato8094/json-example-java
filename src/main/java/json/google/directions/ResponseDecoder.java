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

package json.google.directions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by jsato on 2016/06/20.
 */
public class ResponseDecoder {

  public Optional<Response> decode(final URL url) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      return Optional.of(mapper.readValue(url, Response.class));
    } catch (IOException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

  public Optional<Response> decode(final String json) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      /*
      JsonNode node = mapper.readValue(json, JsonNode.class);

      Status status = Arrays.asList(Status.values()).stream().filter(s -> s.name().equals(node.get("status").asText())).findFirst().orElse(Status.UNKNOWN_ERROR);
      String wayPoints = node.get("geocoded_waypoints").asText();
      String routes = node.get("routes").asText();

      return Optional.of(new Response(status,wayPoints,routes));
      */

      return Optional.of(mapper.readValue(json, Response.class));
    } catch (IOException e) {
      e.printStackTrace();
      return Optional.empty();
    }
  }

}
