package models

import (
	"github.com/jinzhu/gorm"
)
var db *gorm.DB
//func GetDB() *gorm.DB{
func Init() {
	db, _ = gorm.Open("mysql", "root:233333@/dudu?charset=utf8&parseTime=True&loc=Local")
	/*if err != nil {
		panic("连接数据库失败")
	}*/
	//defer db.Close()
	//return db
	db.AutoMigrate(&User{})
	db.AutoMigrate(&Video{})
	db.AutoMigrate(&Comment{})
	/*var count int
	// Model(&User{})查询用户表, Count(&count) 将用户表的数据赋值给count字段。
	if err := db.Model(&User{}).Count(&count).Error; err == nil && count == 0 {
		//新增
		db.Create(&User{NickName: "admin",
			//邮箱
			Email: "waabdxiaoyi@gmail.com",
			//密码
			PassWord: "233333",
			//头像地址
			Avatar: "/static/img/tx.jpg",
			//角色 管理员
			Role: 0,
		})
	}*/
	/*eisuto := GetUserByCard("6")
	//新增视频
	db.Create(&Video{
		User:eisuto,
		FCUrl:"./static/img/fm/1",
		Title:"幻灯花",
		Play:1,
		Like:0,
		UnLike:0,
		Introduc:"一曲幻灯花不仅粉碎了原曲，也几乎粉碎了听众的心，尽管男性的声音在东方歌姬中比例不大，" +
			"然而这首绝对为精品预定，略带沧桑的男声不会让你一耳朵惊艳，然而听过，才会明白这是首多么耐听的歌",
		duration:378,
	})
	*/
}


