package com.java.handlers;

import com.java.model.Gender;
import com.java.model.HasValue;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Represents a handler class for mapping java enumeration(Enum) to string db type
 * */
@MappedTypes(Gender.class)
public class HasValueEnumTypeHandler<E extends Enum<E> & HasValue> extends
        BaseTypeHandler<E> {
    private Class<E> type;
    private final E[] enums;

    public HasValueEnumTypeHandler(Class<E> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter,
                                    JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String value = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        }

        for (E enm : enums) {
            if (value.trim().equals(enm.getValue())) {
                return enm;
            }
        }
        throw new IllegalArgumentException("Cannot convert "
                + value + " to " + type.getSimpleName());
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (rs.wasNull()) {
            return null;
        }
        for (E enm : enums) {
            if (value.trim().equals(enm.getValue())) {
                return enm;
            }
        }
        throw new IllegalArgumentException("Cannot convert " + value + " to " + type.getSimpleName());
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnName) throws SQLException {
        String value = cs.getString(columnName);
        if (cs.wasNull()) {
            return null;
        }
        for (E enm : enums) {
            if (value.trim().equals(enm.getValue())) {
                return enm;
            }
        }
        throw new IllegalArgumentException("Cannot convert " + value + " to " + type.getSimpleName());
    }


}