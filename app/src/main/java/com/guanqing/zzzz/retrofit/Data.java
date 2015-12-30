package com.guanqing.zzzz.retrofit;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Guanqing on 2015/12/30.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "description",
        "datetime",
        "type",
        "animated",
        "width",
        "height",
        "size",
        "views",
        "bandwidth",
        "vote",
        "favorite",
        "nsfw",
        "section",
        "account_url",
        "account_id",
        "comment_preview",
        "gifv",
        "webm",
        "mp4",
        "link",
        "looping"
})
public class Data {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("datetime")
    private Long datetime;
    @JsonProperty("type")
    private String type;
    @JsonProperty("animated")
    private Boolean animated;
    @JsonProperty("width")
    private Long width;
    @JsonProperty("height")
    private Long height;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("views")
    private Long views;
    @JsonProperty("bandwidth")
    private Long bandwidth;
    @JsonProperty("vote")
    private Object vote;
    @JsonProperty("favorite")
    private Boolean favorite;
    @JsonProperty("nsfw")
    private Boolean nsfw;
    @JsonProperty("section")
    private String section;
    @JsonProperty("account_url")
    private Object accountUrl;
    @JsonProperty("account_id")
    private Object accountId;
    @JsonProperty("comment_preview")
    private Object commentPreview;
    @JsonProperty("gifv")
    private String gifv;
    @JsonProperty("webm")
    private String webm;
    @JsonProperty("mp4")
    private String mp4;
    @JsonProperty("link")
    private String link;
    @JsonProperty("looping")
    private Boolean looping;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The description
     */
    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The datetime
     */
    @JsonProperty("datetime")
    public Long getDatetime() {
        return datetime;
    }

    /**
     *
     * @param datetime
     * The datetime
     */
    @JsonProperty("datetime")
    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

    /**
     *
     * @return
     * The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The animated
     */
    @JsonProperty("animated")
    public Boolean getAnimated() {
        return animated;
    }

    /**
     *
     * @param animated
     * The animated
     */
    @JsonProperty("animated")
    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return
     * The width
     */
    @JsonProperty("width")
    public Long getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    @JsonProperty("width")
    public void setWidth(Long width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    @JsonProperty("height")
    public Long getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    @JsonProperty("height")
    public void setHeight(Long height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The size
     */
    @JsonProperty("size")
    public Long getSize() {
        return size;
    }

    /**
     *
     * @param size
     * The size
     */
    @JsonProperty("size")
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     *
     * @return
     * The views
     */
    @JsonProperty("views")
    public Long getViews() {
        return views;
    }

    /**
     *
     * @param views
     * The views
     */
    @JsonProperty("views")
    public void setViews(Long views) {
        this.views = views;
    }

    /**
     *
     * @return
     * The bandwidth
     */
    @JsonProperty("bandwidth")
    public Long getBandwidth() {
        return bandwidth;
    }

    /**
     *
     * @param bandwidth
     * The bandwidth
     */
    @JsonProperty("bandwidth")
    public void setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     *
     * @return
     * The vote
     */
    @JsonProperty("vote")
    public Object getVote() {
        return vote;
    }

    /**
     *
     * @param vote
     * The vote
     */
    @JsonProperty("vote")
    public void setVote(Object vote) {
        this.vote = vote;
    }

    /**
     *
     * @return
     * The favorite
     */
    @JsonProperty("favorite")
    public Boolean getFavorite() {
        return favorite;
    }

    /**
     *
     * @param favorite
     * The favorite
     */
    @JsonProperty("favorite")
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    /**
     *
     * @return
     * The nsfw
     */
    @JsonProperty("nsfw")
    public Boolean getNsfw() {
        return nsfw;
    }

    /**
     *
     * @param nsfw
     * The nsfw
     */
    @JsonProperty("nsfw")
    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    /**
     *
     * @return
     * The section
     */
    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    /**
     *
     * @param section
     * The section
     */
    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    /**
     *
     * @return
     * The accountUrl
     */
    @JsonProperty("account_url")
    public Object getAccountUrl() {
        return accountUrl;
    }

    /**
     *
     * @param accountUrl
     * The account_url
     */
    @JsonProperty("account_url")
    public void setAccountUrl(Object accountUrl) {
        this.accountUrl = accountUrl;
    }

    /**
     *
     * @return
     * The accountId
     */
    @JsonProperty("account_id")
    public Object getAccountId() {
        return accountId;
    }

    /**
     *
     * @param accountId
     * The account_id
     */
    @JsonProperty("account_id")
    public void setAccountId(Object accountId) {
        this.accountId = accountId;
    }

    /**
     *
     * @return
     * The commentPreview
     */
    @JsonProperty("comment_preview")
    public Object getCommentPreview() {
        return commentPreview;
    }

    /**
     *
     * @param commentPreview
     * The comment_preview
     */
    @JsonProperty("comment_preview")
    public void setCommentPreview(Object commentPreview) {
        this.commentPreview = commentPreview;
    }

    /**
     *
     * @return
     * The gifv
     */
    @JsonProperty("gifv")
    public String getGifv() {
        return gifv;
    }

    /**
     *
     * @param gifv
     * The gifv
     */
    @JsonProperty("gifv")
    public void setGifv(String gifv) {
        this.gifv = gifv;
    }

    /**
     *
     * @return
     * The webm
     */
    @JsonProperty("webm")
    public String getWebm() {
        return webm;
    }

    /**
     *
     * @param webm
     * The webm
     */
    @JsonProperty("webm")
    public void setWebm(String webm) {
        this.webm = webm;
    }

    /**
     *
     * @return
     * The mp4
     */
    @JsonProperty("mp4")
    public String getMp4() {
        return mp4;
    }

    /**
     *
     * @param mp4
     * The mp4
     */
    @JsonProperty("mp4")
    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    /**
     *
     * @return
     * The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The looping
     */
    @JsonProperty("looping")
    public Boolean getLooping() {
        return looping;
    }

    /**
     *
     * @param looping
     * The looping
     */
    @JsonProperty("looping")
    public void setLooping(Boolean looping) {
        this.looping = looping;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}