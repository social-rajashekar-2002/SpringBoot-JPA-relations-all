package com.relations.demo.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
    @AttributeOverride(name="name",column=@Column(name="guardianName")),
    @AttributeOverride(name="email",column=@Column(name="guardianEmail"))

})
@Builder
public class Guardian {

    private String name;
    private String email;
}
