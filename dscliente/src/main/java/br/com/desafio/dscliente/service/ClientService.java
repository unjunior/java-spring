package br.com.desafio.dscliente.service;

import br.com.desafio.dscliente.dto.ClientDTO;
import br.com.desafio.dscliente.entities.Client;
import br.com.desafio.dscliente.repository.ClientRepositoty;
import br.com.desafio.dscliente.service.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepositoty repositoty;

    @Transactional(readOnly = true)
    public ClientDTO finbById(Long id){
        Client client = repositoty.findById(id).orElseThrow(
                () -> new ResourceNotFound("O recurso não foi encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repositoty.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = repositoty.save(entity);
        return new ClientDTO(entity);
    }
    @Transactional
    public ClientDTO update (Long id, ClientDTO dto){
        try {
            Client entity = repositoty.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repositoty.save(entity);
            return new ClientDTO(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFound("Recurso não encontrado para update");
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repositoty.existsById(id)){
            throw new ResourceNotFound("Recurso não encontrado para delete!");
        }
       repositoty.deleteById(id);
    }
    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }


}
