<%@ page session="false"%>
<%@page import="java.util.*,bean.CustomTask,bean.SubTask,dao.CustomTaskDAO,dao.SubTaskDAO"%>



<%  
List<CustomTask> list=CustomTaskDAO.getAllTasks(1);  
request.setAttribute("list",list);  
%>  

<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/custom/custom.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/custom/custom.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css">
</head>

<body>
    <div class="w3-sidebar w3-light-grey w3-bar-block" style="width:15%; margin-top: 0%;">
        <h3 class="w3-bar-item">Menu</h3>
        <a href="../userStats/userStats.jsp" class="w3-bar-item w3-button">Home</a>
        <a href="../todo/todo.jsp" class="w3-bar-item w3-button">Todo</a>
        <a href="../custom/custom.jsp" class="w3-bar-item w3-button w3-grey">Custom</a>
        <a href="../calender/calender.jsp" class="w3-bar-item w3-button">Calendar</a>
    </div>
    <div class="card-container" id="customTaskContainer">
    
    	
        
        
    </div>
    <div class = "container">
    <button class="btn btn-primary" style = "margin-left:50px;" onclick = "document.getElementById('custom_addTask').style.display='block'">Add Task</button>
    </div>

    <div class="container">
        <!-- <button class="w3-button w3-black" onclick="document.getElementById('id01').style.display='block'" style="margin-left: 150px;">Add event</button> -->
        <div id="custom-modal" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom custom-modal-container" style="max-width:1000px">
            
        
              <div class="w3-center"><br>
                <span onclick="document.getElementById('custom-modal').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                <h4 class="CustomTaskHeading"></h4>
              </div>
              <div class="container py-5">
              <button class="btn btn-primary" style = "margin-left:50px;" onclick = "document.getElementById('custom_addSubTask').style.display='block'">Add Task</button>
                    <div class="row">
                        <div class="col-lg-7 mx-auto">
                        	<input type="text" id="custom_task_id" value="0" name="custom_task_id" hidden>
                            <ul class="timeline subTaskList">
                            </ul>
            
                        </div>
                    </div>
                </div>
            
            </div>
          </div>
        
    </div>
	    <div class="container">
        <!-- <button class="w3-button w3-black" onclick="document.getElementById('id01').style.display='block'" style="margin-left: 150px;">Add event</button> -->
        <div id="custom_addTask" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
        
              <div class="w3-center"><br>
                <span onclick="document.getElementById('custom_addTask').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                <h4>Add Task</h4>
              </div>
        
              <form class="w3-container" id="addCustomTaskForm">
                <div class="w3-section">
                  <label><b>Task title</b></label>
                  <input class="w3-input w3-border w3-margin-bottom" id="custom_task_name" type="text" placeholder="Enter Task title" name="tasktitle" required>
                  <br><br>
                  <input class="w3-input w3-border w3-margin-bottom" id="custom_task_desc" type="text" placeholder="Enter Task description" name="taskdesc" required>
                  <br><br>
                  
                  <input class="w3-button w3-block w3-dark-grey w3-section w3-padding" type="button" id="addCustomTaskButton" value="Add">
                </div>
            </form>
            </div>
          </div>
          
          
          <div class="container">
        <!-- <button class="w3-button w3-black" onclick="document.getElementById('id01').style.display='block'" style="margin-left: 150px;">Add event</button> -->
        <div id="custom_addSubTask" class="w3-modal">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
        
              <div class="w3-center"><br>
                <span onclick="document.getElementById('custom_addSubTask').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
                <h4>Add Sub Task</h4>
              </div>
        
              <form class="w3-container" id="addCustomTaskForm">
                <div class="w3-section">
                  <label><b>Task title</b></label>
                  <input class="w3-input w3-border w3-margin-bottom" id="custom_subtask_name" type="text" placeholder="Enter Task title" name="subtasktitle" required>
                  <br><br>
                  <label><b>Task Description</b></label>
                  <input class="w3-input w3-border w3-margin-bottom" id="custom_subtask_desc" type="text" placeholder="Enter Task description" name="subtaskdesc" required>
                  <br><br>
                  <label for="deadlinetime"><b>Deadline</b></label>
                  <input type="datetime-local" id="deadline" name="deadline" required>
                  <br><br>
                  
                  <input class="w3-button w3-block w3-dark-grey w3-section w3-padding" type="button" id="addSubTaskButton" value="Add">
                </div>
            </form>
            </div>
          </div>
        
    </div>


</body>