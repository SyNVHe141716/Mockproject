function clickAdd() {
	if (!checkFullName()) {
		alert('Full name is invalid');
	}
	else if (!checkPhoneNumber()) {
		alert('Phone number is invalid');
	}
	else if (document.getElementById('dateofbirth').value == '') {
		alert('Date of birth cannot be blank');
	}
	else if(!checkEmail()){
		alert('Email is invalid');
	}
	else if (document.getElementById('account').value == '') {
		alert('Account cannot be blank')
	}
	else if (document.getElementById('password').value == '') {
		alert('Password cannot be blank')
	}
	else  {
		document.getElementById('form-add-employee').submit();
	}
}

function clickUpdate(){
    if(document.getElementById('fullname').value == ''){
        alert('Full name cannot be blank');
    }
    else if(!checkPhoneNumber()){
        alert('Phone number is invalid');
    }
    else if(document.getElementById('dateofbirth').value == ''){
        alert('Date of birth cannot be blank');
    }
    else if(document.getElementById('account').value == ''){
        alert('Account cannot be blank')
    }
    else if(document.getElementById('password').value == ''){
        alert('Password cannot be blank')
    }
    else{
        document.getElementById('form-update-employee').submit();
    }
}

function clickDetele(){
    var check = confirm('Are you sure want to delete?');
    var id = document.getElementById('id').value;
    if(check){
        window.location.href = '#';
    }
}

function checkEmail(){
	if(document.getElementById('email').value != '' && !/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(document.getElementById("email").value)){
		return false;
	}
	return true;
}

function checkPhoneNumber() {
	var test = document.getElementById('phonenumber').value;
	if (test == '') {
		return false;
	}
	for (var i = 0; i < test.length; i++) {
		if (test.charCodeAt(i) < 48 || test.charCodeAt(i) > 57) {
			return false;
		}
	}
	return true;
}

function checkFullName() {
	var test = document.getElementById('fullname').value;
	if (test == '') {
		return false;
	}
	for (var i = 0; i < test.length; i++) {
		if (test.charCodeAt(i) < 65 || (test.charCodeAt(i) > 90 && test.charCodeAt(i) < 97) || test.charCodeAt(i) > 122) {
			return false;
		}
	}
	return true;
}

function clickReset(){
	document.getElementById('fullname').value = '';
	document.getElementById('phonenumber').value = '';
	document.getElementById('dateofbirth').value = '';
	document.getElementById('address').value = '';
	document.getElementById('email').value = '';
	document.getElementById('account').value = '';
	document.getElementById('password').value = '';
}
