package seabroso.exceptions;

public class ItemInvalidoCarrinhoException extends Exception{
    public ItemInvalidoCarrinhoException(){
        super("a compra não foi efetuada por conta de um produto inacessível");
    }

}
