public class Saint{
    private String nome;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO; 
    private boolean armaduraVestida;
    private double vida = 100.0;
    private int qtSentidosDespertados= 5;//Default = 5
    
    public Saint(String nome, Armadura armadura){
       this.nome = nome;
       this.armadura = armadura;
       if(this.armadura.getCategoria()==Categoria.PRATA){
           this.qtSentidosDespertados = 6;
       }else if(this.armadura.getCategoria()==Categoria.OURO){
           this.qtSentidosDespertados = 7;
       } //Se não for nenhuma dessas condições o valor será definido como default igual a 5
    }
    //ARMADURA
    public Armadura getArmadura(){
        return this.armadura;
    }
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
    //STATUS
    public Status getStatus(){
        return this.status;
    }
    //VIDA
    public double getVida(){
        return this.vida;
    }
    public void perderVida(double vidaPerdida){
        this.vida = this.vida - vidaPerdida;
    }
    //SENTIDOS
    public int getQtSentidosDespertados(){
        return this.qtSentidosDespertados;
    }
    
}
