/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_kusy;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kusy
 */
public class LoginController implements Initializable {

    public LoginModel loginModel = new LoginModel();

    @FXML
    private Label isConnected;
    @FXML
    private TextField UserName;
    @FXML
    private TextField PassName;
//    @FXML
//    private AnchorPane main_page;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (loginModel.isDbConnected()) {
            //isConnected.setText("Connected");
        } else {
            isConnected.setText("Nie połączono z bazą danych");
        }
    }


    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) throws IOException {
    Parent main_page_parent =  FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene main_page_scene = new Scene(main_page_parent);
            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            if (loginModel.isLogin(UserName.getText(), PassName.getText())) {
                
                app_stage.hide(); //optional
                app_stage.setScene(main_page_scene);
                app_stage.show();  
            } else {
                UserName.clear();
                PassName.clear();
                isConnected.setText("Błędny login lub hasło");
            }
        } catch (SQLException ex) {
            isConnected.setText("Błędny login lub hasło");
            ex.printStackTrace();
        }
    }
}
