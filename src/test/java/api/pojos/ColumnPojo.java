package api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColumnPojo {
    private String id;
    private String name;
    private boolean closed;
    private int pos;
    private String idBoard;

    public ColumnPojo(String id, String name, boolean closed, int pos, String idBoard) {
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

    public ColumnPojo() {
        super();
    }
}
