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
	var status = validatePaymentForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	
	$("#formPayment").submit();
});
// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event) {
			$("#pidPaymentIDSave").val($(this).closest("tr").find('#pidPaymentIDUpdate').val());
			$("#payDate").val($(this).closest("tr").find('td:eq(0)').text());
			$("#payMethod").val($(this).closest("tr").find('td:eq(1)').text());
			$("#payAmount").val($(this).closest("tr").find('td:eq(2)').text());
			$("#PID").val($(this).closest("tr").find('td:eq(3)').text());
			$("#hosID").val($(this).closest("tr").find('td:eq(4)').text());
			$("#AppID").val($(this).closest("tr").find('td:eq(5)').text());
		
		});
// CLIENTMODEL=========================================================================
function validatePaymentForm() {
	// CODE
	if ($("#payDate").val().trim() == "") {
		return "Insert Payment Date.";
	}
	// NAME
	if ($("#payMethod").val().trim() == "") {
		return "Insert Payment Method.";
	}
	// PRICE-------------------------------

	if ($("#payAmount").val().trim() == "") {
		return "Insert Payment Amount.";
	}
	
	if ($("#PID").val().trim() == "") {
		return "Insert Patient ID.";
	}
	// NAME
	if ($("#hosID").val().trim() == "") {
		return "Insert Hospital ID.";
	}
	// PRICE-------------------------------

	if ($("#AppID").val().trim() == "") {
		return "Insert Appointment ID.";
	}
		
  return true;
}


