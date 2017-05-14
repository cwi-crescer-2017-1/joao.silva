var h2 = document.querySelector('h2');
h2.innerText = new Date().toLocaleString();
let countAtualizaAviso=0;
function atualizaAviso(){
  horaInicialEmMS = new Date().getTime();
  if(countAtualizaAviso<5){
    exibeHora();
    countAtualizaAviso++;
  }else if(countAtualizaAviso<8){
    exibeAlerta();
    countAtualizaAviso++;
  }else{
    countAtualizaAviso=0;
  }
}
var exibeHora = ()=>{h2.innerText = new Date().toLocaleString();};
var exibeAlerta = ()=>{h2.innerText = "Remember: Only important things!"};

setInterval(atualizaAviso,1000);
