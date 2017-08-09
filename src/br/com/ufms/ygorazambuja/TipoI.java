package br.com.ufms.ygorazambuja;

import java.util.HashMap;
import java.util.Map;

public class TipoI {

    Map opcode = new HashMap();

    public void setOpcode() {

        opcode.put("100000", "lb");  //ok
        opcode.put("100100", "lbu"); //ok
        opcode.put("100001", "lh");  //ok
        opcode.put("100101", "lhu"); //ok
        opcode.put("100011", "lw");  //ok

        opcode.put("101000", "sb"); //ok
        opcode.put("101011", "sw"); //ok
        opcode.put("101001", "sh"); //ok

        opcode.put("000100", "beq"); //ok
        opcode.put("000111", "bgtz");//ok
        opcode.put("000110", "blez");//ok
        opcode.put("000101", "bne"); //ok

        opcode.put("001101", "ori");//ok

        opcode.put("001010", "slti");//ok
        opcode.put("001001", "sltiu");//ok


        opcode.put("001000", "addi");//ok
        opcode.put("001001", "addiu");//ok

        opcode.put("001100", "andi"); //ok

        opcode.put("001110", "xori");//ok


    }

    public Object getI(String s) {
        return opcode.get(s);
    }

    public boolean isContains(String s) {
        return opcode.containsValue(getI(s));
    }



}
