package projeto_adocao.projeto.de.adocao.service;

import org.springframework.stereotype.Service;
import projeto_adocao.projeto.de.adocao.exceptions.RecursoNaoEncontrado;
import projeto_adocao.projeto.de.adocao.model.Pet;
import projeto_adocao.projeto.de.adocao.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> listarPets() {
        return petRepository.findAll();
    }

    public Pet buscarPetPorId(Long id) {
        return petRepository.findById(id)
                .orElseThrow(null);
    }

    public void deletarPet(Long id) {
        if (petRepository.existsById(id)) {
            petRepository.deleteById(id);
        } else {
            throw new RecursoNaoEncontrado("Pet com ID " + id + " não encontrado.");
        }
    }

    public Pet salvarPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet atualizarPet(Long id, Pet petDetails) {
        Optional<Pet> petOptional = petRepository.findById(id);
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();

            pet.setNome(petDetails.getNome());
            pet.setIdade(petDetails.getIdade());
            pet.setTipo(petDetails.getTipo());
            pet.setRaca(petDetails.getRaca());
            pet.setPorte(petDetails.getPorte());
            pet.setDescricao(petDetails.getDescricao());
            pet.setImagemUrl(petDetails.getImagemUrl());
            pet.setLocalizacao(petDetails.getLocalizacao());
            pet.setDisponivel(petDetails.getDisponivel());

            return petRepository.save(pet);
        }else {
            throw new RecursoNaoEncontrado("Pet com o ID " + id + " não encontrado.");
        }
    }
}
