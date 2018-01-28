package aop_lab.dao;

import aop_lab.DataBaseException;
import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Repository
public class SomeDaoImpl implements SomeDao {
    @Override
    public void save() {
        Random random = new Random();
        if (random.nextInt(3) == 1) {
            throw new DataBaseException("fire all dba");
        }
        System.out.println("Data was saved...");
    }
}
