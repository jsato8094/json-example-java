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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by jsato on 2016/06/20.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Response {
  private final Status status;
  private final Object[] wayPoints;
  private final Object[] routes;

  public Response(Status status, Object[] wayPoints, Object[] routes) {
    this.status = status;
    this.wayPoints = wayPoints;
    this.routes = routes;
  }

  @JsonCreator
  public static Response create(@JsonProperty("status") String status,
                                @JsonProperty("geocoded_waypoints") Object[] wayPoints,
                                @JsonProperty("routes") Object[] routes) {
    return new Response(Status.forValue(status), wayPoints, routes);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Response response = (Response) o;

    if (status != response.status) return false;
    // Probably incorrect - comparing Object[] arrays with Arrays.equals
    if (!Arrays.equals(wayPoints, response.wayPoints)) return false;
    // Probably incorrect - comparing Object[] arrays with Arrays.equals
    return Arrays.equals(routes, response.routes);

  }

  @Override
  public int hashCode() {
    int result = status != null ? status.hashCode() : 0;
    result = 31 * result + Arrays.hashCode(wayPoints);
    result = 31 * result + Arrays.hashCode(routes);
    return result;
  }
}
