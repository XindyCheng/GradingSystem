window.onload = function(){
	console.log("onload!");
	var unit1 = document.getElementById("unit1");
	document.getElementById("unit2").style.display='none';
	document.getElementById("unit3").style.display='none';
	document.getElementById("unit4").style.display='none';
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
}
function changeUnit1(val) {
	var unit2 = document.getElementById("unit2");
	unit2.options.length = 0;
	unit3.options.length = 0;
	unit4.options.length = 0;
	var mark = 0;
	document.getElementById("unit2").style.display='none';
	document.getElementById("unit2").style.display='none';
	document.getElementById("unit3").style.display='none';
	document.getElementById("unit4").style.display='none';
	for(var i = 0; i < departments.length; i++){
		if(departments[i]['p_id'] == val){
			var option = document.createElement("option");
			option.innerHTML = departments[i]['name'];
			option.value = departments[i]['id'];
			unit2.appendChild(option);
			mark = 1;
		}
	}
	if(mark == 1){
		document.getElementById("unit2").style.display='';
		document.getElementById("unit2").style.display='';
	}
}
function changeUnit2(val) {
	document.getElementById("unit3").style.display='none';
	document.getElementById("unit4").style.display='none';
	var unit3 = document.getElementById("unit3");
	unit3.options.length = 0;
	unit4.options.length = 0;
	var mark = 0;
	for(var i = 0; i < departments.length; i++){
		if(departments[i]['p_id'] == val){
			//console.log(val);
			var option = document.createElement("option");
			option.innerHTML = departments[i]['name'];
			option.value = departments[i]['id'];
			unit3.appendChild(option);
			mark = 1;
		}
	}
	if(mark == 1){
		document.getElementById("unit3").style.display='';
	}
}
function changeUnit3(val) {
	document.getElementById("unit4").style.display='none';
	var unit4 = document.getElementById("unit4");
	unit4.options.length = 0;
	var mark = 0;
	for(var i = 0; i < departments.length; i++){
		if(departments[i]['p_id'] == val){
			//console.log(val);
			var option = document.createElement("option");
			option.innerHTML = departments[i]['name'];
			option.value = departments[i]['id'];
			unit4.appendChild(option);
			mark = 1;
		}
	}
	if(mark == 1){
		document.getElementById("unit4").style.display='';
	}
}

function getAbilityStr(){
	//获取input所在div的对象  
    var ob = document.getElementById("div_ability");  
    //获取div中所用的IUPUT控件集合  
    var col = ob.getElementsByTagName("input");  
    //定义一个变量并初始化为空  
    var str = "";  
    var count = 0;  
    //循环遍历，判断INPUT是否选中  
    for (var i = 0 ; i < col.length; i++) {  
        if (col[i].checked == true) {  
            count++;  
            if (count == 1) {//当是一个值得时候，直接把选中的值赋给字符串  
                str += col[i].value;  
            }  
            else {  
                str += "，" + col[i].value;//多个被选中的时候，需要把选定的值不断的拼接  
            }  
            //str+=col[i].value+"/";  
        }  
    }  
    document.getElementById("ability").value = str;//把选择完后的字符串给一个隐藏空间以便向后台传送  
    console.log("涉及能力："+document.getElementById("ability").value);
}