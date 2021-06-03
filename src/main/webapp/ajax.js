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
	   gender:gender
	   }
	
	$.ajax({
		url:"postDataServlet",
		type:"post",
		data:{"data":JSON.stringify(data)},
		success:function(data){
		$("#data").text(fullname +" "+age+" "+married+" "+gender);
		}
	});

	
}

function getAPIData(){
	$.ajax({
		url:"https://restcountries.eu/rest/v2/all",
		type:"get",
		dataType:"json",
		success:function(data){
			console.log("entered");
			$.ajax({
				url:"postCountriesServlets",
				type:"post",
				data:{"data":JSON.stringify(data)},
				success:function(data){
				
					var array=JSON.parse(data);
					var input="<table border=1>";
					for(var i=0;i<array.length;i++){
						var obj = array[i];
						input+="<tr><td>"+obj.name+"</td><td>"+obj.capital+"</td><td>"+obj.region+"</td></tr>";
					}
					input+="</table>";
					$("#countries").html(input);
				}
			
			});
		}
	});

}