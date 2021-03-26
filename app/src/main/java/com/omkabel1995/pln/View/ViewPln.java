package com.omkabel1995.pln.View;

import com.omkabel1995.pln.Model.Model_Pln;

import java.util.List;

public interface ViewPln {
    void Berhasil(List<Model_Pln> datapln);

    void gagal(String Message);

    void no_internet(String Message);
}
