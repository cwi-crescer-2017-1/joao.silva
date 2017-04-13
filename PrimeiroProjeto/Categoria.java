public enum Categoria
{
    OURO(3), PRATA(2), BRONZE(1);
    //OURO(3), OURO CHAMA O CONSTRUTOR Categoria com o valor 3
    private int valor;
    
    private Categoria(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
}