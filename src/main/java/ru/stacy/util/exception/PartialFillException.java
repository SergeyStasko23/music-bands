package ru.stacy.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PartialFillException extends RuntimeException {
    public PartialFillException(String message) {
        super(message);
    }
}
