modulo.factory('aulaService',function(instrutorService,$http){ //servicesInstrutores deve estar presente para executar a aulaService!
    
    let urlBase = 'http://localhost:3000';

    //Gera novo id
    function gerarId(){
        list().then(function(response){
            let aulas = response.data;
            let maior = -1;
            for(let i=0;i<aulas.length;i++){
                if(aulas[i].id>maior){
                    maior=aulas[i].id;
                }
            }
            return maior+1;//Aumenta 1 no ID do maior ID
        });
    };   

    //Adiciona uma nova aula
    function create(nomeaula){
        idNovaAula = gerarId();
        let novaAula={id:idNovaAula,nome:nomeaula};
        idNovaAula++;
        return $http.post(urlBase + '/aula/', novaAula);
    };

    //Alterar aula
    function update(idAula,novoNome){
        let aulaAtualizada = {id:idAula,nome:novoNome}
        return $http.put(urlBase + '/aula/' + idAula, aulaAtualizada);
    };

    //Deletar aula
    function deleteClass(idAula){
        return $http.delete(urlBase + '/aula/'+idAula);
    };

    //Retorna lista de aulas
    function list(){
        return $http.get(urlBase + '/aula');
    }
    //Retorna aula pelo id
    function findById(idAula){
        return $http.get(urlBase + '/aula/'+idAula);
    };
    
    return { 
        list:list,  //Não recebe parâmetros () e retorna todas as aulas
        findById:findById, //Recebe Id (idAula) e torna a aula com este id
        update:update,   //Recebe Id da aula a ser alterada e o novo nome (idAula,novoNome).
        create:create,  //Recebe o nome da nova aula (nomeAula).
        delete:deleteClass     //Recebe o Id da aula a ser deletada (idAula).
    }; 
});