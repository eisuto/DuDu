package controllers

import (
	"github.com/astaxie/beego"
)

type MainController struct {
	beego.Controller
}

func (c *MainController) Get() {
	c.TplName = "index.html"
}
func (c *MainController) LoginPage() {
	c.TplName = "login.html"
}
func (c *MainController) IndexPage() {
	c.TplName = "index.html"
}
func (c *MainController) RegisterPage() {
	c.TplName = "register.html"
}
func (c *MainController) AppPage() {
	c.TplName = "app.html"
}
func (c *MainController) VideoPage() {
	c.TplName = "du.html"
}
