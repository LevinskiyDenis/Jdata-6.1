package com.example.jdata6_1.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    // Не понимаю, как работают в Hibernate связанные сущности UserCredentials и Role и как нам это все заджойнить
    // Рилейшны написал правильно, но все равно никак не вкурю термины родительская и детская таблица
    // Вот эту статью надо почитать https://www.baeldung.com/hibernate-one-to-many
    // http://java-online.ru/hibernate-entities.xhtml
    // https://www.baeldung.com/role-and-privilege-for-spring-security-registration
    // https://www.javadevjournal.com/spring-security/spring-security-roles-and-permissions/
    // проблема - ввылазит эксепш хибернейта что лейзилоад базы. Надо проверить, что будет, если постаивть eager, хотя
    // так решать проблему нельзя
    // failed to lazily initialize a collection of role: com.example.jdata6_1.entity.Role.operations, could not initialize proxy - no Session
    // https://www.baeldung.com/hibernate-initialize-proxy-exception
    // у телки похожая проблема https://stackoverflow.com/questions/46810929/how-to-use-fetchtype-lazy-with-manytomany
    // может просто мэни тумэни попробвоать на более простом примере
    // https://www.logicbig.com/tutorials/spring-framework/spring-data-access-with-jdbc/correct-use-of-declarative-transaction.html
    // дофига советов в этом топике: https://stackoverflow.com/questions/11746499/how-to-solve-the-failed-to-lazily-initialize-a-collection-of-role-hibernate-ex

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(columnDefinition = "boolean default true")
    boolean IsAccountNonExpired;

    @Column(columnDefinition = "boolean default true")
    boolean IsAccountNonLocked;

    @Column(columnDefinition = "boolean default true")
    boolean isCredentialsNonExpired;

    @Column(columnDefinition = "boolean default true")
    boolean isEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isIsAccountNonExpired() {
        return IsAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        IsAccountNonExpired = accountNonExpired;
    }

    public boolean isIsAccountNonLocked() {
        return IsAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        IsAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
