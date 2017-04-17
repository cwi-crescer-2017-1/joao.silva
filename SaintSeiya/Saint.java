public class Saint{
    private String nome;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO; 
    private boolean armaduraVestida;
    private double vida = 100.0;
    private int qtSentidosDespertados;
    
    public Saint(String nome, Armadura armadura) throws Exception{
       this.nome = nome;
       this.armadura = armadura;
       //O valor de qtSentidosDespertados soma com o valor da Categoria da Armadura, BRONZE(0), PRATA(1) e OURO(2)
       //logo Ouro fica com (5+2=7) sentidos e Prata (5+1=6) sentidos  
       if(this.armadura.getCategoria() == Categoria.OURO){
           this.qtSentidosDespertados = 7;
           String constelacao = armadura.getConstelacao();
           if(!constelacao.equals("Áries") 
           && !constelacao.equals("Touro") 
           && !constelacao.equals("Sagitário") 
           &&!constelacao.equals("Virgem")){
               //ERRO
               throw new Exception("Constelação inválida");
           }
        }else if(this.armadura.getCategoria() == Categoria.PRATA){
            this.qtSentidosDespertados = 6;
        }else{ //BRONZE
            this.qtSentidosDespertados = 5;
        }
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
