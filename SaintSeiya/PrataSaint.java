public class PrataSaint extends Saint{
    public PrataSaint(String nome, String constelacao) throws Exception{
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.PRATA));
        this.qtSentidosDespertados = 6;
    }
}
