describe("Number.prototype.arredondar", function() {
    it("Teste com arredondamento na casa 4", function() {
        var resultado = 3.4567;
        expect(resultado).toBe((3.456735).arredondar(4));
    });
    it("Teste com arredondamento na casa default(2)", function() {
        var resultado =2.55;
        expect(resultado).toBe((2.54654).arredondar());
    });
    it("Teste com arredondamento para cima na casa 3", function() {
        var resultado = 4.657;
        expect(resultado).toBe((4.6567).arredondar(3));
    });
});
