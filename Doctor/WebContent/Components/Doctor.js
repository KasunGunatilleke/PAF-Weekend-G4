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
	var status = validateDoctorForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	$("#formDoctor").submit();
});
// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event) {
			$("#didDoctorIDSave").val($(this).closest("tr").find('#didDoctorIDUpdate').val());
			$("#docName").val($(this).closest("tr").find('td:eq(0)').text());
			$("#docAge").val($(this).closest("tr").find('td:eq(1)').text());
			$("#docGender").val($(this).closest("tr").find('td:eq(2)').text());
			$("#docSpecialization").val($(this).closest("tr").find('td:eq(3)').text());
		});
// CLIENTMODEL=========================================================================
function validateDoctorForm() {
	// CODE
	if ($("#docName").val().trim() == "") {
		return "Insert Doctor name.";
	}
	// NAME
	if ($("#docAge").val().trim() == "") {
		return "Insert Doctor Age.";
	}
	// PRICE-------------------------------

	if ($("#docGender").val().trim() == "") {
		return "Insert Doctor Gender.";
	}
	
	if ($("#docSpecialization").val().trim() == "") {
		return "Insert Doctor Specialization.";
	}
	return true;
}

