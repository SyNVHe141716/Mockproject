function changeCategory() {
    var category = document.getElementById('category').value;
    if(category == 'bookingOffice' || category == 'trip'){
        document.getElementById('input-search').type = 'text';
    }  
}

function searchBookingOffice(){
        document.getElementById('form-search').submit();
}
