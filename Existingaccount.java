/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.smhack.Banking.bank;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.smhack.Banking.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author viki
 */
class Existingaccount extends Bank {
    public String sqlQuery;
    public  String sql;
    void existingaccount() {
                System.out.println("\n\n\tmenu option");
                try {
                    while (true) {
                        System.out.println("1.CashDepost\t2.CashWithdraw\t3.checkbalance\t4.transactionDetails.");
                        int ch = in.nextInt();
                        switch (ch) {
                            case 1:
                                Deposit Q=new Deposit();
                                Q.deposit();
                                break;
                            case 2:
                                Withdraw W=new Withdraw();
                                W.withdraw();
                                break;
                            case 3:
                                Checkbalance C=new Checkbalance();
                                C.checkBalance();
                                break;
                         case 4:
                                Lasttransaction L=new Lasttransaction();
                                L.lasttransaction();
                                break;
                        }
                    }
                } catch (Exception e) {
e.printStackTrace();
                } finally {
                    in.close();
                }
            }

     


}
