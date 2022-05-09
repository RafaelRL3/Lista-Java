import java.util.Stack;

public class quinta {
    public static void main(String[] args) {
        ArithmeticExpr test = new ArithmeticExpr("2*3+4/6");
        test.solve();
    }
}

public interface Exepression{
    void solve();
    void show();
}

class ArithmeticExpr implements Exepression{
    private String eq;
    ArithmeticExpr(String eq){
        this.eq = eq;
    }
    public void solve(){
        // if(this.eq == null || this.eq.isEmpty()){
        //     System.out.println(0);
        // }
        int len = this.eq.length();
        Stack<Float> stack = new Stack<Float>();
        float curr=0.0f;
        char operation = '+';
        for(int i =0; i< len; i++){
            char currentC = this.eq.charAt(i);
            if(Character.isDigit(currentC))
                curr = (curr*10) +(currentC -'0');
        
            if (!Character.isDigit(currentC) && !Character.isWhitespace(currentC) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-curr);
                }
                else if (operation == '+') {
                    stack.push(curr);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * curr);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / curr);
                }
                operation = currentC;
                curr = 0;
            }
        }
    
        float result = 0.0f;
        while (!stack.isEmpty()) {
            result += stack.pop();
        
        System.out.println(result);
        }
    }        
}  


class LogicalExpr implements Exepression{
    private String eq;
    LogicalExpr(String eq){
        this.eq = eq;
    }
    public void solve(){

    }
}

class TernaryExpr implements Exepression{
    private String eq;
    TernaryExpr(String eq){
        this.eq = eq;
    }
    public void solve(){

    }
}