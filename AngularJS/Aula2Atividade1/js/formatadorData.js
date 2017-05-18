function formatarData(data){
    /*
    let pattern = '((\d{2})\/(\d{2})\/(\d{4}))|((\d{2})\.(\d{2})\.(\d{4}))|((\d{2})\\(\d{2})\\(\d{4}))|((\d{2})\-(\d{2})\-(\d{4}))';
    let replace = '$1.$2.$3';
    data.replace(replace,pattern);
    return new Date(data);
    */
    if(data.indexOf('/')>-1){
        var parts = data.split('/');
        return new Date(parts[0],parts[1]-1,parts[2]);
    }else if(data.indexOf('-')>-1){
        return data;
    }else if(data.indexOf('.')>-1){
        return new Date(data);
    }else{
        return null;
    }    
}