package com.example.Aesthetic.model.background;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Background {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String url;

    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for url
    public String getUrl() {
        return url;
    }

    // Setter for url
    public void setUrl(String url) {
        this.url = url;
    }

}
