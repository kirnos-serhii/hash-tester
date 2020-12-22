
$(document).ready(init);

function init() {
    setupForm();
}

function setupForm() {
    if ($('#dataGeneration option:selected').val() == 'SEQUENCE') {
        $('#startAt').prop( "disabled", false );
    } else {
        $('#startAt').prop( "disabled", true );
    }
}

$('#clean').click(function() {
    $('#result-table tbody').empty();
});

$('#dataGeneration').change(setupForm);

$('#perform-btn').click(function() {
    emptyErrors();
    let calculationData = getCalculateData();

    $.ajax({
        url: '/calculate',
        type: 'POST',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(calculationData),
        success: function(data, textStatus) {
            $('#result-table tbody').append($(getRow(data)));
        },
        error: function(xhr) {
            let $alertBlock = $(generateErrors());
            xhr.responseJSON.forEach(element => $("ul", $alertBlock).append('<li>' + element + '</li>'));
            $('#error-container').append($alertBlock);
            $('.alert').alert();
        }
    });
});

function emptyErrors() {
    $('#error-container').empty();
}

function generateErrors() {
    return `
        <div class="alert alert-warning alert-dismissible fade show w-100 ml-2 mr-2" role="alert">
          <ul style="margin: 0"></ul>
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
    `;
}

function generateLi(msg) {
    return `
    <li>${msg}</li>
    `;
}

function getRow(elem) {
    return `
        <tr>
            <td>${elem.algorithm}</td>
            <td>${elem.bits}</td>
            <td>${elem.numberElements}</td>
            <td>${elem.executionTime}</td>
            <td>${elem.numberOfCollisions}</td>
        </tr>
    `;
}

function getCalculateData() {
    return {
        'numberElements': $('#numberElements').val(),
        'algorithm': $('#algorithm option:selected').val(),
        'dataGeneration': $('#dataGeneration option:selected').val(),
        'startAt': $('#startAt').val(),
        'cut': $('input[name=cut]:checked').val()
    }
}