package edu.illinois.cs.softeng;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/**
 * You are required to define a customized visitor via implementing the
 * org.jsoup.select.NodeVisitor interface to pretty print input HTML pages.
 *
 */
public class MyPrinter
{
	/**
	 * Just another entry point for playing with the program 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String html = "<html><body><ul><li>xx</li></ul></body></html>";
		Document doc = Jsoup.parse(html); // get initial HTML document
		MyPrinter printer = new MyPrinter(); 
		String output = printer.prettyPrint(doc);
		System.out.println(output);
	}

	/**
	 * Pretty print an Element
	 * 
	 * @param element
	 *            the root element to format
	 * @return formatted text
	 */
	public String prettyPrint(Element element) {
		MyNodeVisitor formatter = new MyNodeVisitor();
		// walk the DOM, and call .head() and .tail() for each node
		NodeTraversor.traverse(formatter, element);
		return formatter.toString();
	}
}
