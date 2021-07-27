package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
    
    /* definimos uma propriedade “fetch” = FetchType.LAZY. Isso significa que ao realizarmos um 
	“SELECT * from FuncionarioLazy” teremos todos os campos retornados, mas os campos com a 
	propriedade FetchType.LAZY estarão nulos, mesmo que eles existam no banco. Essa é uma forma de n
	ão sobrecarregar sua aplicação com dados inúteis que não serão utilizados, tornando-a rápida e 
	performática.
	
	Voltando ao nosso cenário de exemplo, temos então a classe FuncionarioLazy acima, e precisamos 
	de uma lista com todos os nomes e idades dos funcionários da empresa. Faremos um simples 
	“SELECT * FROM FuncionarioLazy” e temos todos os dados em mãos, nosso objeto estará carregado \
	apenas com o nome e idade, todos os outros campos estarão nulos.
	*/
}
