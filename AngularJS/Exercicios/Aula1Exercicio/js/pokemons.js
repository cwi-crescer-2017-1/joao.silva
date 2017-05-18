var modulo = angular.module('PokemonAPPv2',[]);
modulo.controller('pokemons',['$scope', function (model){
    model.pokemons = listaPokemons; //listaPokemons - variável definida em listapokemons.js
    model.tamanholista = model.pokemons.length;
    model.pesquisaNome='';
    model.pesquisaTipo='';
    model.pesquisaId='';
    model.filtradosPorNome =[];
    model.filtradosPorTipo =[];
    model.filtradosPorId =[];
    
    model.selecao = ()=>{
        model.pokemons = model.selecaoPorNome(model.selecaoPorTipo(model.selecaoPorId(listaPokemons)));
        model.tamanholista = model.pokemons.length;
    }
    model.selecaoPorNome=(filtroSelecao)=>{
            model.filtradosPorNome = filtroSelecao.filter(pokemon=>{
                return pokemon.name.toUpperCase().indexOf(model.pesquisaNome.toUpperCase())>-1; //possível usar .filter, porém com compatibilidade menor
            });
            return model.filtradosPorNome;
    }
    model.selecaoPorTipo=(filtroSelecao)=>{
            model.filtradosPorTipo = filtroSelecao.filter(pokemon =>{
                for(tipo of pokemon.tipos){
                    return tipo.type.name.toUpperCase().indexOf(model.pesquisaTipo.toUpperCase())>-1;
                }
            }) 
            return model.filtradosPorTipo;      
    }
    model.selecaoPorId=(filtroSelecao)=>{
            model.filtradosPorId = filtroSelecao.filter(pokemon=>{
                return pokemon.id.toString().indexOf(model.pesquisaId)>-1;
            });
            return model.filtradosPorId;
    }
}])
