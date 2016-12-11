package system.models;

import system.DistributionSystem;
import system.Object;
import system.Subject;

public class BibaModel implements DistributionSystem {
    /**
     * @return true if full control, false if only read of write
     */
    public boolean checkPermission(Subject s, Object o) {
        if (s.getLabel() == o.getLabel()) {
            return true;
        } else if (s.getLabel() > o.getLabel()) {
            System.out.println("only write");
            return false;
        } else {
            System.out.println("only read");
            return false;
        }

    }
}
