<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
  <%@ page import="model.Patient" %>  
<% 
   if (request.getParameter("PatientName") != null) {
    Patient Patient_1 = new Patient();
    String
    stsMsg = "";
    
    //Insert--------------------------
    if (request.getParameter("hidPatientIDSave") == "") {
        stsMsg = Patient_1.insertPatient(request.getParameter("PatientName"),
                request.getParameter("Gender"), request
                        .getParameter("Email"), request
                        .getParameter("Phone"), request
                        .getParameter("Address"), request
                        .getParameter("Password"), request
                        .getParameter("ConfirmPassword"));
    } else//Update----------------------
    {
        stsMsg = Patient_1.updatePatient(request.getParameter("hidPatientIDSave"),
                        request.getParameter("PatientName"), request
                                .getParameter("Gender"), request
                                .getParameter("Email"), request
                                .getParameter("Phone"), request
                                .getParameter("Address"), request
                                .getParameter("Password"), request
                                .getParameter("ConfirmPassword"));
    }
    session.setAttribute("statusMsg", stsMsg);
   }
   //Delete--------------------------------
   if (request.getParameter("hidPatientIDDelete") != null) {
	Patient
    Patient_1 = new Patient();
    String
    stsMsg = Patient_1.deletePatient(request
            .getParameter("hidPatientIDDelete"));
    session.setAttribute("statusMsg", stsMsg);
   }
   %>    	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient_Insert</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./Components/Patient.js"></script>
</head>
<body>

	<div class="container">
		<h2>Patient Register Details</h2>
		
		<form class="formPatient" name="formPatient" method="post" action="Patient_Insert.jsp">
				<div class="form-group">
				
					<lable for="PatientName">Patient Name:</lable>
					<input type="PatientName" class="form-control"  id="PatientName" placeholder="Enter your Name" name="PatientName"><br>
					
					<lable for="Gender">Gender:</lable>
					<input type="radio" name="Gender" value="Male" class="form-radio">Male
				    <input type="radio" name="Gender" value="Female" class="form-radio">Female<br><br>
					
					<lable for="Email">Email:</lable>
					<input type="Email" class="form-control"  id="Address" placeholder="Enter your Address" name="Email"><br>
					
					<lable for="Phone">Phone:</lable>
					<input type="Phone" class="form-control"  id="Phone" placeholder="Enter your Contact number" name="Phone"><br>
					
					<lable for=" Address"> Address:</lable>
					<input type=" address" class="form-control"  id=" address" placeholder="Enter your Address" name="address"><br>
								
					<lable for=" Password"> Password:</lable>
					<input type="Password" class="form-control" id="Password" placeholder="Enter your password" name="Password"><br>
									
					<lable for="ConfirmPassword"> ConfirmPassword:</lable>
					<input type="Password" class="form-control" id="ConfirmPassword" placeholder="Enter your ConfirmPassword" name="ConfirmPassword"><br>
					
					<input id="btnSave" name="btnSave" type="submit" value="Save"
			          class="btn btn-primary"> 
										
					</div> 
				   </form>
				   
				   <div id"alertSuccess" class="alert alert-success">
		            <%
			          out.print(session.getAttribute("statusMsg"));
	             	%>

	             </div>
	             
	               <%
	                Patient patientObj = new Patient();
	                 out.print(patientObj.readPatient());
                	%>
		            <script language="javascript">
	             
</body>
</html>