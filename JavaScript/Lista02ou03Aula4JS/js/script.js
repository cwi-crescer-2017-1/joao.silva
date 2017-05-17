/*Exercício 1

Busca por número

Crie um arquivo pokesearch.html (com javascript incluído) e implemente o evento de click do
botão para pesquisar pelo pokémon a partir do número digitado no input. No retorno da requisição,
renderize dentro de uma div as seguintes informações do pokémon:

Nome
Número
Sprite principal do pokémon (front_default)
Lista de descrições tipos (pode ser um elemento <ul>)
Fique à vontade para estilizar a página como desejar. Compartilhe no slack com seus colegas!*/
document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
    let pokemon = document.getElementById('txtPesquisar').value;
    criarPoke(("http://pokeapi.co/api/v2/pokemon/").concat(pokemon),pokemon);

  }
})
function criarPoke(url,numero){
  fetch(url)
     .then(response => response.json())
     .then(json => {
       console.log(json.forms[0].name, numero, json.sprites.front_default, json.types,json.abilities);
       let pokemonSelecionado = new Pokemon(json.forms[0].name, numero, json.sprites.front_default, json.types,json.abilities,json.stats);
       pokemonSelecionado.html();
     })
}
/*
let nomePoke = document.getElementById('NomePoke');
let numeroPoke = document.getElementById('NumeroPoke');
let imgPoke = document.getElementById('imgPoke');
let tiposPoke = document.getElementById('tiposPoke');
let habilidadesPoke = document.getElementById('habilidadesPoke');
*/
