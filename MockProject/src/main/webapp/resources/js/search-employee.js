function changeCategory(){
    var category = document.getElementById('category').value;
    if(category == 'name' || category == 'address'){
        document.getElementById('input-search').type = 'text';
    }
    else if(category == 'dateofbirth'){
        document.getElementById('input-search').type = 'date';
    }
    else if(category == 'phonenumber'){
        document.getElementById('input-search').type = 'tel';
    }
}

function searchEmployee(){
    if(document.getElementById('input-search').type == 'tel' && !checkPhoneNumber()){
        alert('Phone number is invalid');
    }
    else{
        document.getElementById('form-search').submit();
    }
}

function checkPhoneNumber(){
    var input = document.getElementById('input-search').value;
    for(var i = 0; i < input.lenght; i++){
        if (input.charCodeAt(i) < 48 || input.charCodeAt(i) > 57) {
			return false;
		}
    }
}