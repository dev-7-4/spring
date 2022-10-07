package eu.softcent.spring.entity;

import eu.softcent.spring.utils.ApiUtils;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String email;
  private String subject;
  private String department;

  @Override
  public String toString() {
    return ApiUtils.toJson(this);
  }
}
