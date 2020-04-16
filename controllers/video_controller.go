package controllers

import (
	"dudu/models"
	"github.com/astaxie/beego"
	"strconv"
)

type VideoController struct {
	beego.Controller
}
//增加一条评论
func (c *VideoController) AddVideoComment()  {
	uid,_ := strconv.Atoi(c.GetString("uid"))
	vid,_ := strconv.Atoi(c.GetString("vid"))
	comm  := c.GetString("comm")
	models.AddComment(uid,vid,comm)
	c.Data["json"] = map[string]interface{}{"mod":true}
	c.ServeJSON()
}
//获取视频信息
func (c *VideoController) GetVideoInfo(){
	id ,_ := strconv.Atoi(c.GetString("id"))
	v  := models.GetVideoInfoById(id)
	//点击+1
	models.UpVideoPlayById(id)
	c.Data["json"] = map[string]interface{}{"v":v}
	c.ServeJSON()
}
//获取首页动画区推荐视频 15个
func (c *VideoController) GetIndexAnimeVideo(){
	v1 := models.GetVideoInfoById(1)
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
	v2 := models.GetVideoInfoById(2)
	v1 := models.GetVideoInfoById(1)
	vids :=[12]models.Video{
		v2,v1,v1,v1,
		v1,v1,v1,v1,
		v1,v1,v1,v1,
	}
	c.Data["json"] = map[string]interface{}{"vids":vids}
	c.ServeJSON()
}