package com.example.jooq.exceptions;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;

public class ExceptionListener extends DefaultExecuteListener {

    private static final long serialVersionUID = 3322945344669578204L;

    @Override
    public void exception(ExecuteContext context) {
        SQLDialect dialect = context.configuration().dialect();
        SQLExceptionTranslator translator = new SQLErrorCodeSQLExceptionTranslator(dialect.name());

        context.exception(translator.translate("Access database using jOOQ", context.sql(), context.sqlException()));
    }
}