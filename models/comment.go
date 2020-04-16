package models

import "github.com/jinzhu/gorm"

type Comment struct {
	gorm.Model
	User      User
	UserID    int    `gorm:"index"`
	Video     Video
	VideoID   int    `gorm:"index"`
	Text      string `gorm:"size:256"`
}