package de.dreadlabs;

import java.util.ArrayList;

public class OptionalStreamArrayOperationsTest {

    private void doIt() {
        ArrayList<String> list = new ArrayList<>();
        String configs = params.getConfigurationIds(); // TODO: CSV list payload
        if (configs != null && !configs.trim().isEmpty()) { // TODO: compare with call to StringValidator.isEmptyString() at line 5
            // split the list and put all items into the list
            if (!StringValidator.isEmptyString(configs)) { // TODO: method body like: string == null || string.trim().isEmpty()
                String[] feld = configs.split(",");
                if (feld != null) {
                    if (feld.length > 0) {
                        for (String dummy : feld) {
                            String tmp = dummy.trim();
                            if (tmp.length() > 0) {
                                list.add(tmp);
                            }
                        }
                    } else { // no comma
                        list.add(configs);
                    }
                }
            }
        }
    }
}
