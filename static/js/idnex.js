$(document).ready(function(){ 
    get_user_by_index();
    
    get_12video();
    get_area_video();
});
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
                    "<a href='./static/img/video/"+msg.vids[i].ID+".mp4'><div class='mask'>"+
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
                                    "<span class='mask-time'>"+msg.vids[i].Duration+"</span>"+
                                "</p>"+
                                "<a href='./static/img/video/"+msg.vids[i].ID+".mp4'>"+
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