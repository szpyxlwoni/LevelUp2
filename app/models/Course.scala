package models

import com.github.aselab.activerecord._

case class Course(var name: String, var content: Option[String]) extends ActiveRecord {
  lazy val teachers = hasMany[Person]
  lazy val students = hasMany[Person]
}

object Course extends ActiveRecordCompanion[Course]