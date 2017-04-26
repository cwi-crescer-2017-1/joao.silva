import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
    private BronzeSaint saintBronze;
    private PrataSaint saintPrata;
    private OuroSaint saintOuro;
    private double vidaAnterior;
    private Movimento movimento;
    
    @After
    public void tearDown(){
        System.gc();
    }
    //Número de testes: 21
    //ARMADURA
    public void newSaintBronze() throws Exception{ //Criar saintBronze
        this.saintBronze = new BronzeSaint("Ikki", "Fênix");
    }

    public void newSaintPrata() throws Exception{ //Criar saintPrata
        this.saintPrata = new PrataSaint("Marin", "Águia");
    }

    public void newSaintOuro() throws Exception{ //Criar saintOuro
        this.saintOuro = new OuroSaint("Aioros", "Sagitário");
    }

    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
        //ARRANGE
        newSaintBronze();
        //ACT
        this.saintBronze.vestirArmadura();
        //ASSERT
        assertEquals(true,this.saintBronze.getArmaduraVestida());
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
        //ARRANGE
        newSaintPrata();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(false,this.saintPrata.getArmaduraVestida());
    }
    //GENERO
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception{
        //ARRANGE
        newSaintOuro();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(Genero.NAO_INFORMADO, this.saintOuro.getGenero());
    }

    @Test 
    public void alterarSaintGenero() throws Exception{
        //ARRANGE
        newSaintBronze();
        //ACT
        this.saintBronze.setGenero(Genero.MASCULINO);
        //ASSERT
        assertEquals(Genero.MASCULINO, this.saintBronze.getGenero());
        //ACT
        this.saintBronze.setGenero(Genero.FEMININO);
        //ASSERT
        assertEquals(Genero.FEMININO, this.saintBronze.getGenero());
    }
    //STATUS //Dica de nome para o método: statusInicialDeveSerVivo, achei mais explicativo 
    @Test
    public void aoCriarSaintStatusDeVidaEVivo() throws Exception{
        //ARRANGE
        newSaintOuro();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(Status.VIVO, saintOuro.getStatus());
    }
    //VIDA
    @Test
    public void aoCriarSaintVidaIgualCem() throws Exception{ //aVidaInicialDeveSer100 -> Dica de outro nome para o teste
        //ARRANGE
        newSaintBronze();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(100.0, saintBronze.getVida(), 0.01);
    }
    //aoPerderVida
    @Test
    public void aoPerder20DeVida() throws Exception{
        //ARRANGE
        newSaintPrata(); //Recem criado tem 100 de vida
        //ACT
        vidaAnterior=this.saintPrata.getVida();
        this.saintPrata.perderVida(20.0);
        //ASSERT
        assertEquals(vidaAnterior-20.0, this.saintPrata.getVida(), 0.01);
    }

    @Test
    public void aoPerder200DeVida() throws Exception{ //Atributo vida sem contenção para limitar número minimo de vida a zero, ajustar caso seja criada uma conteção
        //ARRANGE
        newSaintOuro();
        //ACT
        vidaAnterior=this.saintOuro.getVida();
        this.saintOuro.perderVida(200.0);
        //ASSERT
        assertEquals(0.0, this.saintOuro.getVida(), 0.01); //Ao perder mais vida do que possui ou perder toda sua vida o valor da vida fica zero
    }

    @Test
    public void aoPerderNumeroQuebradoDeVida() throws Exception{
        //ARRANGE
        newSaintOuro();
        //ACT
        vidaAnterior=this.saintOuro.getVida();
        this.saintOuro.perderVida(3.141592);
        //ASSERT
        assertEquals(vidaAnterior-3.141592, this.saintOuro.getVida(), 0.01);
    }

    @Test(expected=InvalidParameterException.class)
    public void aoPerderNumeroNegativoDeVida() throws Exception{ //Teste deve ser removido caso se evite números negativos no método PerderVida()
        //ARRANGE
        newSaintOuro();
        //ACT
        this.saintOuro.perderVida(-100.0);
        //ASSERT - O esperado é o retorno de um erro devido ao fato de ser proibido retirar um número negativo de vida
    }

    @Test
    public void aoPerderTodaVidaEsperadoQueStatusSejaMorto() throws Exception{
        //ARRANGE
        newSaintPrata();
        //ACT
        this.saintPrata.perderVida(100.0);
        //ASSERT
        assertEquals(Status.MORTO, this.saintPrata.getStatus());
    }
    //SENTIDOS
    @Test
    public void aoCriarSaintBronzeNasceCom5SentidosDespertados() throws Exception{
        //ARRANGE
        newSaintBronze();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(5, this.saintBronze.getQtSentidosDespertados());
    }

    @Test
    public void aoCriarSaintPrataNasceCom6SentidosDespertados() throws Exception{
        //ARRANGE
        newSaintPrata();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(6, this.saintPrata.getQtSentidosDespertados());
    }

    @Test
    public void aoCriarSaintOuroNasceCom7SentidosDespertados() throws Exception{
        //ARRANGE
        newSaintOuro();
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT
        assertEquals(7, this.saintOuro.getQtSentidosDespertados());
    }
    //CONSTELACAO
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception{
        //ARRANGE
        this.saintOuro = new OuroSaint("YOLO", "Errada");
        //ACT - TESTE DE PRÉ DEFINIÇÃO
        //ASSERT - TESTE DE DECLARAÇÃO DE VARIÁVEL
    }
    //GOLPES
    @Test
    public void aprenderUmGolpe() throws Exception{
        //ARRANGE
        newSaintOuro();
        Golpe golpe = new Golpe("Chute",10);

        //ACT
        this.saintOuro.aprenderGolpe(golpe);

        //ASSERT
        assertEquals(golpe, this.saintOuro.getGolpes().get(0));
        assertEquals(1,this.saintOuro.getGolpes().size());
    }

    @Test
    public void aprenderDoisGolpe() throws Exception{
        //ARRANGE
        newSaintPrata();
        Golpe golpe1 = new Golpe("Chute",10);
        Golpe golpe2 = new Golpe("Soco", 10);

        //ACT
        this.saintPrata.aprenderGolpe(golpe1);
        this.saintPrata.aprenderGolpe(golpe2);
        //ASSERT
        assertEquals(golpe1, this.saintPrata.getGolpes().get(0));
        assertEquals(golpe2, this.saintPrata.getGolpes().get(1));
        assertEquals(2,this.saintPrata.getGolpes().size()); //tamanho ArrayList = quantidade de valores adicionados
    }

    @Test
    public void aprenderTresGolpes() throws Exception{
        //ARRANGE
        newSaintOuro();
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        golpes[2] = new Golpe("Excalibur",50);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
            this.saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT
        for(int indice = 0; indice<golpes.length; indice++){ //Verifica se os golpes foram adicionados corretamente
            assertEquals(golpes[indice], this.saintOuro.getGolpes().get(indice));  
        }
        assertEquals(3,this.saintOuro.getGolpes().size());
    }

    @Test
    public void aprenderSeisGolpes() throws Exception{
        //ARRANGE
        newSaintOuro();
        Golpe[] golpes = new Golpe[6];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        golpes[2] = new Golpe("Excalibur",50);
        golpes[3] = new Golpe("Chute Magnífico", 20);
        golpes[4] = new Golpe("Soco Magnífico",20);
        golpes[5] = new Golpe("Excalibur Esplêndida",100);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 6 golpes, sendo que ficará gravado na classe os 3 últimos
            this.saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT - Esperado erro
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 6 golpes, sendo que ficará gravado na classe os 3 últimos
            assertEquals(golpes[indice].getNome(), this.saintOuro.getGolpes().get(indice).getNome());
        }
        assertEquals(6,this.saintOuro.getGolpes().size());
    }

    @Test
    public void aoPegarOValorDoProximoGolpeComDoisGolpes() throws Exception{
        //ARRANGE
        newSaintOuro();
        Golpe golpe;
        Golpe[] golpes = new Golpe[2];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
            this.saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT
        for(int indice = 0; indice<golpes.length; indice++){
            golpe = this.saintOuro.getProximoGolpe();
            assertEquals(golpes[indice], golpe); //Verifica o nome
        }
    }

    @Test
    public void aoPegarOValorDoProximoGolpeSeisVezesComTresGolpes() throws Exception{
        //ARRANGE
        newSaintOuro();
        Golpe golpe;
        Golpe[] golpes = new Golpe[3];
        golpes[0] = new Golpe("Chute",10);
        golpes[1] = new Golpe("Soco",10);
        golpes[2] = new Golpe("Excalibur",50);
        //ACT
        for(int indice = 0; indice<golpes.length; indice++){ //Adiciona os 3 golpes
            this.saintOuro.aprenderGolpe(golpes[indice]);
        }
        //ASSERT
        for(int i = 0; i<2; i++){ //Executa o segundo "for" duas vezes para passar mais de uma vez por todos os valores no getProximoGolpe()
            for(int indice = 0; indice<golpes.length; indice++){
                golpe = this.saintOuro.getProximoGolpe();
                assertEquals(golpes[indice], golpe); //Verifica o nome
            }
        }
    }

    @Test
    public void aoPegarOValorDoProximoGolpeComListaVazia() throws Exception{
        //ARRANGE
        newSaintOuro();
        //ACT
        //ASSERT
        assertNull(this.saintOuro.getProximoGolpe()); 
    }
    //GET CSV
    @Test
    public void getCSVGeneroFeminino() throws Exception{
        newSaintBronze();
        this.saintBronze = new BronzeSaint("June", "Camaleão");
        this.saintBronze.setGenero(Genero.FEMININO);
        this.saintBronze.perderVida(15.5);
        assertEquals("June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false",this.saintBronze.getCSV());
    }

    @Test
    public void getCSVComArmaduraVestida() throws Exception{
        newSaintOuro();
        this.saintOuro = new OuroSaint("Dohko","Libra");
        this.saintOuro.perderVida(90);
        this.saintOuro.vestirArmadura();
        assertEquals("Dohko,10.0,Libra,OURO,VIVO,NAO_INFORMADO,true",this.saintOuro.getCSV());
    }

    //GetProximoMovimento
    @Test
    public void aoPegarOValorDoProximoMovimentoComDoisMovimentosDeDiferentesTipos() throws Exception{
        //ARRANGE
        newSaintOuro();
        newSaintPrata();
        Movimento[] movimentos = new Movimento[2];
        movimentos[0] = new VestirArmadura(saintOuro);
        //movimentos[1] = new Golpear(saintOuro,saintPrata);
        //ACT

        for(int indice = 0; indice<movimentos.length; indice++){ //Adiciona os 3 movimentos
            this.saintOuro.adicionarMovimento(movimentos[indice]);
        }
        //ASSERT
        for(int indice = 0; indice<movimentos.length; indice++){
            this.movimento = this.saintOuro.getProximoMovimento();
            assertEquals(movimentos[indice], this.movimento); 
            //Verifica os movimentos do array com os movimentos adicionados no Saint utilizando o método getProximoMovimento
        }
    }

    @Test
    public void aoPegarOValorDoProximoMovimentoSeisVezesComTresMovimentos() throws Exception{
        //ARRANGE
        newSaintOuro();
        newSaintPrata();
        Movimento[] movimentos = new Movimento[3];
        movimentos[0] = new VestirArmadura(saintOuro);
        movimentos[1] = new Golpear(saintOuro,saintPrata);
        movimentos[2] = new Golpear(saintOuro,saintPrata);
        //ACT
        for(int indice = 0; indice<movimentos.length; indice++){ //Adiciona os 3 movimentos
            this.saintOuro.adicionarMovimento(movimentos[indice]);
        }
        //ASSERT
        for(int i = 0; i<2; i++){ //Executa o segundo "for" duas vezes para passar mais de uma vez por todos os valores no getProximoMovimento()
            for(int indice = 0; indice<movimentos.length; indice++){
                this.movimento = this.saintOuro.getProximoMovimento();
                assertEquals(movimentos[indice], this.movimento);
                //System.out.println("Indice: "+indice+" I: "+i);
                //Verifica os movimentos do array com os movimentos adicionados no Saint utilizando o método getProximoMovimento
            }
        }
    }

    @Test
    public void aoPegarOValorDoProximoMovimentoComListaVazia() throws Exception{
        //ARRANGE
        newSaintOuro();
        //ACT
        //ASSERT
        assertNull(this.saintOuro.getProximoMovimento()); 
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
            Saint saint = new BronzeSaint("teste " +i,"armadura "+i);
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