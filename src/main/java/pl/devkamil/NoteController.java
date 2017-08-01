package pl.devkamil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class FirstServlet, main application servlet
 */

@Controller
public class NoteController {

		
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	/**
	 * This object saving Note to .txt file
	 */
	@Autowired
	private WriterFile writerFile;
	
	/**
	 * This object provides a CRUD methods
	 */
	@Autowired
	private NoteRepository noteRepository;	



	
	/**
	 * This is starting method, main page of application
	 * @return Main page of application
	 */
	@RequestMapping(value={"/","", "/spring-boot-app"})
	public String welcome(Model model) {
		List<Note> allNote =  (List<Note>) noteRepository.findAll();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
	
	/**
	 * This method print blank form to add Note
	 * @return Blank form 'addNote'
	 */
	@GetMapping(value="/add-note")
	public String noteAddNote(@ModelAttribute("noteDto") NoteDTO noteDto) {
		
		return "addNote";
	}
		
	
	/**
	 * This method is creating Note object from index.jsp form and saving Note in database
	 * @return Main page of application
	 */
	@PostMapping(value="/add-note")
	public String noteAddNote(@ModelAttribute("noteDto") @Valid NoteDTO noteDto, BindingResult result){
		
		if (result.hasErrors()){			
			return "addNote";			
		}else{
			Note note = new Note();
			Date date = new Date();
			String currentDate = DATE_FORMAT.format(date);
			
			note.setTitle(noteDto.getTitle());
			note.setContent(noteDto.getContent());
			note.setAuthor(noteDto.getAuthor());
			note.setDate(currentDate);
			
			writerFile.fileWriter(note, date);
			noteRepository.save(note);
			return "redirect:/";
		}
	}

	
	/**
	 * This method shows a Note
	 * @param id Number 'id' of Note
	 * @return Page with full content of Note
	 */
	@RequestMapping("/show-page/{id}")
	public String showNotePage(Model model, @PathVariable("id") Long id){		
		Note noteById = noteRepository.findOne(id);		
		model.addAttribute("notes", noteById);		
		return "note";		
	}
	
	
	/**
	 * This method display a page to edit a Note
	 * @param id Number 'id' of Note
	 * @return Page to edit a Note
	 */
	@GetMapping("/edit-note/{id}")
	public String editNotePage(Model model, @PathVariable("id") Long id) {		
		Note noteById = noteRepository.findOne(id);
		model.addAttribute("notes", noteById);
		return "edit";
	}
	
	
	/**
	 * This method is saving an edited Note and updating it in database
	 * @param id Number 'id' of Note
	 * @return Main page of application
	 */
	@PostMapping("edit-note")
	public String editNote (@ModelAttribute Note note, Model model) {		
		noteRepository.save(note);
		
		List<Note> allNote =  (List<Note>) noteRepository.findAll();
		model.addAttribute("notes", allNote);
		return "index";
	}
	
	
	/**
	 * This method print deleted Note
	 * @param id Number 'id' of Note
	 * @return Page with "Back" or "Remove" buttons
	 */
	@RequestMapping("/delete-page/{id}")
	public String deleteNotePage(Model model, @PathVariable("id") Long id){
		Note noteById = noteRepository.findOne(id);
		model.addAttribute("notesDelete", noteById);
		return "delete";
	}
	
	/**
	 * This method is deleting Note
	 * @param id Number 'id' of Note
	 * @return Main page of application
	 */
	@RequestMapping("/remove-note/{id}")
	public String removeNote(Model model, @PathVariable("id") Long id) {
		noteRepository.delete(id);
		List<Note> allNote = (List<Note>)noteRepository.findAll();
		model.addAttribute("notes", allNote);
		return "index";
	}

}
