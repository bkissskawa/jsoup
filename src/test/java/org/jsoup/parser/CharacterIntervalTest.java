package org.jsoup.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class CharacterIntervalTest {

	@Test
	public void testTagSourcePosition() throws Exception {
		String html = "<html><head><title>Get interval!</title></head><body><p class=\"active\">Where am I?</p>" +
				"<input type=\"text\" value=\"hello\"/>" +
				"<div><div><p>Hello, <strong>here</strong> I am.</p></div></div>" +
				"<div><span>Hi</span><span></span></div>" +
				"</body></html>";
		Document doc = Jsoup.parse(html);
		Element p = doc.body().child(0);

		assertTrue(p.sourcePosition() != null);
		assertEquals("<p class=\"active\">Where am I?</p>", source(html, p));

		Element input = doc.body().child(1);
		assertEquals("<input type=\"text\" value=\"hello\"/>", source(html, input));

		Element div = doc.body().child(2);
		assertEquals("<div><div><p>Hello, <strong>here</strong> I am.</p></div></div>", source(html, div));

		Element body = doc.body();
		assertEquals("<body><p class=\"active\">Where am I?</p><input type=\"text\" value=\"hello\"/><div><div><p>Hello, <strong>here</strong> I am.</p></div></div><div><span>Hi</span><span></span></div></body>", source(html, body));
	}

	private String source(String s, Element e) {
		return s.substring(e.sourcePosition().getStartPos(), e.sourcePosition().getEndPos());
	}
}
