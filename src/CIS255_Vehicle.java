import java.util.Scanner;

public class CIS255_Vehicle {
  public static void main(String[] args) {
  
      boolean Exit = false;
      int Choice = 0; 
      CarLot mycarLot = new CarLot();
       
       while (!Exit) { 
       
          System.out.println("1.Create Vehicle"); 
          System.out.println("2.Exit"); 
          
          Scanner input = new Scanner(System.in);
          
          Choice = input.nextInt();
          
          switch (Choice){
          
          case 1:
              System.out.println ("What Make?");
              String tempMake = ""; 
              boolean loopdone=false;
               while (!loopdone) {
                 tempMake="";
                 tempMake = input.nextLine();
                 System.out.println(tempMake);
                 
                 for (ColorEnum make : ColorEnum.values()){
                                         
                     if (make.toString().equalsIgnoreCase(tempMake)) {
                    
                         loopdone=true;
                     }
                  }
                              
               } 
               
               loopdone=false;
               String tempModel = "";
               
       
          System.out.println("1.Create Vehicle"); 
          System.out.println("2.Exit"); 

              System.out.println ("Make");
              
              
              
              break; 
     
          case 2: 
              System.out.println ("Exiting");
              Exit = true;  
              break;
         }
     }
  
    System.out.println("");
   
   
   }
  
}