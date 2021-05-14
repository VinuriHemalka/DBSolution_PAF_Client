//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#hidOrderIDSave").val("");
	$("#RESEARCHPROJECT")[0].reset();
});

$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	// If valid------------------------
	var type = ($("#project_ID").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "ResearchProjectAPI",
		type : type,
		data : $("#RESEARCHPROJECT").serialize(),
		dataType : "text",
		complete : function(response, status) {
			//console.log(status);
			onItemSaveComplete(response.responseText, status);
			window.location.reload(true);
		}
	});

});

function onItemSaveComplete(response, status) {
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#ResearchProjectGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error") {
		
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while saving...");
		$("#alertError").show();
	}
	
	$("#project_ID").val("");
	$("#RESEARCHPROJECT")[0].reset();
}

$(document).on("click", ".btnRemove", function(event) {
	
	$.ajax({
		url : "ResearchProjectAPI",
		type : "DELETE",
		data : "project_ID=" + event.target.value,
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
			window.location.reload(true);
		}
	});
});

function onItemDeleteComplete(response, status) {
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#ResearchProjectGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		
	} else if (status == "error") {
		
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event)
		{
			$("#project_ID").val($(this).closest("tr").find('td:eq(0)').text());
			$("#project_Name").val($(this).closest("tr").find('td:eq(1)').text());
			$("#cost").val($(this).closest("tr").find('td:eq(2)').text());
			$("#project_Category").val($(this).closest("tr").find('td:eq(3)').text());
			$("#description").val($(this).closest("tr").find('td:eq(4)').text());
					
		});


// CLIENTMODEL=========================================================================
function validateItemForm() {
	
	// Project Name
	if ($("#project_Name").val().trim() == "") {
		return "Please insert project name";
	}
	
	// Project Cost
	if ($("#cost").val().trim() == "") {
		return "Please insert project cost";
	}
	
	// Project Category
	if ($("#project_Category").val().trim() == "") {
		return "Please insert project category";
	}
	
	// Project Description
	if ($("#description").val().trim() == "") {
		return "Please insert project description";
	}
	
	return true;
}
