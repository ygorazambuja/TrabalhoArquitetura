package br.com.ufms.ygorazambuja;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by ygorazambuja on 14/07/17.
 */
public class Main {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bem Vindo.");
        String s = JOptionPane.showInputDialog("Digite ''hex'' para Converter Hexa," +
                " Digite ''dec'' para converter Decimal. \n");

        String hexa, deci;

        if (s.equals("hex")) {
            s = JOptionPane.showInputDialog("Digite o Valor em Hexadecimal.");
            int n = Integer.valueOf(s, 16);
            String sAux = Integer.toBinaryString(n);
            JOptionPane.showMessageDialog(null, "Numero Convertido é: " + sAux);
        } else if (s.equals("dec")) {
            s = JOptionPane.showInputDialog("Digite o Valor em decimal.");
            String sAux = Integer.toBinaryString(Integer.parseInt(s));
            JOptionPane.showMessageDialog(null, "Numero Convertido é " + sAux);
        } else {
            throw new RuntimeException("Opção Invalida");
        }


        /*
            String decimal = Integer.toBinaryString(n);
            String hexadecimal = Integer.toHexString(n);
        */




        //https://opencores.org/project,plasma,opcodes
        //https://www.eg.bucknell.edu/~csci320/mips_web/
      }
}
