
package tinyserver

import java.net._
import java.io._
import scala.io._

object Hello {

  def main(args: Array[String]) {

    println("Hello I am a simple server!")
    val server = new ServerSocket(8080)
    while (true) {
      val s = server.accept()
      println("Accept")
      val in = new BufferedSource(s.getInputStream()).getLines()
      val out = new PrintStream(s.getOutputStream())

      out.println("Hello from server, you wrote:")
      out.println(in.next())
      out.flush()
      s.close()
    }
  }

}
