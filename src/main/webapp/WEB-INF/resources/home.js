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
                    return '<input type="button" id="delete/' + o.aData["id"] + '" class="btn btn-danger btn-mini"  value="Delete" data-toggle="confirmation" data-href="/emp/delete/' + o.aData["id"] + '" />'
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
 jQuery.getJSON("/phone/" + $(this).val(), function (data) {

 $('#myModal').modal({
 keyboard: false
 })
 $('#modalFirstName').val(data.firstName);
 $('#modalLastName').val(data.lastName);
$('#modalPhone').val(data.phone);o
 $('#modalId').val(data.id);



 });
 })
/*

 jQuery(document).ready(function () {
 jQuery("#editForm").submit(function (e) {
 jQuery(".error").remove();
 jQuery.ajax({
 url: "/emp/update",
 context: document.body,
 type: 'post',
 data: jQuery(this).serialize()

 }).done(function (res) {
 if (res.status === "ERROR") {
 for (var key in res.errorsMap) {
 var err = "<span class=\"error\" id=\"" + key + "Id\">" + res.errorsMap[key] + "</span>";
 jQuery("[name^='" + key + "']").after(err);
 }
 } else {
 jQuery("#msg").html("Form submitted");
 $('#myModal').modal('hide');
 var $empTable =
 $("#emptable").dataTable({ bRetrieve: true });
 $empTable.fnDraw();

 }
 }).fail(function (data) {
 jQuery("#msg").html("<span class=\"error\">Server failed to process request</span>");
 });
 return false;
 });
 });*/

