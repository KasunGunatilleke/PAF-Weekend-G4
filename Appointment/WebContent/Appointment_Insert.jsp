<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Appointment" %>
    
    
<%	
	if (request.getParameter("DocID") != null) {
		Appointment Appointment_1 = new Appointment();
		String
		stsMsg = "";
		
		//Insert--------------------------
		if (request.getParameter("aidAppointmentIDSave") == "") {
			stsMsg = Appointment_1.insertAppointment(request.getParameter("DocID"),
					request.getParameter("AppDate"), request
							.getParameter("AppTime"), request
							.getParameter("patient_id"));
		} else//Update----------------------
		{
			stsMsg = Appointment_1.updateAppointment(request.getParameter("aidAppointmentIDSave"),
							request.getParameter("DocID"), request
									.getParameter("AppDate"), request
									.getParameter("AppTime"), request
									.getParameter("patient_id"));
		}
		session.setAttribute("statusMsg", stsMsg);
	}
	//Delete-----------------------------
	if (request.getParameter("aidAppointmentIDDelete") != null) {
		Appointment
		Appointment_1 = new Appointment();
		String
		stsMsg = Appointment_1.deleteAppointment(request
				.getParameter("aidAppointmentIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
%>	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment_Insert</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./Components/Appointment.js"></script>
</head>
<body>
	<form id="formAppointment" name="formAppointment" method="post" action="Appointment_Insert.jsp">
	    Doctor ID:
	     <input id="DocID" name="DocID" type="text" 
			class="form-control form-control-sm"required > <br> 
		Appointment Date: 
		<input id="AppDate" name="AppDate" type="date"
			class="form-control form-control-sm" required> <br> 
		Appointment Time:
		 <input id="AppTime" name="AppTime" type="time"  
			class="form-control form-control-sm" required> <br> 
		Patient ID:
		 <input id="patient_id" name="patient_id" type="text"  
			class="form-control form-control-sm" required> <br> 
		<input id="btnSave" name="btnSave" type="submit" value="Save" 
			class="btn btn-primary"  > 
		<input type="hidden" id="aidAppointmentIDSave" name="aidAppointmentIDSave" value="">
	</form>

	<div id"alertSuccess" class="alert alert-success">
		<%
			out.print(session.getAttribute("statusMsg"));
		%>

	</div>

	<%
	Appointment a1= new Appointment();
	out.print(a1.readAppointment());
	%>
		<script language="javascript">

		
</body>
</html>