modulo.factory('servicePostagem',function($http,authService){
    let urlBase = 'http://localhost:8080/postagem/';

    function registrar(descricao,urlImg){
        let postagem = {};
        postagem.descricao = descricao;
        postagem.urlImg = urlImg;
        return $http.put(urlBase+'save',postagem);
    }
    function getPage(page,size){
        let usuario = {};
        usuario = authService.getUsuario();
        return $http.post(urlBase+'findPage/'+page+'/'+size,usuario);
    }
    return { 
        registrar:registrar,
        getPage:getPage,
    }; 
});