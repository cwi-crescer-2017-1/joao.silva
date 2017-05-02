public class GolpeSimples implements Movimento{
    Saint golpeador, golpeado;
    public void executar(){
        double dano = this.golpeado.getVida() * 0.25;
        this.golpeado.perderVida(dano);
    }
    public GolpeSimples(Saint golpeador, Saint golpeado){
        this.golpeador=golpeador;
        this.golpeado=golpeado;
    }
}
