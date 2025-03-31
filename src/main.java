import java.util.Scanner;

class main {
  public static void main(String[] args) {
    Scanner input1 = new Scanner(System.in);
    String version;
    System.out.println("Enter Minecraft version"); 
    version = input1.nextLine();   
    System.out.println(version);

    if (version=="hell") {
        System.out.println("Minecraft version is: " + version);
    };
    
  }
}