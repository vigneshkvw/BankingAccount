/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vikibanking;

import com.mysql.jdbc.Connection;

import java.util.Scanner;
import java.sql.*;
import java.sql.ResultSet;
/**
 *
 * @author viki
 */
class Bank {
  Account account = new Account();
Scanner in = new Scanner(System.in);
    private int acctype;
    private float Cashdeposit;
    private int year;
  
    
    void createAcc() {
     getConnection();
     try {
			getInfo();
			System.out.println("\nAccount Successfully Created!");

			System.out.println("Hello " + account.getName() + " your account no is " + account.getAccNo() + ".\n");
		} catch (Exception e) {
			System.out.println("Fatal Error");
		}
    }

    void existingaccount() {
         System.out.println("Enter your accont number");
      	account.setAccNum(in.nextInt());
       try {
           Connection conn1 = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking?useSSL=false","root", "viki");
            System.out.println("Creating statement...");
  conn1.setAutoCommit(false);
         
          PreparedStatement preparedStatement = conn1.prepareStatement("SELECT * FROM logbook where accountnumber = ? ");
           preparedStatement.setInt(1, account.getAccNum());
           preparedStatement.execute();
            
          System.out.println("accountnumber\t\tname\t\taddress\t\tstate\t\tcity \t\tpincode\t\tcashdeposit\t\tbalance");
 System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
   System.out.println("%s, %s, %s, %s, %s, %s\n" );

       
       } catch (SQLException ex) {

      System.out.println("\n\n\tmenu option");
		try {
			while (true) {
				System.out.println("1.CashDepost\t2.CashWithdraw\t3.checkbalance.");
				int ch = in.nextInt();
				switch (ch) {


case 1:
					deposit();
					break;
                    case 2:
					withdraw();
					break;
                    case 3:
					checkBalance();
					break;
                }
            }
            } catch (Exception e) {
			System.out.println("SELF THROWN EXCEPTION IS--->" + e);
		} finally {
			in.close();
		}
        }
    }
void getConnection(){
    try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}

      try {
         Connection con = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking?useSSL=false","root", "viki");

          System.out.println("Creating statement...");
}
       catch (SQLException ex) {
                  System.out.println("Database error");
            }
}

    public void CreateTable(Account account) {
        try {
           Connection conn1 = (Connection) DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Banking?useSSL=false","root", "viki");
            String insertTableSQL = "INSERT INTO logbook" + "(accountnumber, name,address,state,city,pincode, cashdeposit, balance) VALUES" + "(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn1.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, account.getAccNo());
            preparedStatement.setString(2, account.getName());
            preparedStatement.setString(3, account.getAddrees());
            preparedStatement.setString(4, account.getstate());
            preparedStatement.setString(5, account.getcity());
            preparedStatement.setInt(6, account.getpincode());
            preparedStatement.setFloat(7, account.getCashDeposit());
            preparedStatement.setFloat(8, account.getCashDeposit());
            preparedStatement.executeUpdate();
                Statement stmt = (Statement) conn1.createStatement();
            String sql="select*from logbook";
            System.out.println("accountnumber\t\tname\t\taddress\t\tstate\t\tcity \t\tpincode\t\tcashdeposit\t\tbalance");
             System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ResultSet rs = stmt.executeQuery(sql);
             while (rs.next()) {
                 int accountnumber = rs.getInt("accountnumber\t\t");
                  String name = rs.getString("name\t\t");
                  String address = rs.getString("address\t\t");
                  String state = rs.getString("state\t\t");
                    String city = rs.getString("city\t\t");
                    int pincode = rs.getInt("pincode\t\t");
                    Float cashdeposit=rs.getFloat("cashdeposit\t\t");
                    Float balance=rs.getFloat("balance\t\t");
          System.out.format("%s, %s, %s, %s, %s, %s\n", accountnumber, name,address,state,city,pincode,cashdeposit,balance );

              }
        } catch (SQLException ex) {
           
        }

    }

    private void checkBalance() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void deposit() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    private void getInfo() {
        try {



			System.out.print("Enter your full Name: ");
			 account.setName(in.nextLine() ) ;

			System.out.print("Enter account number: ");
			account.setAccNo(in.nextInt());

			System.out.println("Enter your local address");
			 account.setAddress(in.nextLine());
			System.out.println("Enter your city");
			account.setcity(in.nextLine());
			System.out.println("Enter your state");
			account.setstate(in.nextLine());
			System.out.println("Enter your pin code");
			account.setpinCode(in.nextInt());

			System.out.println("Mention account type:\n1.Savings (7% intr )\t2.Current (5% intr) ");
			acctype = in.nextInt();
			switch (acctype) {
			case 1:
				System.out.println("Enter the initial amount of deposit:");
				Cashdeposit = in.nextFloat();
				if (Cashdeposit < 0) {
					System.out.println("Invalid Amount\nTry again:\n");
					System.out.println("Enter the initial amount of deposit:");
					Cashdeposit = in.nextFloat();
				}
				account.setCashDeposit(Cashdeposit);
				System.out.println("Enter no of years:");
				year = in.nextInt();
				if (year <= 0) {
					System.out.println("Invalid year\n Try again.");
					System.out.println("Enter no of years:");
					year = in.nextInt();
				}

				break;

			case 2:
				System.out.println("Enter the initial amount of deposit:");
				Cashdeposit = in.nextFloat();
				if (Cashdeposit < 0) {
					System.out.println("Invalid Amount\nTry again:\n");
					System.out.println("Enter the initial amount of deposit:");
					Cashdeposit = in.nextFloat();
				}
				break;

			default:
				System.out.println("Invalid Option");
			}
			CreateTable( account );

		} catch (Exception e) {
			System.out.println("Inbuilt Exception --> " + e);
			System.exit(0);
		}
    }

    private void withdraw() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
