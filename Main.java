import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

class Main {
  public static void main(String[] args) {
    // criando exceções personalizadas
    // SOLUÇÃO BOA
    
    // "throws ParseException" teve de ser removido pois agora essa exceção será tratada, ao invés de propagada

    Scanner entrada = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      System.out.print("\nRoom number: ");
      int number = entrada.nextInt();
      System.out.print("Check-in date (dd/MM/yyyy): ");
      Date checkIn = sdf.parse(entrada.next());
      System.out.print("Check-out date (dd/MM/yyyy): ");
      Date checkOut = sdf.parse(entrada.next());
      
      Reservation reservation = new Reservation(number, checkIn, checkOut);
      System.out.println("Reservation: " + reservation);

      System.out.println();
      System.out.println("Enter data to update the reservation:");
      System.out.print("Check-in date (dd/MM/yyyy): ");
      checkIn = sdf.parse(entrada.next());
      System.out.print("Check-out date (dd/MM/yyyy): ");
      checkOut = sdf.parse(entrada.next());
      
      // agora o método updateDate() passará a lançar uma exceção caso ela ocorra
       reservation.updateDates(checkIn, checkOut);
      System.out.println("Reservation: " + reservation);    
    }
    catch (ParseException e) {
      System.out.println("Invalid date format");
    }
    catch (IllegalArgumentException e) {
      // getMessage() retorna a mensagem que foi usada na hora de instanciar a exceção no método updateDate()
      System.out.println("Error in reservation: " + e.getMessage());
    }

    entrada.close();
  
  }
}