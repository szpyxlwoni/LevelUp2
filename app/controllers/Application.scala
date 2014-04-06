package controllers

import play.api._
import play.api.mvc._
import play.api.db.slick._
import scala.slick.lifted.Query
import play.api.db.slick.Config.driver.simple._
import play.api.Play.current

import models._

object Application extends Controller {

  def index = DBAction { implicit rs =>
    Ok(views.html.cocktails(Query(new Cocktails).list))
  }
  
}