package itu.com.CRM.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

    private String ref;
    private String exceptionType;
    private String innerException;
    private String source;
    private String stackTrace;

    public Error(String InnerException, String Source, String StackTrace, String ExceptionType)
    {
        ref = "https://datatracker.ietf.org/doc/html/rfc9110";
        innerException = InnerException;
        source = Source.trim();
        stackTrace = StackTrace.trim();
        exceptionType = ExceptionType;
    }
}
