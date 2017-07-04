modulo.factory('serviceCurtida',function($http){
    let urlBase = 'http://localhost:8080/curtida/';
    function salvar(perfil,postagem){
        let curtida = {};
        curtida.perfil = perfil;
        return $http.post(urlBase+'save/'+postagem.id,curtida);
    }
    function deletar(perfil,postagem){
        return $http.put(urlBase+'remove/'+postagem.id+'/'+perfil.id);
    }
    return { 
        salvar:salvar,
        deletar:deletar
    }; 
});