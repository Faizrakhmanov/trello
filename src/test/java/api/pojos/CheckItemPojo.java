package api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckItemPojo {
    private String idChecklist;
    private String state;
    private String id;
    private String name;

    public CheckItemPojo(String idChecklist, String state, String id, String name) {
        this.idChecklist = idChecklist;
        this.state = state;
        this.id = id;
        this.name = name;
    }

    public String getIdChecklist() {
        return idChecklist;
    }

    public String getState() {
        return state;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CheckItemPojo() {
        super();
    }
}
