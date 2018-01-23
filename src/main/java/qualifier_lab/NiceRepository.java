package qualifier_lab;/**
 * @author Evgeny Borisov
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Qualifier
@Repository
public @interface NiceRepository {
    DBType value();
}
