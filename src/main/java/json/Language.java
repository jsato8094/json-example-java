package json;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by jsato on 2016/06/18.
 */
public enum Language {
  JAPANISE("Japanese"),
  ENGLISH("English"),
  GERMANY("Germany"),
  C("C"),
  JAVA("Java"),
  CPP("C++"),
  CLOJURE("Clojure"),
  PYTHON("Python"),
  GO("Go"),
  SCALA("Scala"),
  KOTLIN("Kotlin"),
  SWIFT("Swift"),
  PHP("PHP"),
  JAVASCRIPT("JavaScript"),
  HTML("HTML"),
  OTHER("Other")
  ;

  private final String name;

  Language(String name) {
    this.name = name;
  }

  @JsonValue
  public String getName() {
    return name;
  }
}
