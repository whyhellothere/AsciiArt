
public class Canvas {

  private final int width;  // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  public Canvas(int width, int height) {
    if(width<=0) {
      throw new IllegalArgumentException("Width cannot be less than or equal to zero");
    } else if(height<=0) {
      throw new IllegalArgumentException("Height cannot be less than or equal to zero");
    }
    this.width = width;
    this.height = height;

    drawingArray = new char[height][width];
    for(int i=0; i<height; i++) {
      for(int j=0; j<width; j++) {
        drawingArray[i][j] = ' ';
      }
    }
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
  }

  //Draw a character at the given position
  // This method should throw an IllegalArgumentException if the drawing position is outside the canvas
  // If that position is already marked with a different character, overwrite it.
  // After making a new change, add a matching DrawingChange to the undoStack so that we can undo if needed.
  // After making a new change, the redoStack should be empty.
  public void draw(int row, int col, char c) {
    if(row>=height || col>=width) {
      throw new IllegalArgumentException("Char located outside of canvas"); 
    }
    char previous = drawingArray[row][col]; // stores the previous value locally 
    drawingArray[row][col] = c; // assigns the new char to the array
    undoStack.push(new DrawingChange(row, col, previous, c)); // pushes a DrawingChange object
    DrawingStackIterator iter = new DrawingStackIterator(redoStack);
    while(!redoStack.isEmpty()) { // loops through redoStack and removes all objects
      redoStack.pop();
    }
  } 

  //Undo the most recent drawing change. Return true if successful. False otherwise.
  // An undone DrawingChange should be added to the redoStack so that we can redo if needed.
  public boolean undo() {
    if(undoStack.peek()!=null) {
      DrawingChange change = undoStack.pop();
      drawingArray[change.x][change.y] = change.prevChar;
      redoStack.push(change);
      return true;
    }
    return false;
  } 

  //Redo the most recent undone drawing change. Return true if successful. False otherwise.
  // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if needed.
  public boolean redo() { 
    if(redoStack.peek()!=null) {
      DrawingChange change = redoStack.pop();
      drawingArray[change.x][change.y] = change.newChar;
      undoStack.push(change);
      return true;
    }
    return false;
  } 

  //Return a printable string version of the Canvas.
  public String toString() { 
    String canvas = "";
    for(int i=0; i<height; i++) {
      for(int j=0; j<width; j++) {
        if(drawingArray[i][j] == ' ') {
          canvas += "_";
        } else {
          canvas += drawingArray[i][j];
        }
      }
      canvas += System.lineSeparator();
    }
    return canvas;
  } 


}
