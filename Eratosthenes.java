package com.company.core.tryout;

import java.util.BitSet;

public class Eratosthenes {

//    It will set all non prime number
    public BitSet sieveNumber(int n) {
        BitSet primeSet = new BitSet(n);

        for(int p =2; p*p <= n && p*p > 2; p++) {
//            It will skip all number which has been already marked as non prime.
            if(primeSet.get(p) && p != 2) {
                continue;
            }

            for(int i = p*2; i < n && i > 1; i = i + p) {
                primeSet.set(i);
            }
        }

        return primeSet;
    }


    public static void main(String[] arg) {
        Eratosthenes era = new Eratosthenes();
        BitSet primeSet = era.sieveNumber(50);

        System.out.println("Cardinality : " + primeSet.cardinality());
        System.out.println("Prime set : " + primeSet);

//        Print all off set value
        for(int i = 2; i < primeSet.length(); i++) {
            if(!primeSet.get(i)) {
                System.out.println(" " + i);
            }
        }
    }
}
