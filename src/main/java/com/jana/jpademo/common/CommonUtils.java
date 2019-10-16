package com.jana.jpademo.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.web.context.request.ServletWebRequest;

public class CommonUtils {

	public static void convertBlobToWord(byte[] byteData) {
		try {
			/*
			 * // int blobLength = (int) blob.length(); int pos = 1; // position is 1-based
			 * int len = 10; // byte[] bytes = blob.getBytes(1l, (int) blob.length());
			 * 
			 * // for (int i = 0; i < bytes.length; i++) { String s = new String(blob); //
			 * System.out.println(s); // System.out.println(Arrays.toString(bytes)); // }
			 * 
			 * // byte[] bytes = blob.getBytes(pos, blobLength); // InputStream is =
			 * blob.getBinaryStream(); // int b = 0;// is.read(); FileOutputStream os = new
			 * FileOutputStream("D:/IEE/Test/Test1.docx"); // while ((b = is.read()) != -1)
			 * { os.write(blob); // fos is the instance of FileOutputStream // }
			 */

			// byte[] byteData = ....

			// read as XWPFDocument from byte[]
			HttpServletRequest request = null;// ServletActionContext.getRequest();
			ServletWebRequest servletWebRequest = new ServletWebRequest(request);
			HttpServletResponse response = servletWebRequest.getResponse();
			/* HTTP Requests */

			/*
			 * if (user == null) { auth = "anonymous"; } else { auth =
			 * authUser.getUsername(); }
			 */

			response.reset();
			response.setContentType("application/msword");
			response.setHeader("Content-Disposition", "attachment;filename=" + "+Curriculum+Vitae.doc");
			response.setHeader("Pragma", "anytextexeptno-cache,true");
			response.setHeader("Cache-Control", "max-arg=0");

			OutputStream outputStream = new FileOutputStream("D:/IEE/Test/Test1.docx");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");

			outputStreamWriter.write(byteData.toString());

			// setup print writer
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			// File newFile = new File("/var/vhosts/atlassian/cv.doc");

			// POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(newFile));

			// HWPFDocument doc = new HWPFDocument(fs);

			// Range range = doc.getRange();

			// CharacterRun run = range.insertBefore("1. Hello World!!! It works well!!!");
			// run.setBold(true);
			// run.setItalic(true);
			// run.setCapitalized(true);

			// doc.write(out);
			String result = out.toString();

			out.close();

			// print content
			pw.print(result);
			// pw.print( "You would usually use some form of CSV writer or similar to export
			// content in a CSV format." );

			// close the print writer which will start the download prompt
			pw.close();

		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static byte[] convertFileContentToBlob(String filePath) throws IOException {
		byte[] fileContent = null;
		Blob blob = null;
		StringBuffer fileContentStr = new StringBuffer("");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				fileContentStr.append(line).append("\n");
				// System.out.println(fileContentStr.toString());
			}
			fileContent = fileContentStr.toString().trim().getBytes();

			try {
				blob = new javax.sql.rowset.serial.SerialBlob(fileContent);
			} catch (SerialException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			convertBlobToWord(fileContent);
		} catch (IOException e) {
			throw new IOException("Unable to convert file to byte array. " + e.getMessage());
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return fileContent;
	}

	public static void convertBlobToLatex(Blob blob) {

	}

	public static boolean isNullOrEmpty(String str) {
		if (null != str && !str.trim().isEmpty()) {
			return false;
		}
		return true;
	}

	public static Long convertoLong(String str) {
		return new Long(str);
	}

	public static void main(String args[]) {
		try {
			// CommonUtils.convertFileContentToBlob("D:/IEE/Test/Test.docx");
			System.out.println(CommonUtils.isNullOrEmpty(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
