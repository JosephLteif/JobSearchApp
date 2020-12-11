/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.University;
import Helpers.MySQLConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lama
 */
public class RepoUni {
    
      
     private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    private static Statement stmt;

    public RepoUni() {
        con = MySQLConnectionManager.getConnection();
    }
    
    
    private University extractUniFromResultSet(ResultSet rs) throws SQLException {
       University uni=new University();
       uni.setId(rs.getInt("ID_UNIVERSITY"));
       uni.setUname(rs.getString("UNIVERSITY_NAME"));
       uni.setAccreditation(rs.getString("ACCREDITATION"));
       uni.setRanking(rs.getInt("RANKING"));
       return uni;
    }
    
    
    
     public ArrayList<University>getAllUnis() throws SQLException{
       ArrayList <University> unis=new ArrayList();
           ps = con.prepareStatement("select ID_UNIVERSITY, UNIVERSITY_NAME, ACCREDITATION,RANKING from university;");
           rs = ps.executeQuery();
           while(rs.next()){
               University uni=extractUniFromResultSet(rs);
               unis.add(uni);
               
           }
            return unis;
    }
}
     