package org.jsoup.helper;

import java.io.Serializable;

public class Interval implements Serializable {

	private static final long serialVersionUID = -4097535626745467100L;

	private final int start;
	private final int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int length() {
		return getEnd() - getStart() + 1;
	}
}
