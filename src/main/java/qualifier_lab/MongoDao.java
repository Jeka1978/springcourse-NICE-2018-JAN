package qualifier_lab;

import org.springframework.stereotype.Repository;

/**
 * @author Evgeny Borisov
 */
@NiceRepository(DBType.MONGO)
public class MongoDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to mongo much faster than oracle...");
    }
}
