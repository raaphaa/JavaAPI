package tech.jaya.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.escritorioAgil.entity.Pessoas;
import br.com.escritorioAgil.entity.DTO.PessoaDTO;
import tech.jaya.project.domain.User;
import tech.jaya.project.dto.UserResgisterDTO;
import tech.jaya.project.exception.NotFoundException;
import tech.jaya.project.repository.UserRepository;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	
	public UserResgisterDTO createUser(UserResgisterDTO userDTO) throws NotFoundException {
	
		if (userDTO == null) {
			
			logger.error("A Not Found error occurs for userDTO.");
			throw new NotFoundException("Cannot register an empty user.");

		} else {
			
			User userCreated = new User();
			userCreated.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
			userCreated.setLogin(userDTO.getLogin());
			userCreated.setName(userDTO.getName());
			userCreated.setEmail(userDTO.getEmail());
			repository.save(userCreated);
			
			logger.info("Request for user was successful.");
			
			return null ;	
		}
	}
	
	public List<Pessoas> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoas findById(Integer id) {
        Optional<Pessoas> entity = pessoaRepository.findById(id);
        if (entity.isPresent()){
        	entity.get().setSenha(null);
            return entity.get();
        }

        throw new RuntimeException();
    }

    public Pessoas save(PessoaDTO dto) {

        pessoaRepository.findByEmail(dto.getEmail());
        Optional <Pessoas> pessoasOptional= Optional.ofNullable(pessoaRepository.findByEmail(dto.getEmail()));

        if (pessoasOptional.isPresent()){
            return null;
        }


        Pessoas pessoas = new Pessoas();
        pessoas.setNome(dto.getNome());
        pessoas.setEmail(dto.getEmail());
        pessoas.setTelefone(dto.getTelefone());
        pessoas.setSenha(dto.getSenha());
        pessoas.setFoto(dto.getFoto());
        pessoas.setFuncao(dto.getFuncao());

        return pessoaRepository.save(pessoas);

    }

    public Pessoas update(Integer id, PessoaDTO dto) {
    	Optional<Pessoas> pessoas = pessoaRepository.findById(id);
    	
        pessoas.get().setNome(dto.getNome());
        pessoas.get().setEmail(dto.getEmail());
        pessoas.get().setTelefone(dto.getTelefone());
        
        if (dto.getSenha().equals("same1")) {
        	pessoas.get().setSenha(pessoas.get().getSenha());
        	
		}else {
			pessoas.get().setSenha(dto.getSenha());	
		}
        
        
        pessoas.get().setFoto(dto.getFoto());
        pessoas.get().setFuncao(dto.getFuncao());
        return pessoaRepository.save(pessoas.get());



    }

    public void delete(Integer id) {
        pessoaRepository.deleteById(id);
    }
    
    
    public String uploadImage(MultipartFile file, Integer userId) {
    	Optional<Pessoas> pessoa = pessoaRepository.findById(userId);
    	
    	if (pessoa.isEmpty()) return "Not Found";
    	
    	if (pessoa.get().getFoto() != null) {
    		this.deleteImage(userId);
    	}
    	
		String filePath = disk.saveFile(file, "/images");
		
		pessoa.get().setFoto(filePath);
		pessoaRepository.save(pessoa.get());
		
		return filePath;
	}
    
    public void deleteImage(Integer id) {
    	Optional<Pessoas> pessoa = pessoaRepository.findById(id);
		
		if (pessoa.isEmpty()) return;
		if (pessoa.get().getFoto() == null) return;
		
		
		disk.deleteFile(pessoa.get().getFoto(), "images");
		pessoa.get().setFoto(null);
		

		pessoaRepository.save(pessoa.get());
	}
    
}