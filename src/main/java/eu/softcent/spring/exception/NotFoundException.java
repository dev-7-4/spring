package eu.softcent.spring.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException extends Exception {
  String message;
}
