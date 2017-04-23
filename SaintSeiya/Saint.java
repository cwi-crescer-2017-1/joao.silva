import java.security.InvalidParameterException;
import java.util.ArrayList;
public abstract class Saint{
    private String nome;
    private Armadura armadura;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO; 
    private boolean armaduraVestida = false;
    private double vida = 100.0;
    protected int qtSentidosDespertados;
    private int proximoGolpe;
    private int proximoMovimento;
    private ArrayList<Movimento> movimentos = new ArrayList<Movimento>();
    //Extendem Saint: BronzeSaint, PrataSaint e OuroSaint
    public Saint(String nome, Armadura armadura) throws Exception{
       this.nome = nome;
       this.armadura = armadura;
       //O valor de qtSentidosDespertados soma com o valor da Categoria da Armadura, BRONZE(0), PRATA(1) e OURO(2)
       //logo Ouro fica com (5+2=7) sentidos e Prata (5+1=6) sentidos  
    }
    /*public boolean equals(Object object){//Verifica se um objeto possui os mesmos valores que outro objeto
       Saint outroSaint = (Saint) object;
       return this.nome.equals(outroSaint.nome) 
       && this.armadura.equals(outroSaint.armadura)
       && this.genero.equals(outroSaint.genero)
       && this.status.equals(outroSaint.status)
       && this.armaduraVestida==outroSaint.armaduraVestida
       && this.vida == outroSaint.vida
       && this.qtSentidosDespertados == outroSaint.qtSentidosDespertados
       && this.proximoGolpe == outroSaint.proximoGolpe
       ;
    }*/
    //NOME
    public String getNome(){
        return this.nome;
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
        if(vidaPerdida<0){ //Condição que nega valores negativos para a perda de vida
            throw new InvalidParameterException("dano negativo: "+vidaPerdida);
            //throw new IllegalArgumentException("dano"); - Mensagem de erro alternativa
        }else if(this.status!=Status.MORTO){//Apenas cogita a hipótese se o status não for Morto
            if(this.vida-vidaPerdida<1){ //Se a vida for ficar <1 quando diminuida o status passa para Morto e a vida para ZERO
            this.vida = 0;
            this.status = Status.MORTO;
            }else{ //Caso passe pelos testes anteriores a vida é diminuida normalmente
            this.vida = vida-vidaPerdida;
            }
        }    
    }
    //SENTIDOS
    public int getQtSentidosDespertados(){
        return this.qtSentidosDespertados;
    }
    //GOLPES
    private Constelacao getConstelacao(){ //Método para diminuir a repetição do this.armadura passando a ser this.getConstelacao(), o método é privado pois só é usado( e só deve ser usado) dentro da classe Saint
        return this.armadura.getConstelacao();
    }
    public ArrayList<Golpe> getGolpes(){
        return this.getConstelacao().getGolpes();
    }
    public void aprenderGolpe(Golpe golpe){
        this.getConstelacao().adicionarGolpe(golpe);
    }
    public Golpe getProximoGolpe(){
        if(this.getGolpes().isEmpty()){
            return null;
        }
        int size = this.getGolpes().size(); //Guarda o tamanho do array de golpes 
        if(this.proximoGolpe==size){ 
           this.proximoGolpe = 0;
        }
        int posicao = proximoGolpe;
        this.proximoGolpe++;
        return this.getGolpes().get(posicao);
    }
    public String getCSV(){
        return String.format(
            "%s,%s,%s,%s,%s,%s,%s",
            this.nome,
            this.vida, //É %s pois o java converte o valor para String
            this.armadura.getConstelacao().getNome(),
            this.armadura.getCategoria(),
            this.status,
            this.genero,
            this.armaduraVestida
        );
    }
    public void adicionarMovimento(Movimento movimento){
        this.movimentos.add(movimento);
    }
    public Movimento getProximoMovimento(){
        if(this.movimentos.isEmpty()){
            return null;
        }
        int size = this.movimentos.size(); //Guarda o tamanho do array de golpes 
        if(this.proximoMovimento==size){ 
           this.proximoMovimento = 0;
        }
        int posicao = proximoMovimento;
        this.proximoMovimento++;
        return this.movimentos.get(posicao);
    }
}
