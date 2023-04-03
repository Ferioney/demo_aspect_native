package com.example.demo.logic;

public class DefaultHomeService implements HomeService {

    @Override
    @AspectAnnotation
    public String getWelcome() {
        return "Welcome!";
    }
}
