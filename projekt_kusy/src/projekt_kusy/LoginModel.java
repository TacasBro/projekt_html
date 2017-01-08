/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_kusy;

import java.sql.*;

public class LoginModel {
    Connection connection;
    public LoginModel(){
        connection = SqlConnection.Connector();
        if(connection==null) {
            System.out.println("Connection not successful");
            System.exit(1);
        }
    }
    
    public boolean isDbConnected(){
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            ex.printStackTrace();
        return false;
        }
    }
    PreparedStatement preparedStatment = null;
       ResultSet resultSet = null;
   public boolean isLogin(String user, String pass) throws SQLException{
       
       String query="select * from login_lek where login = ? and password = ?";
       try{
        preparedStatment = connection.prepareStatement(query);
        preparedStatment.setString(1, user);
        preparedStatment.setString(2, pass);
        
        resultSet = preparedStatment.executeQuery();
        if(resultSet.next()){
            return true;
        }else {
            return false;
        }
       }catch(Exception e){
           return false;
       }finally{
           preparedStatment.close();
           resultSet.close();
       }
   } 
}
