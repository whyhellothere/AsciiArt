
public class AsciiTest {
  
  public static void main(String[] args) {
    testStackPushPeek();
  }
  
  
  public static boolean testStackPushPeek() { 
    
    
    Canvas canvas = new Canvas(10, 3);
    canvas.draw(0, 0, 'x');
    canvas.draw(0, 2, 'x');
    canvas.undo();
    System.out.println(canvas.toString());
    
    return true;
  }
  
  public static boolean runStackTestSuite() {
    return true;
  }
}
