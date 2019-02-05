/**
 * This class is generated by jOOQ
 */
package org.example.jooq.db.public_.tables.records;


import java.math.BigDecimal;

import javax.annotation.Generated;

import org.example.jooq.db.public_.tables.Jasuil;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


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
public class JasuilRecord extends TableRecordImpl<JasuilRecord> implements Record2<BigDecimal, String> {

	private static final long serialVersionUID = -173951688;

	/**
	 * Setter for <code>PUBLIC.JASUIL.ID</code>.
	 */
	public void setId(BigDecimal value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>PUBLIC.JASUIL.ID</code>.
	 */
	public BigDecimal getId() {
		return (BigDecimal) getValue(0);
	}

	/**
	 * Setter for <code>PUBLIC.JASUIL.NAME</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>PUBLIC.JASUIL.NAME</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<BigDecimal, String> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<BigDecimal, String> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<BigDecimal> field1() {
		return Jasuil.JASUIL.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Jasuil.JASUIL.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JasuilRecord value1(BigDecimal value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JasuilRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JasuilRecord values(BigDecimal value1, String value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached JasuilRecord
	 */
	public JasuilRecord() {
		super(Jasuil.JASUIL);
	}

	/**
	 * Create a detached, initialised JasuilRecord
	 */
	public JasuilRecord(BigDecimal id, String name) {
		super(Jasuil.JASUIL);

		setValue(0, id);
		setValue(1, name);
	}
}