package com.github.evgdim.tasktrack.project;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId, String thrownByMethod) {
        super(userId + "" + thrownByMethod, null, true, false);
    }
}
