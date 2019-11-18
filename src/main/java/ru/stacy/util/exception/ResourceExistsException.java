package ru.stacy.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.stacy.business.entity.MusicBlock;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Resource with such name already exists")
public class ResourceExistsException extends RuntimeException {

}
