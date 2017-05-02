import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuerraEntreExercitosTest{
    @Test
    public void aoRealizarGuerraEntraDoisExercitosDeSeisSaintsCada() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        Saint aiolia = new OuroSaint("Aiolia", "Leão");
        aiolia.aprenderGolpe(new Golpe("Cápsula do Poder", 30));
        aiolia.aprenderGolpe(new Golpe("Chute",15));
        aiolia.aprenderGolpe(new Golpe("Relâmpago de Plasma", 40));
        aiolia.adicionarMovimento(new VestirArmadura(aiolia));

        Saint shaina = new PrataSaint("Shaina", "Ofiúco");
        shaina.aprenderGolpe(new Golpe("Soco", 25));
        shaina.aprenderGolpe(new Golpe("Chute",10));
        shaina.aprenderGolpe(new Golpe("Garras de Trovão", 35));
        shaina.adicionarMovimento(new VestirArmadura(shaina));

        Saint marin = new PrataSaint("Marin", "Águia");
        marin.aprenderGolpe(new Golpe("Meteoros", 25));
        marin.aprenderGolpe(new Golpe("Chute",10));
        marin.aprenderGolpe(new Golpe("Lampejo da Águia", 35));
        marin.adicionarMovimento(new VestirArmadura(marin));

        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        seiya.aprenderGolpe(new Golpe("Meteoro de Pégaso", 20));
        seiya.aprenderGolpe(new Golpe("Chute",5));
        seiya.aprenderGolpe(new Golpe("Cometa de Pégaso", 30));
        seiya.adicionarMovimento(new VestirArmadura(seiya));

        Saint shura = new OuroSaint("Shura", "Capricórnio");
        shura.aprenderGolpe(new Golpe("Pedras Saltitantes", 30));
        shura.aprenderGolpe(new Golpe("Chute",15));
        shura.aprenderGolpe(new Golpe("Excalibur", 40));
        shura.adicionarMovimento(new VestirArmadura(shura));

        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        shiryu.aprenderGolpe(new Golpe("Excalibur", 20));
        shiryu.aprenderGolpe(new Golpe("Chute do Dragão",5));
        shiryu.aprenderGolpe(new Golpe("Cólera dos Cem Dragões", 30));
        shiryu.adicionarMovimento(new VestirArmadura(shiryu));
        
        defensoresDeAthena.alistar(aiolia);
        defensoresDeAthena.alistar(shaina);
        defensoresDeAthena.alistar(marin);
        defensoresDeAthena.alistar(seiya);
        defensoresDeAthena.alistar(shura);
        defensoresDeAthena.alistar(shiryu);

        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        Saint misty = new PrataSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Barreira de Ar", 25));
        misty.aprenderGolpe(new Golpe("Chute",10));
        misty.aprenderGolpe(new Golpe("Furacão das Trevas", 35));
        misty.adicionarMovimento(new VestirArmadura(misty));
        
        Saint mascadaDaMorte = new OuroSaint("Máscara da Morte", "Câncer");
        mascadaDaMorte.aprenderGolpe(new Golpe("Soco", 30));
        mascadaDaMorte.aprenderGolpe(new Golpe("Chute",15));
        mascadaDaMorte.aprenderGolpe(new Golpe("Ondas do Inferno", 40));
        mascadaDaMorte.adicionarMovimento(new VestirArmadura(mascadaDaMorte));
        
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        ikki.aprenderGolpe(new Golpe("Golpe Fantasma da Fênix", 20));
        ikki.aprenderGolpe(new Golpe("Chute",5));
        ikki.aprenderGolpe(new Golpe("Ave Fênix", 30));
        ikki.adicionarMovimento(new VestirArmadura(ikki));
        
        Saint saga = new OuroSaint("Saga", "Gêmeos");
        saga.aprenderGolpe(new Golpe("Outra Dimensão", 30));
        saga.aprenderGolpe(new Golpe("Chute",15));
        saga.aprenderGolpe(new Golpe("Explosão Galáctica", 40));
        saga.adicionarMovimento(new VestirArmadura(saga));
        
        Saint algol = new PrataSaint("Algol", "Perseu");
        algol.aprenderGolpe(new Golpe("Soco", 25));
        algol.aprenderGolpe(new Golpe("Chute",10));
        algol.aprenderGolpe(new Golpe("Górgona Demoníaca", 35));
        algol.adicionarMovimento(new VestirArmadura(algol));
        
        Saint ichi = new BronzeSaint("Ichi", "Hidra");
        ichi.aprenderGolpe(new Golpe("Soco", 20));
        ichi.aprenderGolpe(new Golpe("Chute",5));
        ichi.aprenderGolpe(new Golpe("Presas Venenosas", 30));
        ichi.adicionarMovimento(new VestirArmadura(ichi));
        
        impostores.alistar(misty);
        impostores.alistar(mascadaDaMorte);
        impostores.alistar(ikki);
        impostores.alistar(saga);
        impostores.alistar(algol);
        impostores.alistar(ichi);

        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        guerra.iniciar();

        assertEquals(defensoresDeAthena,guerra.exercitoVencedor());
    }
    @Test
    public void aoRealizarGuerraEntreDoisSaintOuroContraDoisSaintsBronzeEDoisSaintsPrata() throws Exception{
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        
        Saint aiolia = new OuroSaint("Aiolia", "Leão");
        aiolia.aprenderGolpe(new Golpe("Cápsula do Poder", 30));
        aiolia.aprenderGolpe(new Golpe("Chute",15));
        aiolia.aprenderGolpe(new Golpe("Relâmpago de Plasma", 40));
        aiolia.adicionarMovimento(new VestirArmadura(aiolia));
        
        Saint shura = new OuroSaint("Shura", "Capricórnio");
        shura.aprenderGolpe(new Golpe("Pedras Saltitantes", 30));
        shura.aprenderGolpe(new Golpe("Chute",15));
        shura.aprenderGolpe(new Golpe("Excalibur", 40));
        shura.adicionarMovimento(new VestirArmadura(shura));
        
        defensoresDeAthena.alistar(aiolia);
        defensoresDeAthena.alistar(shura);
        
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        
        Saint ichi = new BronzeSaint("Ichi", "Hidra");
        ichi.aprenderGolpe(new Golpe("Soco", 20));
        ichi.aprenderGolpe(new Golpe("Chute",5));
        ichi.aprenderGolpe(new Golpe("Presas Venenosas", 30));
        ichi.adicionarMovimento(new VestirArmadura(ichi));
        
        Saint misty = new PrataSaint("Misty", "Lagarto");
        misty.aprenderGolpe(new Golpe("Barreira de Ar", 25));
        misty.aprenderGolpe(new Golpe("Chute",10));
        misty.aprenderGolpe(new Golpe("Furacão das Trevas", 35));
        misty.adicionarMovimento(new VestirArmadura(misty));
        
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        ikki.aprenderGolpe(new Golpe("Golpe Fantasma da Fênix", 20));
        ikki.aprenderGolpe(new Golpe("Chute",5));
        ikki.aprenderGolpe(new Golpe("Ave Fênix", 30));
        ikki.adicionarMovimento(new VestirArmadura(ikki));
        
        Saint algol = new PrataSaint("Algol", "Perseu");
        algol.aprenderGolpe(new Golpe("Soco", 25));
        algol.aprenderGolpe(new Golpe("Chute",10));
        algol.aprenderGolpe(new Golpe("Górgona Demoníaca", 35));
        algol.adicionarMovimento(new VestirArmadura(algol));

        impostores.alistar(misty);
        impostores.alistar(ikki);
        impostores.alistar(algol);
        impostores.alistar(ichi);
        
        GuerraEntreExercitos guerra = new GuerraEntreExercitos(defensoresDeAthena, impostores);
        guerra.iniciar();

        assertEquals(impostores,guerra.exercitoVencedor());
    }
}
