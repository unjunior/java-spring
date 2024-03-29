package br.com.projeto.seguranca.dto;

public class ProductDTO {

    private Long id;
    private String name;

    public ProductDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
