import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
    //Lembrar: Manter testes mais independentes, não focar tanto em performance e mais em estabilidade do teste
    @After
    public void tearDown(){
        System.gc();
    }

    //Número de testes: 21
    
    //ARMADURA
    public Saint newSaintBronze() throws Exception{ //Criar saintBronze
        BronzeSaint saintBronze;
        return saintBronze = new BronzeSaint("Ikki", "Fênix");
    }

    public Saint newSaintPrata() throws Exception{ //Criar saintPrata
        PrataSaint saintPrata;
        return saintPrata = new PrataSaint("Marin", "Águia");
    }

    public Saint newSaintOuro() throws Exception{ //Criar saintOuro
        OuroSaint saintOuro;
        return saintOuro = new OuroSaint("Aioros", "Sagitário");
    }

    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
        //ARRANGE
        Saint saintBronze = newSaintBronze();
        //ACT
        saintBronze.vestirArmadura();
        //ASSERT
        assertEquals(true,saintBronze.getArmaduraVestida());
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
        //ARRANGE
        Saint saintPrata = newSaintPrata();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(false,saintPrata.getArmaduraVestida());
    }
    //GENERO
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(Genero.NAO_INFORMADO, saintOuro.getGenero());
    }

    @Test 
    public void alterarSaintGenero() throws Exception{
        //ARRANGE
        Saint saintBronze = newSaintBronze();
        //ACT
        saintBronze.setGenero(Genero.MASCULINO);
        //ASSERT
        assertEquals(Genero.MASCULINO, saintBronze.getGenero());
        //ACT
        saintBronze.setGenero(Genero.FEMININO);
        //ASSERT
        assertEquals(Genero.FEMININO, saintBronze.getGenero());
    }
    //STATUS //Dica de nome para o método: statusInicialDeveSerVivo, achei mais explicativo 
    @Test
    public void aoCriarSaintStatusDeVidaEVivo() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(Status.VIVO, saintOuro.getStatus());
    }
    //VIDA
    @Test
    public void aoCriarSaintVidaIgualCem() throws Exception{ //aVidaInicialDeveSer100 -> Dica de outro nome para o teste
        //ARRANGE
        Saint saintBronze = newSaintBronze();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(100.0, saintBronze.getVida(), 0.01);
    }
    //aoPerderVida
    @Test
    public void aoPerder20DeVida() throws Exception{
        //ARRANGE
        Saint saintPrata = newSaintPrata(); //Recem criado tem 100 de vida
        double vidaAnterior;
        //ACT
        vidaAnterior=saintPrata.getVida();
        saintPrata.perderVida(20.0);
        //ASSERT
        assertEquals(vidaAnterior-20.0, saintPrata.getVida(), 0.01);
    }

    @Test
    public void aoPerder200DeVida() throws Exception{ //Atributo vida sem contenção para limitar número minimo de vida a zero, ajustar caso seja criada uma conteção
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        double vidaAnterior;
        //ACT
        vidaAnterior=saintOuro.getVida();
        saintOuro.perderVida(200.0);
        //ASSERT
        assertEquals(0.0, saintOuro.getVida(), 0.01); //Ao perder mais vida do que possui ou perder toda sua vida o valor da vida fica zero
    }

    @Test
    public void aoPerderNumeroQuebradoDeVida() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        double vidaAnterior;
        //ACT
        vidaAnterior=saintOuro.getVida();
        saintOuro.perderVida(3.141592);
        //ASSERT
        assertEquals(vidaAnterior-3.141592,saintOuro.getVida(), 0.01);
    }

    @Test(expected=InvalidParameterException.class)
    public void aoPerderNumeroNegativoDeVida() throws Exception{ //Teste deve ser removido caso se evite números negativos no método PerderVida()
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        //ACT
        saintOuro.perderVida(-100.0);
        //ASSERT - O esperado é o retorno de um erro devido ao fato de ser proibido retirar um número negativo de vida
    }

    @Test
    public void aoPerderTodaVidaEsperadoQueStatusSejaMorto() throws Exception{
        //ARRANGE
        Saint saintPrata = newSaintPrata();
        //ACT
        saintPrata.perderVida(100.0);
        //ASSERT
        assertEquals(Status.MORTO, saintPrata.getStatus());
    }
    //SENTIDOS
    @Test
    public void aoCriarSaintBronzeNasceCom5SentidosDespertados() throws Exception{
        //ARRANGE
        Saint saintBronze = newSaintBronze();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(5, saintBronze.getQtSentidosDespertados());
    }

    @Test
    public void aoCriarSaintPrataNasceCom6SentidosDespertados() throws Exception{
        //ARRANGE
        Saint saintPrata = newSaintPrata();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(6,saintPrata.getQtSentidosDespertados());
    }

    @Test
    public void aoCriarSaintOuroNasceCom7SentidosDespertados() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(7, saintOuro.getQtSentidosDespertados());
    }
    //CONSTELACAO
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception{
        //ARRANGE
        Saint saintOuro = new OuroSaint("YOLO", "Errada");
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT - TESTE DE DECLARAÇÃO DE VARIÁVEL
    }
    //GOLPES
    @Test
    public void aprenderUmGolpe() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        Golpe golpe = new Golpe("Chute",10);

        //ACT
        saintOuro.aprenderGolpe(golpe);

        //ASSERT
        assertEquals(golpe, saintOuro.getGolpes().get(0));
        assertEquals(1,saintOuro.getGolpes().size());
    }

    @Test
    public void aprenderDoisGolpe() throws Exception{
        //ARRANGE
        Saint saintPrata = newSaintPrata();
        Golpe golpe1 = new Golpe("Chute",10);
        Golpe golpe2 = new Golpe("Soco", 10);

        //ACT
        saintPrata.aprenderGolpe(golpe1);
        saintPrata.aprenderGolpe(golpe2);
        //ASSERT
        assertEquals(golpe1, saintPrata.getGolpes().get(0));
        assertEquals(golpe2, saintPrata.getGolpes().get(1));
        assertEquals(2,saintPrata.getGolpes().size()); //tamanho ArrayList = quantidade de valores adicionados
    }

    @Test
    public void aprenderTresGolpes() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        golpes[2] = new Golpe("Excalibur",50);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
            saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT
        for(int indice = 0; indice<golpes.length; indice++){ //Verifica se os golpes foram adicionados corretamente
            assertEquals(golpes[indice], saintOuro.getGolpes().get(indice));  
        }
        assertEquals(3,saintOuro.getGolpes().size());
    }

    @Test
    public void aprenderSeisGolpes() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        Golpe[] golpes = new Golpe[6];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        golpes[2] = new Golpe("Excalibur",50);
        golpes[3] = new Golpe("Chute Magnífico", 20);
        golpes[4] = new Golpe("Soco Magnífico",20);
        golpes[5] = new Golpe("Excalibur Esplêndida",100);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 6 golpes, sendo que ficará gravado na classe os 3 últimos
            saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT - Esperado erro
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 6 golpes, sendo que ficará gravado na classe os 3 últimos
            assertEquals(golpes[indice].getNome(), saintOuro.getGolpes().get(indice).getNome());
        }
        assertEquals(6,saintOuro.getGolpes().size());
    }

    @Test
    public void aoPegarOValorDoProximoGolpeComDoisGolpes() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        Golpe golpe;
        Golpe[] golpes = new Golpe[2];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
            saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT
        for(int indice = 0; indice<golpes.length; indice++){
            golpe = saintOuro.getProximoGolpe();
            assertEquals(golpes[indice], golpe); //Verifica o nome
        }
    }

    @Test
    public void aoPegarOValorDoProximoGolpeSeisVezesComTresGolpes() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        Golpe golpe;
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        golpes[2] = new Golpe("Excalibur",50);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
            saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT
        for(int i = 0; i<2; i++){ //Executa o segundo "for" duas vezes para passar mais de uma vez por todos os valores no getProximoGolpe()
            for(int indice = 0; indice<golpes.length; indice++){
                golpe = saintOuro.getProximoGolpe();
                assertEquals(golpes[indice], golpe); //Verifica o nome
            }
        }
    }

    @Test
    public void aoPegarOValorDoProximoGolpeComListaVazia() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        //ACT
        //ASSERT
        assertNull(saintOuro.getProximoGolpe()); 
    }
    //GET CSV
    @Test
    public void getCSVGeneroFeminino() throws Exception{
        Saint saintBronze = newSaintBronze();
        saintBronze = new BronzeSaint("June", "Camaleão");
        saintBronze.setGenero(Genero.FEMININO);
        saintBronze.perderVida(15.5);
        assertEquals("June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false",saintBronze.getCSV());
    }

    @Test
    public void getCSVComArmaduraVestida() throws Exception{
        Saint saintOuro = newSaintOuro();
        saintOuro = new OuroSaint("Dohko","Libra");
        saintOuro.perderVida(90);
        saintOuro.vestirArmadura();
        assertEquals("Dohko,10.0,Libra,OURO,VIVO,NAO_INFORMADO,true",saintOuro.getCSV());
    }

    //GetProximoMovimento
    @Test
    public void aoPegarOValorDoProximoMovimentoComDoisMovimentosDeDiferentesTipos() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        Saint saintPrata = newSaintPrata();
        Movimento movimento;
        Movimento[] movimentos = new Movimento[2];
        movimentos[0] = new VestirArmadura(saintOuro);
        //movimentos[1] = new Golpear(saintOuro,saintPrata);
        //ACT

        for(int indice = 0; indice<movimentos.length; indice++){ //Adiciona os 3 movimentos
            saintOuro.adicionarMovimento(movimentos[indice]);
        }
        //ASSERT
        for(int indice = 0; indice<movimentos.length; indice++){
            movimento = saintOuro.getProximoMovimento();
            assertEquals(movimentos[indice], movimento); 
            //Verifica os movimentos do array com os movimentos adicionados no Saint utilizando o método getProximoMovimento
        }
    }

    @Test
    public void aoPegarOValorDoProximoMovimentoSeisVezesComTresMovimentos() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        Saint saintPrata = newSaintPrata();
        Movimento movimento;
        Movimento[] movimentos = new Movimento[3];
        movimentos[0] = new VestirArmadura(saintOuro);
        movimentos[1] = new Golpear(saintOuro,saintPrata);
        movimentos[2] = new Golpear(saintOuro,saintPrata);
        //ACT
        for(int indice = 0; indice<movimentos.length; indice++){ //Adiciona os 3 movimentos
            saintOuro.adicionarMovimento(movimentos[indice]);
        }
        //ASSERT
        for(int i = 0; i<2; i++){ //Executa o segundo "for" duas vezes para passar mais de uma vez por todos os valores no getProximoMovimento()
            for(int indice = 0; indice<movimentos.length; indice++){
                movimento = saintOuro.getProximoMovimento();
                assertEquals(movimentos[indice], movimento);
                //System.out.println("Indice: "+indice+" I: "+i);
                //Verifica os movimentos do array com os movimentos adicionados no Saint utilizando o método getProximoMovimento
            }
        }
    }

    @Test
    public void aoPegarOValorDoProximoMovimentoComListaVazia() throws Exception{
        //ARRANGE
        Saint saintOuro = newSaintOuro();
        //ACT
        //ASSERT
        assertNull(saintOuro.getProximoMovimento()); 
    }
    //GetQtdSaints(static)
    @Test
    public void aoPegarQtdSaints() throws Exception{
        //ARRANGE
        int qtdSaintsPreTeste = Saint.getQtdSaints();
        //ACT
        for(int i = 0; i<10; i++){ //10*3 Saints criados
            Saint bronze = new BronzeSaint("Seiya","Pégasus");
            Saint ouro = new OuroSaint("Aiolos","Sagitário");
            Saint prata = new PrataSaint("Marin","Águia");
        }
        //ASSERT
        assertEquals(qtdSaintsPreTeste+30,Saint.getQtdSaints());
    }
    //QtdSaints
    
    @Test
    public void aoCriarDezSaintsQtdSaintsFicaDezAfterGarbageColector() throws Exception{
        for(int i=0; i<10; i++){
            new BronzeSaint("teste " +i,"armadura "+i);
        }
        assertEquals(10,Saint.getQtdSaints());//Por algum motivo desconhecido retorna 11 em vez de 10
    }
    
    //Id
    @Test
    public void aoCriarSaintsIdsDiferentes() throws Exception{
        //ARRANGE
        int qtdSaintsAntes = Saint.getCountSaintsCriados();
        
        //ACT
        Saint bronze = new BronzeSaint("Seiya","Pégasus");
        Saint ouro = new OuroSaint("Aiolos","Sagitário");
        Saint prata = new PrataSaint("Marin","Águia");
        
        //ASSERT
        assertEquals(qtdSaintsAntes+1,bronze.getId());
        assertEquals(qtdSaintsAntes+2,ouro.getId());
        assertEquals(qtdSaintsAntes+3,prata.getId());
    }
}