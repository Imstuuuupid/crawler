package com.xzx.crawler.entity;

import java.io.Serializable;
import java.util.Date;

public class ArticleTest implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.id
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.title
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.author
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.url
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.authority
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private Double authority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.hub
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private Double hub;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.task_id
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private Long taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.create_date
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.update_date
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.is_delete
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private Byte isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column article_copy1.desc
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private String desc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table article_copy1
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.id
     *
     * @return the value of article_copy1.id
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.id
     *
     * @param id the value for article_copy1.id
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.title
     *
     * @return the value of article_copy1.title
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.title
     *
     * @param title the value for article_copy1.title
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.author
     *
     * @return the value of article_copy1.author
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.author
     *
     * @param author the value for article_copy1.author
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.url
     *
     * @return the value of article_copy1.url
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.url
     *
     * @param url the value for article_copy1.url
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.authority
     *
     * @return the value of article_copy1.authority
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public Double getAuthority() {
        return authority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.authority
     *
     * @param authority the value for article_copy1.authority
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setAuthority(Double authority) {
        this.authority = authority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.hub
     *
     * @return the value of article_copy1.hub
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public Double getHub() {
        return hub;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.hub
     *
     * @param hub the value for article_copy1.hub
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setHub(Double hub) {
        this.hub = hub;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.task_id
     *
     * @return the value of article_copy1.task_id
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.task_id
     *
     * @param taskId the value for article_copy1.task_id
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.create_date
     *
     * @return the value of article_copy1.create_date
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.create_date
     *
     * @param createDate the value for article_copy1.create_date
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.update_date
     *
     * @return the value of article_copy1.update_date
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.update_date
     *
     * @param updateDate the value for article_copy1.update_date
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.is_delete
     *
     * @return the value of article_copy1.is_delete
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.is_delete
     *
     * @param isDelete the value for article_copy1.is_delete
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article_copy1.desc
     *
     * @return the value of article_copy1.desc
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article_copy1.desc
     *
     * @param desc the value for article_copy1.desc
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article_copy1
     *
     * @mbg.generated Fri Jan 08 21:53:58 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", url=").append(url);
        sb.append(", authority=").append(authority);
        sb.append(", hub=").append(hub);
        sb.append(", taskId=").append(taskId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", desc=").append(desc);
        sb.append("]");
        return sb.toString();
    }
}