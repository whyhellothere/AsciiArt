import java.util.Iterator;

public class DrawingStackIterator implements Iterator<DrawingChange> {

  private DrawingStack stack;

  public DrawingStackIterator(DrawingStack stack) {
    this.stack = stack;

  }

  @Override
  public boolean hasNext() {
    if(stack.peek()!=null) {
      return true;
    }
    return false;
  }

  @Override
  public DrawingChange next() {
    // TODO Auto-generated method stub
    return (DrawingChange) stack.pop();
  }

}
