public class VestirArmadura implements Movimento{
    private Saint saint;
    public void executar(){
        this.saint.vestirArmadura();
        saint.removerMovimento(this);
    }
    public VestirArmadura(Saint saint) throws Exception{
        this.saint = saint;
    }
}
