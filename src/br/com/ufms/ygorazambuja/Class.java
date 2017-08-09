/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufms.ygorazambuja;

import com.sun.org.apache.regexp.internal.RE;

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

    static String tipor1 = "";
    static String tipor2 = "";
    static String tipor3 = "";
    static String tipor4 = "";
    static String tipor5 = "";
    static String tipor6 = "";

    static String tipoi1 = "";
    static String tipoi2 = "";
    static String tipoi3 = "";
    static String tipoi4 = "";

    static String tipoj1 = "";
    static String tipoj2 = "";

    static boolean ehr = false;
    static boolean ehi = false;
    static boolean ehj = false;


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

        tipor1 = Str.substring(26, 32);  // function
        tipor2 = Str.substring(21, 26); // shift amount
        tipor3 = Str.substring(16, 21); // registrador D
        tipor4 = Str.substring(11, 16); // registrador T
        tipor5 = Str.substring(6, 11);  // registrador S
        tipor6 = Str.substring(0, 6);   // opcode


        tipoi1 = Str.substring(16, 32);  // imediato
        tipoi2 = Str.substring(11, 16); // registrador T
        tipoi3 = Str.substring(6, 11);  // registrador S
        tipoi4 = Str.substring(0, 6);   // opcode

        tipoj1 = Str.substring(6, 32);   // Target
        tipoj2 = Str.substring(0, 6);    // opcode

        target = Str.substring(6, 32);

        if (tipor.isContains(tipor1) && tipor6.equals("000000")) {
            ehr = true;
            return (String) tipor.function.get(tipor1);
        }
        if (tipoi.isContains(tipoi4)) {
            ehi = true;
            return (String) tipoi.opcode.get(tipoi4);
        }
        if (tipoj.isContains(tipoj2)) {
            ehj = true;
            return (String) tipoj.opcode.get(tipoj2);
        } else {
            throw new IllegalArgumentException("PAU LOCO");
        }


    }


    public static void tMemorias(Registradores reg) {
        TipoJ j = new TipoJ();
        TipoR r = new TipoR();
        TipoI i = new TipoI();

        String reg1, reg2, reg3;


        if (ehr) {
            reg1 = String.valueOf((Integer.parseInt(tipor3, 2)));
            reg2 = String.valueOf((Integer.parseInt(tipor4, 2)));
            reg3 = String.valueOf((Integer.parseInt(tipor5, 2)));

            System.out.println("rd = " + reg.register.get(reg1));
            System.out.println("rt = " + reg.register.get(reg2));
            System.out.println("rs = " + reg.register.get(reg3));

        }

        if (ehj) {

            
        }
        if (ehi) {

        }

    }

    public static void main(String[] args) {
        TipoR tipor = new TipoR();
        TipoI tipoi = new TipoI();
        TipoJ tipoj = new TipoJ();
        Registradores reg = new Registradores();


        tipor.setFunctionR();
        tipoi.setOpcode();
        tipor.setFunctionR();
        reg.setRegister();
        System.out.println("Digite o Valor: ");
        //  valores devem ser inseridos da seguinte maneira,
        //  0x : para hexadecimal
        //   x : para octal
        //  sem nada para decimal
        //  resultado sempre sera em binario.

        // String s = inp.next();


        String s = "0x02695020";


        binario = defTipo(s);


        System.out.println("Tipo da Instrução: " + decodif(binario));

        tMemorias(reg);

        // R opcode (6) rs (5) rt (5) rd (5) shamt (5) funct (6)
        // I opcode (6) rs (5) rt (5)              imediato (16)
        // J opcode (6)                            endereço (26)


    }
}
