package com.example.giulia.menufragment;

/**
 * Created by Giulia on 22/02/2018.
 */

public class Pizza {

String nome;
String description;

    public Pizza(String nome, String description) {
        this.nome=nome;
        this.description=description;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getDescription(){
        return description;
    }

    public void setDescrizione(String descrizione){
        this.description=descrizione;
    }


}
