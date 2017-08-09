package br.com.ufms.ygorazambuja;

import java.util.HashMap;
import java.util.Map;

public class TipoR {

    Map function = new HashMap();


    public void setFunctionR() {

        // Dizem que é achado pelo Function.

        function.put("100000", "add"); //ok
        function.put("100001", "addu");//ok
        function.put("100100", "and");//ok
        function.put("011010", "div");//ok
        function.put("011011", "divu");//ok
        function.put("011000", "mult");//ok
        function.put("011001", "multu");//ok
        function.put("100111", "nor");//ok
        function.put("100101", "or");//ok
        function.put("000000", "sll");//ok
        function.put("000100", "sllv");//ok
        function.put("000011", "sra");//ok
        function.put("000111", "srav");//ok
        function.put("000010", "srl");//ok
        function.put("000110", "srlv");//ok
        function.put("100010", "sub");//ok
        function.put("100011", "subu");//ok
        function.put("100110", "xor");//ok
        function.put("010000", "mfhi");// ok
        function.put("010010", "mflo");//ok
        function.put("010001", "mthi");//ok
        function.put("010011", "mtlo");//ok
        function.put("101010", "slt");//ok
        function.put("101001", "sltu");//ok
        function.put("001001", "jalr");//ok
        function.put("001000", "jr");//ok

    }

    public Object getR(String s) { return function.get(s);  }

    public boolean isContains(String s) {
        return function.containsValue(getR(s));
    }

    public boolean getReg(String s) { return function.containsValue(s); }




}
