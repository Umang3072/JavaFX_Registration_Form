

package com.example.umang;

import javafx.application.Application;

import javafx.collections.FXCollections;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;

import javafx.stage.Stage;

import java.io.IOException;

import java.util.regex.Pattern;

public class HelloApplication extends Application {

    @Override

    public void start(Stage primaryStage) throws IOException {

        GridPane pane = new GridPane();

        pane.setAlignment(Pos.CENTER); 

        pane.setHgap(5);

        pane.setVgap(5);

        //Creating label and text field for First Name

        Label fn = new Label("First Name");

        TextField  fnText = new TextField();

        fnText.setPromptText("Enter First Name");

        pane.add(fn,1,0);

        pane.add(fnText,2,0);

        //Creating label and text field for Middle Name

        Label mn = new Label("Middle Name");

        TextField  mnText = new TextField();

        mnText.setPromptText("Enter Middle Name");

        pane.add(mn,1,1);

        pane.add(mnText,2,1);

        //Creating label and text field for Last Name

        Label ln = new Label("Last Name");

        TextField  lnText = new TextField();

        lnText.setPromptText("Enter Last Name");

        pane.add(ln,1,2);

        pane.add(lnText,2,2);

        //Creating label and text field for Email Address

        Label email = new Label("Email Address");

        TextField  emailText = new TextField();

        emailText.setPromptText("Enter Email Address");

        pane.add(email,1,3);

        pane.add(emailText,2,3);

        //Creating label and text field for Mobile Number

        Label mon = new Label("Mobile Number");

        TextField  monText = new TextField();

        monText.setPromptText("Enter Mobile Number");

        pane.add(mon,1,4);

        pane.add(monText,2,4);

        //Create a ComboBox for DateOfBirth

        Label DOB = new Label("Date Of Birth");

        Label Day = new Label("Day");

        Label Month = new Label("Month");

        Label Year = new Label("Year");

        String [] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        String [] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

        String [] years = {"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"};

        ComboBox cBDay = new ComboBox(FXCollections.observableArrayList(days));

        ComboBox cBMonth = new ComboBox(FXCollections.observableArrayList(months));

        ComboBox cBYear = new ComboBox(FXCollections.observableArrayList(years));

        pane.add(DOB,1,5);

        pane.add(Day,1,6);

        pane.add(cBDay,2,6);

        pane.add(Month,1,7);

        pane.add(cBMonth,2,7);

        pane.add(Year,1,8);

        pane.add(cBYear,2,8);

        //Create a Radio Button for Gender

        Label gender = new Label("Gender");

        RadioButton rBMale = new RadioButton("Male");

        RadioButton rBFemale = new RadioButton(("Female"));

        ToggleGroup group = new ToggleGroup();

        rBMale.setToggleGroup(group);

        rBFemale.setToggleGroup(group);

        pane.add(gender,1,9);

        pane.add(rBMale,2,9);

        pane.add(rBFemale,2,10);

        //Create a Language known option by using Checkbox class

        Label language = new Label("Language");

        CheckBox hindi = new CheckBox("Hindi");

        CheckBox gujarati = new CheckBox("Gujarati");

        CheckBox english = new CheckBox("English");

        pane.add(language,1,11);

        pane.add(hindi,2,11);

        pane.add(gujarati,2,12);

        pane.add(english,2,13);

        //Create a submit and cancel button

        Button cancel = new Button("Cancel");

        Button submit = new Button("Submit");

        pane.add(cancel,1,18);

        pane.add(submit,2,18);

//Create a second scene for when a user submit the data the new scene will appear

        GridPane pane2 = new GridPane();

        Scene scene2 = new Scene(pane2,1000,300);

        pane2.setStyle("-fx-font:40px CENTER");

        pane2.setAlignment(Pos.CENTER);

        Label welcomePage = new Label();

        //Creating a setOnAction event that takes place when user click submit button

        submit.setOnAction (e-> {

                    //Validation for first,middle and last names

                    String fml = "[A-Za-z\\s]+";

                    Pattern p = Pattern.compile(fml);

                    boolean a = p.matcher(fnText.getText()).matches();

                    if(!a){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Name Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("First name must be character and not be null ");

                        alert.showAndWait();

                    }

                    boolean b = p.matcher(mnText.getText()).matches();

                    if(!b){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Name Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("Middle name must be character and not be null");

                        alert.showAndWait();

                    }

                    boolean c = p.matcher(lnText.getText()).matches();

                    if(!c){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Name Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("Last name must be character and not be null");

                        alert.showAndWait();

                    }

                    //Validation for email address

                    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

                    Pattern emailPattern = Pattern.compile(emailRegex);

                    boolean emailChecker = emailPattern.matcher(emailText.getText()).matches();

                    if(!emailChecker){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Email Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("Please Enter Valid Email Address");

                        alert.showAndWait();

                    }

                    //Validation for mobile number

                    String numberRegex = "[6-9][0-9]{9}";

                    Pattern numberPattern = Pattern.compile(numberRegex);

                    boolean numberChecker = numberPattern.matcher(monText.getText()).matches();

                    if(!numberChecker){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Number Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("Please Enter Valid Mobile Number with limit in 10 digits");

                        alert.showAndWait();

                    }

                    //validation for ComboBox

                    boolean d = cBDay.getSelectionModel().isEmpty();

                    if(d){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("DOB Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("Select the Day");

                        alert.showAndWait();

                    }

                    boolean m = cBMonth.getSelectionModel().isEmpty();

                    if(m){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("DOB Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("Select the Month");

                        alert.showAndWait();

                    }

                    boolean y = cBYear.getSelectionModel().isEmpty();

                    if(y) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("DOB Warning");

                        alert.setHeaderText(null);

                        alert.setContentText("Select the Year");

                        alert.showAndWait();

                    }

                    //Validation for RadioButton

                    boolean mf = ((rBMale.isSelected() | rBFemale.isSelected()));

                    if(!mf){

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Validate Fields");

                        alert.setHeaderText(null);

                        alert.setContentText("Select one of the gender");

                        alert.showAndWait();

                    }

                    //Validation for CheckBox

                    boolean hge =  (hindi.isSelected() | gujarati.isSelected() | english.isSelected() );

                    if(!hge) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);

                        alert.setTitle("Validate Fields");

                        alert.setHeaderText(null);

                        alert.setContentText("Select one of the language");

                        alert.showAndWait();

                    }

                    //If all the content of registration form are valid , we show a welcome screen

                    if(a && b && c && !d && !m && !y && mf && hge && emailChecker && numberChecker ){

                        primaryStage.setScene(scene2);

                        String name = fnText.getText() + "" + lnText.getText();

                        welcomePage.setText("Welcome " + name + " to our group");

                        pane2.add(welcomePage,1,1);

                    }

                });

        //Creating a setOnAction event that takes place when user click cancel button

        //It will clear the input which are in the form

        cancel.setOnAction(e-> {

            fnText.clear();

            mnText.clear();

            lnText.clear();

            emailText.clear();

            monText.clear();

            cBDay.getSelectionModel().clearSelection();

            cBMonth.getSelectionModel().clearSelection();

            cBYear.getSelectionModel().clearSelection();

            rBMale.setSelected(false);

            rBFemale.setSelected(false);

            hindi.setSelected(false);

            gujarati.setSelected(false);

            english.setSelected(false);

        });

        //Setting the first scene

        Scene scene1 = new Scene(pane, 400, 450);

        primaryStage.setTitle("RegistrationForm");

        primaryStage.setScene(scene1);

        primaryStage.show();

    }

    public static void main(String[] args) {

        launch();

    }

}
