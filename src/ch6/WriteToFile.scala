/**
 * Created by gongxingfa on 15/3/13.
 */

import java.io._

def writeToFile(fileName: String)(codeBlock: PrintWriter => Unit): Unit = {
  val write = new PrintWriter(new File((fileName)))
  try {
    codeBlock(write)
  } finally {
    write.close();
  }
}

writeToFile("output.txt") { writer =>
  writer write "hello from Scalasc"
}