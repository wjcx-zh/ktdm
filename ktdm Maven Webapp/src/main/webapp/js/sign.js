$(function(){
    $('#img').click(function(){
    $('#show-table').css("opacity","0");
    $(this).addClass('selected');
    $('#show-img').load("sign.jpg");//k.1从后台下载图片
    $("#show-img").css('display','block');
    });
   
    $('#table').click(function(){
    	$("#show-img").css('display','none');
         $('#show-table').css("opacity","1");
         $(this).addClass('selected');
         $('#table').css("display","block");
        $.getJSON('StudentInfo.json',function(data){//k.2从后台获取签到的StudentInfo.json文件
            $('#show-table').empty();
           
          
            var strHTML='';
            $.each(data,function(InfoIndex,Info){
                strHTML+='学号：'+Info['num']+' '+'姓名：'+Info['name']+"<br>";
            })
            $("#show-table").html(strHTML);
        });
    })
    

})