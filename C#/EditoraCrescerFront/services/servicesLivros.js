modulo.factory('servicesLivros',function($http){ //servicesInstrutores deve estar presente para executar a aulaService!
    
    let urlBase = 'http://localhost:60184/api/';

    //Retorna lista de aulas
    function listLimitada(quantidade,skip){
        return $http.get(urlBase+'Livros/ListaLimitada/'+quantidade+'/'+skip);
    }
    function listLimitadaCompleta(quantidade,skip){
        return $http.get(urlBase+'Livros/ListaLimitadaCompleta/'+quantidade+'/'+skip); 
    }
    function listLancamentos(){
        return $http.get(urlBase+'Livros/Lancamentos');
    }
    function alterarLivro(livro){
        return $http.put(urlBase+'Livros/'+livro.Isbn, livro);
    }
    function revisarLivro(idRevisor,isbn){
        return $http.put(urlBase+'Livros/revisar/'+idRevisor+'/'+isbn);
    }
    function publicarLivro(isbn){
        return $http.put(urlBase+'Livros/publicar/'+isbn);
    }
    function pedirNovaRevisao(isbn){
        return $http.put(urlBase+'Livros/novaRevisao/'+isbn);
    }
    return { 
        listLimitada:listLimitada,
        listLancamentos:listLancamentos,
        alterarLivro:alterarLivro,
        listLimitadaCompleta:listLimitadaCompleta,
        revisarLivro:revisarLivro,
        publicarLivro:publicarLivro,
        pedirNovaRevisao:pedirNovaRevisao
    }; 

});

/*
let propriedades = {
   url: urlBase+'Livros/revisar/',
   method: 'PUT',
   params: {
      idRevisor:idRevisor,
      isbn:isbn
   }
} 
*/