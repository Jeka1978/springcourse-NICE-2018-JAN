package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
@Getter
@AllArgsConstructor
public enum MaritalStatus {

    SINGLE("רווק", 1), MARRIED("נשוי", 2), DIVORCED("גרוש", 5);

    private final String hebrewDesc;
    private final int dbCode;


    public static MaritalStatus findByDbCode(int dbCode) throws UnsupportedOperationException {

     /*   MaritalStatus[] maritalStatuses = values();   old school style
        for (MaritalStatus maritalStatus : maritalStatuses) {
            if (maritalStatus.dbCode == dbCode) {
                return maritalStatus;
            }
        }*/

        Optional<MaritalStatus> optional = Arrays.stream(values())
                .filter(maritalStatus -> maritalStatus.dbCode == dbCode)
                .findAny();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new MaritalStatusNotSupportedException(dbCode + " not supported yet");
        }


    }

    @Override
    public String toString() {
        return hebrewDesc;
    }
}
