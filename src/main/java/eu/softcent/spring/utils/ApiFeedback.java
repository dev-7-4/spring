package eu.softcent.spring.utils;

import eu.softcent.spring.entity.ApiResponse;

public class ApiFeedback {
  public static ApiResponse onError(Exception exception) {
    final ApiResponse response = new ApiResponse();
    /// remove stack trace elements
    StackTraceElement[] x = {};
    exception.setStackTrace(x);
    /// give it a message
    if (exception.getMessage() == null) {
      exception = new Exception("Something Wrong");
    }
    response.setData(new Object());
    response.setError(exception);
    response.setMessage(exception.getMessage());
    response.setIsSucceed(false);
    return response;
  }
}
