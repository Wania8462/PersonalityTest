package com.projects.PersonalityTest.exception.handler;

import com.projects.PersonalityTest.exception.AnswerNotFoundException;
import com.projects.PersonalityTest.exception.QuestionNotFoundException;
import com.projects.PersonalityTest.exception.UserNotFoundException;
import com.projects.PersonalityTest.exception.UserResultsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ExceptionObject> handle(UserNotFoundException ex,
                                               WebRequest request) {
        return mapError(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserResultsNotFoundException.class)
    private ResponseEntity<ExceptionObject> handle(UserResultsNotFoundException ex,
                                                   WebRequest request) {
        return mapError(ex, request, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(QuestionNotFoundException.class)
    private ResponseEntity<ExceptionObject> handle(QuestionNotFoundException ex,
                                                   WebRequest request) {
        return mapError(ex, request, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AnswerNotFoundException.class)
    private ResponseEntity<ExceptionObject> handle(AnswerNotFoundException ex,
                                                   WebRequest request) {
        return mapError(ex, request, HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<ExceptionObject> mapError(RuntimeException ex,
                                                 WebRequest request,
                                                 HttpStatus httpStatus) {
        ExceptionObject errorObject = ExceptionObject.builder()
                .timeStamp(new Date())
                .status(httpStatus.value())
                .error(ex.getMessage())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(errorObject, httpStatus);
    }
}
