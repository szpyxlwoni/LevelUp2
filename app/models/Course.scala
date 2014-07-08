package models

import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._
import play.api.libs.json._

case class Course(var name: String, var content: Option[String]) extends ActiveRecord {
    lazy val children = hasMany[Course]
    val courseId: Option[Long] = None
    lazy val parent = belongsTo[Course]
    lazy val users = hasAndBelongsToMany[User]
//  lazy val studentMemberships = hasMany[Membership](conditions = Map("roleId" -> 2))

//  lazy val teachers = hasManyThrough[User, Membership](teacherMemberships)
//  lazy val students = hasManyThrough[User, Membership](studentMemberships)
}

object Course extends ActiveRecordCompanion[Course] {
  implicit val implicitQuoteWrites = new Writes[Course] {
    def writes(c: Course): JsValue = {
      Json.obj(
        "name" -> c.name,
        "content" -> c.content
      )
    }
  }
}