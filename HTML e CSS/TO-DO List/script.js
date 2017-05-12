var h2 = document.querySelector('h2');
h2.innerText = new Date().toLocaleString();

var atualizaHora = ()=>{h2.innerText = new Date().toLocaleString();};
setInterval(atualizaHora, 1000);
