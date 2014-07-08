package controllers

import play.api.mvc._

import models._
import play.api.data.Form
import play.api.data.Forms._
import com.github.aselab.activerecord.dsl._
import play.api.libs.json.{JsObject, Json}

object Application extends Controller {
  Tables.initialize

  def index = Action {
    Ok(views.html.course.index(Course.toList))
  }

  def create = Action {
    Ok(views.html.course.create(Course.toList))
  }

  def diagram = Action {
    Ok(views.html.course.diagram(Json.toJson(Course.toList).toString()))
  }

  def tasks(course: Long) = Action {
    Ok(Json.toJson(Course.find(course).get.users.toList).toString())
  }

  def courses = {
    val rootCourse: Course = Course.find(1).get
    Action {
      Ok(buildJson(rootCourse))
    }
  }

  private def buildJson(rootCourse: Course): JsObject = {
    Json.obj(
      "id" -> rootCourse.id,
      "name" -> rootCourse.name,
      "children" -> rootCourse.children.toList.map(buildJson)
    )
  }

  def edit = Action {
    Ok(views.html.course.edit(Course.find(1).get))
  }

  val courseForm = Form(
    tuple(
      "name" -> text(),
      "content" -> optional(text()),
      "parent" -> optional(longNumber())
    )
  )

  def save = Action { implicit rs =>
    val course = courseForm.bindFromRequest.get
    val courseC: Course = Course(course._1, course._2).create
    if(!course._3.isEmpty){
      Course.find(course._3.get).get.children << courseC
    }

    Redirect("/")
  }

  Tables.cleanup
}