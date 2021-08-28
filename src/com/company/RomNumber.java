package com.company;

public enum RomNumber {
    I (1), V (5), X (10), L(50), C(100);

    private int eqv;

    RomNumber (int i) {this.eqv = i;}

    public int getEqv(){ return eqv;}

}
