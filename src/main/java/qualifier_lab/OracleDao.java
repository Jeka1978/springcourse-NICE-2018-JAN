package qualifier_lab;

import org.springframework.stereotype.Repository;

/**
 * @author Evgeny Borisov
 */
@Repository
public class OracleDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to Oracle...");
    }
}
