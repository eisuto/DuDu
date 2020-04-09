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
	Like      int    `gorm:"default:0"` //赞
	UnLike    int    `gorm:"default:0"`	//踩
	Introduc  string `gorm:"size:200"`	//简介
	duration  int    					//时长
}
