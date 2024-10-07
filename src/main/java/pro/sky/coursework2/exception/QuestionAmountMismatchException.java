package pro.sky.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionAmountMismatchException extends RuntimeException {
    public QuestionAmountMismatchException(String message) {
        super();
    }
}
