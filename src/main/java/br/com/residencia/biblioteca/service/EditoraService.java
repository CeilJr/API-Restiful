package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.EditoraDTO;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.repository.EditoraRepository;

@Service
public class EditoraService/* extends Editora*/{
	@Autowired
	EditoraRepository editoraRepository;
	
	public List<Editora> getAllEditoras(){
		return editoraRepository.findAll();
	}
	
	public List<EditoraDTO> getAllEditorasDTO(){
		return editoraRepository.findAll();
	}
	
	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}
	
	public Editora saveEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public EditoraDTO saveEditoraDTO(EditoraDTO editoraDTO){
		
		Editora editora = new Editora(editoraDTO.getNome());
		//editora.setNome(editoraDTO.getNome());
		editora = editoraRepository.save(editora);
		
		EditoraDTO novaEditoraDTO = new EditoraDTO(editora.getCodigoEditora(), editora.getNome());
		/*novaEditoraDTO.setCodigoEditora(novaEditora.getCodigoEditora());
		novaEditoraDTO.setNome(novaEditora.getNome());*/
		
		return novaEditoraDTO;
	}
	
	public Editora updateEditora(Editora editora, Integer id) {
		Editora editoraExistenteNoBanco = getEditoraById(id);
		
		editoraExistenteNoBanco.setNome(editora.getNome());
		
		return editoraRepository.save(editoraExistenteNoBanco);
	}
	
	public Editora deleteEditora(Integer id) {
		editoraRepository.deleteById(id);
		return getEditoraById(id);
	}

}
