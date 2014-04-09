package models

import com.github.aselab.activerecord._
import dsl._

case class User(name: String) extends ActiveRecord {
  lazy val memberships = hasMany[Membership]

  lazy val courses = hasManyThrough[Course, Membership](memberships)
}

object User extends ActiveRecordCompanion[User]