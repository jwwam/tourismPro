package com.feelcode.tourism.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.rjeschke.txtmark.Processor;
import lombok.Data;

/**
 * @ClassName: Blog
 * @Auther: 朱利尔
 * @Date: 2021/4/7 01:21
 * @Description:
 */
@Entity
@Table(name = "tourism_blog")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer","handler"})
public class Blog extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "标题不能为空")
    @Size(min=2, max=60)
    @Column(nullable = false, length = 60) // 映射为字段，值不能为空
    private String title;

    @NotEmpty(message = "封面不能为空")
    @Size(min=2, max=300)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String coverImage;

    @NotEmpty(message = "摘要不能为空")
    @Size(min=2, max=300)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String summary;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch=FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min=2)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String content;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch=FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min=2)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String htmlContent; // 将 md 转为 html

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch=FetchType.EAGER) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min=2)
    @Column(nullable = false) // 映射为字段，值不能为空
    private String mdHtmlContent; // 由于this.htmlContent = Processor.process(content);转换code时存在显示bug，故增加此字段，页面中由marked()方法直接获取的html内容

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="reading")
    private Long reading = 0L; // 访问量、阅读量

    @Column(name="comments")
    private Long comments = 0L;  // 评论量

    @Column(name="likes")
    private Long likes = 0L;  // 点赞量

    protected Blog() {
        // TODO Auto-generated constructor stub
    }
    public Blog(String title, String summary,String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.htmlContent = Processor.process(content);
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public Long getComments() {
        return comments;
    }
    public void setComments(Long comments) {
        this.comments = comments;
    }
    public Long getLikes() {
        return likes;
    }
    public void setLikes(Long likes) {
        this.likes = likes;
    }
    public Long getReading() {
        return reading;
    }
    public void setReading(Long reading) {
        this.reading = reading;
    }

    public String getMdHtmlContent() {
        return mdHtmlContent;
    }

    public void setMdHtmlContent(String mdHtmlContent) {
        this.mdHtmlContent = mdHtmlContent;
    }
}