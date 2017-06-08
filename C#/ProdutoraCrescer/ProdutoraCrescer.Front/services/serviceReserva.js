modulo.factory('serviceReserva',function($http){

    let urlBase = 'http://localhost:61689/api/';

    function registrar(tempoReservaEmDias,idCliente,idUsuario,idOpcional,idPacote,idFesta){
        let reserva = {};
        reserva.TempoReservaEmDias = tempoReservaEmDias;
        reserva.IdCliente = idCliente;
        reserva.IdUsuario = idUsuario;
        reserva.IdOpcional = idOpcional;
        reserva.IdPacote = idPacote;
        reserva.IdFesta = idFesta;
        return $http.post(urlBase+'reserva/registrar',reserva);
    }
    function obterLista(){ //Permissão 'Gerente'
        return $http.get(urlBase+'reserva/');
    }
    function obterListaNaoDevolvidos(){ //Permissão 'Gerente'
        return $http.get(urlBase+'reserva/limitada');
    }
    function obterValorDevolucao(idReserva){
        return $http.get(urlBase+'reserva/valordevolucao/'+idReserva);
    }
    function ObterRelatorioLocacaoMensal(dataFinal){ //Permissão 'Gerente'
        return $http.get(urlBase+'reserva/relatorioLocacaoMensal/'+dataFinal);
    }
    function obterPorId(idReserva){
        return $http.get(urlBase+'reserva/'+idReserva);
    }
    function ObterListaPorIdCliente(idCliente){
        return $http.get(urlBase+'reserva/cliente/'+idCliente);
    }
    function ObterRelatorioAtrasos(){ 
        return $http.get(urlBase+'reserva/relatorioAtrasos/');
    }
    function Devolver(idReserva){
        return $http.put(urlBase+'reserva/'+idReserva);
    }
    return { 
        registrar:registrar,
        obterLista:obterLista,
        obterListaNaoDevolvidos:obterListaNaoDevolvidos,
        obterValorDevolucao:obterValorDevolucao,
        ObterRelatorioLocacaoMensal:ObterRelatorioLocacaoMensal,
        obterPorId:obterPorId,
        ObterListaPorIdCliente:ObterListaPorIdCliente,
        ObterRelatorioAtrasos:ObterRelatorioAtrasos,
        Devolver:Devolver
    }; 
});