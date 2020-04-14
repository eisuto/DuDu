package controllers

import (
	"dudu/models"
	"github.com/astaxie/beego"
)

type VideoController struct {
	beego.Controller
}
//获取首页动画区推荐视频 15个
func (c *VideoController) GetIndexAnimeVideo(){
	v1 := models.GetVideoINfoById(1)
	vids :=[15]models.Video{
		v1,v1,v1,v1,v1,
		v1,v1,v1,v1,v1,
		v1,v1,v1,v1,v1,
	}
	c.Data["json"] = map[string]interface{}{"vids":vids}
	c.ServeJSON()
}
//获取首页头部推荐视频 12个
func (c *VideoController) GetIndexHeadVideo(){
	v2 := models.GetVideoINfoById(2)
	v1 := models.GetVideoINfoById(1)
	vids :=[12]models.Video{
		v2,v1,v1,v1,
		v1,v1,v1,v1,
		v1,v1,v1,v1,
	}
	c.Data["json"] = map[string]interface{}{"vids":vids}
	c.ServeJSON()
}