modulo.factory('serviceUsuario',function($http){
    let urlBase = 'http://localhost:8080/usuarioCon/';
    function registrar(username,password){
        let usuario = {};
        usuario.email = username;
        usuario.senha = password;
        return $http.post(urlBase+'save',usuario);
    }
    function addPerfil(id,username,password,perfil){
        let usuario = {};
        usuario.id = id;
        usuario.email = username;
        usuario.senha = password;
        usuario.perfil = perfil; 
        return $http.post(urlBase+'update',usuario);
    }
    return { 
        registrar:registrar,
        addPerfil:addPerfil
    }; 
});