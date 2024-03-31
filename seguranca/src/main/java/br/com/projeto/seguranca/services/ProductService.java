package br.com.projeto.seguranca.services;

import br.com.projeto.seguranca.dto.ProductDTO;
import br.com.projeto.seguranca.entities.Product;
import br.com.projeto.seguranca.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product entity = repository.findById(id).get();
        return new ProductDTO(entity);
    }

    @Transactional
    public List<ProductDTO> findAll(){
        return repository.findAll().stream().map(x -> new ProductDTO(x)).toList();
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }
}
