var modulo = angular.module('pokemonAPP',[]);
modulo.controller('PokemonName', ['$scope', function (model) { //O modulo.controller retorna o Model, Scope
    model.info={nome: '',tipo:'',numero:"1"};
    model.keypress=0;
    model.count = function(){
        model.keypress = model.keypress+1;
    };
    model.img = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png";
    model.imgDetector = function(){
        let numero = model.info.numero;
        let url = `http://pokeapi.co/api/v2/pokemon/${numero}/`;
        if(url!==`http://pokeapi.co/api/v2/pokemon//`){
        fetch(url)
            .then(response => response.json())
            .then(json => {
            model.img = json.sprites.front_default;
        })
        }
        return model.img;
    };
}]);
