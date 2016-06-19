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
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jsato on 2016/06/20.
 */
public enum Status {
  OK,
  NOT_FOUND,
  ZERO_RESULTS,
  MAX_WAYPOINTS_EXCEEDED,
  INVALID_REQUEST,
  OVER_QUERY_LIMIT,
  REQUEST_DENIED,
  UNKNOWN_ERROR
  ;

  private static Map<String, Status> namesMap;

  static {
    namesMap = new HashMap<>();
    Arrays.asList(Status.values()).forEach(s -> namesMap.put(s.name(), s));
  }

  Status() {
  }

  @JsonCreator
  public static Status forValue(@JsonProperty("status") String status) {
    return namesMap.get(status);
  }

}
