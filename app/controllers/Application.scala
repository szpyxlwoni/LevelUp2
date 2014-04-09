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
      "content" -> optional(text()),
      "teacher" -> optional(number()),
      "student" -> optional(number())
    )
  )

  def save = Action { implicit rs =>
    if (Role.all.count == 0) {
      Seq("teacher", "student").foreach(s => Role(s).save)
    }
    val course = courseForm.bindFromRequest.get
    val teacher = User.find(course._3.get)
    val student = User.find(course._4.get)
    val newCourse = Course(course._1, course._2).create
    val membership = newCourse.users << student.get
    membership.role := Role.findBy("name", "teacher").get
    membership.save

    Redirect("/")
  }

  Tables.cleanup
}