package Registraton;

import org.hibernate.annotations.NaturalId;

public record RegistrationRequest(
     String UserName,
     String Firstname,
     String Lastname,
     String Role,
     String email,
     Integer age,
     String password )
{

        }
