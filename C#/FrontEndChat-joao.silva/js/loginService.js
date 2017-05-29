modulo.factory('loginService',function($http){
        let urlBase = 'http://localhost:63906/api/Usuario';
        function create(nomeDeUsuario,nome,senha,imgUrl){
            return $http.post(`${urlBase}/?nomeDeUsuario=${nomeDeUsuario}&nome=${nome}&senha=${senha}&imgUrl=${imgUrl}`);
        };
        function login(nomeDeUsuario,senha){
            return $http.get(`${urlBase}/?nomeDeUsuario=${nomeDeUsuario}&senha=${senha}`)
        };   
        return { 
            login:login,
            create:create,
        }; 
});