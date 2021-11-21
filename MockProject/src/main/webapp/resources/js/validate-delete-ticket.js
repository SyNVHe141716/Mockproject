function clickDelete(id){
    var check = confirm('Are you sure want to delete?');
    if(check){
        window.location.href = 'DeleteTicketController?id=' + id;
    }
}