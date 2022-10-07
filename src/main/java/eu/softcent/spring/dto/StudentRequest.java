package eu.softcent.spring.dto;

import lombok.*;
import eu.softcent.spring.utils.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class StudentRequest {
  @NotBlank
  private String name;
  @Email
  @NotBlank
  private String email;
  @NotBlank
  private String subject;
  @NotBlank
  private String department;

  @Override
  public String toString() {
    return ApiUtils.toJson(this);
  }
}
