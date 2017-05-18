var modulo = angular.module('DateAPP',[]);
modulo.controller('date',['$scope',function(model){
    model.data = '';
    model.dataFormat = dataFormat;
    model.resultado='';
    function dataFormat(){
       model.resultado = formatarData(model.data);
    }
}])