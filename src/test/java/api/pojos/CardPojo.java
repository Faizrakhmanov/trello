package api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardPojo {
        private String id;
        private String name;
        private boolean closed;
        private int pos;
        private String idBoard;

    public CardPojo(String id, String name, boolean closed, int pos, String idBoard) {
        this.id = id;
        this.name = name;
        this.closed = closed;
        this.pos = pos;
        this.idBoard = idBoard;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isClosed() {
        return closed;
    }

    public int getPos() {
        return pos;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public CardPojo() {
        super();
    }
}
