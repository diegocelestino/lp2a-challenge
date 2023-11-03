package com.challenge;


public class TestTypeChain {

    public static void main(String[] args) {

        String teste = "9878 duas sjaisj";
        String finaks = teste.substring(teste.indexOf(" ")).replaceFirst(" ", "") +
                " " + teste.substring(0, teste.indexOf(" "));

        System.out.println(finaks);

    }
}
