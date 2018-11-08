import java.util.Scanner;

public class AsciiArt {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); 

    Canvas canvas = startPrompt(scanner);


    while(true) {
      userPrompt();
      String command = scanner.nextLine();
      String[] commandArray = command.split(" ");
      if(command=="undo") {
        canvas.undo();
      } else if(command=="redo") {
        canvas.redo();
      } else if(commandArray[0]=="draw") {
        try {
          canvas.draw(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]), 
              commandArray[3].charAt(0));
        } catch(Exception e) {
          System.out.println("invalid command");
          break;
        }
      }
    }
    
    //    if(same.length!=5) {
    //      System.out.println("Incorrect command format");
    //    }

  }

  private static Canvas startPrompt(Scanner scanner) {
    System.out.println("Specify the canvas dimension (width height)");
    Canvas canvas = null;
    try {
      String[] dimensions = scanner.next().split(" ");
      canvas = new Canvas(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
    } catch (Exception e) {
      System.out.println("invalid command");
      startPrompt(scanner);
    }
    return canvas;
  }

  private static void userPrompt() {

    System.out.println("Welcome to the thing");
    System.out.println("Please enter a character at a location");

  }

}
