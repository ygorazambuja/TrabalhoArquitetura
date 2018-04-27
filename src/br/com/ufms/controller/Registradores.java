package br.com.ufms.controller;

import java.util.HashMap;
import java.util.Map;

public class Registradores {

    public Map register = new HashMap();

    public void setRegister() {

        register.put("0", "$zero");
        register.put("1", "$at");
        register.put("2", "$v0");
        register.put("3", "$v1");
        register.put("4", "$a0");
        register.put("5", "$a1");
        register.put("6", "$a2");
        register.put("7", "$a3");
        register.put("8", "$t0");
        register.put("9", "$t1");
        register.put("10", "$t2");
        register.put("11", "$t3");
        register.put("12", "$t4");
        register.put("13", "$t5");
        register.put("14", "$t6");
        register.put("15", "$t7");
        register.put("16", "$s0");
        register.put("17", "$s1");
        register.put("18", "$s2");
        register.put("19", "$s3");
        register.put("20", "$s4");
        register.put("21", "$s5");
        register.put("22", "$s6");
        register.put("23", "$s7");
        register.put("24", "$t8");
        register.put("25", "$t9");
        register.put("26", "$k0");
        register.put("27", "$k1");
        register.put("28", "$gp");
        register.put("29", "$sp");
        register.put("30", "$fp");
        register.put("31", "$ra");

    }

    public Object getRegister(String s) {
        setRegister();
        return register.get(s);
    }
}
