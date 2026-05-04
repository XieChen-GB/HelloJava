// 简单银行账户信息

import java.util.HashMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// 自定义异常： 存取金额必须大于0
class InvalidAmountException  extends Exception{
    InvalidAmountException (String message){
        super(message);
    }
}

// 自定义异常: 余额不足
class InsufficientFundsException extends Exception{
    InsufficientFundsException(String message){
        super(message);
    }
}
// 抽象类： 银行账户
abstract class BankAccount{
    private String accountId;
    private String owner;
    private double balance;

    // 构造方法
    BankAccount(String accountId, String owner, double balance){
        this.accountId = accountId;
        this.owner = owner;
        this.balance = balance;
    }

    abstract String getAccountType();

    public String getAccountId(){ return accountId; }

    public String getOwner(){ return owner; }

    public double getBalance(){ return balance; }

    protected void setBalance( double balance) { this.balance = balance;}

    // 存款
    public void deposit(double ammout) throws InvalidAmountException {
        if(ammout <= 0){
            throw new InvalidAmountException ("处理异常： 存入金额必须大于0!");
        }
        setBalance(getBalance() + ammout); 
    }

    // 取款
    public void withdraw(double ammount) throws InvalidAmountException, InsufficientFundsException{
        if (ammount <= 0){
            throw new InvalidAmountException("处理异常： 取款金额必须大于0");
        }
        if(ammount > balance){
            throw new InsufficientFundsException("处理异常： 余额不足！"); 
        }
        setBalance(getBalance() - ammount);
        
    }
}
    // 子类： 储蓄账户
class SavingAccount extends BankAccount{
    // 构造方法
    private double interestRate;
    SavingAccount(String accountId, String owner, double balance, double interestRate){
        super(accountId, owner, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate(){ return interestRate; }

    @Override
    public String getAccountType(){ return "储蓄账户";}

    @Override
    public String toString(){
        return "[" + getAccountType() + "] 账号: " + getAccountId() + " 户主： " + getOwner() + " 余额: " 
                   + String.format("%.2f", getBalance()) + " 年利率: " + String.format("%.1f%%", getInterestRate()*100);
    }

    // 计算利息
    public double addInterest(){ 
        double interest = getBalance()*interestRate;
        try {
            deposit(interest);
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
        return interest; }

}

// 子类： 支票账户
class CheckingAccount extends BankAccount{
    private double overdraftLimit; // 透支额度
    // 构造方法
    CheckingAccount(String accountId, String owner, double balance,double overdraftLimit){
        super(accountId, owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit(){ return overdraftLimit;}

    @Override
    public String getAccountType(){ return "支票账户";}

    @Override
    public void withdraw(double ammount) throws InvalidAmountException,InsufficientFundsException{
        if ( ammount <= 0){
            throw new InvalidAmountException("处理异常： 取款金额必须大于0");
        }
        if ((ammount - getBalance()) > overdraftLimit){
            throw new InsufficientFundsException("处理异常： 超出透支额度");
        }

        setBalance(getBalance() - ammount);
    } 

    @Override
    public String toString() {
        return "[" + getAccountType() + "] 账号: " + getAccountId() + " 户主： " + getOwner() + " 余额: " 
                      + String.format("%.2f", getBalance()) + " 透支额度: " 
                      + String.format("%.2f",getOverdraftLimit());
    }

}

public class App {

    public static void main(String[] args) {
        
        HashMap<String,BankAccount> hsmapAccount = new HashMap<>();
        hsmapAccount.put("S001", new SavingAccount("S001", "谢晨", 10000, 0.035));
        hsmapAccount.put("C001", new CheckingAccount("C001", "田中", 5000, 2000));

        // 账户信息
        for (String account : hsmapAccount.keySet()){
            System.out.println(hsmapAccount.get(account).toString());

        }

        // 存款
        System.out.println("--- 存款 ---");
        double ammount = 2000.0;
        try {
            hsmapAccount.get("S001").deposit(ammount);
            System.out.println(hsmapAccount.get("S001").getOwner() + " 存入 " + 
                               String.format("%.2f", ammount) + 
                               "元，当前余额: " + String.format("%.2f", hsmapAccount.get("S001").getBalance()));
        } catch (InvalidAmountException  e) {
            System.out.println(e.getMessage());  
        } 

        ammount = 1000.0;
        try {
            hsmapAccount.get("C001").deposit(ammount);
            System.out.println(hsmapAccount.get("C001").getOwner() + " 存入 " + 
                                String.format("%.2f", ammount)
                                + "元，当前余额: " + String.format("%.2f", hsmapAccount.get("C001").getBalance()));

        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

        // 取款
        System.out.println("--- 取款 ---");
        ammount = 3000;
        try {
            hsmapAccount.get("S001").withdraw(ammount);
            System.out.println(hsmapAccount.get("S001").getOwner() + " 取出 " + 
                String.format("%.2f", ammount) + "元，当前余额: " + 
                String.format("%.2f", hsmapAccount.get("S001").getBalance()));
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }

        System.out.println("--- 余额不足（异常） ---");
        ammount = 10000;
        try {
            hsmapAccount.get("S001").withdraw(ammount);
            System.out.println(hsmapAccount.get("S001").getOwner() + " 取出 " + 
                String.format("%.2f", ammount) + "元，当前余额: " + 
                String.format("%.2f", hsmapAccount.get("S001").getBalance()));
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }

        System.out.println("--- 金额不足（异常） ---");
        ammount = -1000;
        try {
            hsmapAccount.get("C001").withdraw(ammount);
            System.out.println(hsmapAccount.get("C001").getOwner() + " 取出 " + 
                String.format("%.2f", ammount) + "元，当前余额: " + 
                String.format("%.2f", hsmapAccount.get("C001").getBalance()));
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }

        // 计算利息
        System.out.println("--- 计算利息 ---");
        double interest;
        BankAccount account = hsmapAccount.get("S001");
        if (account instanceof SavingAccount){  
            SavingAccount saAccount = (SavingAccount) account; // 强制类型转换
            interest = saAccount.addInterest();
            System.out.println(saAccount.getOwner() + " 利息收入： " + String.format("%.2f", interest)
            + " 元，当前余额: " + String.format("%.2f", saAccount.getBalance()) + " 元");
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt"))){
            
            for(String accountId : hsmapAccount.keySet()){
                writer.write(hsmapAccount.get(accountId).toString());
                writer.newLine();
            }
            System.out.println("--- 写入文件成功 ---");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
     }
}
