package com.pragma.arquetipobootcamp2024.domain.model;

import com.pragma.arquetipobootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.arquetipobootcamp2024.domain.util.DomainConstants;

import static java.util.Objects.requireNonNull;

public class Tecnologia {
    private final Long id;
    private final String name;
    private final String descrip;

    public Tecnologia(long id, String name, String descrip){
        if (name.trim().isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (descrip.trim().isEmpty()){
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPCION.toString());
        }

        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.descrip = requireNonNull(name, DomainConstants.FIELD_DESCRIPCION_NULL_MESSAGE);

    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public String getDescrip(){
        return descrip;
    }
}
