package com.gmail.snyp4eg.exception;

public class DaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    private Throwable rootCause;

    public DaoException () {
      
    }

    public DaoException (String message) {
    this.message = message;
    }

    public DaoException (String message, Throwable rootCause) {
    this.message = message;
    this.rootCause = rootCause;
    }

    public DaoException (Throwable rootCause) {
    this.rootCause = rootCause;
    }

    @Override
    public String getMessage() {
      return message;
    }

    public Throwable getRootCause() {
      return rootCause;
    }

    @Override
    public String toString() {
      return message;
    }
  }
