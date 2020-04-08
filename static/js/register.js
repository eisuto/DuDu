var emailCode
$(document).ready(function(){ 
    
    $("#in-email").blur(checkEmail);
    $("#pwd").blur(checkPwd);
    $("#card").blur(checkCard);
    get_user_by_index();
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
//邮箱格式
function checkEmail(){
    var checkmod = false;
    var eValue = $("#in-email").val();
    if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(eValue)){
        $('#in-email').css({"border-color":"#ff2121","border-width":"2px"})
        $('.eemail').text("哪有你家这样的邮箱啊!(╬￣皿￣)=○")
        checkmod = false;
    }
    else{
        $('#in-email').css({"border-color":"#ccc","border-width":"1px"})
        $('.eemail').html("<br>")
        checkmod = true;
    }
    return checkmod;
}
//密码格式
function checkPwd(){
    var checkmod = false;
    var pwd  = $('#pwd').val();
    if(pwd.length >=16 || pwd.length <6){
        $('#pwd').css({"border-color":"#ff2121","border-width":"2px"})
        $('.epwd').text("密码好像有问题哦 ! ?(6位~16位之间的密码)")
        checkmod = false;
    }
    else{
        $('#pwd').css({"border-color":"#ccc","border-width":"1px"})
        $('.epwd').html("<br>")
        checkmod = true;
    }
    return checkmod;
}
//名称格式
function checkCard(){
    var checkmod = false;
    var card = $('#card').val();
    if(card.length >=16 || card.length ==0){
        $('#card').css({"border-color":"#ff2121","border-width":"2px"})
        $('.ecard').text("名字格式不对哦orz")
        checkmod = false;
    }
    else{
        $('#card').css({"border-color":"#ccc","border-width":"1px"})
        $('.ecard').html("<br>")
        checkmod = true;
    }
    return checkmod;

}

//发送邮箱验证码
function emailTodoku(){
    if(checkEmail() & checkPwd() & checkCard()){
        var email = $("#in-email").val()
        console.log(email)
        $("#email-check").css({"background-color":"#e8e8e8","color":"#7a7a7a"});
        $.ajax({
            async: false,
            type:"POST",
            url:"/get_email_code",
            data:{"email":email}
            }).done(function(msg){
            if(msg != null){
                //window.location.href="/"
                console.log("获取验证码成功")
                emailCode = msg.code
                console.log(msg.code)
            }
        });
        reEmailTime();
    }
}
//注册按钮最后校验
function checkInput(){
    var code = $('#email-code').val();
    //console.log(code)
    //console.log(emailCode)
    if(checkEmail() & checkPwd() & checkCard()){
        if(emailCode == code){
            //提交注册
            $('#email-code').css({"border-color":"#ccc","border-width":"1px"})
            $('.ecode').html("<br>")
            postRegister();
        }
        else{
            $('#email-code').css({"border-color":"#ff2121","border-width":"2px"})
            $('.ecode').text("眼花了? 再看看(￣▽￣)／")
        }
    }
}
function postRegister(){
    console.log("提交注册")
    var card  = $('#card').val();
    var pwd   = $('#pwd').val();
    var email = $("#in-email").val();
    $.ajax({
        async: false,
        type:"POST",
        url:"/register_post",
        data:{"card":card,"pwd":pwd,"email":email}
        }).done(function(msg){
        if(msg != null){
            if(msg.mod)
            console.log("注册成功")
            
            layer.msg('注册成功，正在登录', {
                icon: 16
                ,shade: 0.01
            });
            setTimeout(window.location.href="/index",5000)
        }
    });
}

var c = 60;
var t;
function reEmailTime(){
    
    $('#email-check').html(c+'s');
    c-=1;
    if(c>=0){
        t=setTimeout("reEmailTime()",1000);
        $("#email-check:hover").css({"pointer-events": "none"});
        $("#cen").css({"cursor":"not-allowed"})
    }
    else{
        $('#email-check').text('重新发送')
        $("#cen").css({"cursor":"pointer"})
        $("#email-check").css({"pointer-events": "auto","background-color":"#449efc","color":"#fff"})
        c = 6;
    }
}

