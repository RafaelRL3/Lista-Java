import java.util.Scanner;

public class quarta {
    public static void main(String[] args) {
        Zoo rafinha = new Zoo();
        Leao l = new Leao("jose", 2);
        Cobra c = new Cobra("susana", 0);
        Robot b = new Robot("Breno", 1);
        rafinha.insertAnimal(c);
        rafinha.insertAnimal(l);
        rafinha.insertRobot(b);
    }
}

abstract class Animals {
    private String nome;
    private int pos;

    Animals(String nome, int pos) {
        this.nome = nome;
        this.pos = pos;
    }

    public abstract String talk();

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

class Leao extends Animals {
    public Leao(String nome, int pos) {
        super(nome, pos);
    }

    public String talk() {
        return "Raaaaauwwwwww";
    }
}

class Cobra extends Animals {
    public Cobra(String nome, int pos) {
        super(nome, pos);
    }

    @Override
    public String talk() {
        return "Tssssssss, vai lacraia, vai lacraia";
    }
}

class Robot {
    private String id;
    private int pos;
    Scanner sc = new Scanner(System.in);

    public Robot(String id, int pos) {
        if (id.length() > 5) {
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

class Zoo {
    // in the zoo 1 = animal 2 is robot and 0 is empty
    private int[][] zoo = new int[4][3];
    private Robot[] robot = new Robot[12];
    private Animals[] animal = new Animals[12];
    private int anSize = 0;
    private int robotSize = 0;

    public boolean checkZoo(int pos) {
        int line = pos / 3;
        int coll = pos % 3;
        if (zoo[line][coll] == 0) {
            return true;
        } else
            return false;
    }

    public boolean insertAnimal(Animals animal) {
        int line = animal.getPos() / 3;
        int coll = animal.getPos() % 3;
        if (anSize > 12 && !checkZoo(animal.getPos())) {
            System.out.println("Zoologico cheio de animais");
            return false;
        } else {
            this.animal[anSize] = animal;
            this.zoo[line][coll] = 1;
            return true;
        }
    }

    public boolean insertRobot(Robot robot) {
        int line = robot.getPos() / 3;
        int coll = robot.getPos() % 3;
        if (robotSize > 12 && !checkZoo(robot.getPos())) {
            System.out.println("Zoologico sem vagas para robo");
            return false;
        } else {
            this.robot[robotSize] = robot;
            this.zoo[line][coll] = 1;
            return true;
        }
    }

    public Robot seeRobot(String id) {
        for (Robot a : this.robot) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public Animals seeAn(String name) {
        for (Animals a : this.animal) {
            if (a.getNome() == name) {
                return a;
            }
        }
        return null;
    }

    public void swap(Animals a, Robot r) {
        int x = r.getPos() / 3;
        int y = r.getPos() % 3;
        int xa = a.getPos() % 3;
        int ya = a.getPos() / 3;

        zoo[x][y] = 1;
        zoo[xa][ya] = 2;
        for (Robot aux : this.robot) {
            if (aux.getId() == r.getId()) {

                aux.setPos(a.getPos());

            }
        }
        for (Animals c : this.animal) {
            if (c.getNome() == a.getNome()) {
                c.setPos(r.getPos());
            }
        }

    }

    public void verifyNeiber(Animals auxA, Robot auxR) {
        int aL = auxA.getPos() / 3;
        int aC = auxA.getPos() % 3;
        int rL = auxR.getPos() / 3;
        int rC = auxR.getPos() % 3;
        // inicio do zoo
        if (aC == 0) {
            if (aL == 0) {
                if ((rC == aC && rL == aL + 1) || (rC == aC + 1 && rL == aL)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            } else if (aL == 3) {
                if ((rC == aC && rL == aL - 1) || (rC == aC + 1 && rL == aL)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            } else {
                if ((rC == aC && rL == aL + 1) || (rC == aC + 1 && rL == aL) || (rC == aC && rL == aL - 1)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            }
        } else if (aC == 2) {
            if (aL == 0) {
                if ((rC == aC && rL == aL + 1) || (rC == aC + 1 && rL == aL)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            } else if (aL == 3) {
                if ((rC == aC && rL == aL - 1) || (rC == aC && rL == aL + 1) || (rC == aC - 1 && rL == aL)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }

            } else {
                if ((rC == aC && rL == aL - 1) || (rC == aC - 1 && rL == aL) || (rC == aC && rL == aL + 1)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            }
        } else {
            if (aL == 0) {
                if ((rC == aC + 1 && rL == aL) || (rC == aC - 1 && rL == aL) || (rC == aC && rL == aL + 1)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            } else if (aL == 3) {
                if ((rC == aC + 1 && rL == aL) || (rC == aC - 1 && rL == aL) || (rC == aC && rL == aL - 1)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            } else {
                if ((rC == aC && rL == aL - 1) || (rC == aC + 1 && rL == aL) || (rC == aC - 1 && rL == aL)
                        || (rC == aC && rL == aL + 1)) {
                    auxA.talk();
                    swap(auxA, auxR);
                }
            }

        }
    }

    public void checkNeighbor(String id, String nome) {
        Animals auxA = seeAn(nome);
        Robot auxR = seeRobot(id);
        if (auxA == null) {
            System.out.println("Robo nao cadastrado");
            return;
        }
        if (auxR == null) {
            System.out.println("Animal nao cadastrado");
            return;
        }
        verifyNeiber(auxA, auxR);
    }
}