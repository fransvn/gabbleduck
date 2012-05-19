package crazy.test.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;

import org.junit.Ignore;
import org.junit.Test;

public class TextualPieceTestCase {

	private TextualPiece textualPiece;

	@Test
	public void reads_the_first_word() throws Exception {

		if_we_have_a_valid_textual_piece();

		String word = textualPiece.nextWord();

		assertEquals("should be the first word in the test string", "How", word);
	}

	@Test
	public void reads_the_nth_word() throws Exception {

		if_n_words_have_been_read();

		String word = textualPiece.nextWord();

		assertEquals("should be the nth word in the test string", "brown", word);
	}

	@Test
	public void end_of_stream_is_handled_gracefully() throws Exception {

		if_we_are_at_the_end_of_the_stream();

		String nextWord = textualPiece.nextWord();

		assertNull("should return null", nextWord);
	}

	@Test
	@Ignore
	public void returns_word_without_question_mark() throws Exception {

		if_next_word_ends_with_question_mark();

		String nextWord = textualPiece.nextWord();

		assertEquals("the word should be returned without the question mark.",
				"How", nextWord);
	}

	private void if_we_have_a_valid_textual_piece() {

		initialiseTextualPiece("How now brown cow?");
	}

	private void initialiseTextualPiece(String theString) {

		textualPiece = new TextualPiece(new ByteArrayInputStream(
				theString.getBytes()));
	}

	private void if_we_are_at_the_end_of_the_stream() {

		initialiseTextualPiece("End");
		textualPiece.nextWord();
	}

	private void if_next_word_ends_with_question_mark() {

		initialiseTextualPiece("How?");
	}

	private void if_n_words_have_been_read() {

		if_we_have_a_valid_textual_piece();

		textualPiece.nextWord();
		textualPiece.nextWord();
	}
}