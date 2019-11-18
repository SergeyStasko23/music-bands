package ru.stacy.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Error writing data to excel file")
public class ErrorWritingDataToExcelFileException extends RuntimeException {
}
