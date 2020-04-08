
object Main extends App {
  val homeDir = System.getProperty("user.home")
  val file = new FileIO(homeDir + "/.xabda_db")
  val lines = file.read()

  if (args.length > 0) {
    args(0) match {
      case "add"  => if (args.length > 1) add(args(1))
      case "list" => list()
      case _      =>
        println(s"xabda: '${args(0)}' is not a xabda command.")
        println("Currently available commands are: add, list.")
    }
  } else println("Currently available commands are: add, list.")

  private def add(line: String) = {
    if (!lines.exists(_.toLowerCase == line.toLowerCase))
      file.write(line)
  }

  private def list() = {
    lines.foreach(println)
  }
}
