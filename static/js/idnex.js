$(document).ready(function(){ 
    get_user_by_index();
    get_12video()
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
            
        }
    });
}
