package models

import com.github.aselab.activerecord._

case class Person(name: String) extends ActiveRecord

object Person extends ActiveRecordCompanion[Person]