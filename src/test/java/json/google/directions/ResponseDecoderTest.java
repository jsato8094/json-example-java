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

import org.junit.Test;

import java.net.URL;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

/**
 * Created by jsato on 2016/06/20.
 */
public class ResponseDecoderTest {
  @Test
  public void decode() throws Exception {
//    String json = "{\n" +
//            "   \"available_travel_modes\" : [ \"DRIVING\", \"WALKING\" ],\n" +
//            "   \"geocoded_waypoints\" : [\n" +
//            "      {\n" +
//            "         \"geocoder_status\" : \"OK\",\n" +
//            "         \"place_id\" : \"ChIJuxzHyqz-GGARmPJscpwls_o\",\n" +
//            "         \"types\" : [ \"premise\" ]\n" +
//            "      },\n" +
//            "      {\n" +
//            "         \"geocoder_status\" : \"OK\",\n" +
//            "         \"place_id\" : \"ChIJC3Cf2PuLGGAROO00ukl8JwA\",\n" +
//            "         \"types\" : [\n" +
//            "            \"transit_station\",\n" +
//            "            \"train_station\",\n" +
//            "            \"subway_station\",\n" +
//            "            \"point_of_interest\",\n" +
//            "            \"establishment\"\n" +
//            "         ]\n" +
//            "      }\n" +
//            "   ],\n" +
//            "   \"routes\" : [],\n" +
//            "   \"status\" : \"ZERO_RESULTS\"\n" +
//            "}";

    final URL url = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=place_id:ChIJ685WIFYViEgRHlHvBbiD5nE&destination=place_id:ChIJA01I-8YVhkgRGJb0fW4UX7Y&alternatives=true&key=INPUT_YOUR_API_KEY_HERE");

    final ResponseDecoder decoder = new ResponseDecoder();
//    assertThat(decoder.decode(json).orElse(null),is(not(nullValue())));

    // I don't know this line is necessary or not
    CompletableFuture<Response> future = CompletableFuture.supplyAsync(() -> decoder.decode(url).orElse(null));

    assertThat(future.get(),is(not(nullValue())));
  }
}