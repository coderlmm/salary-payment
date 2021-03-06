package com.doudou.transaction;

import com.doudou.paymentMethod.HoldMethod;
import com.doudou.paymentMethod.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction{

    public ChangeHoldTransaction(int empId) {
        super(empId);
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }
}
