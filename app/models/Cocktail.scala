package models

import play.api.db.slick.Config.driver.simple._

case class Cocktail(id: Option[Long], name: String)

class Cocktails extends Table[Cocktail]("COCKTAIL") {
  def id = column[Long]("ID")
  def name = column[String]("NAME")
  def * = id.? ~ name <> (Cocktail.apply _, Cocktail.unapply _)
}