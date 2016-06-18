package json;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jsato on 2016/06/18.
 */
public class Person {
  private int age;
  private String name;
  private Sex sex;
  private List<String> hobbies;
  private List<Language> languages;

  public Person(int age, String name, Sex sex, List<String> hobbies, List<Language> languages) {
    this.age = age;
    this.name = name;
    this.sex = sex;
    this.hobbies = hobbies;
    this.languages = languages;
  }

  public Person(int age, String name, Sex sex, String[] hobbies, Language[] languages) {
    this.age = age;
    this.name = name;
    this.sex = sex;
    this.hobbies = Arrays.asList(hobbies);
    this.languages = Arrays.asList(languages);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public List<String> getHobbies() {
    return hobbies;
  }

  public void setHobbies(List<String> hobbies) {
    this.hobbies = hobbies;
  }

  public List<Language> getLanguages() {
    return languages;
  }

  public void setLanguages(List<Language> languages) {
    this.languages = languages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    return age == person.age && (name != null ? name.equals(person.name) : person.name == null && sex == person.sex && (hobbies != null ? hobbies.equals(person.hobbies) : person.hobbies == null && (languages != null ? languages.equals(person.languages) : person.languages == null)));

  }

  @Override
  public int hashCode() {
    int result = age;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (sex != null ? sex.hashCode() : 0);
    result = 31 * result + (hobbies != null ? hobbies.hashCode() : 0);
    result = 31 * result + (languages != null ? languages.hashCode() : 0);
    return result;
  }
}
