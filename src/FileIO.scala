import java.io._

class FileIO(filename: String) {

  def write(lines: Seq[String]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file, true))
    for (line <- lines)
      bw.write(line)

    bw.close()
  }

  def write(str: String): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file, true))
    bw.write(str + "\n")
    bw.close()
  }

  def read(): List[String] = {
    try {
      val file = new File(filename)
     
      if (!file.exists)
        write(Nil)
      
      scala.io.Source.fromFile(file).getLines().toList
    } catch {
      case e: Exception => println("err >>> " + e.getMessage())
      Nil
    }
  }

}
