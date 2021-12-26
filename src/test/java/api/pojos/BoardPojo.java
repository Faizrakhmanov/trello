package api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardPojo {
    private String id;
    private String name;
    private String desc;
    private Object descData;
    private boolean closed;
    private String idOrganization;
    private Object idEnterprise;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Object getDescData() {
        return descData;
    }

    public boolean isClosed() {
        return closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public Object getIdEnterprise() {
        return idEnterprise;
    }

    public boolean isPinned() {
        return pinned;
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public BoardPojo(String id, String name, String desc, Object descData, boolean closed, String idOrganization, Object idEnterprise, boolean pinned, String url, String shortUrl) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.descData = descData;
        this.closed = closed;
        this.idOrganization = idOrganization;
        this.idEnterprise = idEnterprise;
        this.pinned = pinned;
        this.url = url;
        this.shortUrl = shortUrl;
    }

    public boolean pinned;
    public String url;
    public String shortUrl;

    public BoardPojo() {
        super();
    }
}
