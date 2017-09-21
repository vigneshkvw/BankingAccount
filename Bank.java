/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author viki
 */
import java.sql.*;
import java.sql.Connection;
public class Bank extends BankUtilities  {
     Account account = new Account();
     ResultSet rs = null;
     Statement stmt = null;
     int accountnumber;
     Float cashdeposit;
     String address;
     String city;
     int pincode;
     String state;
    public  Connection Connection;
    public  Connection conn;
     void getConnection()throws SQLException{
         Connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking?useSSL=false","root", "viki");
         conn=Connection;
     }
     void getInfo() {
		try {
			System.out.print("Enter your full Name: ");
			 account.setName(in.nextLine() ) ;
             System.out.print("Enter your  Pin Number: ");
			 account.setPinNum(in.next());
             System.out.print("Enter account number: ");
			account.setAccNo(in.nextInt());
            AccNo=rnd.nextInt(1000)+1;
             System.out.print("Enter your  address: ");
            account.setAddress(in.next());
             System.out.println("Enter your city");
			account.setcity(in.next());
            System.out.println("Enter your state");
			account.setstate(in.next());
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
			createAccountInDB( account );
        } catch (Exception e) {
            System.exit(0);
        }
    }
    public void createAcc() {
        try {
            getInfo();
            System.out.println("\nAccount Successfully Created!");
			System.out.println("Hello " + account.getName() + " your account no is " + account.getAccNo() + ".\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createAccountInDB( Account account ) throws SQLException{
        String sqlQuery;

        try {

          getConnection();
           
            
            String insertTableSQL = "INSERT INTO banking.logbook" + "(accountnumber,pinNum, name,address,state,city,pincode, cashdeposit,cashwithdraw, balance) VALUES" + "(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, account.getAccNo());
            preparedStatement.setString(2, account.getPinNum());
            preparedStatement.setString(3, account.getName());
            preparedStatement.setString(4, account.getAddrees());
            preparedStatement.setString(5, account.getstate());
            preparedStatement.setString(6, account.getcity());
            preparedStatement.setInt(7, account.getpincode());
            preparedStatement.setFloat(8, account.getCashDeposit());
            preparedStatement.setFloat(9, account.getcashwithdraw());
            preparedStatement.setFloat(10, account.getCashDeposit());
            preparedStatement.executeUpdate();
            String inserttransaction = "INSERT INTO transactiondetails" + "(AccNum,cahdeposit, cashwithdraw,balance,Date1) VALUES" + "(?,?,?,?,curdate())";
            PreparedStatement ps = conn.prepareStatement(inserttransaction);
            ps.setInt(1, account.getAccNo());
            ps.setFloat(2, account.getCashDeposit());
            ps.setFloat(3, account.getcashwithdraw());
            ps.setFloat(4, account.getCashDeposit());
            ps.executeUpdate();
            sqlQuery = ("SELECT * FROM banking.logbook where accountnumber = ? ");
            PreparedStatement preparedSelect = (PreparedStatement) conn.prepareStatement(sqlQuery);
            preparedSelect.setInt(1, account.getAccNo());
            System.out.println("accountnumber\t\tpassword\t\tname\t\taddress\t\tstate\t\tcity \t\tpincode\t\tcashdeposit\t\tcashwithdraw\t\tbalance");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ResultSet rs1 = (ResultSet) preparedSelect.executeQuery();
            while (rs1.next()) {
                int accountnumber1 = rs1.getInt("accountnumber");
                String pinnumber1 = rs1.getString("pinNum");
                String name1 = rs1.getString("name");
                String address1 = rs1.getString("address");
                String state1 = rs1.getString("state");
                String city1 = rs1.getString("city");
                int pincode1 = rs1.getInt("pincode");
                int cashdeposit1=rs1.getInt("cashdeposit");
                int cashwithdraw1=rs1.getInt("cashwithdraw");
                int Balance2=rs1.getInt("balance");
                System.out.format("%s, %s, %s, %s, %s,%s,%s,%s,%s, %s\n", accountnumber1,pinnumber1, name1,address1,state1,city1,pincode1,cashdeposit1,cashwithdraw1,Balance2 );
    }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     conn.close();
    }
 }
