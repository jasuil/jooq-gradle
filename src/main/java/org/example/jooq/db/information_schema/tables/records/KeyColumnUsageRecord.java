/**
 * This class is generated by jOOQ
 */
package org.example.jooq.db.information_schema.tables.records;


import javax.annotation.Generated;

import org.example.jooq.db.information_schema.tables.KeyColumnUsage;
import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class KeyColumnUsageRecord extends TableRecordImpl<KeyColumnUsageRecord> implements Record9<String, String, String, String, String, String, String, String, String> {

	private static final long serialVersionUID = -434142189;

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_CATALOG</code>.
	 */
	public void setConstraintCatalog(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_CATALOG</code>.
	 */
	public String getConstraintCatalog() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_SCHEMA</code>.
	 */
	public void setConstraintSchema(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_SCHEMA</code>.
	 */
	public String getConstraintSchema() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_NAME</code>.
	 */
	public void setConstraintName(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_NAME</code>.
	 */
	public String getConstraintName() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_CATALOG</code>.
	 */
	public void setTableCatalog(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_CATALOG</code>.
	 */
	public String getTableCatalog() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_SCHEMA</code>.
	 */
	public void setTableSchema(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_SCHEMA</code>.
	 */
	public String getTableSchema() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_NAME</code>.
	 */
	public void setTableName(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_NAME</code>.
	 */
	public String getTableName() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.COLUMN_NAME</code>.
	 */
	public void setColumnName(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.COLUMN_NAME</code>.
	 */
	public String getColumnName() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.ORDINAL_POSITION</code>.
	 */
	public void setOrdinalPosition(String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.ORDINAL_POSITION</code>.
	 */
	public String getOrdinalPosition() {
		return (String) getValue(7);
	}

	/**
	 * Setter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.POSITION_IN_UNIQUE_CONSTRAINT</code>.
	 */
	public void setPositionInUniqueConstraint(String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>INFORMATION_SCHEMA.KEY_COLUMN_USAGE.POSITION_IN_UNIQUE_CONSTRAINT</code>.
	 */
	public String getPositionInUniqueConstraint() {
		return (String) getValue(8);
	}

	// -------------------------------------------------------------------------
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<String, String, String, String, String, String, String, String, String> fieldsRow() {
		return (Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<String, String, String, String, String, String, String, String, String> valuesRow() {
		return (Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.CONSTRAINT_CATALOG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.CONSTRAINT_SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.CONSTRAINT_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.TABLE_CATALOG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.TABLE_SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.TABLE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.COLUMN_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field8() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.ORDINAL_POSITION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field9() {
		return KeyColumnUsage.KEY_COLUMN_USAGE.POSITION_IN_UNIQUE_CONSTRAINT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getConstraintCatalog();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getConstraintSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getConstraintName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getTableCatalog();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getTableSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getTableName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getColumnName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value8() {
		return getOrdinalPosition();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value9() {
		return getPositionInUniqueConstraint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value1(String value) {
		setConstraintCatalog(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value2(String value) {
		setConstraintSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value3(String value) {
		setConstraintName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value4(String value) {
		setTableCatalog(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value5(String value) {
		setTableSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value6(String value) {
		setTableName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value7(String value) {
		setColumnName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value8(String value) {
		setOrdinalPosition(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord value9(String value) {
		setPositionInUniqueConstraint(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KeyColumnUsageRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached KeyColumnUsageRecord
	 */
	public KeyColumnUsageRecord() {
		super(KeyColumnUsage.KEY_COLUMN_USAGE);
	}

	/**
	 * Create a detached, initialised KeyColumnUsageRecord
	 */
	public KeyColumnUsageRecord(String constraintCatalog, String constraintSchema, String constraintName, String tableCatalog, String tableSchema, String tableName, String columnName, String ordinalPosition, String positionInUniqueConstraint) {
		super(KeyColumnUsage.KEY_COLUMN_USAGE);

		setValue(0, constraintCatalog);
		setValue(1, constraintSchema);
		setValue(2, constraintName);
		setValue(3, tableCatalog);
		setValue(4, tableSchema);
		setValue(5, tableName);
		setValue(6, columnName);
		setValue(7, ordinalPosition);
		setValue(8, positionInUniqueConstraint);
	}
}
