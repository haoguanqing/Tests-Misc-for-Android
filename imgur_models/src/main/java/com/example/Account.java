package com.example;

/**
 * Created by Guanqing on 2016/2/9.
 */
public class Account {
    private AccountData data;
    private Integer status;
    private Boolean success;

    /**
     *
     * @return
     * The data
     */
    public AccountData getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(AccountData data) {
        this.data = data;
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
}
