class Pokemon {
  constructor(nome, numero, urlSprite, tipos, habilidades, status) {
    this.nome = nome;
    this.nome = Object.seal(nome);
    this.numero = numero;
    this.numero = Object.seal(numero);
    this.urlSprite = urlSprite;
    this.urlSprite = Object.seal(urlSprite);
    this.tipos = tipos;
    this.habilidades = habilidades;
    this.status = status;
  }
  html() {
    let nomePoke = document.getElementById("NomePoke");
    let numeroPoke = document.getElementById("NumeroPoke");
    let divImgPoke = document.getElementById("imgPoke");
    let ulTiposPoke = document.getElementById("tiposPoke");
    let ulHabilidadesPoke = document.getElementById("habilidadesPoke");
    let statusPoke = document.getElementById("status");
    let statusPokeNovo = document.getElementById("status");
    let imgPoke;
    imgPoke = document.createElement("img");
    divImgPoke.append(imgPoke);
    imgPoke.src = this.urlSprite;
    let liTipo,h3Tipo,imgTipo,barraStatus,nomeStatus,porcentagem;
    console.log(nomePoke);
    if(nomePoke.textContent===""){
      nomePoke.innerText = `${this.nome} ( ${this.numero} )`;
    }else{
      nomePoke.innerText = `${nomePoke.textContent}, ${this.nome}(${this.numero})`;
    }
    /*if(numeroPoke.textContent===""){
      numeroPoke.innerText = this.numero;
    }else{
      numeroPoke.innerText = `${numeroPoke.textContent}, ${this.numero}`;
    }**/
    let tiposTitulo = document.createElement("h3");
    tiposTitulo.innerText = `Tipos do ${this.nome}`;
    ulTiposPoke.append(tiposTitulo);
    this.tipos.forEach(tipo=> {
      liTipo=document.createElement("li");
      h3Tipo=document.createElement("h3");
      h3Tipo.innerText = tipo.type.name;
      liTipo.append(h3Tipo);
      ulTiposPoke.append(liTipo);
      //document.getElementById("tiposPoke").append(liTipo);
    })
    let habilidadesTitulo = document.createElement("h3");
    habilidadesTitulo.innerText = `Habilidades do ${this.nome}`;
    ulHabilidadesPoke.append(habilidadesTitulo);
    this.habilidades.forEach(habilidade=> {
      liTipo=document.createElement("li");
      h3Tipo=document.createElement("h3");
      h3Tipo.innerText = habilidade.ability.name;
      liTipo.append(h3Tipo);
      ulHabilidadesPoke.append(liTipo);
      //document.getElementById("habilidadesPoke").append(liTipo);
    })
    let statusTitulo = document.createElement("h3");
    statusTitulo.innerText = `Status do ${this.nome}`;
    statusPoke.append(statusTitulo);
    this.status.forEach(status=>{
      barraStatus=document.createElement("div");
      nomeStatus=document.createElement("h3");
      porcentagem = status.base_stat;
      nomeStatus.innerText = `${(status.stat.name).toUpperCase()} - ${porcentagem}%`;
      barraStatus.append(nomeStatus);
      barraStatus.className = "barraStatus";
      barraStatus.style.width = `${porcentagem}%`; //Verificar se porcentagem é o melhor modo de tratar essa variavel
      if(porcentagem>=90){
        barraStatus.style.background = "#00CC00";
      }else if(porcentagem>=80){
        barraStatus.style.background = "#009900";
      }else if(porcentagem>=70){
        barraStatus.style.background = "#006600";
      }else if(porcentagem>=50){
        barraStatus.style.background = "#FFFF00";
      }else{
        barraStatus.style.background = "#FF0000";
      }
      barraStatus.autofocus;
      statusPoke.append(barraStatus);
      //barraStatus.style.width = status.base_stat;
    })
  }
}
