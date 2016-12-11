package system;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.PortableInterceptor.DISCARDING;
import system.models.BelaLaPadulaModel;
import system.models.BibaModel;
import system.models.LatticeModel;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Context {
    private Models model;

    @JsonView(DistributionSystem.class)
    private Set<Object> objects;

    @JsonView(DistributionSystem.class)
    private Set<Subject> subjects;

    private ObjectMapper mapper = new ObjectMapper();

    public enum Models{
        Lattice(new LatticeModel(),new File("src/main/resources/lattice.json")),
        Biba(new BibaModel(),new File("src/main/resources/biba.json")),
        BalaLaPadula(new BelaLaPadulaModel(),new File("src/main/resources/lapadula.json"));

        private DistributionSystem ds;
        private File contextFile;


        Models(DistributionSystem ds,File contextFile) {
            this.ds = ds;
            this.contextFile = contextFile;
        }

        public DistributionSystem getDs() {
            return ds;
        }
        public File getContextFile() {
            return contextFile;
        }
    }

    public void setDistributionSystem(Models model){
         this.model = model;
    }

    public Set<Object> getObjects() {
        return objects;
    }

    public void setObjects(Set<Object> objects) {
        this.objects = objects;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public void loadContext() throws IOException {
        Context c = mapper.readerWithView(DistributionSystem.class).forType(Context.class).readValue(model.getContextFile());
        setObjects(c.getObjects());
        setSubjects(c.getSubjects());
    }

    public void save() throws IOException {
        mapper.writerWithView(DistributionSystem.class).forType(Context.class).writeValue(model.getContextFile(),this);
    }

    public boolean checkPermissions(Subject s,Object o){
        return model.getDs().checkPermission(s,o);
    }

}
