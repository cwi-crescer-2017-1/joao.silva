modulo.factory('serviceUsuario',function($http){
    let urlBase = 'http://localhost:8080/usuarioCon/';
    function registrar(email,senha){
        let usuario = {};
        usuario.email = email;
        usuario.senha = senha;
        return $http.post(urlBase+'save',usuario);
    }
    function addPerfil(id,email,senha,idPerfil,nome,genero,fotoUrl,dataNascimento,estado){
        let usuario = {};
        let perfil = {};
        usuario.id = id;
        usuario.email = email;
        usuario.senha = senha;
        perfil.id = idPerfil;
        perfil.nome = nome;
        perfil.genero = genero;
        perfil.fotoUrl = fotoUrl;
        perfil.sexo = genero;
        perfil.dataNascimento = dataNascimento;
        perfil.estado = estado;
        usuario.perfil = perfil; 
        return $http.post(urlBase+'save',usuario);
    }
    return { 
        registrar:registrar,
        addPerfil:addPerfil
    }; 
});