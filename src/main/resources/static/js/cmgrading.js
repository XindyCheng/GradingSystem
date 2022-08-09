function changeUinit(val){
	var unit1 = document.getElementById("unit1");
	unit.options.length = 0;
	$.getJSON("C:/Downloads/telecom/results3.json",function(data,status){
		console.log(status);
		if( status=='success'){
			jsondata = data;
		}
	});
}

private fun readGson() {
    //读取json，将json放到listString中
    var listString = FileIOUtils.readFile2String("C:/Downloads/telecom/results3.json")
    //将json变成json数组
    val jsonArray = JsonParser().parse(listString).asJsonArray       //这一步特别容易忘
    //定义gson
    val gson = Gson()
    //用gson将json的数组转换成数据模型
    for (js in jsonArray) {
        val nameBean = gson.fromJson(js, WorkModel::class.java)
        workModelList.add(nameBean)
    }
}
