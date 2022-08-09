import display.DisplayMessages;

public class Main {

  public static void main(String[] args) {
    System.out.println(DisplayMessages.ENTER_INPUT);
    SinhFunction sinhFunction = new SinhFunction();
    try {
      sinhFunction.initCalculation();
    } catch (Exception e) {
      System.out.println(DisplayMessages.PROGRAM_STOPPED_ERROR_MESSAGE);
      System.out.println(e.getMessage());
    }
  }
  
}
