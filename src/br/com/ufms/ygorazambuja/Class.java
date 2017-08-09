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
    static String target = "";
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


    public static String decodif(String Str) {

        // a vontade de rir é grande
        // mais a de chorar é maior.

        Str = binario;

        TipoR tipor = new TipoR();
        tipor.setFunctionR();
        TipoI tipoi = new TipoI();
        tipoi.setOpcode();
        TipoJ tipoj = new TipoJ();
        tipoj.setOpcode();

        String tipor1 = Str.substring(26, 32);  // function
        String tipor2 = Str.substring(21, 26); // shift amount
        String tipor3 = Str.substring(16, 21); // registrador D
        String tipor4 = Str.substring(11, 16); // registrador T
        String tipor5 = Str.substring(6, 11);  // registrador S
        String tipor6 = Str.substring(0, 6);   // opcode


        String tipoi1 = Str.substring(16, 32);  // imediato
        String tipoi2 = Str.substring(11, 16); // registrador T
        String tipoi3 = Str.substring(6, 11);  // registrador S
        String tipoi4 = Str.substring(0, 6);   // opcode

        String tipoj1 = Str.substring(6, 32);   // Target
        String tipoj2 = Str.substring(0, 6);    // opcode

        target = Str.substring(6, 32);

        if (tipor.isContains(tipor1) && tipor6.equals("000000")) {
            return (String) tipor.function.get(tipor1);
        }
        if (tipoi.isContains(tipoi4)) {
            return (String) tipoi.opcode.get(tipoi4);
        }
        if (tipoj.isContains(tipoj2)) {
            return (String) tipoj.opcode.get(tipoj2);
        } else {
            throw new IllegalArgumentException("PAU LOCO");
        }


    }


    public static String tMemorias(String s) {
        TipoJ j = new TipoJ();
        TipoR r = new TipoR();
        TipoI i = new TipoI();

        if (s == j.getJ(s)) {
            return "Target: 0x" + j.endereco(target);
        }

        if (s == r.getR(s)) {
            return "tipo R";
        }
        if (s == i.getI(s)) {

        }

        throw new IllegalArgumentException("Buguei, Parabens!");
    }

    public static void main(String[] args) {


        System.out.println("Digite o Valor: ");
        //  valores devem ser inseridos da seguinte maneira,
        //  0x : para hexadecimal
        //   x : para octal
        //  sem nada para decimal
        //  resultado sempre sera em binario.

        // String s = inp.next();


        String s = "0x02574820";


        binario = defTipo(s);


        System.out.println("Tipo da Instrução: " + decodif(binario));

        System.out.println(tMemorias(decodif(binario)));


        // R opcode (6) rs (5) rt (5) rd (5) shamt (5) funct (6)
        // I opcode (6) rs (5) rt (5)              imediato (16)
        // J opcode (6)                            endereço (26)


    }
}
