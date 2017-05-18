function formatarData(data){
    var parts = data.split('/');
    console.log(parts[0]);
    console.log(parts[1]);
    console.log(parts[2]);
    return new Date(parts[0],parts[1]-1,parts[2]);    
}