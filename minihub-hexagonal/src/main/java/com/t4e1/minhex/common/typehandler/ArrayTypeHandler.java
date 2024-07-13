package com.t4e1.minhex.common.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@MappedTypes(java.util.List.class)
@MappedJdbcTypes(JdbcType.ARRAY)
public class ArrayTypeHandler extends BaseTypeHandler<List<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        Array array = ps.getConnection().createArrayOf("varchar", parameter.toArray());
        ps.setArray(i, array);
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toList(rs.getArray(columnName));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toList(rs.getArray(columnIndex));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toList(cs.getArray(columnIndex));
    }

    private List<String> toList(Array pgArray) throws SQLException {
        if (pgArray == null)
            return new ArrayList<>();

        String[] strings = (String[]) pgArray.getArray();
        return containsOnlyNulls(strings) ? new ArrayList<>() : new ArrayList<>(List.of(strings));
    }

    private boolean containsOnlyNulls(String[] strings) {
        for (String s : strings) {
            if (s != null) {
                return false;
            }
        }
        return true;
    }
}
