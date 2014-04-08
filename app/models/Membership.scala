package models

import com.github.aselab.activerecord._
import org.squeryl.dsl.TOptionLong

case class Membership(userId: Long, courseId: Long, roleId: Option[Long] = None) extends ActiveRecord {
  lazy val user = belongsTo[User]
  lazy val course = belongsTo[Course]
  lazy val role = belongsTo[Role]
}

object Membership extends ActiveRecordCompanion[Membership]