package system.models;

import system.DistributionSystem;
import system.Object;
import system.Subject;

public class LatticeModel implements DistributionSystem {
    /**
     * lattice model mapped on dividers of 30
     * @param s subject that wants to check permissions
     * @param o object to
     * @return true if s have permissions
     */
    public boolean checkPermission(Subject s, Object o) {
        return (s.getLabel()>=o.getLabel())&&(s.getLabel()%o.getLabel() == 0);
    }
}
