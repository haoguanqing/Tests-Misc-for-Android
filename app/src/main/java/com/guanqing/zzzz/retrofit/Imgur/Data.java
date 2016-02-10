package com.guanqing.zzzz.retrofit.Imgur;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "deletehash",
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
        "favorite",
        "nsfw",
        "section",
        "gifv",
        "webm",
        "mp4",
        "link",
        "looping",
        "vote",
        "account_url",
        "account_id",
        "comment_preview"
})
public class Data {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("deletehash")
    private String deletehash;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("datetime")
    private int datetime;
    @JsonProperty("type")
    private String type;
    @JsonProperty("animated")
    private boolean animated;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;
    @JsonProperty("size")
    private int size;
    @JsonProperty("views")
    private int views;
    @JsonProperty("bandwidth")
    private long bandwidth;
    @JsonProperty("favorite")
    private boolean favorite;
    @JsonProperty("nsfw")
    private boolean nsfw;
    @JsonProperty("section")
    private String section;
    @JsonProperty("gifv")
    private String gifv;
    @JsonProperty("webm")
    private String webm;
    @JsonProperty("mp4")
    private String mp4;
    @JsonProperty("link")
    private String link;
    @JsonProperty("looping")
    private boolean looping;
    @JsonProperty("vote")
    private String vote;
    @JsonProperty("account_url")
    private String accountUrl;
    @JsonProperty("account_id")
    private String accountId;
    @JsonProperty("comment_preview")
    private String commentPreview;
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
     * The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The deletehash
     */
    @JsonProperty("deletehash")
    public String getDeletehash() {
        return deletehash;
    }

    /**
     *
     * @param deletehash
     * The deletehash
     */
    @JsonProperty("deletehash")
    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The datetime
     */
    @JsonProperty("datetime")
    public int getDatetime() {
        return datetime;
    }

    /**
     *
     * @param datetime
     * The datetime
     */
    @JsonProperty("datetime")
    public void setDatetime(int datetime) {
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
    public boolean isAnimated() {
        return animated;
    }

    /**
     *
     * @param animated
     * The animated
     */
    @JsonProperty("animated")
    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    /**
     *
     * @return
     * The width
     */
    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The size
     */
    @JsonProperty("size")
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     * The size
     */
    @JsonProperty("size")
    public void setSize(int size) {
        this.size = size;
    }

    /**
     *
     * @return
     * The views
     */
    @JsonProperty("views")
    public int getViews() {
        return views;
    }

    /**
     *
     * @param views
     * The views
     */
    @JsonProperty("views")
    public void setViews(int views) {
        this.views = views;
    }

    /**
     *
     * @return
     * The bandwidth
     */
    @JsonProperty("bandwidth")
    public long getBandwidth() {
        return bandwidth;
    }

    /**
     *
     * @param bandwidth
     * The bandwidth
     */
    @JsonProperty("bandwidth")
    public void setBandwidth(long bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     *
     * @return
     * The favorite
     */
    @JsonProperty("favorite")
    public boolean isFavorite() {
        return favorite;
    }

    /**
     *
     * @param favorite
     * The favorite
     */
    @JsonProperty("favorite")
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    /**
     *
     * @return
     * The nsfw
     */
    @JsonProperty("nsfw")
    public boolean isNsfw() {
        return nsfw;
    }

    /**
     *
     * @param nsfw
     * The nsfw
     */
    @JsonProperty("nsfw")
    public void setNsfw(boolean nsfw) {
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
    public boolean isLooping() {
        return looping;
    }

    /**
     *
     * @param looping
     * The looping
     */
    @JsonProperty("looping")
    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    /**
     *
     * @return
     * The vote
     */
    @JsonProperty("vote")
    public String getVote() {
        return vote;
    }

    /**
     *
     * @param vote
     * The vote
     */
    @JsonProperty("vote")
    public void setVote(String vote) {
        this.vote = vote;
    }

    /**
     *
     * @return
     * The accountUrl
     */
    @JsonProperty("account_url")
    public String getAccountUrl() {
        return accountUrl;
    }

    /**
     *
     * @param accountUrl
     * The account_url
     */
    @JsonProperty("account_url")
    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    /**
     *
     * @return
     * The accountId
     */
    @JsonProperty("account_id")
    public String getAccountId() {
        return accountId;
    }

    /**
     *
     * @param accountId
     * The account_id
     */
    @JsonProperty("account_id")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     *
     * @return
     * The commentPreview
     */
    @JsonProperty("comment_preview")
    public String getCommentPreview() {
        return commentPreview;
    }

    /**
     *
     * @param commentPreview
     * The comment_preview
     */
    @JsonProperty("comment_preview")
    public void setCommentPreview(String commentPreview) {
        this.commentPreview = commentPreview;
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