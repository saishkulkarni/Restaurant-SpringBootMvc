<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	 body{
            height: 100vh;
            width: 100vw;
            margin: 0px;
            flex-wrap: wrap;
            
        }
        .container{
            height: 100vh;
            width: 100vw;
            margin: 0px;
            border: .1px solid white;
            display: flex;
        }
        .item-box1{
            height: 100vh;
            width: 30vw;
            margin: 0px;
            border: .1px solid white;
        }
        .item-box2{
            height: 100vh;
            width: 70vw;
            margin: 0px;
            border: .1px solid white;
        }
        .items1{
            height: 10vh;
            width: 30vw;
            margin: 0px;
            border: .1px solid orange;
            color: white;
            background-color: orange;
        }
        .items2{
            height: 90vh;
            width: 30vw;
            border: .1px solid orange;
            background-color: orange;
            color: white;
        }
        .items3{
            height: 10vh;
            width: 70vw;
            margin: 0px;
            border: .1px solid black;
            display: flex;
            justify-content: space-around;
            align-items: center;
            align-content: space-around;
            background-color: black;
            color: white;
            text-decoration: transparent;
            
        }
        .items4{
            height: 90vh;
            width: 70vw;
            border: .1px solid black;
            background: url(./images/OIP.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            backface-visibility: hidden;
            box-decoration-break: transparent;
            color: white;
            text-decoration: transparent;
        }
        .head{
            
            
    height: 10vh;
    width: 70vw;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    font-size: 20px;
    background-color: black;
    color: white;
    flex-direction: row;
    flex-wrap: wrap;
    align-content: space-around;
        }
        a{
            text-decoration: transparent;
            color: white;
        }
		.footer{
            /* height: 4vh;
            width: 100vw; */
            /* border: 2px solid red; */
            /* background-color: orange; */
            display: flex;
            /* background-color: black; */
            margin: 0px;
            color: white;
        }

        .footer1{
            display: flex;
            width: 25%; 
            /* border: 2px solid red; */ 
          /* background-color: orange; */
        

        }

        .footer1 img{
            border-radius: 50%;
            height: 70px;
            width: 70px;
            /* margin-left: 7px;
            margin-top: -57px; */
            margin-top: 360px;
            margin-left: 12px;
        }

        .footer2 img{
            border-radius: 50%;
            height: 71px;
            width: 71px;
            /* margin-left: -220px;
            margin-top: -89px; */
            margin-left: 160px;
            margin-top: 360px;
        }

        .footer3 img{
            border-radius: 50%;
            height: 71px;
            width: 71px;
            /* margin-left: -130px;
            margin-top: -89px; */
            margin-top: 360px;
            margin-left: -180px;
        }
        

        
		table{
			margin-left: 150px;
			margin-top:100px;

		}
		button{
			margin-left: 250px;
			margin-top:10px;

		}
		h1{
			display:inline;
			margin-top:150px;
		}
		
        .cancel:hover{
            margin-left: 100px;
        }
</style>
</head>
<body>
	<h1 style="color: green">${pos}</h1>
	<h1 style="color: red">${neg}</h1>
	<div class="container">
        <div class="item-box1">
            <div class="items1">
                <h1 class="logo">On-Wheel   <img src="./images/motorcycle-solid.svg" alt="" style="height: 60px;width: 30px;margin-left:3px;margin-top: -40px;"></h1>
            </div>
            <div class="items2">
                <div class="footer">
                    
                    <div class="footer1"><img src="/images/download.png" alt=""></div>
                    <div class="footer2"><img src="/images/download (12).png" alt=""></div>
                    <div class="footer3"><img src="/images/images1-removebg-preview.png" alt=""></div>
                </div>
            </div>
        </div>
        <div class="item-box2">
            <div class="items3">
               
                <div class="the" style="margin-left: 0px;">
                    <h1 style="color: white;margin-left: -100px;"><i>Welcome TO Customer-Register</i></h1>
                </div>
                
                 <div class="box2">
            
                
            </div>
               
            </div>
	<div class="items4">
		<div class="item-box">
		 
		 <mvc:form action="/customer/signup" method="post" modelAttribute="customer">
			 <table cellspacing="2px" cellpadding="2px" style="color:black;">
				 <tr>
					 <th>Name:</th>
					 <th><mvc:input path="name" />    </th>
					 <th><mvc:errors path="name" /></th>
				 </tr>
				 <tr>
					 <th>Email:</th>
					 <th><mvc:input path="Email" /></th>
					 <th><mvc:errors path="Email" /></th>
				 </tr>
				 <tr>
					 <th>Password:</th>
					 <th><mvc:password path="password" /></th>
					 <th><mvc:errors path="password" /></th>
				 </tr>
				 <tr>
					 <th>Mobile:</th>
					 <th><mvc:input path="mobile" /></th>
					 <th><mvc:errors path="mobile" /></th>
				 </tr>
				 <tr></table>
			 <button type="submit">Login</button>
			 <button style="margin-left: 40px;" class="cancel">Cancel</button>
		 </mvc:form>
			 
					 
		 <div class="box5" style="margin-top: 0px;margin-left: 300px;height: 30px;width: 30px;background-color:transparent;border: none;">
			 <a href="/main" style="background-color:transparent;border: none;margin-left: 0px;"><button class="house" style="background-color: transparent;border: none;height: 100px;width: 150px;margin-left: 0px;color:black;font-size: 20px;">Back-to-Home <img src="./images/house-solid.svg" alt="" style="background-color:transparent;height: 50px;width: 50px;border: none;margin-top: 0px;margin-left: 0px;"></button></a>
		 </div>
		</div>
	</div>
</div>
</div>

</body>
</html>