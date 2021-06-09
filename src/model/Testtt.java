package model;


import java.util.ArrayList;
import java.util.List;

public class Testtt {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
       ArrayList<History> arr = datasource.getFromHistory("andrei");
       for(History h : arr){
           System.out.println(h.getUsername()+ " " + h.getQuiz()+ " " +
                   h.getPoints());
       }
    }
}
