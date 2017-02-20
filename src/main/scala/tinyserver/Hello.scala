/**
 * A super simple web server.
 */
package tinyserver

import java.net._
import java.io._
import scala.io._

object Hello {

  def main(args: Array[String]) {

    var cnt = 0

    println("Hello I am a simple server!")
    val server = new ServerSocket(8080)
    while (true) {
      val s = server.accept()
      println("Accepted connection")

      val in = new BufferedSource(s.getInputStream()).getLines()
      val out = new PrintStream(s.getOutputStream())

      cnt += 1;
      val resp = "HTTP/1.0 200 OK\r\n\r\n" +
        "<html><head></head><body><h2>Hello WWW World!</h2>" +
        cnt +
        "</body></html>\r\n\r\n"

      out.print(resp)
      out.flush()
      println("Close connection");
      s.close()
    }
  }
}

  /*
 * a complete response would be:
 
  val resp = "HTTP/1.1 200 OK\r\n\r\n" +
    "Content-Type: text/plain\r\n" +
    "Content-Length: 12\r\n" +
    "Connection: close\r\n\r\n" +

 */