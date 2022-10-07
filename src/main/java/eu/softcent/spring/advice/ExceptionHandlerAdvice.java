package eu.softcent.spring.advice;

import java.util.*;

import eu.softcent.spring.entity.ApiResponse;
import eu.softcent.spring.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class ExceptionHandlerAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiResponse handleInvalidArgument(MethodArgumentNotValidException exception) {
    final Map<String, String> errors = new HashMap<String, String>();
    exception.getBindingResult().getFieldErrors().forEach(error -> {
      errors.put(error.getField(), error.getDefaultMessage());
    });
    final ApiResponse apiResponse = new ApiResponse();
    apiResponse.setData(new Object());
    apiResponse.setError(errors);
    apiResponse.setMessage("Invalid Arguments");
    apiResponse.setIsSucceed(false);
    return apiResponse;
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public ApiResponse handleNotFoundException(NotFoundException exception) {
    final ApiResponse apiResponse = ApiResponse
            .build(null, "Not Found", false, exception.getMessage());
    return apiResponse;
  }
}
