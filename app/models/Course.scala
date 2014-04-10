package models

import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._

case class Course(var name: String, var content: Option[String]) extends ActiveRecord {
  lazy val teacherMemberships = hasMany[Membership](conditions = Map("roleId" -> 1))
  lazy val studentMemberships = hasMany[Membership](conditions = Map("roleId" -> 2))

  lazy val teachers = hasManyThrough[User, Membership](teacherMemberships)
  lazy val students = hasManyThrough[User, Membership](studentMemberships)
}

object Course extends ActiveRecordCompanion[Course]