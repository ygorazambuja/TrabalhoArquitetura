package br.com.ufms.ygorazambuja;

import java.util.Scanner;

/**
 * Created by ygorazambuja on 15/07/17.
 */
public class TesteMain {


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        String bin = inp.next();


    }

    public void decodif(String bin) {
        if (bin.length() == 32) {
    
        } else {
            throw new RuntimeException("Instrução precisar ter 32 bits");
        }

    }


}
