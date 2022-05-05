package segunda_questao;

import java.util.Scanner;
/*
Crie a classe principal Main que deverá instanciar dois objetos da classe Account, 
cada um utilizando um tipo de construtor diferente da classe Password. 
Em seguida, mostre as senhas das duas contas, modifique a senha alfanumérica da primeira conta e a numérica da segunda 
e mostre novamente as duas senhas, bem como o identificador e a agência da primeira conta. 
Por fim, modifique o número de identificador e a agência da segunda conta.
*/
public class segunda {
    public static void main(String[] args) {
        Account p = new Account("Id233","ag123", 0, "1234a","");
        Account c = new Account("Id234","ag123", 1000000, "a12345","9234");
        System.out.println("Senha Alfa: " + p.getSenha().getAlfa() + " Senha Number: " + p.getSenha().getNumber());
        
        System.out.println("Senha Alfa: " + c.getSenha().getAlfa() + " Senha Number: " + c.getSenha().getNumber());
        
        p.setSenhaAlfa("123B");
        c.setSenhaNum("123456");
        System.out.println("Senha Alfa: " + p.getSenha().getAlfa() + " Senha Number: " + p.getSenha().getNumber());
        
        System.out.println("Senha Alfa: " + c.getSenha().getAlfa() + " Senha Number: " + c.getSenha().getNumber());
        
        p.setId("Id333");
        c.setId("Id334");
        p.setAgencia("ag223");
        c.setAgencia("ag224");
        System.out.println("Id: " + p.getId() + " Agencia: " + p.getAgencia());
        System.out.println("Id: " + c.getId() + " Agencia: " + c.getAgencia());
        

        
    }
}

class Password {
    Password(){}

    Password(String alfa, String number){
        this.alfa = isAlfa(alfa);
        this.number = isNumber(number);
    }
    private String alfa;
    private String number;
    Scanner sc = new Scanner(System.in); 

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

    public void setAlfa(String alfa) {
     this.alfa = isAlfa(alfa);
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public String getAlfa() {
        return alfa;
    }

    public String getNumber() {
        return number;
    }
}

class Account{
    //max lenght of id is 10
    private String id;
    private String agencia;
    private float saldo;
    private Password senha; 
    Scanner sc = new Scanner(System.in); 

    Account(String id, String agencia, float saldo, String senhaAlfa, String senhaNum){
        this.id = testId(id);
        this.agencia = agencia;
        this.saldo = saldo;
        this.senha = new Password(senhaAlfa, senhaNum);
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
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

    public void setId(String id) {
        this.id = testId(id);
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public void setSenhaAlfa(String senha) {
        this.senha.setAlfa(senha);
    }

    public void setSenhaNum(String senha) {
        this.senha.setNumber(senha);
    }

    public String getAgencia() {
        return agencia;
    }
    public String getId() {
        return id;
    }
    public float getSaldo() {
        return saldo;
    }
    public Password getSenha() {
        return senha;
    }

}