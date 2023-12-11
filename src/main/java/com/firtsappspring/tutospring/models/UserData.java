package com.firtsappspring.tutospring.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserData {
    public String name;

    @JsonIgnore
    public int age; // No se envia al cliente

    @JsonProperty("real_address") // le ponemos un nombre diferente al que viene por defecto "address"
    public String adrress;

    // @JsonValue // al momento de serializar la clase, ya no quiero un json de respuesta, ahora devuelveme esto:
    // public String info(){
    //     return "Username is " + name + " and age is " + age + " and address is " + adrress;
    // }
    @JsonGetter("information")
    public String info(){
        return "Username is " + name + " and age is " + age + " and address is " + adrress;
        // con esto devolvemos "information": "Username is kevin and age is 25 and address is Calle 123"
        // creamos una clave JSON "information" y el valor es el return de la funcion.
    }
    

    public UserData(String name, int age, String adrress) {
        this.name = name;
        this.age = age;
        this.adrress = adrress;
    }

    
}
