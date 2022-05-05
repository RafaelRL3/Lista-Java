package segunda_questao;

import java.util.Scanner;

public class segunda {
    public static void main(String[] args) {
        Account p = new Account("Id233","ag123", 0, new Password("",""));
       
        Account c = new Account("Id234","ag123", 1000000, new Password("ABC12345","12345"));
        
        System.out.println("Senha Alfa: " + p.getSenha().getAlfa() + " Senha Number: " + p.getSenha().getNum());
        
        System.out.println("Senha Alfa: " + c.getSenha().getAlfa() + " Senha Number: " + c.getSenha().getNum());
        
        p.setSenha(new Password("1234b",""));;
        c.setSenha(new Password("","123456"));
        System.out.println("Senha Alfa: " + p.getSenha().getAlfa() + " Senha Number: " + p.getSenha().getNum());
        
        System.out.println("Senha Alfa: " + c.getSenha().getAlfa() + " Senha Number: " + c.getSenha().getNum());
        
        p.setId("Id333");
        c.setId("Id334");
        p.setAgencia("ag223");
        c.setAgencia("ag224");
        System.out.println("Id: " + p.getId() + " Agencia: " + p.getAgencia());
        System.out.println("Id: " + c.getId() + " Agencia: " + c.getAgencia());
        
    }
}

class Account{
    private String id;
    private String agencia;
    private float saldo;
    private Password senha; 
    Scanner sc = new Scanner(System.in);

    Account(String id, String agencia, float saldo, Password senha){
        this.id = testId(id);
        this.agencia = agencia;
        this.saldo = saldo;
        this.senha = new Password(senha.getAlfa(), senha.getNum());   
    }

    public String testId(String id){
        while(true){
            if(id.length() <= 10){                
                this.id = id;
                return id;
            }
            else{
                System.out.print("A id Ultrapassou o limite de char, redigite: ");
                id = sc.nextLine();
            }
        }
    }

    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public Password getSenha(){
        return this.senha;
    }
    public void setSenha(Password senha) {
        this.senha = senha;
    }
}

class Password{
    private String alfa;
    private String num;
    Scanner sc = new Scanner(System.in); 

    //constructor
    Password(){
        this.alfa = "123abc";
        this.num = "123";
    }


    Password(String alfa , String num){
        this.alfa = isAlfa(alfa);
        this.num = isNumber(num);
    }

    public String isAlfa(String alfa){
        if(alfa == "" || alfa == " ")
            return alfa;
        while(true){
            boolean num = false;
            boolean ch = false;
            for(char a: alfa.toCharArray()){
                if((a >= 'a' || a<='z') && (a>='A' || a<='Z') && !ch)
                        ch = true;
                else if((a >='0' || a <='9') && !num)
                    num = true;

                if(num && ch){
                    return  alfa;
                }
            }
            if((num && !ch) || (!num && ch)){
                System.out.print("Digite uma senha com caracteres e Numberos: ");
                alfa = sc.nextLine();
            }
        }
    }

    public String isNumber(String number){
        if(number == "" || number == " ")
            return number;
        while(true){
            boolean num = false;
            for(char a: number.toCharArray()){
                if((a >='0' || a <='9'))
                    num = true;
                else
                    num = false;
            }
            if(!num){
                System.out.print("Digite uma senha apenas com Numberos: ");
                number = sc.nextLine();
            }
            else
                return number;
        }
    }

    public String getAlfa() {
        return this.alfa;
    }
    public void setAlfa(String alfa) {
        this.alfa = alfa;
    }
    public String getNum() {
        return this.num;
    }
    public void setNum(String num) {
        this.num = num;
    }
}