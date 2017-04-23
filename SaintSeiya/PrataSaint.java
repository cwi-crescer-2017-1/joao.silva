public class PrataSaint extends Saint{
    public PrataSaint(String nome,String constelacao) throws Exception {
        this(nome, new Armadura(new Constelacao(constelacao), Categoria.PRATA));
    }
    public PrataSaint(String nome, Armadura armadura) throws Exception{
        super(nome, armadura);
        this.qtSentidosDespertados = 6;
    }
}
