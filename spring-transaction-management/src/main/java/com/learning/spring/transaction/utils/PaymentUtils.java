package com.learning.spring.transaction.utils;

import com.learning.spring.transaction.exception.InsufficientAmountException;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Map<String,Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1",12000.0);
        paymentMap.put("acc2",10000.0);
        paymentMap.put("acc3",8000.0);
        paymentMap.put("acc4",5000.0);
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount) {
        if(paidAmount > paymentMap.get(accNo)) {
            throw new InsufficientAmountException("Insufficient amount..!");
        }
        else {
            return true;
        }
    }
}
