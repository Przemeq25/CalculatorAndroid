package com.example.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private TextView textViewCalculations;
    public static double liczba1;
    public static double liczba2;
    public static char znak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.textViewResult);
        textViewCalculations = findViewById(R.id.textViewCalculations);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("calc", textViewCalculations.getText().toString());
        outState.putString("resul", textViewResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String restore1 = savedInstanceState.getString("calc");
        String restore2 = savedInstanceState.getString("resul");
        textViewCalculations.setText(restore1);
        textViewResult.setText(restore2);
    }
    public void b1OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"1");
    }

    public void b2OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"2");
    }
    public void b3OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"3");
    }
    public void b4OnClick(View view) { textViewResult.setText(textViewResult.getText()+"4"); }
    public void b5OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"5");
    }
    public void b6OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"6");
    }
    public void b7OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"7");
    }
    public void b8OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"8");
    }
    public void b9OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"9");
    }
    public void b0OnClick(View view) {
        textViewResult.setText(textViewResult.getText()+"0");
    }


    public void divideOnClick(View view) {
        try{
            if(textViewResult.getText().length()>0) {
                if (textViewCalculations.getText() == "") {
                    String tekst = String.valueOf(textViewResult.getText());
                    znak = '/';
                    textViewCalculations.setText(tekst + "/");
                    liczba1 = Double.parseDouble(tekst.split("/")[0]);
                    textViewResult.setText("");
                } else if (textViewCalculations.getText() != "" && textViewResult.getText() != "") {
                    znak = '/';
                    liczba2 = Double.parseDouble(textViewResult.getText().toString());
                    if(liczba2 == 0) {
                        textViewCalculations.setText("");
                        textViewResult.setText("Error");
                    }
                    else {
                        textViewCalculations.setText(String.valueOf(liczba1 / liczba2));
                        textViewResult.setText("");
                    }
                }
            }
        }catch(Exception err){
            textViewCalculations.setText("");
            textViewResult.setText("ERROR");
        }
    }
    public void addOnClick(View view) {
        try{
            if(textViewResult.getText().length()>0){
                if(textViewCalculations.getText()==""){
                    String tekst = String.valueOf(textViewResult.getText());
                    znak='+';
                    textViewCalculations.setText(tekst+"+");
                    liczba1=Double.parseDouble(tekst.split("\\+")[0]);
                    textViewResult.setText("");
                }else if(textViewCalculations.getText()!=""&&textViewResult.getText()!=""){
                    znak='+';
                    liczba2=Double.parseDouble(textViewResult.getText().toString());
                    textViewCalculations.setText(String.valueOf(liczba1+ liczba2)+"+");
                    liczba1= liczba1 + liczba2;
                    textViewResult.setText("");
                }
            }
        }catch(Exception err){
            textViewCalculations.setText("");
            textViewResult.setText("ERROR");
        }
    }
    public void subtractOnClick(View view) {
        try{
            if(textViewResult.getText().length()>0) {
                if (textViewCalculations.getText() == "") {
                    String tekst = String.valueOf(textViewResult.getText());
                    znak = '-';
                    textViewCalculations.setText(tekst + "-");
                    liczba1 = Double.parseDouble(tekst.split("-")[0]);
                    textViewResult.setText("");
                } else if (textViewCalculations.getText() != "" && textViewResult.getText() != "") {
                    znak = '-';
                    liczba2 = Double.parseDouble(textViewResult.getText().toString());
                    textViewCalculations.setText(String.valueOf(liczba1 - liczba2) + "-");
                    liczba1 = liczba1 - liczba2;
                    textViewResult.setText("");
                }
            }else{
                textViewResult.setText("-");
            }
        }catch(Exception err){
            textViewCalculations.setText("");
            textViewResult.setText("ERROR");
        }
    }
    public void multiplyOnClick(View view) {
        try{
            if(textViewResult.getText().length()>0) {
                if (textViewCalculations.getText() == "") {
                    String tekst = String.valueOf(textViewResult.getText());
                    znak = '*';
                    textViewCalculations.setText(tekst + "*");
                    liczba1 = Double.parseDouble(tekst.split("\\*")[0]);
                    textViewResult.setText("");
                } else if (textViewCalculations.getText() != "" && textViewResult.getText() != "") {
                    znak = '*';
                    liczba2 = Double.parseDouble(textViewResult.getText().toString());
                    textViewCalculations.setText(String.valueOf(liczba1 * liczba2) + "*");
                    liczba1 = liczba1 * liczba2;
                    textViewResult.setText("");
                }
            }
        }catch(Exception err){
            textViewCalculations.setText("");
            textViewResult.setText("ERROR");
        }
    }

    public void equalOnClick(View view) {
        try{
            if(znak=='+'){
                liczba2=Double.parseDouble(textViewResult.getText().toString());
                textViewResult.setText(String.valueOf(liczba1+ liczba2));
                textViewCalculations.setText("");
            }else if(znak=='-'){
                liczba2=Double.parseDouble(textViewResult.getText().toString());
                textViewResult.setText(String.valueOf(liczba1- liczba2));
                textViewCalculations.setText("");
            }else if(znak=='*'){
                liczba2=Double.parseDouble(textViewResult.getText().toString());
                textViewResult.setText(String.valueOf(liczba1* liczba2));
                textViewCalculations.setText("");
            }else if(znak=='/'){
                liczba2=Double.parseDouble(textViewResult.getText().toString());
                if(liczba2==0){
                    textViewCalculations.setText("");
                    textViewResult.setText("Error");
                }else{
                    textViewResult.setText(String.valueOf(liczba1/ liczba2));
                    textViewCalculations.setText("");
                }
            }
        }catch(Exception err){
            textViewCalculations.setText("");
            textViewResult.setText("ERROR");
        }
    }
    public void buttonClear(View view) {
        textViewResult.setText("");
        textViewCalculations.setText("");
    }
    public void pointOnClick(View view) {
        String point = textViewResult.getText().toString();
        if (point.contains(".")) {
            textViewResult.setText(textViewResult.getText());
        } else {
            textViewResult.setText(textViewResult.getText() + ".");
        }
    }

    public void plusMinusOnClick(View view) {
        try{
            if(textViewResult.getText()!=""){
                if(textViewResult.getText().charAt(0)=='-'){
                    StringBuilder s = new StringBuilder(textViewResult.getText());
                    s= s.replace(0,1,"");
                    textViewResult.setText(s);
                }else{
                    StringBuilder s = new StringBuilder(textViewResult.getText());
                    s= s.insert(0,"-");
                    textViewResult.setText(s);
                }
            }
        }catch(Exception err){
            textViewCalculations.setText("");
            textViewResult.setText("ERROR");
        }
    }


    public void PerOnClick(View view) {
        try {
            if (textViewResult.getText().toString().isEmpty()) {
                textViewResult.setText("");
            }
            else if (textViewResult.getText().toString().contains("%")) {
                textViewResult.setText(textViewResult.getText());
            } else {
                String percent = (textViewResult.getText()).toString();
                textViewResult.setText(Float.parseFloat(percent) / 100 + "");
            }
        }catch(Exception err){
            textViewCalculations.setText("");
            textViewResult.setText("ERROR");
        }
    }


    public void logOnClick(View view) {
        if(textViewResult.getText()!=""){
            double liczba= Double.parseDouble(String.valueOf(textViewResult.getText()));
            textViewResult.setText(String.valueOf(Math.log10(liczba)));
        }
    }

    public void silOnClick(View view) {
        if(textViewResult.getText()!=""){
            double liczba= Double.parseDouble(String.valueOf(textViewResult.getText()));
            double wypisz=1;
            for(int i=1;i<=liczba;i++){
                wypisz*=i;
            }
            textViewResult.setText(String.valueOf(wypisz));
        }
    }

    public void sqrtOnClick(View view) {
        if(textViewResult.getText()!=""){
            double liczba= Double.parseDouble(String.valueOf(textViewResult.getText()));
            textViewResult.setText(String.valueOf(Math.sqrt(liczba)));
        }

    }

    public void x3OnClick(View view) {
        if(textViewResult.getText()!=""){
            double liczba= Double.parseDouble(String.valueOf(textViewResult.getText()));
            textViewResult.setText(String.valueOf(Math.pow(liczba,3)));
        }
    }

    public void x2OnClick(View view) {
        if(textViewResult.getText()!=""){
            double liczba= Double.parseDouble(String.valueOf(textViewResult.getText()));
            textViewResult.setText(String.valueOf(Math.pow(liczba,2)));
        }
    }

}
