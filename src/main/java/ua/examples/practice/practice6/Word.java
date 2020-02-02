package ua.examples.practice.practice6;

public class Word implements Comparable<Word> {
	
	private String content;
	
	private int frequency;

	public Word(String content) {

		this.content = content;
		frequency = 1;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Word word = (Word) o;

		return content != null ? content.equals(word.content) : word.content == null;
	}

	@Override
	public int hashCode() {
		return content != null ? content.hashCode() : 0;
	}

	@Override
	public int compareTo(Word w) {

		if(this.frequency != w.getFrequency()){
			return -this.frequency + w.getFrequency();
		}
		else {
			return this.content.compareTo(w.getContent());
		}
	}
}
