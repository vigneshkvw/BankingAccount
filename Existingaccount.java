package smhack.banking;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

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
                        System.out.println("1.CashDepost\t2.CashWithdraw\t3.checkbalance\t4.transactionDetails\t5.Update Customer Info\t6.EXit.");
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
                             case 5:
                                update u=new update();
                                u.updatedata();
                                break;
                            case 6:
                                System.exit(0);
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
