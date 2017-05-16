function arredondamento(numero,casas=2){
    return Number(numero.toFixed(casas));
}
console.log(`Número arredondado: ${arredondamento(3.456735,4)}, tipo da váriavel: ${typeof arredondamento(3.456735,2)}`);
console.log(`Número arredondado: ${arredondamento(3.456735)}, tipo da váriavel: ${typeof arredondamento(3.456735)}`);
