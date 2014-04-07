package controllers

import play.api.mvc._
import models._
import play.api.data.Form
import play.api.data.Forms._

object PersonCtrl extends Controller {
  Tables.initialize

  def index = Action {
    Ok(views.html.person.index(Person.toList))
  }

  def create = Action {
    Ok(views.html.person.create())
  }

  val personForm = Form(
    mapping(
      "name" -> text()
    )(Person.apply)(Person.unapply)
  )

  def save = Action { implicit rs =>
    val person = personForm.bindFromRequest.get
    Person(person.name).save

    Redirect("/person")
  }

  Tables.cleanup
}
