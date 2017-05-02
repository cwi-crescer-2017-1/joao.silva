public class GuerraEntreExercitos{
    private ExercitoDeSaints exercitoUm, exercitoDois;
    private int vitoriasExercitoUm=0, vitoriasExercitoDois=0;
    public GuerraEntreExercitos(ExercitoDeSaints exercitoUm, ExercitoDeSaints exercitoDois){
        this.exercitoUm = exercitoUm;
        this.exercitoDois = exercitoDois;
    }

    public void iniciar() throws Exception{
        boolean batalhaAindaNaoTerminou = true;
        do{
            if(this.exercitoUm.getTamanho()>0 && this.exercitoDois.getTamanho()>0 ){   
                Saint lutadorExercitoUm = this.exercitoUm.getProximoSaintDoExercito();
                Saint lutadorExercitoDois = this.exercitoDois.getProximoSaintDoExercito();
                if(lutadorExercitoUm!=null && lutadorExercitoDois != null){
                    lutadorExercitoUm.adicionarMovimento(new Golpear(lutadorExercitoUm,lutadorExercitoDois));
                    lutadorExercitoDois.adicionarMovimento(new Golpear(lutadorExercitoDois,lutadorExercitoUm));
                    Batalha batalha = new Batalha(lutadorExercitoUm,lutadorExercitoDois);
                    batalha.iniciar();
                    if(batalha.getVencedor()==lutadorExercitoUm){
                        vitoriasExercitoUm++;
                    }else if(batalha.getVencedor()==lutadorExercitoDois){
                        vitoriasExercitoDois++;
                    }
                }else{
                    batalhaAindaNaoTerminou = false;
                }

            }else{
                batalhaAindaNaoTerminou = false;
            }
        }while(batalhaAindaNaoTerminou);
    }

    public ExercitoDeSaints exercitoVencedor(){
        if(exercitoUm.getTamanho()==0){
            return this.exercitoDois;
        }else{//exercitoDois.getTamanho()==0
            return this.exercitoUm;
        }
    }

    public int numeroDeVitoriasdoExercitoUm(){
        return this.vitoriasExercitoUm;
    }

    public int numeroDeVitoriasDoExercitoDois(){
        return this.vitoriasExercitoDois;
    }
}
