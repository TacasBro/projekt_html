
package projekt_kusy;

import java.sql.*;


public class SqlConnection {
   public static Connection Connector(){
       try{
           Class.forName("org.sqlite.JDBC");
           Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\Projekt_programowanie\\baza_danych.db3");
       return conn;
       }
       catch (Exception e){
           System.out.println(e);
          return null; 
       }
   } 
}
