modulo.factory('instrutorService',function(){
    let idNovoInstrutor=4; 
    let instrutores = [{id:0,nome:'Teste',sobrenome:'Tester',idade:22,email:'teste@tester.com.br',dandoAula:true,aula:[0],urlFoto:'img/perfil_padrao.jpg'},
                         {id:1,nome:'Saitama',sobrenome:'',idade:26,email:'opm@heroassociation.jp',dandoAula:false,aula:[],urlFoto:'img/perfil_padrao.jpg'},
                         {id:2,nome:'Toshinori',sobrenome:'Yagi',idade:36,email:'yagi@gmail.jp',dandoAula:true,aula:[1],urlFoto:'img/perfil_padrao.jpg'},
                         {id:3,nome:'Severus',sobrenome:'Snape',idade:38,email:'severus@discipline.uk',dandoAula:true,aula:[2,3],urlFoto:'img/perfil_padrao.jpg'}];
    
    //Pega index do instrutor pelo id
    function pegarIndexInstrutorPorID(idInstrutor){
        for(let i=0;i<instrutores.length;i++){
            if(instrutores[i].id===idInstrutor){
                return i; //Devolve o index do id
            }
        }
        return false; //ID não encontrado
    };
    
    //Verifica se o nome instrutor ainda não existe
    function verificarExistenciaNomeInstrutor(nome){
        for(instrutor of instrutores){
            if(instrutor.nome.toLowerCase() === nome.toLowerCase()){
                return true; //Existe :(
            }
        }
        return false; //Ainda não existe :)
    };

    //Sistema de validação de instrutor
    function validaInstrutor(instrutor){
        let instrutorValido = validaNomeInstrutor(instrutor.nome) &&  validaSobreNomeInstrutor(instrutor.sobrenome) && validaIdadeInstrutor(instrutor.idade) && validaEmailInstrutor(instrutor.email);
        if(instrutorValido){
            return true; //Válido :)
        };
        return false; //Inválido :(
    };
    //Validações necessárias
    function validaNomeInstrutor(nome){
        if(typeof nome === 'undefined'){
            return false;
        }
        if(nome.length<3||nome.length>20){
            return false;
        }
        for(instrutor of instrutores){
            if(instrutor.nome.toLowerCase() === nome.toLowerCase()){
                return false;
            }
        }
        return true;
    };
    function validaSobreNomeInstrutor(sobrenome){
        if(typeof sobrenome === 'undefined'){
            return true; //Sobrenome pode ser indefinido
        }
        if(sobrenome.length>30){
            return false;
        }
        return true;
    };
    function validaIdadeInstrutor(idade){
        if(typeof idade === 'undefined'){
            return false;
        }
        if(idade>90){
            return false;
        }
        return true;
    };
    function validaEmailInstrutor(email){
        if(typeof email === 'undefined' || email===''){
            return false;
        }
        for(instrutor of instrutores){
            if(instrutor.email.toLowerCase() === email.toLowerCase()){
                return false;
            }
        }
        return true;
    };
    //Configurações default instrutor
    function configurarInstrutor(instrutor){
        if(typeof instrutor.aulas !== 'undefined'){ //Converte o id das aulas para inteiros
            for(let i=0;i<instrutor.aulas.length;i++){
                instrutor.aulas[i]=Number(instrutor.aulas[i]);
            }
        }
        if(instrutor.dandoAula===false){instrutor.aulas=[]};
        if(validaInstrutor(instrutor)){
            if(typeof instrutor.urlFoto === 'undefined' || instrutor.urlFoto===''){ //Adiciona a foto default se necessário
                instrutor.urlFoto = 'img/perfil_padrao.jpg';
            }
            if(typeof instrutor.aulas === 'undefined' || instrutor.aulas.length<=0){ //Dando aula fica false se não possui aulas
                instrutor.dandoAula = false;
            }
            let instrutorValidado = {id:0,nome:instrutor.nome,sobrenome:instrutor.sobrenome,idade:instrutor.idade,email:instrutor.email,dandoAula:instrutor.dandoAula,aula:instrutor.aulas,urlFoto:instrutor.urlFoto};
            return instrutorValidado;
        }
        return false;
    };

    //Adicionar Instrutor
    function adicionarInstrutor(instrutorNovo){
        instrutorValidado = configurarInstrutor(instrutorNovo);
        if(instrutorValidado!==false){
            instrutorValidado.id = idNovoInstrutor;
            idNovoInstrutor++;
            instrutores.push(instrutorValidado);
            return true;//Sucesso!
        }
        return false;//Falha!
    };
            
    //Alterar Instrutor
    function alterarInstrutor(instrutorAlterado){
        let idOriginal = instrutorAlterado.id; //Salva o id do instrutor a ser modificado
        instrutorValidado = configurarInstrutor(instrutorAlterado); //Configura e valida o instrutor
        if(instrutorValidado!==false){ //Se validade com sucesso
            instrutorValidado.id = idOriginal; //Devolve o id original
            let index = pegarIndexInstrutorPorID(instrutorValidado.id);//Busca o index original
            instrutores[index] = instrutorValidado; //Sobre escreve o instrutor antigo com o novo já modificado 
            return true; //Sucesso
        }
        return false; //Falha
    };

    //Deleta instrutor
    function deletarInstrutor(idInstrutor){
        let index = pegarIndexInstrutorPorID(idInstrutor);
        if(index === false){ //Verifica se o instrutor existe
            return false; //Falha, instrutor id não existe
        }
        if(instrutores[index].dandoAula){
            return false; //Falha, instrutor dando aula
        }else{
            instrutores.splice(index,1);
            return true; //Sucesso
        }
    }

    //Retorna todos os instrutores
    function getTodosOsInstrutores(){
        return instrutores;
    }
    //Retorna instrutor pelo id
    function getInstrutorPorId(idInstrutor){
        return instrutores.find((instrutore) => instrutore.id == idInstrutor); 
    }

    return { 
        list:getTodosOsInstrutores, //Não recebe parâmetros ()
        findById:getInstrutorPorId, //Recebe o id do instrutor (idInstrutor) e retorna o instrutor,tipo object, selecionado.
        update:alterarInstrutor,    //Recebe o instrutor alterado (instrutorAlterado) e retorna true para sucesso e false para falha
        create:adicionarInstrutor,  //Recebe o novo instrutor (instrutorNovo) e retorna true para sucesso e false para falha
        delete:deletarInstrutor     //Receve o id do instrutor (isInstrutor) e retorna true para sucesso e false para falha
    }; 
});