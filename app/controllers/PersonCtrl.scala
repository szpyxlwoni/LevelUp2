package controllers

import play.api.mvc._
import models._
import play.api.data.Form
import play.api.data.Forms._

object PersonCtrl extends Controller {
  Tables.initialize

  def index = Action {
    Ok(views.html.person.index(User.toList))
  }

  def create = Action {
    Ok(views.html.person.create())
  }

  val userForm = Form(
    mapping(
      "name" -> text()
    )(User.apply)(User.unapply)
  )

  def save = Action { implicit rs =>
    val user = userForm.bindFromRequest.get
    User(user.name).save

    Redirect("/person")
  }

  Tables.cleanup
}
