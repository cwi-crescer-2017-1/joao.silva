modulo.controller('PaginaLogin',['$scope','$routeParams','loginService', function(model,$routeParams,loginService){
    model.id = $routeParams.idUrl;
    model.criarUsuario = criarUsuario;
    model.usuario;
    model.senha;
    model.logar = logar;
    model.novoNome;
    model.novaImgUrl;
    model.novoUsuario;
    model.novaSenha;
    model.irParaRegistro = irParaRegistro;
    model.irParaLogin = irParaLogin;
    function criarUsuario(nomeDeUsuario,nome,senha,imgUrl) {
            loginService.create(nomeDeUsuario,nome,senha,imgUrl).then(function(response){
            alert('Usuário cadastrado com sucesso!', 'Sucesso!');
            console.log(response.data);
            location.href="http://localhost:8080/#!/paginaLogin";
            });
    };
    function logar(nomeDeUsuario,senha) {
            loginService.login(nomeDeUsuario,senha).then(function(response){
            if(response.data!=null){
                alert('Login Efetuado com sucesso!');
                console.log(response.data);
                usuarioLogado.nome = response.data.Nome;
                usuarioLogado.id = response.data.Id;
                usuarioLogado.imgUrl = response.data.ImgUrl;
                usuarioLogado.nomeDeUsuario = response.data.NomeDeUsuario;
                location.href="http://localhost:8080/#!/paginaChat";
            }else{
                alert('Usuário ou senha incorretos ou não cadastrados!');
            }
            
            });
    };
    function irParaRegistro(){
       location.href="http://localhost:8080/#!/paginaRegistro";
    };
    function irParaLogin(){
       location.href="http://localhost:8080/#!/paginaLogin";
    };

}]);