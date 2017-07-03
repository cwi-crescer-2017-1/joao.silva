modulo.factory('servicePostagem',function($http,authService){
    let urlBase = 'http://localhost:8080/postagem/';

    function registrar(urlImg,descricao,perfil){
        let postagem = {};
        console.log(urlImg);
         console.log(descricao);
        postagem.descricao = descricao;
        postagem.urlImg = urlImg;
        postagem.perfil = perfil;
        return $http.post(urlBase+'save',postagem);
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