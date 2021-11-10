function changeCategory() {
    var category = document.getElementById('category').value;
    if(category == 'licensePlate' || category == 'carType' || category == 'carColor' || category == 'company' || category == 'parkingLot'){
        document.getElementById('input-search').type = 'text';
    }  
}

function searchBookingOffice(){
        document.getElementById('form-search').submit();
}
