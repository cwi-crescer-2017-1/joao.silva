modulo.factory('servicePerfil',function($http){
    let urlBase = 'http://localhost:8080/perfil/';
    function registrar(nome,genero,fotoUrl,dataNascimento,estado){
        let perfil = {};
        perfil.nome = nome;
        perfil.genero = genero;
        perfil.fotoUrl = fotoUrl;
        perfil.sexo = genero;
        perfil.dataNascimento = dataNascimento;
        perfil.estado = estado;
        return $http.post(urlBase+'save',perfil);
    }
    function getFilterByName(nome){
        return $http.get(urlBase+'findByName/'+nome);
    }
    function getFilterByNameWithFriendship(idPerfilCorrente,nome){
        return $http.get(urlBase+'findByName/WithFriendship/'+idPerfilCorrente+'/'+nome);
    }
    function getFilterByRelation(idPerfilCorrente){
        return $http.get(urlBase+'findAll/WithRelation/'+idPerfilCorrente);
    }
    return { 
        registrar:registrar,
        getFilterByName:getFilterByName,
        getFilterByNameWithFriendship:getFilterByNameWithFriendship,
        getFilterByRelation:getFilterByRelation,
    }; 
});