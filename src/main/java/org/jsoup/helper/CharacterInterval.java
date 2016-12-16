package org.jsoup.helper;

public class CharacterInterval {

	private final int startPos;
	private final int endPos;

	public CharacterInterval(int startPos, int endPos) {
		this.startPos = startPos;
		this.endPos = endPos;
	}

	public int getStartPos() {
		return startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public int length() {
		return getEndPos() - getStartPos() + 1;
	}
}
