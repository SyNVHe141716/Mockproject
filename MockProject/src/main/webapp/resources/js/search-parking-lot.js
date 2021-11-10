function changeCategory(){
    var category = document.getElementById('category').value;
    if(category == 'name'){
        document.getElementById('name-search').style.display = 'block';
        document.getElementById('from').style.display = 'none';
        document.getElementById('text-to').style.display = 'none';
        document.getElementById('to').style.display = 'none';
        document.getElementById('select-place').style.display = 'none';
    }
    else if(category == 'place'){
        document.getElementById('select-place').style.display = 'block';
        document.getElementById('name-search').style.display = 'none';
        document.getElementById('from').style.display = 'none';
        document.getElementById('text-to').style.display = 'none';
        document.getElementById('to').style.display = 'none';
    }
    else{
        document.getElementById('name-search').style.display = 'none';
        document.getElementById('from').style.display = 'block';
        document.getElementById('text-to').style.display = 'block';
        document.getElementById('to').style.display = 'block';
        document.getElementById('select-place').style.display = 'none';
    }
}