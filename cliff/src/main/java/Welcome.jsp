<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="./style/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<title>Cliff Co Expense Reimbursement Terminal</title>
</head>
<body>
	<div class="grid-container">
		<div class="item1" id="header-header">
			<header>

				<div class="grid-container-header" id="header-nav">
					<div class="item2-header" id="header-logins">
						<nav class="nav">
							<ul>
								<li id="brand">CLIFF CO</li>
								<li><a href="#">Home</a></li>
								<li><a href="#">About</a></li>
								<li style="float: right"><button type="button"
										class="button-login" id='employee-button'
										onclick="getLogoutPage()">
										<i class="far fa-address-card"></i>Employees Logout
									</button></li>
							</ul>
						</nav>

						<!-- <div class="item2-header" id="header-logins">
               <div >
                    <button type="button" class="button-login">Employees Area</button>
                    <button type="button" class="button-login">Managers Area</button>
                </div>
            </div> -->
					</div>
				</div>
				<h1 class="header-h1">CLIFF CO</h1>
			</header>
		</div>

		<div class="item2" id="menu">
			<p>Lorem ipsum dolor sit amet, meis ubique antiopam in est, ei
				autem nulla appellantur est. Mei dicant ignota appareat no. Ea eum
				malorum dolorum temporibus, munere imperdiet elaboraret eu nec. Vero
				reprimique philosophia eum ne. Vim omnium laboramus deterruisset an,
				affert insolens maiestatis nec an, mea oportere senserit ea. Eu
				oratio dissentias sea. Bonorum signiferumque sit ad, vel no dicta
				feugait dolores. His exerci accusamus necessitatibus et. Ne nec
				indoctum evertitur interesset, sit ut liber sonet nominati. Per
				indoctum expetendis eloquentiam eu, mei at epicuri laboramus
				assentior. Vim ei labitur inciderint voluptatibus, lucilius
				scripserit vituperatoribus vix no. Et mei melius placerat
				theophrastus. Sit id tractatos interesset, eu has ocurreret
				assentior tincidunt. Has et nemore meliore, mei diam choro dolorem
				te. Vim porro phaedrum ad, et ius habemus vivendo, eu dicit
				intellegat omittantur pri. Ius probo prodesset ea. Vis ipsum dolore
				voluptua eu, duo ne viris minimum eloquentiam. Eam stet movet in,
				fabellas inciderint cum et. Ut est dicat vidisse. Has eu laoreet
				praesent percipitur. Has eu tempor albucius quaerendum, autem
				admodum argumentum vel ea. Vel cu mutat deleniti intellegat.</p>
		</div>
		<div class="item3" id="main">
			<p id="ajaxText">
				<%
					String username = (String) request.getAttribute("Name");
				%>

				
				<h2>Welcome <%=username%></h2>
			<h2>Below are your account details</h2>
			<h3>First Name:</h3>
			<h3>Last Name:</h3>
			<h3>Email:</h3>
			<h3>Reimbursements Pending:</h3>
			<h3>Reimbursements Approved:</h3>
			<h3>Managers Name:</h3>
			<h2>Submit A New Reimbursement Request Below</h2>
			<form action="Reimbursement" method="post">
				<div class="loginContainer">
					<label for="ename"><b>Reimbursement Type</b></label> <input
						type="text" placeholder="Enter Reimbursement Type" name="rtype"
						required> <label for="receipt"><b>Receipt
							Upload</b></label> <input type="file" placeholder="Upload receipt file"
						name="rfile"> <input type="submit" name="submit"
						value="Submit Request">
				</div>
			</form>

		</div>
		<div class="item4" id="right">
			<p>Lorem ipsum dolor sit amet, meis ubique antiopam in est, ei
				autem nulla appellantur est. Mei dicant ignota appareat no. Ea eum
				malorum dolorum temporibus, munere imperdiet elaboraret eu nec. Vero
				reprimique philosophia eum ne. Vim omnium laboramus deterruisset an,
				affert insolens maiestatis nec an, mea oportere senserit ea. Eu
				oratio dissentias sea. Bonorum signiferumque sit ad, vel no dicta
				feugait dolores. His exerci accusamus necessitatibus et. Ne nec
				indoctum evertitur interesset, sit ut liber sonet nominati. Per
				indoctum expetendis eloquentiam eu, mei at epicuri laboramus
				assentior. Vim ei labitur inciderint voluptatibus, lucilius
				scripserit vituperatoribus vix no. Et mei melius placerat
				theophrastus. Sit id tractatos interesset, eu has ocurreret
				assentior tincidunt. Has et nemore meliore, mei diam choro dolorem
				te. Vim porro phaedrum ad, et ius habemus vivendo, eu dicit
				intellegat omittantur pri. Ius probo prodesset ea. Vis ipsum dolore
				voluptua eu, duo ne viris minimum eloquentiam. Eam stet movet in,
				fabellas inciderint cum et. Ut est dicat vidisse. Has eu laoreet
				praesent percipitur. Has eu tempor albucius quaerendum, autem
				admodum argumentum vel ea. Vel cu mutat deleniti intellegat.</p>

		</div>
		<div class="item5" id="footer">
			<footer>CLIFF CO COPYRIGHT &copy 2019</footer>
		</div>
	</div>
	<script src="./js/logoutAjax.js"></script>

</body>
</html>