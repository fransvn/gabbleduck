package crazy.test.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TextualPiece implements Closeable {

	private Scanner scanner;

	public TextualPiece(InputStream source) {

		scanner = new Scanner(source).useDelimiter("\\s");
	}

	public String nextWord() {

		try {

			return scanner.next();
		} catch (NoSuchElementException ex) {

			return null;
		}
	}

	public boolean hasNext() {

		return scanner.hasNext();
	}

	public void close() throws IOException {

		scanner.close();
	}
}