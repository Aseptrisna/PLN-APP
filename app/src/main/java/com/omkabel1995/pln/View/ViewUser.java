package com.omkabel1995.pln.View;

import com.omkabel1995.pln.Model.Model_Users;

import java.util.List;

public interface ViewUser {
    void Berhasil(String message, String Message);
    void Gagal(String Message);
    void No_Internet(String Message);
    void Berhasil(List<Model_Users> datauser);
}
