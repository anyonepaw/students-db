function deleteIt(id) {
    sendRequest('/students/' + id, "DELETE");
}
function sendRequest(url, type) {
    $.ajax({
        url: url,
        type: type,
        success: function (result) {
            window.location.reload()
        },
        error: function () {
            alert('Whooops... Smth went wrong!');
        }
    });
}


function nextPage() {
    window.location = window.location.pathname + "?page=" + (page + 1)
}

function prevPage() {
    window.location = window.location.pathname + "?page=" + (page - 1)
}

function onChange(input) {
    var pageValue = input.value - 1;
    if (pageValue > 0 || pageValue < allPages) {
        window.location = window.location.pathname + "?page=" + pageValue
    } else {
        return alert("There's no page with such a number!");
    }
}

