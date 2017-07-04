modulo.controller('controllerHome',['$scope','toastr','$location','authService','servicePostagem','servicePerfil','serviceRelacionamento','serviceComentario','serviceCurtida', function(model,toastr,$location,authService,servicePostagem,servicePerfil,serviceRelacionamento,serviceComentario,serviceCurtida){
    model.perfilCorrente = authService.getUsuario().perfil;
    model.nomeCorrente = model.perfilCorrente.nome;
    model.verComentarios = false;
    model.verComentarioClick = 0;
    model.mostrarPesquisa = false;
    let mensagemComentarioMostrar = "Mostrar comentários   .";
    let mensagemComentarioEsconder = "Esconder comentários";
    model.botaoComentario = mensagemComentarioMostrar;
    model.pesquisaUsuario = "";
    model.postagemNova = {};
    model.postagemNova.texto = "";
    model.paginaFinal = false;
    model.telaAtual = "ListaPosts";
    model.relacionamentos = [];
    model.amigos = [];
    model.solicitacoesPendentes = [];
    model.solicitacoesRecebidas = [];


    let pagina = 0;
    let tamanhoPagina = 5;

    let nomeConfig = function(){
        let nome = model.perfilCorrente.nome;
        if(nome.length>13){
             let excesso = nome.length-13;
             model.nomeCorrente = nome.substr(0,(nome.length-excesso));
             model.nomeCorrente = model.nomeCorrente.concat("...");
        }
    }
    nomeConfig();
    model.pesquisar = function(){
        if(typeof model.pesquisaUsuario !== "undefined" && typeof model.pesquisaUsuario !== "null" && model.pesquisaUsuario.replace(/\s{2,}/g, ' ') !== ""){
        servicePerfil.getFilterByNameWithFriendship(model.perfilCorrente.id,model.pesquisaUsuario).then(
                    function (response) {
                        model.perfisPesquisados = response.data;
                        if(model.perfisPesquisados.length===0){
                            toastr.info('Nenhum perfil encontrado!');
                        }else{
                            model.mostrarPesquisa = true;
                        }
                    },
                    function (response) {
                        toastr.error('Erro ao pesquisar por usuários!');
                    });
        }else{
            toastr.warning('Necessário inserir nome para pesquisa!');
        }
    }
    model.retirarPesquisa = function(){
        model.mostrarPesquisa = false;
        model.pesquisaUsuario = "";
    }
    model.registrarPostagem = function (){
        if(typeof model.postagemNova.texto === "undefined" || typeof model.postagemNova.texto === "null" || model.postagemNova.texto.length===0){
            toastr.error('Texto da postagem obrigatório!');
        }else{
            servicePostagem.registrar(model.postagemNova.fotoUrl,model.postagemNova.texto,model.perfilCorrente).then(
                function (response) {
                    $location.path('/home');
                    toastr.success('Postagem realizada!');
                    location.reload();
                },
                function (response) {
                toastr.error('Erro inesperado durante a postagem!');
            });
        }
    }
    model.isEmpty = function (variavel){
        if(typeof variavel === "undefined" || variavel === null){
            return true;
        }else if(typeof variavel === 'string'){
            return variavel.replace(" ","") === "";
        }
        return false;
    }
    model.ativarDesativaComentarios = function(){
        if(model.verComentarioClick === 0){
            model.verComentarios = true;
            model.verComentarioClick = 1;
            model.botaoComentario = mensagemComentarioEsconder;
        }else{
            model.verComentarios = false;
            model.verComentarioClick = 0;
            model.botaoComentario = mensagemComentarioMostrar;
        }
 
    }
    model.getPostagens = function(){
        servicePostagem.getPage(pagina,tamanhoPagina)
        .then(
            function (response) {
                model.postagens = response.data.content;
                console.log(model.postagens);
            },
            function (response) {
                toastr.error('Erro ao carregar as postagens');
            }
        );
    }
    model.carregarMaisPostagens =  function(){
        pagina = pagina + 1;
        servicePostagem.getPage(pagina,tamanhoPagina)
        .then(
            function (response) {
                if(response.data.content.length<tamanhoPagina){
                    model.paginaFinal = true;
                }
                let novasPostagens = response.data.content;
                for(postagem of novasPostagens){
                    model.postagens.push(postagem);
                }
            },
            function (response) {
                toastr.error('Erro ao carregar mais postagens');
            }
        );
    }
    model.calculoData = function(data){
        let date1 = (new Date(data));
        let date2 = new Date();
        let timeDiff = Math.abs(date2.getTime() - date1.getTime());
        let diffDays = Math.ceil(timeDiff / (1000 * 3600)); 
        if(diffDays<=1){
            return 'Há menos de uma horas atrás.';
        }
        return 'Há '+diffDays+' horas atrás.';
    }
    model.converterHoras = function(data){
        let data1 = new Date(data);
        return dataAtualFormatada(data1);
    }
    function dataAtualFormatada(data){
        let dia = data.getDate();
        if (dia.toString().length == 1)
        dia = "0"+dia;
        let mes = data.getMonth()+1;
        if (mes.toString().length == 1)
        mes = "0"+mes;
        let ano = data.getFullYear();  
        return dia+"/"+mes+"/"+ano;
    }
    model.solicitarAmigo = function(perfil){
        serviceRelacionamento.registrar(model.perfilCorrente,perfil)
            .then(
                function (response) {
                    toastr.success('Solicitado com sucesso!');
                    model.pesquisar(model.pesquisaUsuario);
                },
                function (response) {
                    toastr.error('Erro ao solicitar amizade!');
                    model.pesquisaUsuario = "";
                    model.mostrarPesquisa = false;
            });        
    }
    model.removerAmigo = function(perfil){
        serviceRelacionamento.removerAmigo(model.perfilCorrente.id,perfil).then(
            function(response){
                toastr.success('Removido com sucesso!');
                model.pesquisar(model.pesquisaUsuario);
            },
            function(response){
                toastr.error('Erro ocorrido ao remover o usuário!');
            }
        );
    };
    model.aceitarSolicitacao = function(perfil,resposta){
        serviceRelacionamento.responder(model.perfilCorrente.id,perfil.id,resposta).then(
            function(response){
                toastr.success('Aceito com sucesso!');
                model.pesquisar(model.pesquisaUsuario);
                model.carregarRelacionamentos();
            },
            function(response){
                toastr.error('Erro ocorrido ao aceitar a solicitação!');
            }
        );
    }
    model.comentar = function(postagem,comentarioNovo){
        serviceComentario.salvar(model.perfilCorrente,postagem,comentarioNovo).then(
            function(response){
                serviceComentario.getByPostagem(postagem).then(
                function(response){
                    postagem.comentarioSet = response.data;
                },
                function(response){
                    postagem.comentarioSet.push(response.data);
                    toastr.error('Erro ao atualizar comentários!');
                });
            },
            function(response){
                toastr.error('Erro ao salvar comentário!');
            }
        );
        
    }
    model.curtir = function(postagem){
        serviceCurtida.salvar(model.perfilCorrente,postagem).then(
            function(response){
                postagem.curtida = true;
            },
            function(response){
                toastr.error('Erro ao curtir esta postagem!');
            }
        );
    }
    model.descurtir = function(postagem){
        serviceCurtida.deletar(model.perfilCorrente,postagem).then(
            function(response){
                postagem.curtida = false;
            },
            function(response){
                toastr.error('Erro ao descurtir esta postagem!');
            }
        );
    }
    model.tela = function(nomeTela){
        if(model.telaAtual === nomeTela){
            return true;
        }else{
            return false;
        }
    }
    model.trocarTela = function(nomeNovaTela){
        model.carregarRelacionamentos();
        model.telaAtual = nomeNovaTela;
    }
    model.carregarRelacionamentos = function(){
        servicePerfil.getFilterByRelation(model.perfilCorrente.id).then(
            function(response){
                model.relacionamentos = response.data;
                model.amigos = [];
                model.solicitacoesRecebidas = [];
                model.solicitacoesPendentes = [];
                for(relacionamento of model.relacionamentos){
                    if(relacionamento.isFriend){
                        model.amigos.push(relacionamento);
                    }else if(relacionamento.isRequested){
                        model.solicitacoesRecebidas.push(relacionamento);
                    }else if(relacionamento.pendingRequest){
                        model.solicitacoesPendentes.push(relacionamento);
                    }
                }
            },
            function(response){
                toastr.error('Erro ao carregar amigos!');
            }
        );
    }
    model.logout = function(){
        authService.logout().then(
            function(response){
                toastr.error('Você saiu com sucesso da aplicação!');
            },
            function(response){
                toastr.error('Erro ao sair da aplicação!');
            }
        );
    }
    model.carregarRelacionamentos();
    model.getPostagens();
}]);
