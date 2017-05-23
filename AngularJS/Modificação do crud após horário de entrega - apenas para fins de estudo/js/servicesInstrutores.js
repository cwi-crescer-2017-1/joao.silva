modulo.factory('instrutorService',function($http){

    let urlBase = 'http://localhost:3000';

    //Gera novo id
    function gerarId(){
        list().then(function(response){
            let instrutores = response.data;
            let maior = -1;
            for(let i=0;i<instrutores.length;i++){
                if(instrutores[i].id>maior){
                    maior=instrutores[i].id;
                }
            }
            return maior+1;//Aumenta 1 no ID do maior ID
        });
    };  

    //Configurações default instrutor
    function configurarInstrutor(instrutor){
        if(typeof instrutor.aulas !== 'undefined'){ //Converte o id das aulas para inteiros
            for(let i=0;i<instrutor.aulas.length;i++){
                instrutor.aulas[i]=Number(instrutor.aulas[i]);
            }
        }
        if(instrutor.dandoAula===false){instrutor.aulas=[]};
        if(typeof instrutor.urlFoto === 'undefined' || instrutor.urlFoto===''){ //Adiciona a foto default se necessário
            instrutor.urlFoto = '../img/perfil_padrao.jpg';
        }
        if(typeof instrutor.aulas === 'undefined' || instrutor.aulas.length<=0){ //Dando aula fica false se não possui aulas
            instrutor.dandoAula = false;
        }
        let idNovoInstrutor = gerarId();
        let instrutorValidado = {id:idNovoInstrutor,nome:instrutor.nome,sobrenome:instrutor.sobrenome,idade:instrutor.idade,email:instrutor.email,dandoAula:instrutor.dandoAula,aula:instrutor.aulas,urlFoto:instrutor.urlFoto};
        return instrutorValidado;
    };

    //Adicionar Instrutor
    function create(instrutorNovo){
        let instrutorValidado = configurarInstrutor(instrutorNovo);
        return $http.post(urlBase + '/instrutor/', instrutorValidado);
    };
        
    //Alterar Instrutor
    function update(instrutorAlterado){
        let idOriginal = instrutorAlterado.id;
        let instrutorValidado = configurarInstrutor(instrutorAlterado); //Configura e valida o instrutor
        instrutorValidado.id = idOriginal; //Devolve o id original
        return $http.put(urlBase + '/instrutor/' + idOriginal, instrutorValidado);
    };

    //Deleta instrutor
    function deleteI(idInstrutor){
        return $http.delete(urlBase + '/instrutor/'+idInstrutor);
    }

    //Retorna todos os instrutores
    function list(){
        return $http.get(urlBase + '/instrutor');
    }
    //Retorna instrutor pelo id
    function findById(idInstrutor){
        return $http.get(urlBase + '/instrutor/'+idInstrutor);
    }

    return { 
        list:list, //Não recebe parâmetros (), retorna array de instrutores
        findById:findById, //Recebe o id do instrutor (idInstrutor) e retorna o instrutor,tipo object, selecionado.
        update:update,    //Recebe o instrutor alterado (instrutorAlterado) e o salva sobre o instrutor antigo
        create:create,  //Recebe o novo instrutor (instrutorNovo) e o adiciona ao bd
        delete:deleteI     //Recebe o id do instrutor (isInstrutor) e deleta o instrutor com este id
    }; 
});