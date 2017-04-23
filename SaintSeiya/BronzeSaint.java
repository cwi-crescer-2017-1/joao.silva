public class BronzeSaint extends Saint{
    public BronzeSaint(String nome,String constelacao) throws Exception {
        this(nome, new Armadura(new Constelacao(constelacao), Categoria.BRONZE));
    }
    public BronzeSaint(String nome, Armadura armadura) throws Exception{
       super(nome, armadura);
       this.qtSentidosDespertados = 5; 
    }
} 