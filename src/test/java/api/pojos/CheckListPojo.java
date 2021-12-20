package api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckListPojo {
        private String id;
        private String name;
        private String idCard;
        private int pos;
        private String idBoard;

    public CheckListPojo(String id, String name, String idCard, int pos, String idBoard) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.pos = pos;
        this.idBoard = idBoard;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public int getPos() {
        return pos;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public CheckListPojo() {
        super();
    }
}
