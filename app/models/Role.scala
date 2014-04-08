package models

import com.github.aselab.activerecord._

case class Role(name: String) extends ActiveRecord {
  lazy val memberships = hasMany[Membership]
}

object Role extends ActiveRecordCompanion[Role]