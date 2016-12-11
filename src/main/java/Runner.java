import system.Context;
import system.Object;
import system.Subject;

import java.io.IOException;


public class Runner {
    public static void showInfo(Context context){
        for(Subject subj: context.getSubjects()){
            for(Object obj:context.getObjects()){
                System.out.println("Check permission for subject:" + subj.getName() + ", object:" + obj.getFile().getName());
                if (context.checkPermissions(subj,obj)){
                    System.out.println((char) 27 + "[32mfull control" + (char)27 + "[0m");
                }else {
                    System.out.println((char) 27 + "[31mpermission denied" + (char)27 + "[0m");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println((char) 27 + "[34mLattice model: " + (char)27 + "[0m");

        Context context = new Context();
        context.setDistributionSystem(Context.Models.Lattice);
        context.loadContext();
        showInfo(context);

        System.out.println((char) 27 + "[34mBiba model: "+ (char)27 + "[0m");
        context.setDistributionSystem(Context.Models.Biba);
        context.loadContext();
        showInfo(context);

        System.out.println((char) 27 + "[34mBella la Padula model: "+ (char)27 + "[0m");
        context.setDistributionSystem(Context.Models.BalaLaPadula);
        context.loadContext();
        showInfo(context);
    }
}
