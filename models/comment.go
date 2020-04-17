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
//获取视频所有评论
func GetAllComments(uid,vid int) []Comment{
	var cs []Comment
	db.Where("user_id = ?",uid).Or("video_id = ?", vid).Find(&cs)
	return cs;
}