modulo.factory('serviceUsuario',function($http){

    let urlBase = 'http://localhost:61689/api/';

    function registrar(nome,email,senha){
        let usuario = {};
        usuario.Nome = nome;
        usuario.Email = email;
        usuario.Senha =  senha;
        return $http.post(urlBase+'usuario/registrar',usuario);
    }
    function obter(){
        return $http.get(urlBase+'usuario/');
    }
    return { 
        registrar:registrar,
        obter:obter
    }; 
});