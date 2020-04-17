$(document).ready(function(){ 
    get_user_by_index();
    
    get_12video();
    get_area_video();
});
//根据id获取用户信息
function get_user_by_index(){
    $.ajax({
        async: false,
        type:"POST",
        url:"/user_post_by_index",
        //data:{"card":card,"pwd":pwd}
        }).done(function(msg){
        if(msg != null){
            //window.location.href="/"
            console.log("回调数据成功")
            console.log(msg.userID)
            if(msg.userID!=undefined){
                $('#login-btt').css("display","none");
                $('#user-info').css("display","block");
                $('#user-info').html(msg.name+"<span class='caret'></span>");
            }
        }
    });
}
function get_12video(){
    $.ajax({
        async: false,
        type:"POST",
        url:"/get_index_12video",
        //data:{"card":card,"pwd":pwd}
        }).done(function(msg){
        if(msg != null){
            console.log("回调推荐视频成功")
            console.log(msg.vids)
            for(var i=0;i<msg.vids.length;i++){
                $('#12v').append(
                    "<div class='pr-video'>"+
                    "<img src='"+msg.vids[i].FCUrl+"' alt=''>"+
                    "<p id='big-video-title'>"+msg.vids[i].Title+"</p>"+
                    "<a href='/dd?"+msg.vids[i].ID+"'>"+"<div class='mask'>"+
                        "<p id='mask-title'>"+msg.vids[i].Title+"</p>"+
                        "<p id='mask-up'>UP: eisuto</p>"+
                        "<p id='mask-click'><i class='glyphicon glyphicon-expand'></i>"+msg.vids[i].Play+"</p>"+
                    "</div></a>"+
                    "</div>"
                )
            }
        }
    });
}
//获取指定分区首页视频
function get_area_video(){
    $.ajax({
        async: false,
        type:"POST",
        url:"/get_index_animeVideo",
        //data:{"card":card,"pwd":pwd}
        }).done(function(msg){
        if(msg != null){
            console.log("回调推荐视频成功")
            console.log(msg.vids)
            for(var i=0;i<msg.vids.length;i++){
                var time_m = parseInt(msg.vids[i].Duration/60);
                var time_s = parseInt(msg.vids[i].Duration%60);
                $('#anime-video').append(
                    "<div class='area-one'>"+
                            "<div class='area-video'>"+
                            "<img src='"+msg.vids[i].FCUrl+"' alt=''>"+
                                "<div class='yinying'></div>"+
                                "<p>"+
                                    "<i class='glyphicon glyphicon-expand'></i>"+
                                    msg.vids[i].Play+
                                    "<i class='glyphicon glyphicon-heart'></i>"+
                                    msg.vids[i].Like+
                                    "<span class='mask-time'>"+formatDuraton(msg.vids[i].Duration)+"</span>"+
                                "</p>"+
                                "<a href='/dd?"+msg.vids[i].ID+"'>"+
                                    "<div class='area-mask'>"+                                  
                                        "<p><i class='glyphicon glyphicon-play-circle'></i></p>"+
                                    "</div>"+
                                "</a>"+
                            "</div>"+
                            "<div class='video-title'>"+
                                "<p>"+msg.vids[i].Title+"</p>"+
                            "</div>"+
                        "</div>"
                )
            }
        }
    });
}

//视频时长转换
function formatDuraton(time){
    if(time > -1){
        var hour = Math.floor(time/3600);
        var min = Math.floor(time/60) % 60;
        var sec = time % 60;
        if(hour < 10) {
            time = '0'+ hour + ":";
        } else {
            time = hour + ":";
        }

        if(min < 10){
            time += "0";
        }
        time += min + ":";

        if(sec < 10){
            time += "0";
        }
        time += sec;
    }
    return time;
}