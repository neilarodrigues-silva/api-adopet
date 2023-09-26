package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroDeTutorDto;
import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroDeTutorDto dto){
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());
        if(jaCadastrado){
            throw  new ValidacaoExcpetion("Dadosjá cadastrados para outro tutor!");
        }
        repository.save(new Tutor(dto));

    }
public void atualizar(CadastroDeTutorDto dto){
        Tutor tutor = repository.getReferenceById(dto.id());
}
}
