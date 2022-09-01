window.onload = function(){
	console.log("onload!");
	var pmentry_open = document.getElementById("pmentry_open");//展开操作详情按钮 
	var pmentry_close = document.getElementById("pmentry_close");//关闭操作详情按钮
	pmentry_close.style.display = "none";
	var page = document.getElementById("page_wrapper");
	var fream = document.getElementById("pmentry_detail");
	fream.style.display = "none";
	
	var unit1 = document.getElementById("unit1");
	document.getElementById("unit2").disabled='disabled';
	document.getElementById("unit3").disabled='disabled';
	document.getElementById("unit4").disabled='disabled';
	unit1.options.length = 0;
	var option0 = document.createElement("option");
	option0.innerHTML = "--请选择单位--";
	option0.value = 'none';
	unit1.appendChild(option0);
	for(var i = 0; i < departments.length; i++){
		if(departments[i]['p_id'] == '0'){
			//创建option元素节点
			var option = document.createElement("option");
			//设置option元素节点的内容和value
			option.innerHTML = departments[i]['name'];
			option.value = departments[i]['id'];
			//将新创建的option节点添加到下拉框中
			unit1.appendChild(option);
		}
	}
	
	//操作详情表的展开和收起
	pmentry_open.onclick = function(){
		pmentry_close.style.display = "block";
		pmentry_open.style.display = "none";
		fream.style.display = "block";
		page.style.height = "2900px";
	};
	pmentry_close.onclick = function(){
		fream.style.display = "none";
		pmentry_close.style.display = "none";
		pmentry_open.style.display = "block";
		page.style.height = "2000px";
	};
}
function changeUnit1(val) {
	var unit2 = document.getElementById("unit2");
	unit2.options.length = 0;
	unit3.options.length = 0;
	unit4.options.length = 0;
	var mark = 0;
	document.getElementById("unit2").disabled='disabled';
	document.getElementById("unit3").disabled='disabled';
	document.getElementById("unit4").disabled='disabled';
	for(var i = 0; i < departments.length; i++){
		if(departments[i]['p_id'] == val){
			console.log(val);
			var option = document.createElement("option");
			option.innerHTML = departments[i]['name'];
			option.value = departments[i]['id'];
			unit2.appendChild(option);
			mark = 1;
		}
	}
	if(mark == 1){
		document.getElementById("unit2").disabled='';
	}
}
function changeUnit2(val) {
	document.getElementById("unit3").disabled='disabled';
	document.getElementById("unit4").disabled='disabled';
	var unit3 = document.getElementById("unit3");
	unit3.options.length = 0;
	unit4.options.length = 0;
	var mark = 0;
	for(var i = 0; i < departments.length; i++){
		if(departments[i]['p_id'] == val){
			console.log(val);
			var option = document.createElement("option");
			option.innerHTML = departments[i]['name'];
			option.value = departments[i]['id'];
			unit3.appendChild(option);
			mark = 1;
		}
	}
	if(mark == 1){
		document.getElementById("unit3").disabled='';
	}
}
function changeUnit3(val) {
	document.getElementById("unit4").disabled='disabled';
	var unit4 = document.getElementById("unit4");
	unit4.options.length = 0;
	var mark = 0;
	for(var i = 0; i < departments.length; i++){
		if(departments[i]['p_id'] == val){
			console.log(val);
			var option = document.createElement("option");
			option.innerHTML = departments[i]['name'];
			option.value = departments[i]['id'];
			unit4.appendChild(option);
			mark = 1;
		}
	}
	if(mark == 1){
		document.getElementById("unit4").disabled='';
	}
}

function changeProject(id,val){
	var msg = document.getElementById("project_msg");
	msg.innerHTML="<li>" + "当前项目：" + val + "</li>"+"<li>请对本项目的合作商进行评分</li>";
	//把项目参数传入controller中
	$.ajax({
		type: "POST",
		contentType: "application/json;charset=UTF-8",
		url: "/changeProjectCM?pm_id=" + id,
		data: {id},
		success: function (result) {
			console.log("cmgrading.js/changeProject:请求成功")
			console.log(result);
		},
			//请求失败，包含具体的错误信息
		error: function (e) {
			console.log("请求失败");
			console.log(e);
		}
	});
}