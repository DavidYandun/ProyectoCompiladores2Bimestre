/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DAVID
 */
public class programacion {

    public Object[][] tabla(Object[] frase) {
        int EI = 0;

        String[][] tab = new String[frase.length][4];
        Object entrada;
        String entr;
        String numero = "[0-9]+";
        String boleano = "[true][false]";
        String decimal = numero + "." + numero;
        String opbasica = "[+|-|*|/]";
//        String caracteres_e="[A-Za-z0-9]";
        Pattern caracteres_e = Pattern.compile("[!|#|$|%]");
        Pattern comparativo = Pattern.compile("[<>=]+");
        Pattern tipo = Pattern.compile("[int|String|var|char|boolean|decimal]");
        Pattern numeros = Pattern.compile("[0-9]+");
        Pattern indicador = Pattern.compile("[a-zA-Z0-9_]*$");
        Matcher mat;

        for (int i = 0; i < frase.length; i++) {
            entrada = frase[i];
            tab[i][0] = EI + "";
            tab[i][1] = entrada + "";
            switch (EI) {
                case 0:
                    if (entrada.equals("import")) {
                        EI = 1;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Palabra reservada ";

                    } else if (entrada.equals("void")) {
                        EI = 8;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Palabra reservada ";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 1:
                    if (entrada.equals("'")) {
                        EI = 2;
                        tab[i][2] = EI + "";
                        tab[i][3] = "c.simple ";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 2:
                    if (entrada.equals("dart")) {
                        EI = 3;
                        tab[i][2] = EI + "";
                        tab[i][3] = "c.simple ";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";
                    }
                    break;
                case 3:
                    if (entrada.equals(":")) {
                        EI = 4;
                        tab[i][2] = EI + "";
                        tab[i][3] = "puntos ";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";
                    }
                    break;
                case 4:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 5;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador ";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 5:
                    if (entrada.equals("'")) {
                        EI = 6;
                        tab[i][2] = EI + "";
                        tab[i][3] = "c.simple ";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 6:
                    if (entrada.equals(";")) {
                        EI = 0;
                        tab[i][3] = "PUNTO Y COMA";
                        tab[i][2] = EI + "";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 8:
                    if (entrada.equals("main")) {
                        EI = 9;
                        tab[i][2] = EI + "";
                        tab[i][3] = "main";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 9:
                    if (entrada.equals("(")) {
                        EI = 10;
                        tab[i][2] = EI + "";
                        tab[i][3] = "parentesis A";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 10:
                    if (entrada.equals(")")) {
                        EI = 11;
                        tab[i][2] = EI + "";
                        tab[i][3] = "parentesis C";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 11:
                    if (entrada.equals("{")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "llaves A";
                    } else {
                        EI = 0;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 12:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    ///////////////////////////////7
                     if (entrada.equals("print")) {
                        EI = 62;
                        tab[i][2] = EI + "";
                        tab[i][3] = "print";
                    } else if (entrada.equals("for")) {
                        EI = 21;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Condicionales";
                    } else if (entrada.equals("while")) {
                        EI = 21;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Condicionales";
                    } else if (entrada.equals("if")) {
                        EI = 21;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Condicionales";
                    }                    else if (entrada.equals("int") || entrada.equals("String") || entrada.equals("var") || entrada.equals("char") || entrada.equals("boolean") || entrada.equals("decimal")) {
                        EI = 48;
                        tab[i][2] = EI + "";
                        tab[i][3] = "tipo";
                    } else if (mat.matches()) {
                        EI = 56;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } /////////////////////////////////
                    else if (entrada.equals("}")) {
                        EI = 35;
                        tab[i][2] = EI + "";
                        tab[i][3] = "llaves C";
                    } else if (entrada.equals("//")) {
                        EI = 13;
                        tab[i][2] = EI + "";
                        tab[i][3] = "slash";
                    } else if (entrada.equals("int") || entrada.equals("String") || entrada.equals("var") || entrada.equals("char") || entrada.equals("boolean") || entrada.equals("decimal")) {
                        EI = 15;
                        tab[i][2] = EI + "";
                        tab[i][3] = "tipo";
                    }  /////////////////////////////////////////
                    /////////////////////////////////////
                    else {
                        EI = 12;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";

                    }
                    break;
                case 13:
                    entr = (String) entrada;
                    mat = caracteres_e.matcher(entr);
                    if (mat.matches()) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "caracteres_e";
                    } else {
                        EI = 12;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";
                    }
                    break;
                case 15:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 17;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        EI = 12;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";
                    }
                    break;
                case 16:
                    if (entrada.equals("for")) {
                        EI = 21;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Condicionales";
                    } else if (entrada.equals("while")) {
                        EI = 21;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Condicionales";
                    } else if (entrada.equals("if")) {
                        EI = 21;
                        tab[i][2] = EI + "";
                        tab[i][3] = "Condicionales";
                    } else {
                        EI = 12;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";
                    }
                    break;
                case 17:
                    if (entrada.equals(";")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "p y c";
                    } else if (entrada.equals(",")) {
                        EI = 15;
                        tab[i][2] = EI + "";
                        tab[i][3] = "coma";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 18:
                    entr = (String) entrada;
                    mat = comparativo.matcher(entr);
                    if (entrada.equals(")")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = "parentesis C";
                    } else if (entrada.equals("==")) {
                        EI = 36;
                        tab[i][2] = EI + "";
                        tab[i][3] = "doble igual ";
                    } else if (mat.matches()) {
                        EI = 25;
                        tab[i][2] = EI + "";
                        tab[i][3] = "compaarativo";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 19:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 56;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        mat = tipo.matcher(entr);
                    }
                    if (mat.matches()) {
                        EI = 48;
                        tab[i][2] = EI + "";
                        tab[i][3] = "tipo";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 20:
                    if (entrada.equals("(")) {
                        EI = 23;
                        tab[i][2] = EI + "";
                        tab[i][3] = "parentesis C";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 21:
                    if (entrada.equals("(")) {
                        EI = 31;
                        tab[i][2] = EI + "";
                        tab[i][3] = "parentesis C";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 22:
                    if (entrada.equals(";")) {
                        EI = 34;
                        tab[i][2] = EI + "";
                        tab[i][3] = "p y c";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 23:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 18;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        mat = numeros.matcher(entr);
                    }
                    if (mat.matches()) {
                        EI = 28;
                        tab[i][2] = EI + "";
                        tab[i][3] = "numeros";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 24:
                    if (entrada.equals(")")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = "parentesis C";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 25:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 26;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        mat = numeros.matcher(entr);
                    }
                    if (mat.matches()) {
                        EI = 28;
                        tab[i][2] = EI + "";
                        tab[i][3] = "numeros";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 26:
                    if (entrada.equals(")")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "cierre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 27:
                    if (entrada.equals(")")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "cierre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 28:
                    if (entrada.equals(comparativo)) {
                        EI = 29;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "comparativo";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 29:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 30;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 30:
                    if (entrada.equals(")")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "cierre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 31:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (entrada.equals("int") || entrada.equals("String") || entrada.equals("var") || entrada.equals("char") || entrada.equals("boolean") || entrada.equals("decimal")) {
                        EI = 45;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "tipo";
                    } else if (mat.matches()) {
                        EI = 41;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";

                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 32:
                    if (entrada.equals("{")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "abre llave";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 33:
                    entr = (String) entrada;
                    mat = comparativo.matcher(entr);
                    if (mat.matches()) {
                        EI = 39;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "comparativo";
                    } else {
                        tab[i][3] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 34:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 50;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 35:
                    if (entrada.equals("void")) {
                        EI = 59;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "void";
                    } else if (entrada.equals(tipo)) {
                        EI = 69;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "tipo";
                    } else if (entrada.equals("else")) {
                        EI = 32;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "else";
                    } else if (entrada.equals("class")) {
                        EI = 57;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "class";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 36:
                    if (entrada.equals(boleano)) {
                        EI = 37;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "boleano";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 37:
                    if (entrada.equals(")")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "cierre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 38:
                    if (entrada.equals("{")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "abre llave";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 39:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 40;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";
                    } else if (entrada.equals(numeros)) {
                        EI = 22;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "numeros";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 40:
                    if (entrada.equals(";")) {
                        EI = 34;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "punto y coma";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 41:
                    if (entrada.equals("=")) {
                        EI = 42;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "igual";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 42:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 43;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";
                    } else if (entrada.equals(numeros)) {
                        EI = 44;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "numeros";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 43:
                    if (entrada.equals(";")) {
                        EI = 46;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "punto y coma";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 44:
                    if (entrada.equals(";")) {
                        EI = 46;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "punto y coma";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 45:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 41;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 46:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 33;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 47:
                    if (entrada.equals("(")) {
                        EI = 23;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "abre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 48:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 49;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                //estado 50 -74
                case 49:
                    if (entrada.equals("=")) {
                        EI = 52;
                        tab[i][2] = EI + "";
                        tab[i][3] = EI + "igual";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 50:
                    if (entrada.equals("--")) {
                        EI = 54;
                        tab[i][2] = EI + "";
                        tab[i][3] = "comp_negativo";
                    } else if (entrada.equals("++")) {
                        EI = 51;
                        tab[i][2] = EI + "";
                        tab[i][3] = "comp_positivo";
                    } else if (entrada.equals("+") || entrada.equals("-")) {
                        EI = 53;
                        tab[i][2] = EI + "";
                        tab[i][3] = "signo +/-";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 51:
                    if (entrada.equals(")")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = "parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 52:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 61;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else if (entrada.equals(numeros)) {
                        EI = 55;
                        tab[i][2] = EI + "";
                        tab[i][3] = "numeros";
                    } else if (entrada.equals(decimal)) {
                        EI = 60;
                        tab[i][2] = EI + "";
                        tab[i][3] = "numeros";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 53:
                    if (entrada.equals(numeros)) {
                        EI = 24;
                        tab[i][2] = EI + "";
                        tab[i][3] = "numeros";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 54:
                    if (entrada.equals("\\)")) {
                        EI = 38;
                        tab[i][2] = EI + "";
                        tab[i][3] = "cierre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 55:
                    if (entrada.equals(";")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "punto y coma";
                    } else if (entrada.equals(opbasica)) {
                        EI = 52;
                        tab[i][2] = EI + "";
                        tab[i][3] = "opbasica";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 56:
                    if (entrada.equals("=")) {
                        EI = 52;
                        tab[i][2] = EI + "";
                        tab[i][3] = "igual";
                    } else {
                        EI = 12;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";
                    }
                    break;
                case 58:
                    if (entrada.equals("\\{")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "abre llave";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 59:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 70;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 60:
                case 61:
                    if (entrada.equals(";")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "PUNTO Y COMA";
                    } else if (entrada.equals(opbasica)) {
                        EI = 52;
                        tab[i][2] = EI + "";
                        tab[i][3] = "opbasica";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 62:
                    if (entrada.equals("(")) {
                        EI = 63;
                        tab[i][2] = EI + "";
                        tab[i][3] = "abre llave";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 63:
                    if (entrada.equals("'")) {
                        EI = 64;
                        tab[i][2] = EI + "";
                        tab[i][3] = "comilla simple";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 64:
                    if (entrada.equals("'")) {
                        EI = 66;
                        tab[i][2] = EI + "";
                        tab[i][3] = "comilla simple";
                    } else if (entrada.equals(caracteres_e)) {
                        EI = 64;
                        tab[i][2] = EI + "";
                        tab[i][3] = "caracteres_e";
                    } else if (entrada.equals("$")) {
                        EI = 65;
                        tab[i][2] = EI + "";
                        tab[i][3] = "dollar";
                    } else {
                        EI = 12;
                        tab[i][3] = "ERROR";
                        tab[i][2] = EI + "";
                    }
                    break;
                case 65:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 64;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 66:
                    if (entrada.equals("\\)")) {
                        EI = 68;
                        tab[i][2] = EI + "";
                        tab[i][3] = "cierre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 68:
                    if (entrada.equals(";")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "punto y coma";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 69:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 70;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 70:
                    if (entrada.equals("\\(")) {
                        EI = 71;
                        tab[i][2] = EI + "";
                        tab[i][3] = "abre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 71:
                    if (entrada.equals(tipo)) {
                        EI = 72;
                        tab[i][2] = EI + "";
                        tab[i][3] = "tipo";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 72:
                    entr = (String) entrada;
                    mat = indicador.matcher(entr);
                    if (mat.matches()) {
                        EI = 73;
                        tab[i][2] = EI + "";
                        tab[i][3] = "indicador";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 73:
                    if (entrada.equals("'")) {
                        EI = 71;
                        tab[i][2] = EI + "";
                        tab[i][3] = "comilla simple";
                    } else if (entrada.equals("\\)")) {
                        EI = 74;
                        tab[i][2] = EI + "";
                        tab[i][3] = "cierre parentesis";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                case 74:
                    if (entrada.equals("\\{")) {
                        EI = 12;
                        tab[i][2] = EI + "";
                        tab[i][3] = "abre llave";
                    } else {
                        tab[i][2] = "ERROR";
                        EI = 12;
                    }
                    break;
                default:
                    break;
            }
        }
        return tab;
    }
    Metodos mt = new Metodos();

}
