/**
 * This class is generated by jOOQ
 */
package org.example.jooq.db.information_schema.tables.pojos;


import java.io.Serializable;

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
public class Catalogs implements Serializable {

	private static final long serialVersionUID = -1102124144;

	private String catalogName;

	public Catalogs() {}

	public Catalogs(Catalogs value) {
		this.catalogName = value.catalogName;
	}

	public Catalogs(
		String catalogName
	) {
		this.catalogName = catalogName;
	}

	public String getCatalogName() {
		return this.catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Catalogs (");

		sb.append(catalogName);

		sb.append(")");
		return sb.toString();
	}
}
