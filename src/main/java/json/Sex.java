package json;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by jsato on 2016/06/18.
 */
public enum Sex {
  MALE("Male"),
  FEMALE("Female"),
  UNDEFINED("Undefined")
  ;

  private final String sex;

  Sex(final String sex) {
    this.sex = sex;
  }

  @JsonValue
  public String getSex() {
    return sex;
  }
}
