import java.util.Scanner;

public class AsciiArt {

  public static void main(String[] args) {
    
    // creates important variables
    Scanner scanner = new Scanner(System.in); 
    Canvas canvas = startPrompt(scanner);

    while(true) {
      userPrompt();
      String command = scanner.nextLine();
      String[] commandArray = command.split(" ");
      if(command.toLowerCase()=="undo") { // if the user calls undo
        canvas.undo();
      } else if(command.toLowerCase()=="redo") { // if the user calls redo
        canvas.redo();
      } else if(command.toLowerCase()=="print"){ // if the user calls print
        System.out.println(canvas.toString());
      } else if(commandArray[0].toLowerCase()=="draw") { // if the user calls draw
        try { // surround with a try catch because the user could try to 
          canvas.draw(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]), 
              commandArray[3].charAt(0));
        } catch(Exception e) {
          System.out.println("invalid command");
          break;
        }
      } else {
        System.out.println("invalid command");
      }
    }
  }

  private static Canvas startPrompt(Scanner scanner) {
    System.out.println("Specify the canvas dimension (width height)");
    Canvas canvas = null;
    try {
      String[] dimensions = scanner.next().split(" ");
      canvas = new Canvas(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
    } catch (Exception e) { // catch IndexOutOfBoundsException, etc
      System.out.println("invalid command");
      startPrompt(scanner);
    }
    return canvas;
  }

  private static void userPrompt() {
    System.out.println("Please avoid unnecessary whitespace. Thank you.");
    System.out.println("Add a character (row, column, character)");
    System.out.println("Undo (undo)");
    System.out.println("Redo (redo)");
    System.out.println("Print the array (print)");
  }

}
