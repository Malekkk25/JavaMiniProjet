package com.vols.gestionvols.controllers;

import com.vols.gestionvols.ConnexionDB;
import com.vols.gestionvols.entities.Vol;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class ListeVolController implements Initializable {
    ObservableList<Vol> vols= FXCollections.observableArrayList();

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnReser;

    @FXML
    private Button btnReser1;

    @FXML
    private Button btnVols;

    @FXML
    private TableColumn<Vol, Integer> colCapacite;

    @FXML
    private TableColumn<Vol,Integer> colId;

    @FXML
    private TableColumn<Vol, String> colNum;

    @FXML
    private TableView<Vol> listeVol;
    @FXML
    private Text welcomeText;


    private ObservableList<Vol> getVols() throws ClassNotFoundException {

            PreparedStatement st=null;
            ResultSet rs=null;
            Connection conn=ConnexionDB.getConnectiion();
            try{
                st= conn.prepareStatement(" SELECT * FROM vol ");
                rs=st.executeQuery();
                while (rs.next()){
                    Vol v=new Vol();
                    v.setIdVol(rs.getInt("idVol"));
                    v.setNumVol(rs.getString("numVol"));
                    v.setCapacite(rs.getInt("capacite"));
                    vols.add(v);
                    System.out.println(v.toString());

                }
                rs.close();
                st.close();
                conn.close();
                return vols;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



    }
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ObservableList<Vol> vols = getVols();

            listeVol.setItems(vols);
            colId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdVol()).asObject());
            colNum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumVol()));
            colCapacite.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getCapacite()).asObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void listVol() {
        try {
            Stage stage = (Stage) btnVols.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Fxml/ListeVol.fxml"));
            primaryStage.setTitle("List des vols");
            primaryStage.setScene(new Scene(root, 900, 560));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }}
    public void listReservation() {
        try {
            Stage stage = (Stage) btnReser.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/Fxml/ListeReservation.fxml"));
            primaryStage.setTitle("List des vols");
            primaryStage.setScene(new Scene(root, 900, 560));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }}
        @FXML
        public void logout() {
            try {
                Stage stage = (Stage) btnLogout.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/Fxml/LoginUser.fxml"));
                primaryStage.setTitle("Sign in");
                primaryStage.setScene(new Scene(root, 750, 450));
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void display(String username){
        welcomeText.setText("Hello:" +username);
    }

}
