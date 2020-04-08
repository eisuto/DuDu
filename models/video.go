package models

import (
	"github.com/jinzhu/gorm"
)

type Video struct {
	gorm.Model
	User      User
	UserID    int    `gorm:"index"`
	Title     string `gorm:"size:64"`
	Like      int    `gorm:"default:0"`
	UnLike    int    `gorm:"default:0"`
	Introduc  string `gorm:"size:200"`	//简介
	duration  int    					//时长
}
