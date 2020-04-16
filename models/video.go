package models

import (
	"github.com/jinzhu/gorm"
)

type Video struct {
	gorm.Model
	User      User
	UserID    int    `gorm:"index"`
	FCUrl     string `gorm:"size:64"`   //封面地址
	Title     string `gorm:"size:64"`   //标题
	Play	  int    `gorm:"size:32"`   //播放数
	Comm      int    `gorm:"size:32"`   //评论数
	Like      int    `gorm:"default:0"` //赞
	UnLike    int    `gorm:"default:0"`	//踩
	Introduc  string `gorm:"size:200"`	//简介
	Area      string `gorm:"size:64"`   //分区
	Duration  int    `gorm:"size:32"` 	//时长
	Comments  []Comment
	
}

func AddComment(uid,vid int,comm string)  {
	c := Comment{VideoID:vid,UserID:uid,Text:comm}
	v := GetVideoInfoById(vid)
	db.Save(&c)
	db.Model(&v).Update("comm", v.Comm+1)
}
func UpVideoPlayById(id int){
	v := GetVideoInfoById(id)
	db.Model(&v).Update("play", v.Play+1)
}
func GetVideoInfoById(id int) Video  {
	var video Video
	db.Where("id = ?",id).Find(&video)
	return video
}
