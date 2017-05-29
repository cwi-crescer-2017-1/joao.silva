modulo.factory('chatService',function($http){
        let urlBase = 'http://localhost:63906/api/Chat';
        function send(texto,nomeRemetente,idRemetente,imgRemetente){
            console.log(`${urlBase}/?texto=${texto}&nomeRemetente=${nomeRemetente}&idRemetente=${idRemetente}&imgRemetente=${imgRemetente}`);
            return $http.post(`${urlBase}/?texto=${texto}&nomeRemetente=${nomeRemetente}&idRemetente=${idRemetente}&imgRemetente=${imgRemetente}`);
        };
        function get(){
            return $http.get(`${urlBase}/`)
        };   
        return { 
            get:get,
            send:send,
        }; 
});