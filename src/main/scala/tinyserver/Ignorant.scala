/**
 * An ignorant web server, not looking at the request and just talking back plain text and no HTTP.
 */
package tinyserver

import java.net._
import java.io._
import scala.io._

object Ignorant {

  def main(args: Array[String]) {

    println("Hello I am a simple server!")
    val server = new ServerSocket(8080)
    while (true) {
      val s = server.accept()
      println("Accept")
      val in = new BufferedSource(s.getInputStream()).getLines()
      val out = new PrintStream(s.getOutputStream())

      out.println("Hello from the ignorant server, you wrote:")
      out.println(in.next())
      out.flush()
      s.close()
    }
  }

}
