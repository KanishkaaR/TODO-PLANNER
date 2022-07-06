$(function(){
$.get("/todo-planner/customTaskServlet/getAll",
	{
		user_id:1,	
	},
	function(responseJson,status){
		$("#customTaskContainer").text("");
		$.each(responseJson, function(index, product) {
			var $divCard = $(`<div class="w3-card-4 card customDiv" style="width:20%;" ></div>`).appendTo("#customTaskContainer");
			var $divContainer = $(`<div class="w3-container"></div>`).appendTo($divCard);
			var $divContent=$(`<div class="widget-content-right"></div>`).appendTo($divContainer);
			if(product.completed){
				$(`<div class="badge badge-success ml-2">COMPLETED</div>`).appendTo($divContent);
			}
			$comBtn=$(`<button class="border-0 btn-transition btn btn-outline-success customClassAddBtn" > <i class="fa fa-check"></i></button>`).appendTo($divContent);
			$delBtn=$(`<button class="border-0 btn-transition btn btn-outline-danger customClassDelBtn"> <i class="fa fa-trash"></i> </button>`).appendTo($divContent);
			($comBtn).val(product.custom_task_id);
			($delBtn).val(product.custom_task_id);
			$divHeader=$(`<div class="customClassHeader"></div>`).appendTo($divCard);
			($divHeader).data("id",product.custom_task_id);
			($divHeader).data("task",product.task_name);
			$header=$(`<header class="w3-container w3-blue"></header>`).appendTo($divHeader);
			$header1=$(`<h1></h1>`).appendTo($header);
			($header1).text(product.task_name);
			$divContainer2=$(`<div class="w3-container"></div>`).appendTo($divCard);
			$divP=$(`<p></p>`).appendTo($divContainer2);
			($divP).text(product.desc);
			
			
			
		});
	});
$("#addCustomTaskButton").click(function(){
		//alert("hahaha");
		var user_id = "1";
		var task_name = $("#custom_task_name").val();
		var task_desc = $("#custom_task_desc").val();
		
		//alert(user_id + task_name +task_desc);
		
		  $.get("/todo-planner/customTaskServlet/insert",
		  {
		    user_id : user_id,
		    task_name : task_name,
		    task_desc : task_desc,
		  },
		  function(data, status){
		    //alert("Data: " + data + "\nStatus: " + status);
		    location.reload(true);
		  });
		});
		$("#customTaskContainer").on("click",".customClassAddBtn",function(){
		alert("Task completed. Congratulations");
		var custom_task_id = $(this).val();
		//alert(custom_task_id);
		$.get("/todo-planner/customTaskServlet/complete",
		  {
		    custom_task_id:custom_task_id,
		  },
		  function(data, status){
		    //alert("Data: " + data + "\nStatus: " + status);
		    location.reload(true);
		  });
	})
	$("#customTaskContainer").on("click",".customClassDelBtn",function(){
		alert("Deleting task");
		var custom_task_id = $(this).val();
		//alert(custom_task_id);
		$.get("/todo-planner/customTaskServlet/delete",
		  {
		    custom_task_id:custom_task_id,
		  },
		  function(data, status){
		    //alert("Data: " + data + "\nStatus: " + status);
		    location.reload(true);
		  });
	});
	
	
	
	$("#customTaskContainer").on("click",".customClassHeader",function(){
		//alert("Clicked");
		var custom_task_id = $(this).data("id");
		var task_name = $(this).data("task");
		//alert(custom_task_id);
		$(".CustomTaskHeading").text(task_name);
		$("#custom_task_id").val(custom_task_id);
		$.get("/todo-planner/subTaskServlet/getAll",
		{
			custom_task_id:custom_task_id,
		}, 
		function(responseJson,status) {          // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
       	$(".subTaskList").text(""); // Create HTML <table> element and append it to HTML DOM element with ID "somediv".
        $.each(responseJson, function(index, product) {
				//alert(index);
				var subTaskLi = $('<li class="timeline-item bg-white rounded ml-3 p-4 shadow"><div class="timeline-arrow"></div></li>');
				$(".subTaskList").append(subTaskLi);
				if(product.completed){
					$(`<div class="badge badge-success ml-2 ">COMPLETED</div>`).appendTo(subTaskLi);
				}
				var $subTaskBtnDiv = $(`<div class="widget-content-right"></div>`).appendTo(subTaskLi);
				var $completeBtn = $('<button class="border-0 btn-transition btn btn-outline-success completeSubTaskBtn"> <i class="fa fa-check"></i></button>').appendTo($subTaskBtnDiv);
				var $deleteBtn = $('<button class="border-0 btn-transition btn btn-outline-danger deleteSubTaskBtn"> <i class="fa fa-trash"></i> </button> ').appendTo($subTaskBtnDiv);
                var $subTaskHeader = $(`<h2 class="h5 mb-0 subTaskHeader"></h2>`).appendTo(subTaskLi);
                ($completeBtn).val(product.sub_task_id);
                ($deleteBtn).val(product.sub_task_id);
                ($subTaskHeader).text(product.task_name);
                var dummy = product.deadline.split(',');
                var dummy2 = dummy[2].split(':');
                var hrs = dummy2[0];
                var mins = dummy2[1];
				var $subTaskSpan = $('<span class="small text-gray"><i class="fa fa-clock-o mr-1"></i></span>').appendTo(subTaskLi);
				($subTaskSpan).append(dummy[0]+" , "+dummy[1]+", "+hrs+" : "+mins);
				var $subTaskDesc = $('<p class="text-small mt-2 font-weight-light"></p>').appendTo(subTaskLi);
				($subTaskDesc).text(product.desc);
				   
        });
    });
    $("#custom-modal").css("display", "block");
	});
	
	$("#addSubTaskButton").click(function(){
		//alert("hahaha");
		var custom_task_id = $("#custom_task_id").val();
		var task_name = $("#custom_subtask_name").val();
		var task_desc = $("#custom_subtask_desc").val();
		var deadline = $('#deadline').val();
		deadline = deadline.split('T')[0] +" "+ deadline.split('T')[1]
		
		//alert(custom_task_id + task_name +deadline+task_desc);
		
		  $.get("/todo-planner/subTaskServlet/insert",
		  {
		    custom_task_id : custom_task_id,
		    task_name : task_name,
		    deadline : deadline,
		    desc:task_desc,
		  },
		  function(data, status){
		    //alert("Data: " + data + "\nStatus: " + status);
		    location.reload(true);
		  });
		});
		
		$('.subTaskList').on('click', '.completeSubTaskBtn', function() {
		alert("Task completed. Congratulations");
		var task_id = $(this).val();
		//alert(task_id);
		$.get("/todo-planner/subTaskServlet/complete",
		  {
		    sub_task_id:task_id,
		  },
		  function(data, status){
		    //alert("Data: " + data + "\nStatus: " + status);
		    location.reload(true);
		  });
	});
	$('.subTaskList').on('click', '.deleteSubTaskBtn', function() {
		//alert("delete clicked");
		alert("Deleting task");
		var task_id = $(this).val();
		//alert(task_id);
		$.get("/todo-planner/subTaskServlet/delete",
		  {
		    sub_task_id:task_id,
		  },
		  function(data, status){
		    //alert("Data: " + data + "\nStatus: " + status);
		    location.reload(true);
		  });
	});

});