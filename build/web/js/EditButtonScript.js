function editDescr(tab){
    if(tab.innerHTML === "edit"){
        tab.innerHTML = "done";
        document.getElementById('edit').disabled  = false;
    }
    else{
        tab.innerHTML = "edit";
        document.getElementById('edit').disabled  = true;
    }
}