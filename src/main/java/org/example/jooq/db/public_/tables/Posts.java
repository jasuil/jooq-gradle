/**
 * This class is generated by jOOQ
 */
package org.example.jooq.db.public_.tables;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.example.jooq.db.public_.Keys;
import org.example.jooq.db.public_.Public;
import org.example.jooq.db.public_.tables.records.PostsRecord;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


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
public class Posts extends TableImpl<PostsRecord> {

	private static final long serialVersionUID = 1404346138;

	/**
	 * The reference instance of <code>PUBLIC.POSTS</code>
	 */
	public static final Posts POSTS = new Posts();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<PostsRecord> getRecordType() {
		return PostsRecord.class;
	}

	/**
	 * The column <code>PUBLIC.POSTS.ID</code>.
	 */
	public final TableField<PostsRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.POSTS.TITLE</code>.
	 */
	public final TableField<PostsRecord, String> TITLE = createField("TITLE", org.jooq.impl.SQLDataType.VARCHAR.length(200).nullable(false), this, "");

	/**
	 * The column <code>PUBLIC.POSTS.CONTENT</code>.
	 */
	public final TableField<PostsRecord, String> CONTENT = createField("CONTENT", org.jooq.impl.SQLDataType.CLOB.defaulted(true), this, "");

	/**
	 * The column <code>PUBLIC.POSTS.CREATED_ON</code>.
	 */
	public final TableField<PostsRecord, Timestamp> CREATED_ON = createField("CREATED_ON", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * Create a <code>PUBLIC.POSTS</code> table reference
	 */
	public Posts() {
		this("POSTS", null);
	}

	/**
	 * Create an aliased <code>PUBLIC.POSTS</code> table reference
	 */
	public Posts(String alias) {
		this(alias, POSTS);
	}

	private Posts(String alias, Table<PostsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Posts(String alias, Table<PostsRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<PostsRecord, Integer> getIdentity() {
		return Keys.IDENTITY_POSTS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Posts as(String alias) {
		return new Posts(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Posts rename(String name) {
		return new Posts(name, null);
	}
}
