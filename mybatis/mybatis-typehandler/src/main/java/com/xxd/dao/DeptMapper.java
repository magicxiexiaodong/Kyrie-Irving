package com.xxd.dao;


import com.xxd.beans.Dept;

import java.util.List;

public interface DeptMapper {
    void deptSave(Dept dept);

    List<Dept> deptFind();
}
