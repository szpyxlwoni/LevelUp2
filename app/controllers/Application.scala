package controllers

import play.api.mvc._

import models._
import play.api.data.Form
import play.api.data.Forms._

object Application extends Controller {
  Tables.initialize

  def index = Action { implicit rs =>
    Ok(views.html.course.index(Course.toList))
  }

  val courseForm = Form(
    mapping(
      "name" -> text(),
      "content" -> optional(text())
    )(Course.apply)(Course.unapply)
  )

  def create = Action {
    Ok(views.html.course.create(Person.toList))
  }

  def save = Action { implicit rs =>
    val course = courseForm.bindFromRequest.get
    Course(course.name, course.content).save

    Redirect("/")
  }

  Tables.cleanup
}