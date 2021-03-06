package com.doudou.transaction;

import com.doudou.database.PayrollDatabase;
import com.doudou.emp.Employee;
import com.doudou.paymentMethod.HoldMethod;
import com.doudou.paymentMethod.MailMethod;
import com.doudou.paymentMethod.PaymentMethod;
import org.junit.Assert;
import org.junit.Test;

public class ChangeHoldTransactionTest extends BaseTest {

    @Test
    public void changeTest() {
        int empId = 1;
        String name = "Bob";
        String address = "Home";
        double salary = 1000.00;
        double commissionRate = 88.8;
        AddCommissionedEmployee commissionedEmployee = new AddCommissionedEmployee(empId, name, address, salary, commissionRate);
        commissionedEmployee.execute();

        Employee employee = PayrollDatabase.getEmployee(empId);
        Assert.assertNotNull(employee);
        employee.setPaymentMethod(new MailMethod());

        ChangeHoldTransaction cht = new ChangeHoldTransaction(empId);
        cht.execute();

        PaymentMethod pm = employee.getPaymentMethod();
        Assert.assertNotNull(pm);
        Assert.assertTrue(pm instanceof HoldMethod);
    }
}
