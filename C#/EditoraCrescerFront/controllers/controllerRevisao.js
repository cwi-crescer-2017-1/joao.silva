modulo.controller('PaginaRevisao',['$scope','$routeParams','servicesLivros','toastr','$location','authService','authConfig', function(model,$routeParams,servicesLivros,toastr,$location,authService,authConfig){ 
    model.livroSendoRevisado = livroSendoRevisado;
    model.livroEditado = {};

    model.editandoTitulo = false;
    model.editandoDescricao =  false;
    model.editandoGenero = false;
    model.alterandoCapa = false;
    model.editando = false;

    model.editarDescricao = editarDescricao;
    function editarDescricao(){
        pararEdicao();
        model.editandoDescricao =  true;
        editar();
    }
    model.editarTitulo = editarTitulo;
    function editarTitulo(){
        pararEdicao();
        model.editandoTitulo = true;
        editar()
    }
    model.editarGenero = editarGenero;
    function editarGenero(){
        pararEdicao();
        model.editandoGenero = true;
        editar();
    }
    model.alterarCapa = alterarCapa;
    function alterarCapa(){
        pararEdicao();
        model.alterandoCapa = true;
        editar();
    }
    function editar(){
        model.editando = true;
        model.livroEditado.Titulo = model.livroSendoRevisado.Titulo;
        model.livroEditado.Genero = model.livroSendoRevisado.Genero;
        model.livroEditado.Descricao = model.livroSendoRevisado.Descricao;
        model.livroEditado.Capa = model.livroSendoRevisado.Capa;
    }
    model.salvarEdicao = salvarEdicao;
    function salvarEdicao(){
        let livro = {};
        livro.Isbn = model.livroSendoRevisado.Isbn;
        livro.Titulo = model.livroEditado.Titulo;
        livro.Genero = model.livroEditado.Genero;
        livro.Descricao = model.livroEditado.Descricao;
        livro.IdAutor = model.livroSendoRevisado.IdAutor;
        livro.Capa = model.livroEditado.Capa;
        livro.DataPublicacao = null;
        servicesLivros.alterarLivro(livro).then(function(response){
            toastr.success('Livro alterado com sucesso!');
            model.livroSendoRevisado = response.data.dados;
            pararEdicao();
        }); 
    }
    model.cancelarEdicao = pararEdicao;
    function pararEdicao(){
        model.editandoTitulo = false;
        model.editandoDescricao =  false;
        model.editandoGenero = false;
        model.alterandoCapa = false;
        model.editando = false;
    }
    model.revisaoCompleta = revisaoCompleta;
    function revisaoCompleta(){
        let IdRevisor = authService.getUsuario().Id;
        let Isbn = model.livroSendoRevisado.Isbn;
        servicesLivros.revisarLivro(IdRevisor,Isbn).then(function(response){
            toastr.success('Revisão salva com sucesso!');
            livroSendoRevisado = null;
            pararEdicao();
            $location.path('/adminstrativo');
        });
    }

    function today(){
        let today = new Date();
        let dd = today.getDate();
        let mm = today.getMonth()+1;
        let yyyy = today.getFullYear();

        if(dd<10) {
            dd='0'+dd
        } 

        if(mm<10) {
            mm='0'+mm
        } 

        today = yyyy+'-'+mm+'-'+dd;
        return today;
    }
    if(!authService.isAutenticado()){
        $location.path(authConfig.urlLogout);
    }else{
        let permissoes = authService.getUsuario().Permissoes;
        let usuarioRevisor = false;
        model.permissoes = permissoes;
        model.permissoes.forEach(function(permissao){
            if(permissao.Nome === "Revisor" || permissao.Nome === "Administrador"){ 
                usuarioRevisor = true; 
            }
        });
        if(!usuarioRevisor){
            $location.path(authConfig.urlPrivado);
        }
    }

}]);