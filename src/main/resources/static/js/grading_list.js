/**
 * 客户经理与交付经理页面显示列表
 */
function toDetail(val_id){
	console.log("进入toDetail()")
	document.getElementById("div_list").style.display = "none";;
	document.getElementById("div_project").style.display = "block";
	console.log("toDetail:" + val_id)
	$.ajax({
		type: "POST",
		contentType: "application/json;charset=UTF-8",
		url: "/detail?id=" + val_id,
		data: {val_id},
		success: function (result) {
			console.log("请求成功")
			console.log(result);
			$("#name").html(result.name);
			$("#supplier").html(result.supplier);
			$("#client").html(result.client);
			$("#pmname").html(result.pmname);
			$("#cmname").html(result.cmname);
			$("#dmname").html(result.dmname);
			console.log("项目详情加载完毕");
			
		},
			//请求失败，包含具体的错误信息
		error: function (e) {
			console.log("请求失败");
			console.log(e);
		}
	});
}

function backtoList(){
	var div1 = document.getElementById("div_list");
	var div2 = document.getElementById("div_project");
	div1.style.display = "block";
	div2.style.display = "none";
}

//调用父窗口的函数，把项目参数传入父窗口
function selectProject(that){
	var val = that.getAttribute('project_name');
	var id = that.value;
	console.log("传入id值:" + id);
	window.parent.changeProject(id,val);
}