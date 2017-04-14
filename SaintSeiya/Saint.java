public class Saint
{
    
    private String nome;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private boolean armaduraVestida;
    
    public Saint(String nome, Armadura armadura){
       this.nome = nome;
       this.armadura = armadura;
    }
    //ARMADURA
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
    public boolean getArmaduraVestida(){
         return this.armaduraVestida;
    }
    //GENERO
    public Genero getGenero(){
        return this.genero;
    }
    public void setGenero(Genero genero){
        this.genero=genero;
    }
    
}
