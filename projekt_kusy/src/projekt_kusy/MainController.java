/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_kusy;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Kusy
 */
public class MainController implements Initializable {

    @FXML
    private TableColumn<?, ?> lekarz_ID;
    @FXML
    private TableColumn<?, ?> data_wizyty;
    @FXML
    private TableColumn<?, ?> cel_wizyty;
    @FXML
    private TableColumn<?, ?> objawy;
    @FXML
    private TableColumn<?, ?> leki;
    @FXML
    private TextField searchPesel;
    @FXML
    private Button searchButton;
    @FXML
    private Label cityLabel;
    @FXML
    private Label insuranceLabel;
    @FXML
    private Label surNameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label peselLabel;
    @FXML
    private TextField getPeselField;
    @FXML
    private TextField getAdressField;
    @FXML
    private TextField getCityField;
    @FXML
    private TextField getNameField;
    @FXML
    private TextField getInsurenceField;
    @FXML
    private TextField getSurrnameField;

    final ObservableList<SqlData> data = FXCollections.observableArrayList();
    @FXML
    TableView<SqlData> table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lekarz_ID.setCellValueFactory(new PropertyValueFactory<>("lekarz_ID"));
        data_wizyty.setCellValueFactory(new PropertyValueFactory<>("data_wizyty"));
        cel_wizyty.setCellValueFactory(new PropertyValueFactory<>("cel_wizyty"));
        objawy.setCellValueFactory(new PropertyValueFactory<>("objawy"));
        leki.setCellValueFactory(new PropertyValueFactory<>("leki"));
        refreshTable();
    }

//    @FXML
//    private void handleButtonSearch(javafx.event.ActionEvent event){
//        refreshTable();
//    }
    Connection connection=SqlConnection.Connector();;
    PreparedStatement preparedStatment = null;
    ResultSet resultSet = null;

    public void refreshTable() {
        String query = "select * from wizyta";
        try {

            preparedStatment = connection.prepareStatement(query);
            resultSet = preparedStatment.executeQuery();

            while (resultSet.next()) {
                data.add(new SqlData(
                        resultSet.getString("lekarz_ID"),
                        resultSet.getString("data_wizyty"),
                        resultSet.getString("cel_wizyty"),
                        resultSet.getString("objawy"),
                        resultSet.getString("leki")
                ));
                table.setItems(data);
            }
            preparedStatment.close();
            resultSet.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
