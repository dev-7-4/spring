package eu.softcent.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class ApiResponse {
  private Object data;
  private String message;
  private Boolean isSucceed;
  private Object error;

  {
    message = "Error Occurred";
    isSucceed = false;
  }
}
