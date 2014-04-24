package controllers

import play.api.mvc._

import models._
import play.api.data.Form
import play.api.data.Forms._
import com.github.aselab.activerecord.dsl._

object Application extends Controller {
  Tables.initialize

  def index = Action {
    Ok(views.html.course.index(Course.toList))
  }

  def create = Action {
    Ok(views.html.course.create(User.toList))
  }

  def edit = Action {
    Ok(views.html.course.edit(Course.find(1).get))
  }

  val courseForm = Form(
    tuple(
      "name" -> text(),
      "content" -> optional(text())
    )
  )

  def save = Action { implicit rs =>
    val course = courseForm.bindFromRequest.get
    Course(course._1, course._2).create

    Redirect("/")
  }

  Tables.cleanup
}