package com.example;

/**
 * Created by Guanqing on 2016/2/9.
 */
public class Image {

    private ImageData data;
    private Boolean success;
    private Integer status;

    /**
     *
     * @return
     * The data
     */
    public ImageData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(ImageData data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     * The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
