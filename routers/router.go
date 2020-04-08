package routers

import (
	"dudu/controllers"
	"github.com/astaxie/beego"
)

func init() {
    beego.Router("/",&controllers.MainController{})
	beego.Router("/index"	  ,&controllers.MainController{},"*:IndexPage")
	beego.Router("/login"	  ,&controllers.MainController{},"*:LoginPage")
	beego.Router("/register"  ,&controllers.MainController{},"*:RegisterPage")
	beego.Router("/app"	      ,&controllers.MainController{},"*:AppPage")

	beego.Router("/login_post"	      ,&controllers.UserController{}, "*:LoginCheck")
	beego.Router("/register_post"	  ,&controllers.UserController{}, "*:Register")
	beego.Router("/logout"            ,&controllers.UserController{}, "*:Logout")
	beego.Router("/user_post_by_index",&controllers.UserController{}, "*:UserOnlineCheck")
	beego.Router("/get_email_code"    ,&controllers.UserController{}, "*:GetEmailCode")
}
