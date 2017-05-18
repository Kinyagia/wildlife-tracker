import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

@Test
public void animal_InstantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Buffalo");
        assertEquals(true, testAnimal instanceof Animal);
}

@Test
public void animal_InstantiatesWithName_String() {
        Animal testAnimal = new Animal("Buffalo");
        assertEquals("Buffalo", testAnimal.getName());
}

@Test
public void equals_returnsTrueIfNameAreSame_true() {
        Animal firstAnimal = new Animal("Buffalo");
        Animal secondAnimal = new Animal("Buffalo");
        assertTrue(firstAnimal.equals(secondAnimal));
}

@Test
public void save_insertObjectIntoDatabase_Animal() {
        Animal testAnimal = new Animal("Buffalo");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
}

@Test
public void all_returnsAllInstancesOfAnimal_true() {
       Animal firstAnimal = new Animal("Buffalo");
       firstAnimal.save();
       Animal secondAnimal = new Animal("Hippo");
       secondAnimal.save();
       assertEquals(true, Animal.all().get(0).equals(firstAnimal));
       assertEquals(true, Animal.all().get(1).equals(secondAnimal));
}

@Test
public void save_assignsIdToObject() {
  Animal testAnimal = new Animal("Buffalo");
  testAnimal.save();
  Animal savedAnimal = Animal.all().get(0);
  assertEquals(testAnimal.getId(), savedAnimal.getId());
}

public void find_returnsPersonWithSameId_secondAnimal() {
  Animal firstAnimal = new Animal("Buffalo");
  firstAnimal.save();
  Animal secondAnimal = new Animal("Hippo");
  secondAnimal.save();
  assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
}
}
