package com.example.phonecall;

public class PhoneBookItem {
    int id; //id ресурса
    String name; //имя контакта
    String info; //краткое описание контакта

    PhoneBookItem(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

}
