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

}
