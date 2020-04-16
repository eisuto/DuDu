package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/sqlite"

)
type User struct {
	gorm.Model
	NickName string `gorm:"size:32,unique_index"`
	Email    string `gorm:"size:32,unique_index"`
	Phone    string `gorm:"size:11,unique_index"`
	PassWord string `gorm:"size:32"`
	Avatar   string `gorm:"size:32"`
	Role     int    `gorm:"default:1"` // 0 管理员 1正常用户
	VideosSelfUp []Video //`gorm:"foreignkey:UserId;ASSOCIATION_FOREIGNKEY:ID"`
	Comments     []Comment
}

func GetUserByCard(card string) User{
	var user User
	db.Where("nick_name = ?",card).Or("email = ?",card).Or("phone = ?",card).Or("id = ?",card).Find(&user)
	return user
}
func RegisterUser(card,pwd,email string)  {
	user := User{NickName:card,PassWord:pwd,Email:email}
	db.Create(&user)
}
func CheckLogin(card ,pwd string) bool{
	var user User
	db.Where("nick_name = ?",card).Or("email = ?",card).Or("phone = ?",card).Find(&user)
	return  user.PassWord == pwd
}
