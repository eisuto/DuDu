package controllers

import (
	"dudu/models"
	"github.com/astaxie/beego"
	"math/rand"
	"strconv"
	"time"
)

type UserController struct {
	beego.Controller
}
//VMEXFHEJHXXNYFSD
func (c *UserController) GetEmailCode(){
	var code string
	rand.Seed(time.Now().Unix())
	for i:=0;i<4;i++{
		code += strconv.Itoa(rand.Intn(10))
	}
	beego.Debug(code)
	/*config := `{"username":"17640106727@163.com","password":"LKGGGHBHEEMLXARU","host":"smtp.163.com","port":25}`
	// 通过存放配置信息的字符串，创建Email对象
	temail:=utils.NewEMail(config)
	// 指定邮件的基本信息
	temail.To = []string{c.GetString("email")}//指定收件人邮箱地址
	temail.From = "17640106727@163.com"//指定发件人的邮箱地址
	temail.Subject = "注册验证-DuDu视频网"//指定邮件的标题
	temail.HTML = `<html>
		<head>
		</head>
	    	 <body>
			   <h1>您的验证码为</br><span style="color:#ff7c00">`+code+`</span></h1>
	     	</body>
	 	</html>`
	err := temail.Send()
	if err != nil{
		beego.Debug("邮件发送失败：",err)
	}*/
	c.Data["json"] = map[string]interface{}{"code":code}
	c.ServeJSON()
}
//根据Session检测是否在线
func (c *UserController) UserOnlineCheck(){
	userID := c.GetSession("UserID")
	if userID != nil{
		id := userID.(uint)
		name := models.GetUserByCard(strconv.Itoa(int(id))).NickName
		c.Data["json"] = map[string]interface{}{"userID":userID,"name":name}
		c.ServeJSON()
	}
	c.ServeJSON()

}
//注册
func (c *UserController)Register()  {
	card,pwd,email :=c.GetString("card"),c.GetString("pwd"),c.GetString("email")
	models.RegisterUser(card,pwd,email)
	c.SetSession("UserID", models.GetUserByCard(card).ID)
	c.Data["json"] = map[string]interface{}{"mod":true}
	c.ServeJSON()
}
//登录校验
func (c *UserController) LoginCheck(){
	card,pwd := c.GetString("card") , c.GetString("pwd")
	mod := models.CheckLogin(card,pwd)
	// 设置session 记住用户登录状态
	if mod{
		c.SetSession("UserID", models.GetUserByCard(card).ID)
		//beego.Debug(c.GetSession("ID"))
	}
	c.Data["json"] = map[string]interface{}{"mod":mod}
	c.ServeJSON()
}
//退出
func (c *UserController) Logout()  {
	c.DelSession("UserID")
	c.Redirect("/index", 302)
}