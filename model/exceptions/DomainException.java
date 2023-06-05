package model.exceptions;

// pode ser uma extensão da classe Exception ou da classe RuntimeException
// RuntimeException é um tipo de exceção que o compilador não te obriga a tratar (se vc não  colocar o try-catch o compilador não te fala nada)
// Exception é um tipo de exceção que o compilador te obriga a tratar (você vai operar com o ParseException)
public class DomainException extends Exception{
    private static final long serialVersionUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }

}
