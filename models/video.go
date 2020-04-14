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
	Like      int    `gorm:"default:0"` //赞
	UnLike    int    `gorm:"default:0"`	//踩
	Introduc  string `gorm:"size:200"`	//简介
	Area      string `gorm:"size:64"`   //分区
	Duration  int    `gorm:"size:32"` 	//时长
	
}

func GetVideoINfoById(id int) Video  {
	var video Video
	db.Where("id = ?",id).Find(&video)
	return video
}
