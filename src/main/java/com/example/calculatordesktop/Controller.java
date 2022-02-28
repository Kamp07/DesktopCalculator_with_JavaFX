package com.example.calculatordesktop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button clear_btn;

    @FXML
    private Button delenie_btn;

    @FXML
    private Button equals_btn;

    @FXML
    private Label label_field;

    @FXML
    private Button minus_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button plus_btn;

    @FXML
    private Button plus_minus_btn;

    @FXML
    private Button umnozhenie_btn;

    @FXML
    private Button zap_btn;

    String strNum = "";
    private float firstNum;
    private char operation;

    @FXML
    void initialize()
    {
        btn_0.setOnAction(event -> addNumber(0));
        btn_1.setOnAction(event -> addNumber(1));
        btn_2.setOnAction(event -> addNumber(2));
        btn_3.setOnAction(event -> addNumber(3));
        btn_4.setOnAction(event -> addNumber(4));
        btn_5.setOnAction(event -> addNumber(5));
        btn_6.setOnAction(event -> addNumber(6));
        btn_7.setOnAction(event -> addNumber(7));
        btn_8.setOnAction(event -> addNumber(8));
        btn_9.setOnAction(event -> addNumber(9));
        plus_btn.setOnAction(event -> mathAction('+'));
        minus_btn.setOnAction(event -> mathAction('-'));
        delenie_btn.setOnAction(event -> mathAction('/'));
        umnozhenie_btn.setOnAction(event -> mathAction('*'));
        equals_btn.setOnAction(event -> {
            if (this.operation == '+' || this.operation == '-'
                    || this.operation == '/' || this.operation == '*')
                equalMethod();
        });
        zap_btn.setOnAction(event -> {
            if (!this.strNum.contains("."))
            {
                this.strNum += ".";
                label_field.setText(strNum);
            }
        });
        percent_btn.setOnAction(event -> {
            if (!this.strNum.equals(""))
            {
                float num = Float.parseFloat(this.strNum) * 0.1f;
                this.strNum = Float.toString(num);
                label_field.setText(strNum);
                this.strNum = "";
                this.operation = 'A';
                this.firstNum = 0;
            }
        });
        plus_minus_btn.setOnAction(event -> {
            if (!this.strNum.equals(""))
            {
                float num = Float.parseFloat(this.strNum) * -1;
                this.strNum = Float.toString(num);
                label_field.setText(strNum);
            }
        });
        clear_btn.setOnAction(event -> {
            label_field.setText("0");
            this.strNum = "";
            this.firstNum = 0;
            this.operation = 'A';
        });
    }

     void equalMethod() {
        float res = 0;
        switch (this.operation)
        {
            case '+':
                res = this.firstNum + Float.parseFloat(this.strNum);
                break;
            case '-':
                res = this.firstNum - Float.parseFloat(this.strNum);
                break;
            case '/':
                if (Float.parseFloat(this.strNum) != 0) {
                    res = this.firstNum / Float.parseFloat(this.strNum);
                }
                else if (Float.parseFloat(this.strNum) == 0)
                {
                    label_field.setText("Ошибка! Деление на 0!");
                    this.strNum = "";
                    this.firstNum = 0;
                    this.operation = 'A';
                }
                break;
            case '*':
                res = this.firstNum * Float.parseFloat(this.strNum);
                break;

        }
        label_field.setText(Float.toString(res));
        this.strNum = "";
        this.operation = 'A';
        this.firstNum = 0;
    }

    void mathAction(char operation)
    {
        if (this.operation != '+' && this.operation != '-'
            && this.operation != '/' && this.operation != '*')
        {
            this.firstNum = Float.parseFloat(this.strNum);
            label_field.setText(String.valueOf(operation));
            this.strNum = "";
            this.operation = operation;
        }

    }

    void addNumber(int number)
    {
        this.strNum += Integer.toString(number);
        label_field.setText(strNum);
    }

}

