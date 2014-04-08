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
    tuple(
      "name" -> text(),
      "content" -> optional(text()),
      "teacher" -> optional(number()),
      "student" -> optional(number())
    )
  )

  def create = Action {
    Ok(views.html.course.create(User.toList))
  }

  def save = Action { implicit rs =>
    val course = courseForm.bindFromRequest.get
    val teacher = User.find(course._3.get)
    val studentRole = Role("student").create
    val teacherRole = Role("teacher").create
    val student = User.find(course._4.get)
    val newCourse = Course(course._1, course._2).create
    val membershipS = newCourse.users.assign(student.get)
    membershipS.role := studentRole
    val membershipT = newCourse.users.assign(teacher.get)
    membershipT.role := teacherRole
    membershipT.save
    membershipS.save

    Redirect("/")
  }

  Tables.cleanup
}