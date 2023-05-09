package com.spring.capstone_project_backend.dto;

import org.springframework.web.multipart.MultipartFile;

public class EventoImmagineDto {
    private Long id;
    private MultipartFile immagine;

    public EventoImmagineDto(Long id, MultipartFile immagine) {
        this.id = id;
        this.immagine = immagine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getImmagine() {
        return immagine;
    }

    public void setImmagine(MultipartFile immagine) {
        this.immagine = immagine;
    }
}
