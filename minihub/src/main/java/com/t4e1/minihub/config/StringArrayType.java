package com.t4e1.minihub.config;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public class StringArrayType implements UserType<String[]> {

    @Override
    public int getSqlType() {
        return Types.ARRAY;
    }

    @Override
    public Class<String[]> returnedClass() {
        return String[].class;
    }

    @Override
    public boolean equals(String[] strings, String[] j1) {
        return Objects.deepEquals(strings, j1);
    }

    @Override
    public int hashCode(String[] strings) {
        return Arrays.hashCode(strings);
    }

    @Override
    public String[] nullSafeGet(ResultSet resultSet, int i,
                                SharedSessionContractImplementor sharedSessionContractImplementor,
                                Object o) throws SQLException {

        Array array = resultSet.getArray(i);
        if(array == null)
            return null;

        return (String[])array.getArray();
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, String[] strings, int i,
                            SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if (strings == null) {
            preparedStatement.setNull(i, Types.ARRAY);
            return;
        }
        Array array = sharedSessionContractImplementor.getJdbcConnectionAccess()
                .obtainConnection()
                .createArrayOf("text", strings);
        preparedStatement.setArray(i, array);
    }

    @Override
    public String[] deepCopy(String[] strings) {
        return strings != null ? strings.clone() : null;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(String[] strings) {
        return deepCopy(strings);
    }

    @Override
    public String[] assemble(Serializable serializable, Object o) {
        return deepCopy((String[]) serializable);
    }
}
