modulo.factory('serviceRelacionamento',function($http,authService,toastr){
    let urlBase = 'http://localhost:8080/relacionamento/';

    function registrar(perfilSolicitante,perfilSolicitado){
        let relacionamento = {};
        relacionamento.perfilSolicitante = perfilSolicitante;
        relacionamento.perfilSolicitado = perfilSolicitado;
        return $http.post(urlBase+'save',relacionamento);
    };

    function responder(idPerfil,idPerfil2,resposta){
        return $http.get(urlBase+'findOneByPerfil/'+idPerfil+'/'+idPerfil2).then(
            function(response){
                return $http.put(urlBase+'responder/'+resposta,response.data);
            },
            function(response){
                toastr.error('Erro ocorrido ao buscar o relacionamento!');
            }
        );
    };

    

    function removerAmigo(idPerfilUsuario,perfilAmigo){
        return $http.put(urlBase+"removerAmigo/"+idPerfilUsuario, perfilAmigo);
    };
    return { 
        registrar:registrar,
        responder:responder,
        removerAmigo:removerAmigo,
    };
});