/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_kusy;

import javafx.beans.property.SimpleStringProperty;



public class SqlData {
    
    private final SimpleStringProperty Doctor;
        private final SimpleStringProperty visitedCol;
        private final SimpleStringProperty aimCol;
        private final SimpleStringProperty sympCol;
        private final SimpleStringProperty drugCol;

        
//        <TableColumn fx:id="doctorCol" prefWidth="75.0" text="Lekarz" />
//                              <TableColumn fx:id="visitedCol" prefWidth="75.0" text="Data wizyty" />
//                              <TableColumn fx:id="aimCol" prefWidth="75.0" text="Cel wizyty" />
//                              <TableColumn fx:id="sympCol" prefWidth="75.0" text="Objawy" />
//                              <TableColumn fx:id="drugCol" prefWidth="75.0" text="Leki" />
    
     public SqlData(String doctor, String visitedF, String aimF, String sympF, String drugF) {
            this.Doctor = new SimpleStringProperty(doctor);
            this.aimCol = new SimpleStringProperty(aimF);
            this.visitedCol = new SimpleStringProperty(visitedF);
            this.sympCol = new SimpleStringProperty(sympF);
            this.drugCol = new SimpleStringProperty(drugF);
        }
 
    public String getDoctor(){
        return Doctor.get();
    }
    public String getVisited(){
        return visitedCol.get();
    }
    public String getAim(){
        return aimCol.get();
    }
    public String getSymp(){
        return sympCol.get();
    }
    public String getDrug(){
        return drugCol.get();
    }
    
    
    public void setDoctor(String doctor){
        Doctor.set(doctor);
    }
    public void setVisited(String visitedF){
        visitedCol.set(visitedF);
    }
    public void setAim(String aimF){
        aimCol.set(aimF);
    }
    public void setSymp(String sympF){
        sympCol.set(sympF);
    }
     public void setDrug(String drugF){
        drugCol.set(drugF);
    }
}
