public class Constelacao{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int indiceProximoGolpe=0;
    public Constelacao(String nome){
        this.nome = nome;
    }
    public void adicionarGolpe(Golpe golpe){
        this.golpes[indiceProximoGolpe] = golpe;
        indiceProximoGolpe++;
    }
    public Golpe[] getGolpes(){
        return this.golpes;
    }
    public String getNome(){
        return this.nome;
    }
    
}
