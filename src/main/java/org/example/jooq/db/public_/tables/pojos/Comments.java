/**
 * This class is generated by jOOQ
 */
package org.example.jooq.db.public_.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Comments implements Serializable {

	private static final long serialVersionUID = -1711413510;

	private Integer   id;
	private Integer   postId;
	private String    name;
	private String    email;
	private String    content;
	private Timestamp createdOn;

	public Comments() {}

	public Comments(Comments value) {
		this.id = value.id;
		this.postId = value.postId;
		this.name = value.name;
		this.email = value.email;
		this.content = value.content;
		this.createdOn = value.createdOn;
	}

	public Comments(
		Integer   id,
		Integer   postId,
		String    name,
		String    email,
		String    content,
		Timestamp createdOn
	) {
		this.id = id;
		this.postId = postId;
		this.name = name;
		this.email = email;
		this.content = content;
		this.createdOn = createdOn;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Comments (");

		sb.append(id);
		sb.append(", ").append(postId);
		sb.append(", ").append(name);
		sb.append(", ").append(email);
		sb.append(", ").append(content);
		sb.append(", ").append(createdOn);

		sb.append(")");
		return sb.toString();
	}
}
