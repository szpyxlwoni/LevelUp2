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

  def edit(id: Long) = Action {
    Ok(views.html.person.edit(User.find(id).get))
  }

  def update(id: Long, courses: List[Long]) = Action {
    val user = User.find(id).get
    for (course <- courses) yield user.courses << Course.find(course).get
    Ok(views.html.person.index(User.toList))
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
