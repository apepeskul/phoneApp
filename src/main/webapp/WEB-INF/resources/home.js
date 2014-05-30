$(document).ready(function () {
    $("#table").dataTable({

        "sAjaxSource": "/phones/get",
        /*"bServerSide": true,*/
        "bJQueryUI": true,
        "aoColumns": [
            { "mDataProp": "firstName" },
            { "mDataProp": "lastName" },
            { "mDataProp": "phone" },
            {   "sDefaultContent": "",
                "bSortable": false,
                "fnRender": function (o) {
                    return '<button class="btn-mini btn-warning" id="editBtn' + o.aData["id"] + '" value="' + o.aData["id"] + '" data-toggle="modal">Edit</button>'
                }
            },
            {   "sDefaultContent": "",
                "bSortable": false,
                "fnRender": function (o) {
                    return '<input type="button" id="delete/' + o.aData["id"] + '" class="btn btn-danger btn-mini"  value="Delete" data-toggle="confirmation" data-href="/phone/delete/' + o.aData["id"] + '" />'
                }
            }

        ],
        "sDom": "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
        "sPaginationType": "bootstrap",
        "oLanguage": {
            "sLengthMenu": "_MENU_ records per page"
        },
        "iDisplayLength": 5,
        "aLengthMenu": [
            [5, 10, 25, -1],
            [5, 10, 25, "All"]
        ],
        "bProcessing": true,
        "fnDrawCallback": function () {
            $("[id^=delete]").confirmation({singleton: true, popout: true});
        }
    });
});

$(document).on("click", "#btnNew", function () {
    document.getElementById("editForm").reset();
    $('#myModal').modal({
        keyboard: false
    })
});

$('#myModal').on('hidden', function () {
    $(this).removeData('.modal');
})


$(document).on("click", "[id^=editBtn]", function () {

    document.getElementById("editForm").reset();
    jQuery(".error").remove();
    jQuery.getJSON("/phone/" + $(this).val(), function (data) {

        $('#myModal').modal({
            keyboard: false
        })
        $('#modalFirstName').val(data.firstName);
        $('#modalLastName').val(data.lastName);
        $('#modalPhone').val(data.phone);
        $('#modalId').val(data.id);


    });
})

$(document).on("click", "#addBtn", function () {
    document.getElementById("editForm").reset();
    jQuery(".error").remove();
    $("#modalId").val('');
    $('#myModal').modal({
        keyboard: false
    })
});

jQuery(document).ready(function () {
    jQuery("#editForm").submit(function (e) {
        jQuery(".error").remove();
        var url = "phone/update";
        if ($("#modalId").val() === '') {
            url = "phone/save"
        }
        jQuery.ajax({
            url: url,
            context: document.body,
            type: 'post',
            data: $('#editForm').serialize()
        }).done(function (res) {
            if (res.status === "ERROR") {
                for (var key in res.errorsMap) {
                    var err = "<label for=\"" + key + "\" class=\"error\" id=\"" + key + "Id\">" + res.errorsMap[key] + "</span>";
                    jQuery("[name^='" + key + "']").after(err);
                }
            } else {
                $('#myModal').modal('hide');
                var $table = $("#table").dataTable({ bRetrieve: true });
                $table.fnReloadAjax();
            }
        }).fail(function (data) {
            jQuery("#msg").html("<span class=\"error\">Server failed to process request</span>");
        });
        return false;
    });
});

