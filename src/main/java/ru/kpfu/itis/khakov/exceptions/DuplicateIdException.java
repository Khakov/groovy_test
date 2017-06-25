package ru.kpfu.itis.khakov.exceptions;

/**
 * @author Khakov Rustam
 */
public class DuplicateIdException extends Exception{
    public DuplicateIdException() {
        this("Duplicate id in list, please change list");
    }

    public DuplicateIdException(String message) {
        super(message);
    }
}
