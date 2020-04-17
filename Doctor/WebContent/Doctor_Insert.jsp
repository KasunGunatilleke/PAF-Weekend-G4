<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Doctor" %>
    
    
<%	
	if (request.getParameter("docName") != null) {
		Doctor Doctor_1 = new Doctor();
		String
		stsMsg = "";
		
		//Insert--------------------------
		if (request.getParameter("didDoctorIDSave") == "") {
			stsMsg = Doctor_1.insertDoctor(request.getParameter("docName"),
					request.getParameter("docAge"), request
							.getParameter("docGender"), request
							.getParameter("docSpecialization"));
		} else//Update----------------------
		{
			stsMsg = Doctor_1.updateDoctor(request.getParameter("didDoctorIDSave"),
							request.getParameter("docName"), request
									.getParameter("docAge"), request
									.getParameter("docGender"), request
									.getParameter("docSpecialization"));
		}
		session.setAttribute("statusMsg", stsMsg);
	}
	//Delete-----------------------------
	if (request.getParameter("didDoctorIDDelete") != null) {
		Doctor
		Doctor_1 = new Doctor();
		String
		stsMsg = Doctor_1.deleteDoctor(request
				.getParameter("didDoctorIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor_Insert</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./Components/Doctor.js"></script>
</head>
<body>
<form id="formDoctor" name="formDoctor" method="post" action="Doctor_Insert.jsp">
		Doctor Name: 
		<input id="docName" name="docName" type="text"
			class="form-control form-control-sm" required> <br>
	    Doctor Age:
	     <input id="docAge" name="docAge" type="text"
	      class="form-control form-control-sm"required > <br> 
		Doctor Gender: 
		<input id="docGender" name="docGender" type="text"
			class="form-control form-control-sm" required> <br> 
		Doctor Specialization:
		 <input id="docSpecialization" name="docSpecialization" type="text"  
			class="form-control form-control-sm" required> <br> 
		<input id="btnSave" name="btnSave" type="submit" value="Save" 
			class="btn btn-primary"  > 
		<input type="hidden" id="didDoctorIDSave" name="didDoctorIDSave" value="">
	</form>

	<div id"alertSuccess" class="alert alert-success">
		<%
			out.print(session.getAttribute("statusMsg"));
		%>

	</div>

	<%
	 Doctor d1= new Doctor();
	out.print(d1.readDoctor());
	%>
		<script language="javascript">



</body>
</html>