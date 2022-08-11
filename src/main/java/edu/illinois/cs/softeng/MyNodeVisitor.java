package edu.illinois.cs.softeng;

import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;

/**
 * the formatting rules, implemented in a breadth-first DOM traverse
 */
public class MyNodeVisitor implements NodeVisitor
{
	// holds the accumulated text
	private StringBuilder accum = new StringBuilder();

	// hit when the node is first seen
	public void head(Node node, int depth) {
		String name = node.nodeName();
		if (node instanceof TextNode) {
			// TextNodes carry all user-readable text in the DOM.
			append(((TextNode) node).text());
		} else if (node instanceof Comment) {
			//TODO
		} else if (StringUtil.in(name, "html", "body", "ul", "li", "p")) {
			//TODO
		}
	}

	// hit when all of the node's children (if any) have been visited
	public void tail(Node node, int depth) {
		String name = node.nodeName();
		//TODO
	}

	// appends text to the string builder with a simple word wrap method
	private void append(String text) {
		accum.append(text);
	}

	@Override
	public String toString() {
		return accum.toString();
	}
}