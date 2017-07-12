package pluto.util

import java.nio.file.Path
import java.nio.file.Files

import java.nio.file.SimpleFileVisitor
import java.nio.file.FileVisitResult
import java.nio.file.attribute.BasicFileAttributes

/**
 * Utility functions to deal with the underlying file system
 *
 * @since 0.1.0
 */
class Storage {

  /**
   * Deletes the directory passed as argument. If it is not empty it
   * will delete recursively the directory.
   *
   * @param directory the folder we would like to remove
   * @since 0.1.0
   */
  static void deleteDirectory(Path directory) {
    Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
      @Override
      FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Files.delete(file)
        return FileVisitResult.CONTINUE
      }

      @Override
      FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        Files.delete(dir)
        return FileVisitResult.CONTINUE
      }
    })

    Files.deleteIfExists(directory)
  }

  /**
   * Deletes a given path if exists. If the path you would like to remove is
   * a non empty folder, then use {@link Storage#deleteDirectory} instead
   *
   * @param path the path you would like to remove
   * @since 0.1.0
   */
  static void deleteFile(Path path) {
    Files.deleteIfExists(path)
  }
}
