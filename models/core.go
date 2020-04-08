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
	var count int
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
	}
}


