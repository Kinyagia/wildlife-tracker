import java.util.Timer;
import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;

public class EndangeredAnimal extends Animal {
  private boolean isEndangered;
  private String health;
  private String age;

public static final String MAX_HEALTH = "healthy";
public static final String MEDIUM_HEALTH = "okay";
public static final String LOW_HEALTH = "ill";

public static final String AGE  = "newborn";

public EndangeredAnimal(String name) {
   super(name);
   isEndangered = isEndangered;
   health = MAX_HEALTH;
   age = AGE;

}

}
