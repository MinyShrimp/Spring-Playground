package shrimp.playground.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shrimp.playground.member.dto.response.ExceptionResponse;
import shrimp.playground.member.exception.NotFoundMemberException;

@Slf4j
@RestControllerAdvice(
        basePackageClasses = {
                MemberController.class
        }
)
public class MemberControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundMemberException.class)
    public ExceptionResponse notFoundMemberExHandler(
            NotFoundMemberException e
    ) {
        return new ExceptionResponse(e.getMessage());
    }
}
