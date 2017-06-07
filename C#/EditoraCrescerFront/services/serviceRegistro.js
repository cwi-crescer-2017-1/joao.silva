modulo.factory('serviceRegistro',function($http){

    let urlBase = 'http://localhost:60184/api/';

    function registrar(nome,email,senha,cargo){
        let usuario = {};
        usuario.Nome = nome;
        usuario.Email = email;
        usuario.Senha =  senha;
        usuario.Cargo = cargo;
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