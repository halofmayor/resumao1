package com.lolofpikadas;

public class Account {

    private String ag;
    private String cc;
    private String name;

    private Log logger;
    private double balance;
    private static final int MAX_LENGTH = 12;

    public Account(String ag, String cc, String name){
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    public void setName(String name) {
        if (name.length() > MAX_LENGTH){
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }

    }

    public boolean withDraw(double value) {
        if (balance < value) {
            logger.out("LEVANTAMENTO - € " + value + " Saldo insuficiente");
            return false;
        }
            balance -= value;
            logger.out("LEVANTAMENTO - € " + value + " Sua conta agora é de € " + balance);
            return true;
    }

    public void deposit(double value) {
        balance += value;
        logger.out("DEPOSITO - € " + value + " Sua conta agora é de € " + balance);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "A conta " + this.name + " " + this.ag + " / " + this.cc + " possui: € " + balance;
    }
}
