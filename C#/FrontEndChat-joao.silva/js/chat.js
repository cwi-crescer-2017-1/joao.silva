modulo.controller('PaginaChat',['$scope','$routeParams','chatService', function(model,$routeParams,chatService){
    model.id = $routeParams.idUrl;
    model.ListaMensagens=[];
    model.novaMensagem;
    model.EnviarMensagem=EnviarMensagem;
    model.ReceberMensagens=ReceberMensagens;
    model.Sair = Sair;
    var recarregarMensagens = window.setInterval(ReceberMensagens, 1000);
    var verificarLogin = window.setInterval(Logado, 1000);
    function EnviarMensagem(texto){
         model.novaMensagem = "";
         chatService.send(texto,usuarioLogado.nome,usuarioLogado.id,usuarioLogado.imgUrl).then(function(response){
             ReceberMensagens();
        });
    }
    function ReceberMensagens(){
         chatService.get().then(function(response){
             model.ListaMensagens=[];
            if(response.data != null){
                response.data.forEach(function(resposta) {
					if(resposta.Nome === usuarioLogado.nome){
						resposta.Nome = "Você";
					}
                    model.ListaMensagens.push(resposta);
                }, this);
            }
        });
    }
    function Logado(){
        if(usuarioLogado.nome==""){
            location.href="http://localhost:8080/#!/paginaLogin";
        }
    }
    function Sair(){
        usuarioLogado.nome="";
        location.href="http://localhost:8080/#!/paginaLogin";
    }
}]);