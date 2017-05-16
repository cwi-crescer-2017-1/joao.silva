series.push({"titulo":"TesteUndefined","anoEstreia":2014,"diretor":["Tester"],"genero":["Drama","Drama","Terror"],"elenco":["Debug","Error","Undefined"],"temporadas":undefined,"numeroEpisodios":undefined,"distribuidora":"JS"});
//Adiciona uma serie com um campo undefined
describe("seriesInvalidas()", function() {
    it("Teste para o array series", function() {
        var resultado = "Séries inválidas: Band of Brothers - Mr. Robot - Narcos - TesteUndefined";
        expect(resultado).toBe(seriesInvalidas(series));
    });
});
