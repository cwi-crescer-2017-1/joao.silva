modulo.factory('serviceComentario',function($http){
    let urlBase = 'http://localhost:8080/comentario/';
    function salvar(perfil,postagem,texto){
        let comentario = {};
        comentario.perfil = perfil;
        comentario.postagem = postagem;
        comentario.texto = texto;
        return $http.post(urlBase+'save/'+postagem.id,comentario);
    }
    function getByPostagem(postagem){
        return $http.get(urlBase+'/get/postagem/'+postagem.id);
    }
    return { 
        salvar:salvar,
        getByPostagem:getByPostagem,
    }; 
});