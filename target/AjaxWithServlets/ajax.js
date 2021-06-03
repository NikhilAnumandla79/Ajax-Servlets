/**
 * 
 */
function postUserData(){
	var fullname = $("#fullname").val();
	var age = $("#age").val();
	var married = $("#married").is(":checked");
	var gender = $("#gender:checked").val();
	
	var data = {
	   fullname : fullname,
	   age:age,
	   married:married,
	   gender:gender}
	
	$.ajax({
		url:"postDataServlet",
		data:{"data":JSON.stringify(data)},
		success:function(data){
		$("#data").text(fullname +" "+age+" "+married+" "+gender);
		}
	});
	
	
	
	
	
}