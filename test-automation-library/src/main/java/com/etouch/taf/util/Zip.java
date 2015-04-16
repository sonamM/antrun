/*
 * 
 */
package com.etouch.taf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class Zip.
 */
public class Zip {
  
  /**
   * Zip folder.
   *
   * @param src the src
   * @param dst the dst
   * @throws Exception the exception
   */
  public static void zipFolder (String src,String dst)throws Exception {
	  zipDir( src,  dst);
  }

  /**
   * Zip dir.
   *
   * @param srcFolder the src folder
   * @param destZipFile the dest zip file
   * @throws Exception the exception
   */
  static public void zipDir(String srcFolder, String destZipFile) throws Exception {
    ZipOutputStream zip = null;
    FileOutputStream fileWriter = null;

    fileWriter = new FileOutputStream(destZipFile);
    zip = new ZipOutputStream(fileWriter);

    addFolderToZip("", srcFolder, zip);
    zip.flush();
    zip.close();
  }

  /**
   * Adds the file to zip.
   *
   * @param path the path
   * @param srcFile the src file
   * @param zip the zip
   * @throws Exception the exception
   */
  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
      throws Exception {

    File folder = new File(srcFile);
    if (folder.isDirectory()) {
      addFolderToZip(path, srcFile, zip);
    } else {
      byte[] buf = new byte[1024];
      int len;
      FileInputStream in = new FileInputStream(srcFile);
      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
      while ((len = in.read(buf)) > 0) {
        zip.write(buf, 0, len);
      }
    }
  }

  /**
   * Adds the folder to zip.
   *
   * @param path the path
   * @param srcFolder the src folder
   * @param zip the zip
   * @throws Exception the exception
   */
  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFolder);

    for (String fileName : folder.list()) {
      if (path.equals("")) {
        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
      } else {
        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
      }
    }
  }
}