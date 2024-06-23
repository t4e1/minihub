package com.t4e1.minihub.config;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringListType implements UserType<List<String>> {

    @Override
    public int getSqlType() {
        return Types.ARRAY;
    }

    @Override
    public Class<List<String>> returnedClass() {
        return (Class<List<String>>) (Class<?>) List.class;
    }

    @Override
    public boolean equals(List<String> x, List<String> y) {
        return Objects.deepEquals(x, y);
    }

    @Override
    public int hashCode(List<String> x) {
        return x != null ? x.hashCode() : 0;
    }

    @Override
    public List<String> nullSafeGet(ResultSet resultSet, int i,
                                    SharedSessionContractImplementor sharedSessionContractImplementor,
                                    Object owner) throws SQLException {
        Array array = resultSet.getArray(i);
        if (array == null) {
            return null;
        }

        String[] stringArray = (String[]) array.getArray();
        return Arrays.asList(stringArray);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, List<String> list, int i,
                            SharedSessionContractImplementor sharedSessionContractImplementor) throws SQLException {
        if (list == null) {
            preparedStatement.setNull(i, Types.ARRAY);
            return;
        }

        Array array = sharedSessionContractImplementor.getJdbcConnectionAccess()
                .obtainConnection()
                .createArrayOf("text", list.toArray(new String[0]));
        preparedStatement.setArray(i, array);
    }

    @Override
    public List<String> deepCopy(List<String> list) {
        return list != null ? new ArrayList<>(list) : null;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(List<String> list) {
        return (Serializable) deepCopy(list);
    }

    @Override
    public List<String> assemble(Serializable serializable, Object owner) {
        return deepCopy((List<String>) serializable);
    }

    @Override
    public List<String> replace(List<String> original, List<String> target, Object owner) {
        return deepCopy(original);
    }
}
