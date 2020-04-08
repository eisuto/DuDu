package main

import (
	"dudu/models"
	_ "dudu/routers"
	"encoding/gob"
	"github.com/astaxie/beego"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)


func main() {
	initModels()
	models.Init()
	beego.Run()
}

func initModels() {
	//beego的session序列号是用gob的方式，因此需要将注册models.User
	gob.Register(models.User{})
	gob.Register(models.Video{})
}