public class Constelacao{
    private String nome;
    private Golpe[] golpes = new Golpe[3];
    private int contador=0;
    public Constelacao(String nome){
        this.nome = nome;
    }
    public void adicionarGolpe(String nome, int fatorDano){
        this.golpes[contador] = new Golpe(nome,fatorDano);
        contador++;
        if(contador==3){
            contador = 0; //Como o número de golpes é limitado devido ao array estático quando chegar ao limite ele irá transcrever o primeiro golpe
        }
    }
    public Golpe[] getGolpes(){
        return this.golpes;
    }
    public String getNome(){
        return this.nome;
    }
    
}
