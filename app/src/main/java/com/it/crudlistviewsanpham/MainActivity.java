package com.it.crudlistviewsanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSanpham;
    ArrayList<sanpham> arraySanpham;
    sanphamAdapter adapter;
    Button btnThem,btnXoa,btnSua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();

        adapter = new sanphamAdapter(this,R.layout.sanpham_view, arraySanpham);
        lvSanpham.setAdapter((adapter));
    }

    private void load() {
        lvSanpham = (ListView) findViewById(R.id.ListViewSanPham);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnSua=(Button) findViewById(R.id.buttonSua);
        btnXoa=(Button) findViewById(R.id.buttonXoa);

        arraySanpham = new ArrayList<>();

        arraySanpham.add(new sanpham("MH0012345678","San pham 1",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 2",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 3",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 4",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 5",10));
    }
}
