package smhack.banking;

import java.sql.Date;

public class Account {

 public	 int accNo;
	 public String name;
	 public float cashDeposit;
	 public float balance;
     public String city;
 public    String address;
     public int mobilenumber;
  public String state;
  public int Accno;
  public Float withdrawCashDeposit;
  public String email;
  public int pincode;
  public int AccNum;
 public  float CashWithdraw;
 public Date date;
 public    float getcashwithdraw;
    public String pinNum;


 public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
     public int getAccNum() {
		return AccNum;
	}

	public void setAccNum(int AccNum) {
		this.AccNum = AccNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCashDeposit() {
		return cashDeposit;
	}

	public void setCashDeposit(float cashDeposit) {
		this.cashDeposit = cashDeposit;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getAddrees() {
		return address;
	}
    	public String getAddress() {
		return address;
	}

     public float getCashWithdraw() {
       return CashWithdraw;
    }
    public void setCashWithdraw(float CashWithdraw) {
		this.CashWithdraw = CashWithdraw;
    }

     public Date getDate() {
         return date;
    }

     public String getPinNum() {
        return pinNum;
    }

public void setPinNum(String pinNum) {
		this.pinNum = pinNum;
	}

     public float getcashwithdraw() {
        return CashWithdraw;
    }

     public int getpincode() {
       return pincode;
    }



     public void setAddress(String address) {
       this.address=address;
    }
	public String getemail() {
		return email;
	}



     public void setemail(String email  ) {
       this.email =email ;
    }

	public String getcity() {
		return city;
	}

     public void setcashDespositAccNo(int Accno) {
        this.Accno=Accno;
    }
    	public int getcashDespositAccNo() {
		return Accno;
	}

     public void setcashWithdrawAccNo(int AccNo) {
        this.Accno=AccNo;
    }
    public int getcashWithdrawAccNo() {
		return Accno;
	}
        public void setcashWithdraw(Float withdrawCashDeposit) {
        this.withdrawCashDeposit=withdrawCashDeposit;
    }
    public Float gettcashWithdraw() {
		return withdrawCashDeposit;
	}
     public void setcity(String city) {
        this.city=city;

    }
public int getmobilenumber() {
		return mobilenumber;
	}

     public void setmobilenumber(int mobilenumber) {
        this.mobilenumber=mobilenumber;
    }
	public String getstate() {
		return state;
	}

     public void setpinCode(int pincode) {
        this.pincode=pincode;
    }
     public void setstate(String state) {
        this.state=state;
    }

}

