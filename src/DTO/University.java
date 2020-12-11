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
public class University {
    
    int id;
    String uname;
    String Accreditation;
    int Ranking;

    public University(int id, String uname, int Ranking) {
        this.id = id;
        this.uname = uname;
        this.Ranking = Ranking;
    }

    public University(int id, String uname) {
        this.id = id;
        this.uname = uname;
    }

    public University(String uname) {
        this.uname = uname;
    }

    public University() {    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAccreditation() {
        return Accreditation;
    }

    public void setAccreditation(String Accreditation) {
        this.Accreditation = Accreditation;
    }

    public int getRanking() {
        return Ranking;
    }

    public void setRanking(int Ranking) {
        this.Ranking = Ranking;
    }
    
    
    
    
    
    
    
    
}
