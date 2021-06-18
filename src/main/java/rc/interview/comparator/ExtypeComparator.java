package rc.interview.comparator;

import rc.interview.Extension;

import java.util.Comparator;

public class ExtypeComparator implements Comparator<Extension> {
    @Override
    public int compare(Extension o1, Extension o2) {


        return ExtValue.saltOf(o1.getExtType()) - ExtValue.saltOf(o2.getExtType());
    }

    public enum ExtValue {
        USER("User", 1),
        DEPT("Dept", 2),
        AO("AO", 3),
        TMO("TMO", 4),
        OTHER("Other", 5);

        private int salt;
        private String description;

        private ExtValue(String description, int salt) {
            this.description = description;
            this.salt = salt;
        }

        public int getSalt() {
            return salt;
        }

        public String getDescription() {
            return description;
        }

        public static int saltOf(String description) {
            for (ExtValue itemEnum : ExtValue.values()) {
                if (itemEnum.getDescription() == description) {
                    return itemEnum.getSalt();
                }
            }
            return 100;
        }

    }
}
