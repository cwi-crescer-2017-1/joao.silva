modulo.factory('serviceRegistro',function($http){

    let urlBase = 'http://localhost:60184/api/';

    function registrar(nome,email,senha){
        let usuario = {};
        usuario.Nome = nome;
        usuario.Email = email;
        usuario.Senha =  senha;
        return $http.post(urlBase+'usuarios/registrar',usuario);
    }
    return { 
        registrar:registrar
    }; 
});