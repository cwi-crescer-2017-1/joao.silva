var modulo = angular.module('PokemonAPPv2',[]);
modulo.controller('pokemons',['$scope', function (model){
    model.pokemons = listaPokemons; //listaPokemons - variável definida em listapokemons.js
}])
