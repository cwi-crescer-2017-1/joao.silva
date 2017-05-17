Number.prototype.arredondar = function(casas=2,criterio=5) {
  let separadosPelaVirgula = this.toString().split(".");
  let numerosDepoisDaVirgula = separadosPelaVirgula[1].split("");
  if(numerosDepoisDaVirgula[casas]>=criterio){
    if(Number(numerosDepoisDaVirgula[casas-1])===9){
      numerosDepoisDaVirgula[casas-1] = 0;
      numerosDepoisDaVirgula[casas-2] = (Number(numerosDepoisDaVirgula[casas-2])+1).toString();
    }else{
    numerosDepoisDaVirgula[casas-1] = (Number(numerosDepoisDaVirgula[casas-1])+1).toString();
    }
  }
  separadosPelaVirgula[1] =  numerosDepoisDaVirgula.join("");
  return Number(separadosPelaVirgula[0].concat(".",separadosPelaVirgula[1].substring(0, casas)));
  //return Number(this.toFixed(casas)) -- não vai funcionar com os tester que tem critério de arredondamento;
}
