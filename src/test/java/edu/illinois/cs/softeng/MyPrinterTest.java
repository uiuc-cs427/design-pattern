package edu.illinois.cs.softeng;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Unit test for MyPrinter.
 */
public class MyPrinterTest
{
	/**
	 * Rigorous Tests :-)
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Test
	public void test1() throws IOException, URISyntaxException {
		String html = "<html><body><ul><li>xx</li></ul></body></html>";
		Document doc = Jsoup.parse(html); // get initial HTML document
		MyPrinter printer = new MyPrinter();
		String output = printer.prettyPrint(doc);
		assertEquals(
				"The output file differs from the expected one: src/test/resources/htmltests/output1.html!",
				FileUtils.readFileToString(
						getFileFromResource("htmltests/output1.html"), "utf-8"),
				output);
	}

	@Test
	public void test2() throws IOException, URISyntaxException {
		String html = "<html><body><!--p>hello</p--><ul><li></li></ul></body></html>";
		Document doc = Jsoup.parse(html); // get initial HTML document
		MyPrinter printer = new MyPrinter();
		String output = printer.prettyPrint(doc);
		assertEquals(
				"The output file differs from the expected one: src/test/resources/htmltests/output2.html!",
				FileUtils.readFileToString(
						getFileFromResource("htmltests/output2.html"), "utf-8"),
				output);
	}

	@Test
	public void test3() throws IOException, URISyntaxException {
		String html = "<html><body><!--p>hello</p--><ul><li><a href=\"http://www.google.com\">Google</a></li></ul><p>xx</p></body></html>";
		Document doc = Jsoup.parse(html); // get initial HTML document
		MyPrinter printer = new MyPrinter();
		String output = printer.prettyPrint(doc);
		assertEquals(
				"The output file differs from the expected one: src/test/resources/htmltests/output3.html!",
				FileUtils.readFileToString(
						getFileFromResource("htmltests/output3.html"), "utf-8"),
				output);
	}

	/**
	 * Get the expected output files from the resource directory
	 * 
	 * @param fileName
	 * @return
	 * @throws URISyntaxException
	 */
	private File getFileFromResource(String fileName)
			throws URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return new File(resource.toURI());
		}

	}
}
