/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufms.ygorazambuja;

import java.util.Scanner;

/**
 * @author ygorazambuja
 */

public class Class {

    // variavel para armazenar o numero binario pronto para ser trabalhado.
    static String binario = "";
    static String function = "";
    static String opcode = "";
    private static Scanner inp = new Scanner(System.in);

    /**
     * @param i
     * @return
     * @defTipo Metodo para detectar quando o valor informado é hexadecimal,
     * decimal ou octal.
     */
    public static String defTipo(String i) { //
        String bin;
        String s = "";
        Long aux;
        if (i.contains("0x")) {
            // é um hexadecimal.
            for (int j = 2; j < i.length(); j++) {
                s += i.charAt(j);
            }
            bin = Long.toBinaryString(Long.valueOf(s, 16));
        } else if (i.contains("x")) {
            // é um octal.
            for (int j = 1; j < i.length(); j++) {
                s += i.charAt(j);
            }
            bin = Long.toBinaryString(Long.valueOf(s, 8));
        } else {
            // é decimal.
            bin = Long.toBinaryString(Long.valueOf(i, 10));
        }
        return verifica(bin);
    }

    /**
     * @param s
     * @return
     * @verifica Metodo pra Adicionar os 0 que faltar.
     */

    public static String verifica(String s) {
        String binario = "";
        int n = 32 - s.length();
        if (n < 0) {
            throw new IllegalArgumentException("Numero excede 32 bits.");
        } else {
            for (int i = 0; i < n; i++) {
                binario += "0";
            }
            binario += s;
            return binario;
        }
    }


    public static String decodif(String Str, TipoJ j,TipoI i,TipoR r) {

        Str = binario;

        String tipor1 = Str.substring(26,32);  // function
        String tipor2 = Str.substring(21, 26); // shift amount
        String tipor3 = Str.substring(16, 21); // registrador D
        String tipor4 = Str.substring(11, 16); // registrador T
        String tipor5 = Str.substring(6, 11);  // registrador S
        String tipor6 = Str.substring(0, 6);   // opcode


        String tipoi1 = Str.substring(16,32);  // imediato
        String tipoi2 = Str.substring(11, 16); // registrador T
        String tipoi3 = Str.substring(6, 11);  // registrador S
        String tipoi4 = Str.substring(0, 6);   // opcode

        String tipoj1 = Str.substring(6,32);   // Target
        String tipoj2 = Str.substring(0,6);    // opcode

        if(r.isContains(tipor1) && tipor6.equals("000000")) {
             return (String) r.function.get(tipor1);
        }
        if(i.isContains(tipoi4)) {
            return (String) i.opcode.get(tipoi4);
        }
        if(j.isContains(tipoj2)) {
            return(String) j.opcode.get(tipoj2);
        } else {
            throw new IllegalArgumentException("PAU LOCO");
        }

    }

    public static void main(String[] args) {

        TipoR tipor = new TipoR();
        tipor.setFunctionR();
        TipoI tipoi = new TipoI();
        tipoi.setOpcode();
        TipoJ tipoj = new TipoJ();
        tipoj.setOpcode();

        System.out.println("Digite o Valor: ");
        //  valores devem ser inseridos da seguinte maneira,
        //  0x : para hexadecimal
        //   x : para octal
        //  sem nada para decimal
        //  resultado sempre sera em binario.

        String s = "0x014B4820";
        binario = defTipo(s);



        System.out.println(binario + " " + binario.length());
        System.out.println(decodif(binario, tipoj,tipoi,tipor));


        // R opcode (6) rs (5) rt (5) rd (5) shamt (5) funct (6)
        // I opcode (6) rs (5) rt (5)              imediato (16)
        // J opcode (6)                            endereço (26)


    }
}
