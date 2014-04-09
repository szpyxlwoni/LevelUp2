package models

import com.github.aselab.activerecord._
import dsl._

case class Role(name: String) extends ActiveRecord {
  lazy val memberships = hasMany[Membership]
}

object Role extends ActiveRecordCompanion[Role]