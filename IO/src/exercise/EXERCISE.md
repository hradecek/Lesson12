# File database for Social network

Vytvořme si jednoduchou souborovou databázi, ve které budou uloženy informace o uživatelích neexistující sociální sítě.

## Třída `User`
Nejprve si vytvořme jednoduchou tříd User (model), která bude reprezentovat uživatele.

Třída bude mít tyto atributy:
  - `username` - jméno uživatele (povinné)
  - `friends` - kolekce obsahující `username` přátel daného uživatele

Třída User by měla umožnit uzivateli přidávat a odebírat přátele.

> Nezapomeňte na metody `equals()` a `hashCode()`.<br>User bude identifikován pouze podle jména.

```java
final var user1 = new User("user1");
final var user2 = new User("user1", List.of("friend1", "friend2"));
final var user3 = new User("user2", List.of("friend1", "friend2"));

user1.equals(user2); // ==  true
user1.equals(user3); // == false
```

## Třída FileUserRepository
Vytvořte třídu `FileUserRepository`, která bude implementovat rozhraní `UserRepository`.

Toto rozhraní slouží k ukládání a načítání uživatelů z databáze.\
V našem připadě bude databází soubor.

**Názve souboru předejte v konstruktoru.**

### Ukládání uživatelů
Pro ukládání uživatelů implementujte dve metody.

```java
void save(Collection<User> usersToSave);
void save(User userToSave);
```

Jestliže uživatel již existuje, tak jej přepište (aktulizujte).\
Jestliže uživatel neexistuje, tak jej vytvořte.

#### Formát souboru
 - každý uživatel bude uložen na jednom řádku.
 - uživatel bude uložen ve formátu `username;friend1,friend2,friend3`

Přḱlad:
```text
alice;
bob;alice,joe
joe;alice,bob
```

> Formát souboru si můžete přizpůsobit 

### Načítání uživatelů
Pro načítání uživatelů implementujte opět dve metody:

```java
List<User> findAll();
Optional<User> findByUsername(String username);
```

Metoda `findAll()` načte všechny uživatele z databáze.\
Metoda `findByUsername(String username)` načte uživatele podle jména - jestliže, takový uživatel neexistuje, tak vrátí `Optional.empty()`.
