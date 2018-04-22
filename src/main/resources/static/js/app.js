function deleteIt(id) {
    sendRequest('/students/' + id, "DELETE");
}



function getQuery() {
    var value = document.getElementById("query").value;
    return value ? ("&Query=" + value) : "";
}

function nextPage() {
    window.location = window.location.pathname + "?page=" + (page + 1) + getQuery()
}

function prevPage() {
    window.location = window.location.pathname + "?page=" + (page - 1) + getQuery()
}

function onChange(input) {
    var pageValue = input.value - 1;
    if (pageValue > 0 || pageValue < allPages) {
        window.location = window.location.pathname + "?page=" + pageValue + getQuery()
    } else {
        return alert("There's no page with such a number!");
    }
}

