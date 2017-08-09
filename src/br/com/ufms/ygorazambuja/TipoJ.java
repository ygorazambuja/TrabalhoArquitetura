package br.com.ufms.ygorazambuja;

import java.util.HashMap;
import java.util.Map;

public class TipoJ {

    Map opcode = new HashMap();

    public void setOpcode() {

        opcode.put("000010", "j");
        opcode.put("000011", "jal");

    }


    public Object getJ(String s) {
        return opcode.get(s);
    }

    public boolean isContains(String s) {
        return opcode.containsValue(getJ(s));
    }


    public String endereco(String s) { // endereço retornado precisa ser um HEXADECIMALL !
        boolean cond = false;
        String binRed = "";
        int hex;
        int cont = 0;
        while (!cond) {
            if (s.charAt(cont) == '0') cont++;
            else break;
        }
        binRed = s.substring(cont, s.length());
        String n = Integer.toHexString(Integer.parseInt(binRed,2));

        return n;

    }
}

