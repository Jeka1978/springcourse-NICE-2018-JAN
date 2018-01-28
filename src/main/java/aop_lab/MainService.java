package aop_lab;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
@RequiredArgsConstructor
public class MainService {
    private final SomeDao someDao;

    public void doWork() {
        someDao.save();
    }
}
