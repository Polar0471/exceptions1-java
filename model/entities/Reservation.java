package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
  
  private Integer roomNumber;
  private Date checkIn;
  private Date checkOut;

  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  
  public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
    if (!checkOut.after(checkIn)) {
        throw new DomainException("Check-out date must be after check-in date");
    }
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Integer getRoomNumber() {
    return this.roomNumber;
  }

  public void setRoomNumber(Integer roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Date getCheckIn() {
    return this.checkIn;
  }

  public Date getCheckOut() {
    return this.checkOut;
  }

  public long duration() {
    // calculando a diferença de milisegundos entre as datas
    long diff = checkOut.getTime() - checkIn.getTime();
    //convertendo de milisegundos para dias
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

  // agora o método updateDate() passará a lançar uma exceção caso ela ocorra
  // é adicionada a palavra throw junto a uma exceção que deverá ser instanciada
  public void updateDates(Date checkIn, Date checkOut) throws DomainException {
    Date now = new Date();
    if (checkIn.before(now) || checkOut.before(now)) {
        throw new DomainException("Reservation dates for update must be future dates");
    } 
    if (!checkOut.after(checkIn)) {
        throw new DomainException("Check-out date must be after check-in date");
    }

    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  @Override
  public String toString() {
    return "Room "
      + roomNumber
      + ", check-in: "
      + sdf.format(checkIn)
      + ", check-out: "
      + sdf.format(checkOut)
      + ", "
      + duration()
      + " nights";
  }
  
}