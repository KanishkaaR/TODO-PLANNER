<%@ page session="false"%>
<%@page import="java.util.*,bean.CalenderEvent,dao.CalenderEventDAO"%>



<!DOCTYPE html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/calender/calender.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css">
    <script src="${pageContext.request.contextPath}/calender/calender.js"></script>
</head>
<body>
        <div class="w3-sidebar w3-light-grey w3-bar-block" style="width:15% ">
            <h3 class="w3-bar-item">Menu</h3>
            <a href="../userStats/userStats.jsp" class="w3-bar-item w3-button">Home</a>
            <a href="../todo/todo.jsp" class="w3-bar-item w3-button">Todo</a>
            <a href="../custom/custom.jsp" class="w3-bar-item w3-button">Custom</a>
            <a href="../calender/calender.jsp" class="w3-bar-item w3-button w3-grey">Calendar</a>
        </div>
        <div class="w3-sidebar w3-light-grey w3-bar-block" style="width:30%; right:0">
        <div style="background:black;">
                <h2 style="margin-left: 120px;color:white;" id="selectedDate">Hello</h2>
            </div>
            <div style="background:black;">
                <h3 style="margin-left: 170px;color:white;">Tasks</h3>
            </div>
            <div class="w3-cell-row" style="max-height:200px; overflow: hidden;">
                <ul class="w3-ul" id="TaskList" style="height:200px;overflow-y: scroll;">
                    
                  </ul>
                  <hr style="width: 60%;margin-left: auto;margin-right: auto;color:black"></hr>
            </div>
            <div style="background:black;">
                <h3 style="margin-left: 170px;color:white;">Events</h3>
            </div>
            <div class="w3-cell-row" style="max-height:200px; overflow: hidden;">
                <div class="w3-cell-row" style="max-height:200px; overflow: hidden;">
                    <ul class="w3-ul w3-card-4" id="eventList" style="height:200px;overflow-y: scroll;">
                        
                      </ul>
                      <hr style="width: 60%;margin-left: auto;margin-right: auto;color:black"></hr>
                </div>
            </div>
            <div class="container">
                <button class="w3-button w3-black" onclick="document.getElementById('id01').style.display='block'" style="margin-left: 150px;">Add event</button>
                <div id="id01" class="w3-modal">
                    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
                
                      <div class="w3-center"><br>
                        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                        <h4>Add event</h4>
                      </div>
                
                      <form class="w3-container">
                        <div class="w3-section">
                          <label><b>Event name</b></label>
                          <input class="w3-input w3-border w3-margin-bottom" id="eventName" type="text" placeholder="Enter Event Name" name="eventname" required>
                         <label><b>Date</b></label>
                      <input class="w3-input w3-border w3-margin-bottom" type="date" id="eventFrmDate" placeholder="Enter Event date" name="eventdate" required>
                          <button class="w3-button w3-block w3-dark-grey w3-section w3-padding" id="addEventBtn" type="submit">Add</button>
                        </div>
                    </form>
                    </div>
                  </div>
                
            </div>
        </div>
        <div style="margin-top:30px" id="calendar"></div> 
        
</body>