 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="model.Payment" %>
    
    
<%	
	if (request.getParameter("payID") != null) {
		Payment Payment_1 = new Payment();
		String
		stsMsg = "";
		
		//Insert--------------------------
		if (request.getParameter("pidPaymentIDSave") == "") {
			stsMsg = Payment_1.insertPayment(request.getParameter("payDate"),
					request.getParameter("payMethod"), request
							.getParameter("payAmount"));
		} else//Update----------------------
		{
			stsMsg = Payment_1.updatePayment(request.getParameter("pidPaymentIDSave"),
							request.getParameter("payDate"), request
									.getParameter("payMethod"), request
									.getParameter("payAmount"));
		}
		session.setAttribute("statusMsg", stsMsg);
	}
	//Delete-----------------------------
	if (request.getParameter("pidPaymentIDDelete") != null) {
		Payment
		Payment_1 = new Payment();
		String
		stsMsg = Payment_1.deletePayment(request
				.getParameter("pidPaymentIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
%>
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment_Insert</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./Components/Payment.js"></script>
</head>
<body>
 <form id="formPayment" name="formPayment" method="post" action="Payment_Insert.jsp">
		Payment Date: 
		<input id="payDate" name="payDate" type="text"
			class="form-control form-control-sm" required> <br>
	    payment Method:
	     <input id="payMethod" name="payMethod" type="text"  
			 class="form-control form-control-sm"required > <br> 
		Payment Amount: 
		<input id="payAmount" name="payAmount" type="text"
			class="form-control form-control-sm" required> <br> 
		<input id="btnSave" name="btnSave" type="submit" value="Save" 
			class="btn btn-primary"  > 
		<input type="hidden" id="pidPaymentIDSave" name="pidPaymentIDSave" value="">
	</form>

	<div id"alertSuccess" class="alert alert-success">
		<%
			out.print(session.getAttribute("statusMsg"));
		%>

	</div>

	<%
	 Payment p1= new Payment();
	out.print(p1.readPayment());
	%>
		<script language="javascript">
 
</body>
</html>