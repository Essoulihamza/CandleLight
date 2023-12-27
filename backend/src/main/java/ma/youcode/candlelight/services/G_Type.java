package ma.youcode.candlelight.services;

public interface G_Type<Req , Res, Identifier> {
    public Res create(Req newElement);
    public Res update(Identifier identifier, Req elementBody);
    public Res findById(Identifier identifier);
    public Res delete(Identifier identifier);
}
