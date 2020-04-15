var videoObject = {
    logo: 'dudu', //设置logo，非必须
    container: '#video',//“#”代表容器的ID，“.”或“”代表容器的class
    variable: 'player',//该属性必需设置，值等于下面的new chplayer()的对象
    video:'../static/img/video/1.mp4'//视频地址
};
var player=new chplayer(videoObject);
getVoideInf();

$("div[class^='menu']").html(" ");
$("div[class^='logo']").html(" ");



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
            $('#play').text(msg.v.Play);
            $('#date').text(msg.v.CreatedAt);
            $('#like').text(msg.v.Like);
            $('#unlike').text(msg.v.UnLike);
        }
    });
}