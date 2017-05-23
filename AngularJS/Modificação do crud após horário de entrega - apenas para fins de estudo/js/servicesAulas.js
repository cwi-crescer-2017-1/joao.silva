modulo.factory('aulaService',function(instrutorService){ //servicesInstrutores deve estar presente para executar a aulaService!
    let idNovaAula=4;
    let aulas = [{id:0,nome:'Tester'},
                   {id:1,nome:'Heroísmo'},
                   {id:2,nome:'Poções'},
                   {id:3,nome:'Defesa contra as artes das trevas'}];  

    //Retorna o index da aula de acordo com o id -
    function pegarIndexAulaPorID(idAula){
        for(let i=0;i<aulas.length;i++){
            if(aulas[i].id === idAula){
                return i;
            }
        }
        return false; //Aula de id correspondente não encontrada
    }
    
    //Verifica se a aula não está sendo utilizada para exclusão
    function aulaNaoUtilizada(idAula){
        let index = pegarIndexAulaPorID(idAula);
        let instrutores = instrutorService.list();
        for(let i=0;i<instrutores.length;i++){ //Percorre todos os intrutores
            for(let x=0;x<instrutores[i].aula.length;x++){//Percorre todas as aulas de cada instrutor
                if(aulas[index].id===instrutores[i].aula[x]){
                    return false;
                }
            }
        }
        return true;
    }    

    //Valida o nome da aula para adicioná-la - Interna
    function validaNomeAula(nome){
        if(typeof nome === 'undefined'){
            return false;
        }
        if(nome.length<3||nome.length>20){
            return false;
        }
        for(aula of aulas){
            if(aula.nome.toLowerCase() === nome.toLowerCase()){
                return false;
            }
        }
        return true;
    }
    //Adiciona uma nova aula
    function adicionarAula(nomeaula){
        if(validaNomeAula(nomeaula)){
            let novaAula={id:idNovaAula,nome:nomeaula};
            idNovaAula++;
            aulas.push(novaAula);
            //alert('Aula criada com sucesso');PENDENTE
            return true; //Sucesso
        }
        return false; //Falha
    };

    //Alterar aula
    function alterarAula(idAula,novoNome){
        let index = pegarIndexAulaPorID(idAula);
        if(index!==false){
            if(validaNomeAula(novoNome)){
                aulas[index].nome = novoNome;
                return true; //Sucesso
            }
        }
        return false; //Falha
    }

    //Deletar aula
    function deletarAula(idAula){
        let index = pegarIndexAulaPorID(idAula);
        if(index!==false){
            if(aulaNaoUtilizada(idAula)){
                aulas.splice(index,1);
                return true; //Sucesso
            }
        }
        return false; //Falha
    }

    //Retorna lista de aulas
    function getTodasAsAulas(){
        return aulas;
    }
    //Retorna aula pelo id
    function getAulaPorId(idAula){
        for(let i=0;i<aulas.length;i++){
            if(aulas[i].id===idAula){
                return aulas[i]; //Devolve o index do id
            }
        }
        return false; //ID não encontrado
    }
    
    return { 
        list:getTodasAsAulas,  //Não recebe parâmetros ()
        findById:getAulaPorId, //Recebe Id (idAula)
        update:alterarAula,   //Recebe Id da aula a ser alterada e o novo nome (idAula,novoNome). Retorna true para sucesso e false para falha
        create:adicionarAula,  //Recebe o nome da nova aula (nomeAula). Retorna true para sucesso e false para falha
        delete:deletarAula     //Recebe o Id da aula a ser deletada (idAula). Retorna true para sucesso e false para falha
    }; 
});