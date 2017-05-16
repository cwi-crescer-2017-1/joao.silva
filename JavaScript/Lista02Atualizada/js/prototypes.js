String.prototype.pegarUltimoNome = function(a, b) {
  let ultimoNome = this.trim().split(" ");
  return ultimoNome[ultimoNome.length-1];
}
String.prototype.temAbreviacao = function() {
  return this.match(/ [A-Z][.] /gi) !== null;
}
