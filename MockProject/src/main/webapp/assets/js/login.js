function checkNull(){
    var user = document.getElementById('username').value;
    var pass = document.getElementById('password').value;
    if(user == '' || pass == ''){
        document.getElementById('button').disabled = true;
    }
    else{
        document.getElementById('button').disabled = false;
    }
}