/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Lama
 */
public class PasswordReset {
    
    
    int id;
    String email;
    String tok;

    public PasswordReset() {
    }

    
    public PasswordReset(int id, String email, String tok) {
        this.id = id;
        this.email = email;
        this.tok = tok;
    }

    public PasswordReset(String email) {
        this.email = email;
    }
    

    
    public PasswordReset(String email, String tok) {
        this.email = email;
        this.tok = tok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTok() {
        return tok;
    }

    public void setTok(String tok) {
        this.tok = tok;
    }
    
    
    
}
