package models

import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._

case class Course(var name: String, var content: Option[String]) extends ActiveRecord {
  lazy val memberships = hasMany[Membership]

  lazy val users = hasManyThrough[User, Membership](memberships)
}

object Course extends ActiveRecordCompanion[Course]