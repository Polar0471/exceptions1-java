import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

class Main {
  public static void main(String[] args) throws ParseException {
    // criando exceções personalizadas
    // SOLUÇÃO RUIM

    Scanner entrada = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("\nRoom number: ");
    int number = entrada.nextInt();
    System.out.print("Check-in date (dd/MM/yyyy): ");
    Date checkIn = sdf.parse(entrada.next());
    System.out.print("Check-out date (dd/MM/yyyy): ");
    Date checkOut = sdf.parse(entrada.next());

    // verifica se uma data ocorre, ou não, após a outra
    if(!checkOut.after(checkIn)) {
      System.out.println("Error in reservation: Check-out date must be after check-in date");
    }
    else {
      Reservation reservation = new Reservation(number, checkIn, checkOut);
      System.out.println("Reservation: " + reservation);

      System.out.println();
      System.out.println("Enter data to update the reservation:");
      System.out.print("Check-in date (dd/MM/yyyy): ");
      checkIn = sdf.parse(entrada.next());
      System.out.print("Check-out date (dd/MM/yyyy): ");
      checkOut = sdf.parse(entrada.next());
      
      String error = reservation.updateDates(checkIn, checkOut);
      if (error != null) {
        System.out.println("Error in reservation: " + error);
        System.out.println();
      }
      else {
        System.out.println("Reservation: " + reservation);
        System.out.println();
      }

    }

    entrada.close();
  
  }
}