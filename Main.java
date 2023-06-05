import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

class Main {
  public static void main(String[] args) throws ParseException {
    // criando exceções personalizadas
    // SOLUÇÃO MUITO RUIM

    // quando vc coloca o "throws ParseException" você está dizendo que o seu método main() pode lançar uma exceção deste tipo, ou seja, o método main() não tem que tratar esse tipo de exceção. Você está propagando a exceção similarmente a "pilha de métodos"

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

      Date now = new Date();
      if (checkIn.before(now) || checkOut.before(now)) {
        System.out.println("Error in reservation: Reservation dates for update must be future dates");
      } 
      else if (!checkOut.after(checkIn)) {
        System.out.println("Error in reservation: Check-out date must be after check-in date");
      }
      else {
        reservation.updateDates(checkIn, checkOut);
        System.out.println("Reservation: " + reservation);
      }

      reservation.updateDates(checkIn, checkOut);
      System.out.println("Reservation: " + reservation);
      System.out.println();
    }

    entrada.close();
  
  }
}