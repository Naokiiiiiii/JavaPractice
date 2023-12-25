package src.section2.ClassBasics.package2;

public class ClassB {
  public void publicMethod() {
    System.out.println("This is the public method of ClassB.");
    privateMethod();
  }

  private void privateMethod() {
    System.out.println("This is the private method of ClassB.");
  }

  protected void protectedMethod() {
    System.out.println("This is the protected method of ClassB");
  }
}
