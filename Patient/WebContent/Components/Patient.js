$(document).ready(function() {
    if ($("#alertSuccess").text().trim() == "") {
        $("#alertSuccess").hide();
    }
    $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
    // Clear alerts---------------------
    $("#alertSuccess").text("");
    $("#alertSuccess").hide();
    $("#alertError").text("");
    $("#alertError").hide();
    // Form validation-------------------
    var status = validatePatientForm();
    if (status != true) {
        $("#alertError").text(status);
        $("#alertError").show();
        return;
    }
    // If valid------------------------
    $("#formPatient").submit();
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
    $("#hidPatientIDSave").val($(this).closest("tr").find('#hidPatientIDUpdate').val());
    $("#PatientName").val($(this).closest("tr").find('td:eq(0)').text());
    $("#Gender").val($(this).closest("tr").find('td:eq(1)').text());
    $("#Email").val($(this).closest("tr").find('td:eq(2)').text());
    $("#Phone").val($(this).closest("tr").find('td:eq(3)').text());
    $("#address").val($(this).closest("tr").find('td:eq(4)').text());
    $("#Password").val($(this).closest("tr").find('td:eq(5)').text());
    $("#ConfirmPassword").val($(this).closest("tr").find('td:eq(6)').text());
});
// CLIENTMODEL=========================================================================
function validatePatientForm() {
    // CODE
    if ($("#PatientName").val().trim() == "") {
        return "Insert patient name.";
    }
    // NAME
    if ($("#Gender").val().trim() == "") {
        return "Insert patient gender.";
    }
    // PRICE-------------------------------

    if ($("#Email").val().trim() == "") {
        return "Insert patient email.";
    }

    if ($("#Phone").val().trim() == "") {
        return "Insert patient Contact Number.";
    }
    // PRICE-------------------------------

    if ($("#address").val().trim() == "") {
        return "Insert patient Address.";
    }
    
    if ($("#Password").val().trim() == "") {
        return "Insert password.";
    }
    
    if ($("#ConfirmPassword").val().trim() == "") {
        return "confirm password.";
    }
    return true;
}