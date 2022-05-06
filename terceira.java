import java.util.Scanner;

public class terceira {
    public static void main(String[] args) {
        SavingAccount a = new SavingAccount("Id234","ag123", 1000000, new Password("ABC12345","12345"));
        SavingAccount b = new SavingAccount("Id235","ag124", 10000, new Password("ABC12345","12345"));
        
        a.debit(3000);
        System.out.println("O saldo de "+ a.getAgencia() + " eh: " + a.getSaldo());
        a.credit(3000);
        System.out.println("O saldo de "+ a.getAgencia() + " eh: " + a.getSaldo());
        a.renderJuros();
        a.renderJuros(50);
        System.out.println("O saldo de "+ a.getAgencia() + " eh: " + a.getSaldo());
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

    public float debit(float value){
        this.saldo = this.saldo - value;
        return this.saldo;
    }

    public float credit(float value){
        this.saldo += value;
        return this.saldo;
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

class SavingAccount extends Account{
    static float taxa = 0.03f;
    public SavingAccount (String id, String agencia, float saldo, Password senha){
        super(id,agencia,saldo,senha);
    }

    public void renderJuros(float taxa){
        setSaldo(getSaldo()*taxa);
    }

    public void renderJuros(){
        float juros = getSaldo() * taxa;
        setSaldo(juros);
    }

   

}