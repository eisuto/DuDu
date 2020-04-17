var videoObject = {
    logo: 'dudu', //设置logo，非必须
    container: '#video',//“#”代表容器的ID，“.”或“”代表容器的class
    variable: 'player',//该属性必需设置，值等于下面的new chplayer()的对象
    video:'../static/img/video/'+location.search.substr(1)+'.mp4'//视频地址
};
$(document).ready(function(){ 
    get_user_by_index();
    new chplayer(videoObject);
    getVoideInf();
    $("div[class^='menu']").html(" ");
    $("div[class^='logo']").html(" ");
    getComments();

});
var videoTime;
var uid = -1;
//增加评论
function addComment(){
    var comm = $('#public-comm').val();
    console.log(comm);
    console.log(uid);
    $.ajax({
        async: false,
        type:"POST",
        url:"/post_comment",
        data:{"uid":location.search.substr(1),"vid":location.search.substr(1),"comm":comm}
        }).done(function(msg){
        if(msg != null){

        }
    });
}
function timeFormatter(value) {

        var da = new Date(value.replace("/Date(", "").replace(")/" , "").split( "+")[0]);
    
        return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();
    
    }
//获取视频信息
function getVoideInf(){
    console.log(location.search.substr(1))
    $.ajax({
        async: false,
        type:"POST",
        url:"/get_video_info",
        data:{"id":location.search.substr(1)}
        }).done(function(msg){
        if(msg != null){
            videoTime  = timeFormatter(msg.v.CreatedAt);
            console.log(msg.v)
            $('#title').text(msg.v.Title);
            $('#play-date').text(msg.v.Play+" 次观看 · "+videoTime);
            $('#comment-size').text(msg.v.Comm+" 条评论")
            $('#like').text(" "+msg.v.Like);
            $('#unlike').text(" "+msg.v.UnLike);
            $('#introduc').text(msg.v.Introduc);
        }
    });
}
//计算时间差
function time_last(t1){
    t1 = timeFormatter(t1);
    var date1 = new Date();
    var date2 = new Date(t1.replace(/\-/g, "/"));
    var date3 = date1.getTime()-date2.getTime(); 
    var days  = Math.floor(date3/(24*3600*1000));
    return days;

}
//获取评论
function getComments(){
    $.ajax({
        async: false,
        type:"POST",
        url:"/get_comments",
        data:{"uid":location.search.substr(1),"vid":location.search.substr(1)}
        }).done(function(msg){
        if(msg != null){
            //window.location.href="/"
            console.log("回调全部评论成功");
            console.log(msg);
            for(var i=0;i<msg.cs.length;i++){
                $('#user-m').append(
                    "<div class='user-comm'>"+
                    "<div class='comm-tx'>"+
                    "<img src='../static/img/tx.jpg' alt=''>"+
                    "</div>"+
                    "<div class='user-comm-main'>"+
                    "<p id='comm-user-name'>"+msg.cs[i].User.NickName+"</p>"+
                    "<p id='comm-last-time'>"+time_last(msg.cs[i].CreatedAt)+"天前</p>"+
                    "<p id='comm-user-text'>"+msg.cs[i].Text+"</p>"+
                    "</div>"+
                    "</div>"
                )
            }
        }
    });
}
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
                uid = msg.userID;
                $('#login-btt').css("display","none");
                $('#user-info').css("display","block");
                $('#user-info').html(msg.name+"<span class='caret'></span>");
            }
        }
    });
}