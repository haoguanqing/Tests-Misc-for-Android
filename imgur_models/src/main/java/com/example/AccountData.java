package com.example;

/**
 * Created by Guanqing on 2016/2/9.
 */
public class AccountData {
    private Integer id;
    private String url;
    private String bio;
    private Double reputation;
    private Integer created;
    private Boolean proExpiration;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The bio
     */
    public String getBio() {
        return bio;
    }

    /**
     *
     * @param bio
     * The bio
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     *
     * @return
     * The reputation
     */
    public Double getReputation() {
        return reputation;
    }

    /**
     *
     * @param reputation
     * The reputation
     */
    public void setReputation(Double reputation) {
        this.reputation = reputation;
    }

    /**
     *
     * @return
     * The created
     */
    public Integer getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    public void setCreated(Integer created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The proExpiration
     */
    public Boolean getProExpiration() {
        return proExpiration;
    }

    /**
     *
     * @param proExpiration
     * The pro_expiration
     */
    public void setProExpiration(Boolean proExpiration) {
        this.proExpiration = proExpiration;
    }
}
