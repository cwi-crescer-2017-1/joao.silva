public class VestirArmadura implements Movimento{
    private Saint saint;
    public void executar(){
        this.saint.vestirArmadura();
    }
    public VestirArmadura(Saint saint) throws Exception{
        this.saint = saint;
    }
}
