import java.util.Scanner;

public class quarta {
    public static void main(String[] args) {
      

        
    }
}

class Animals{
    private String nome;
    private int pos;

    public Animals(String nome, int pos){
        this.nome = nome;
        this.pos = pos;
    }

    public String talk(){
        return "Sou um animal";
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }
}

class Leoes extends Animals{
    public Leoes (String nome, int pos){
        super(nome,pos);
    }
    @Override
    
    public String talk(){
        return "rawunn";
    }
}

class Cobra extends Animals{
    public Cobra (String nome, int pos){
        super(nome, pos);
    }
    @Override

    public String talk(){
        return "tsssssssssissss";
    }
}

class Robot{
    private String id;
    private int pos;
    Scanner sc = new Scanner(System.in);
    public Robot(String id, int pos){
        if(id.length() >5){
            System.out.print("Digite um nome de 5 caracteres: ");
            id = sc.nextLine();
            this.id = id;
        }
        this.pos = pos;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }
}

class Zoo{
    private int [][] zoo = new int[4][3];
    private Robot[] robot = new Robot[12];
    private Animals[] an = new Animals[12];
    private int anSize= 0; 
    private int robotSize=0;
    public boolean insertAnimals(Animals animal){
        if(this.an.length >12 || this.zoo[anSize/3][anSize%3] != 0){
            System.out.println("Zoologico cheio de Animal");
            return false;
        }
        else{
            
            this.an[anSize] = animal;
            anSize ++;
            return true;
        }   
    }
    public boolean insertRobot (Robot robot){
        if(this.robot.length >12){
            System.out.println("Zoologico cheio de Robot");
            return false;
        }
        else{
            this.robot[robotSize]= robot;
            robotSize++;
            return true;
        } 
    }
    public int seeRobot(String id) {
        for(Robot a: this.robot){
            if(a.getId() == id){
                return a.getPos();
            }
        }
        return -1;
    }
    public int seeAn(String name) {
        for(Animals a: this.an){
            if(a.getNome() == name){
                return a.getPos();
            }
        }
        return -1;
    }
    public  void checkNeighbor(String id, String name){
        int posR =seeRobot(id); 
        int posAn = seeAn(id);
        if(posR == -1){
            System.out.println("Robo nao cadastrado");
        }
        if(posAn == -1){
            System.out.println("Animal nao cadastrado");
        }

    }
}
