package tinyserver

import java.net._
import java.io._
import scala.io._

object Client {
  def main(args: Array[String]) {
    val correctGet = "GET /index.html HTTP/1.1\r\n" +
      "Host: www.example.com\r\n\r\n"
    val http10Get = "GET /index.html HTTP/1.0\r\n\r\n"
    val host = "www.example.com"

    val inetAddress = InetAddress.getByName(host)
    println(inetAddress)
    val s = new Socket(host, 80)
    val in = new BufferedSource(s.getInputStream())
    val out = new PrintStream(s.getOutputStream())
    out.print(http10Get)
    in.getLines().foreach(println)
    s.close()
  }
}
