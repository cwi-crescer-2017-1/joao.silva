public class BronzeSaint extends Saint{
    public BronzeSaint(String nome, String constelacao) throws Exception{
       super(nome, new Armadura(new Constelacao(constelacao), Categoria.BRONZE));
       this.qtSentidosDespertados = 5; 
    }
} 