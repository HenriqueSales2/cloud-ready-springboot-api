package br.com.application.data.dto;

import br.com.application.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

// mudar a ordem das variáveis na hora de consultar no JSON
@JsonPropertyOrder({"id", "first_name", "last_name", "phoneNumber", "birthDay", "address", "gender", "sensitiveData"})
@JsonFilter("PersonFilter") // chamando esse filtro que declarei na classe "ObjectMapperConfig" para ocultar o campo
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonProperty("first_name") // exemplo
    private String firstName;

    @JsonProperty("last_name") // exemplo
    @JsonInclude(JsonInclude.Include.NON_NULL) // este campo só vai ser renderizado quando não estiver nulo
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY) // este campo só vai ser renderizado quando não estiver vazio
    private String phoneNumber;

    @JsonFormat(pattern = "dd/MM/yyyy") // conseguimos formatar a data no JSON, através dessa anotação
    private Date birthDay;

    private String address;

    //@JsonIgnore
    @JsonSerialize(using = GenderSerializer.class) //
    private String gender;

    private String sensitiveData;

    public PersonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSensitiveData() {
        return sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(getId(), personDTO.getId()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getPhoneNumber(), personDTO.getPhoneNumber()) && Objects.equals(getBirthDay(), personDTO.getBirthDay()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getGender(), personDTO.getGender()) && Objects.equals(getSensitiveData(), personDTO.getSensitiveData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPhoneNumber(), getBirthDay(), getAddress(), getGender(), getSensitiveData());
    }
}
