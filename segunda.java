public class segunda {
    public static void main(String[] args) {
        Account p = new Account();
        p.
    }
}

class Password{
    private String alfa;
    private String number;

    public void setAlfa(String alfa) {
        this.alfa = alfa;
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
    private String id;
    private String agencia;
    private float saldo;
    private Password senha; 

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public void setSenha(Password senha) {
        this.senha = senha;
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