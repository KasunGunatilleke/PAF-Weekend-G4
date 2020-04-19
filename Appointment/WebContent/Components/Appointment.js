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
	var status = validateAppointmentForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	$("#formAppointment").submit();
});
// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event) {
			$("#aidAppointmentIDSave").val($(this).closest("tr").find('#aidAppointmentIDUpdate').val());
			$("#docID").val($(this).closest("tr").find('td:eq(0)').text());
			$("#AppDate").val($(this).closest("tr").find('td:eq(1)').text());
			$("#AppTime").val($(this).closest("tr").find('td:eq(2)').text());
			$("#PID").val($(this).closest("tr").find('td:eq(3)').text());
		});
// CLIENTMODEL=========================================================================
function validateAppointmentForm() {
	// CODE
//	if ($("#AppID").val().trim() == "") {
//		return "Insert Appointment ID.";
//	}
	
	if ($("#docID").val().trim() == "") {
		return "Insert Doctor ID.";
	}
	
	if ($("#AppDate").val().trim() == "") {
		return "Insert Appointment Date.";
	}
	
	if ($("#AppTime").val().trim() == "") {
		return "Insert Appointment Time.";
	}
	if ($("#PID").val().trim() == "") {
		return "Insert Patient ID.";
	}
	return true;
}

