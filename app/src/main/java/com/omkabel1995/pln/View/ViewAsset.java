package com.omkabel1995.pln.View;

import com.omkabel1995.pln.Response.Model_DetailAsset;

import java.util.List;

public interface ViewAsset {
    void Berhasil_getdata(List<Model_DetailAsset> data);

    void Gagal_getdata(String Message);

    void Berhasil(String Message);

    void No_Internet(String Message);
}
