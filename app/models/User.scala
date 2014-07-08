package models

import com.github.aselab.activerecord._
import dsl._
import play.api.libs.json.{Json, JsValue, Writes}

case class User(name: String) extends ActiveRecord {
  lazy val courses = hasAndBelongsToMany[Course]
}

object User extends ActiveRecordCompanion[User] {
  implicit val implicitQuoteWrites = new Writes[User] {
    def writes(u: User): JsValue = {
      Json.obj(
        "name" -> u.name
      )
    }
  }
}