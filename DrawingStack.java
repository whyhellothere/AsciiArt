import java.util.Iterator;

public class DrawingStack implements StackADT<DrawingChange> {

  private Node<DrawingChange> head;

  public DrawingStack() {
    head = null;
  }

  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if(head == null) {
      head = new Node(element, null);
    } else {
      Node<DrawingChange> temp = head;
      head = new Node(element, temp);
    }
  }

  @Override
  public DrawingChange pop() {
    if(head!=null) {
      DrawingChange pop = head.getData();
      head = head.getNext();
      return pop;
    }
    return null;
  }

  @Override
  public DrawingChange peek() {
    // TODO Auto-generated method stub
    if(head==null) {
      return null;
    }
    return head.getData();
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    if(head==null) {
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    int size = 0;
    Node<DrawingChange> current = head;
    while(current!=null) {
      size++;
      current = current.getNext();
    }
    return size;
  }

  @Override
  public Iterator<DrawingChange> iterator() {
    // TODO Auto-generated method stub
    return new DrawingStackIterator(this);
  }

}
