public class primeira {
    public static void main(String[] args) {
        Text p = new Text("Ola 123");
        System.out.println("Tamanho: " + p.getSize());

        System.out.println("Frequencia: " +p.findFreq("Ola"));

        p.setTexto(p.replaceWords("Ola"));

        System.out.println("String trocada:" + p.getTexto());
        
    }
}


class Text{
    private String texto; 
    
    Text(String texto){
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public int getSize(){
        
         int size = 0;
         for(char ch : this.texto.toCharArray()){
             size++;
         }
         return size;
    }

    public int findFreq(String substr){
        String []aux = this.getTexto().toLowerCase().split(" ");
        int freq = 0;
        for(String a: aux){
            if(a.equals(substr.toLowerCase())){
                freq++;
            }
        }
        return freq;
    }

    public String replaceWords(String str){
        String newString = "bananinha";
        String newTexto = " ";
        String[]aux = this.getTexto().toLowerCase().split(" ");
        for(String a: aux){
            System.out.println("Printando vector antes: " + a);
            if(a.equals(str.toLowerCase())){
                a= newString;
            }
            System.out.println("Printando vector: " + a);
            newTexto = newTexto +  a;
            System.out.println(newTexto);
            newTexto += " ";

        }
        return newTexto;
    }
    
}