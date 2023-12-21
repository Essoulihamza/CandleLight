package ma.youcode.candlelight.services;

public interface service<Dto, Identifier> {
    
    public Dto create(Dto newElement);
    public Dto update(Identifier identifier, Dto elementBody);
    public Dto findById(Identifier identifier);
    public Dto delete(Identifier identifier);

}
