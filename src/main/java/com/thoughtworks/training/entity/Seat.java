package com.thoughtworks.training.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_seat")
public class Seat {
    @Id
    private UUID id;
    private Integer status;

    private Integer x;

    private Integer y;

    @OneToOne
    @JoinTable(name = "t_user_seat",
            joinColumns = @JoinColumn(name = "seat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
