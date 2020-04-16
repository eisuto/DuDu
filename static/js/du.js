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

});
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
            console.log(msg.v)
            $('#title').text(msg.v.Title);
            $('#play-date').text(msg.v.Play+" 次观看 · "+timeFormatter(msg.v.CreatedAt));
            
            $('#like').text(" "+msg.v.Like);
            $('#unlike').text(" "+msg.v.UnLike);
            $('#introduc').text(msg.v.Introduc);
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