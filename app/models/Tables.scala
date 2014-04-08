package models

import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._

object Tables extends ActiveRecordTables {
  val users = table[User]
  val courses = table[Course]
  val roles = table[Role]
  val memberships = table[Membership]
}