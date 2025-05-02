package com.scaler.tictactoe.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }
}
