function changeCategory(){
    var category = document.getElementById('category').value;
    if(category == 'trip'){
        document.getElementById('trip-search').style.display = 'block';
        document.getElementById('input-search').style.display = 'none';
        document.getElementById('license-plate-search').style.display = 'none';
        document.getElementById('from').style.display = 'none';
        document.getElementById('text-to').style.display = 'none';
        document.getElementById('to').style.display = 'none';
    }
    else if(category == 'license-plate'){
        document.getElementById('license-plate-search').style.display = 'block';
        document.getElementById('input-search').style.display = 'none';
        document.getElementById('trip-search').style.display = 'none';
        document.getElementById('from').style.display = 'none';
        document.getElementById('text-to').style.display = 'none';
        document.getElementById('to').style.display = 'none';
    }
    else if(category == 'customer'){
        document.getElementById('input-search').style.display = 'block';
        document.getElementById('license-plate-search').style.display = 'none';
        document.getElementById('trip-search').style.display = 'none';
        document.getElementById('from').style.display = 'none';
        document.getElementById('text-to').style.display = 'none';
        document.getElementById('to').style.display = 'none';
    }
    else{
        document.getElementById('from').style.display = 'block';
        document.getElementById('text-to').style.display = 'block';
        document.getElementById('to').style.display = 'block';
        document.getElementById('input-search').style.display = 'none';
        document.getElementById('license-plate-search').style.display = 'none';
        document.getElementById('trip-search').style.display = 'none';
    }
}