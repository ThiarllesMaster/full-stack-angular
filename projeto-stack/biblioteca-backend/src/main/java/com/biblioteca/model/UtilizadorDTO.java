package com.biblioteca.model;

import java.io.Serializable;

public class UtilizadorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}
