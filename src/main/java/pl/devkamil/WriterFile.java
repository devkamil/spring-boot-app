package pl.devkamil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class WriterFile {

	private static final DateFormat dateWriter = new SimpleDateFormat("yyyy-MM-dd-HHmm");

	public void fileWriter(Note note, Date date) {
		String fileName = dateWriter.format(date);

		File file = new File("C:\\Users\\DOM\\Desktop\\note_" + fileName + ".txt");

		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {

			writer.write(note.toString());
			writer.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WriterFile() {
	}
}
