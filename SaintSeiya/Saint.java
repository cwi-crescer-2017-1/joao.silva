public class Saint{
    private String nome;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO; 
    private boolean armaduraVestida;
    private double vida = 100.0;
    protected int qtSentidosDespertados;
    private int proximoGolpe;
    //Extendem Saint: BronzeSaint, PrataSaint e OuroSaint
    public Saint(String nome, Armadura armadura) throws Exception{
       this.nome = nome;
       this.armadura = armadura;
       //O valor de qtSentidosDespertados soma com o valor da Categoria da Armadura, BRONZE(0), PRATA(1) e OURO(2)
       //logo Ouro fica com (5+2=7) sentidos e Prata (5+1=6) sentidos  
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
    public void perderVida(double vidaPerdida) throws Exception{
        if(vidaPerdida<0){ //Condição que nega valores negativos para a perda de vida
            throw new Exception("InvalidParameterException");
        }else if(this.status!=Status.MORTO){ //Só retira a vida se o Saint não estiver Morto
            this.vida = this.vida - vidaPerdida;
            if(this.vida<1){ //Caso a vida fique <1 configura o status como Morto
                    this.vida = 0;
                    this.status = Status.MORTO;
            }
        }
    }
    //SENTIDOS
    public int getQtSentidosDespertados(){
        return this.qtSentidosDespertados;
    }
    //GOLPES
    public Golpe[] getGolpes(){
        return this.armadura.getConstelacao().getGolpes();
    }
    public void aprenderGolpe(Golpe golpe){
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }
    public Golpe getProximoGolpe(){
        int length = this.armadura.getConstelacao().getGolpes().length; //Guarda o tamanho do array de golpes 
        if(proximoGolpe==length){ 
            this.proximoGolpe = 0;
        }
        this.proximoGolpe++;
        return this.armadura.getConstelacao().getGolpes()[this.proximoGolpe-1];
    }
}
