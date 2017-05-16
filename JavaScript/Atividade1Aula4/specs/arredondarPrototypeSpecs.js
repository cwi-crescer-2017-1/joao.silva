describe("Number.prototype.arredondar", function() {
    it("Teste com arredondamento na casa 4, criterio de arredondamento: 5", function() {
        var resultado = 3.4567;
        expect(resultado).toBe((3.456735).arredondar(4,5));
    });
    it("Teste com arredondamento na casa default(2), criterio de arredondamento: 5", function() {
        var resultado =2.55;
        expect(resultado).toBe((2.54654).arredondar());
    });
    it("Teste com arredondamento para cima na casa 3, criterio de arredondamento: 5", function() {
        var resultado = 4.657;
        expect(resultado).toBe((4.6567).arredondar(3,5));
    });
    it("Teste com arredondamento para cima na casa 3, criterio de arredondamento: 7 - não arredonda", function() {
        var resultado = 4.656;
        expect(resultado).toBe((4.6566).arredondar(3,7));
    });
    it("Teste com arredondamento para cima na casa 3, criterio de arredondamento: 7 - arredonda", function() {
        var resultado = 4.657;
        expect(resultado).toBe((4.6567).arredondar(3,7));
    });
    it("Teste com arredondamento para cima na casa 3, criterio de arredondamento: 9 - não arredonda", function() {
        var resultado = 5.678;
        expect(resultado).toBe((5.6788).arredondar(3,9));
    });
    it("Teste com arredondamento para cima na casa 3, criterio de arredondamento: 9 - arredonda", function() {
        var resultado = 5.679;
        expect(resultado).toBe((5.6789).arredondar(3,9));
    });
    it("Teste com arredondamento para cima na casa 2, tendo a casa anterior ao arredondamento um valor maior que o critério e a casa arredondada o valor 9", function(){
       var resultado = 5.2;
       expect(resultado).toBe((5.195).arredondar());
    });
});
