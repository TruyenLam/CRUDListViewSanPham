package com.it.crudlistviewsanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSanpham;
    ArrayList<sanpham> arraySanpham;
    sanphamAdapter adapter;
    Button btnThem,btnXoa,btnSua;
    EditText edtMasp,edtTensp,edtSoluong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();
        addsanpham();

        adapter = new sanphamAdapter(this,R.layout.sanpham_view, arraySanpham);
        lvSanpham.setAdapter((adapter));
    }

    private void addsanpham() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl;
                sl =Integer.parseInt(edtSoluong.getText().toString());
                arraySanpham.add(new sanpham(edtMasp.getText().toString(),
                        edtTensp.getText().toString(),sl));

                adapter.notifyDataSetChanged();
            }
        });
    }

    private void load() {
        lvSanpham = (ListView) findViewById(R.id.ListViewSanPham);
        btnThem = (Button) findViewById(R.id.buttonThem);
        btnSua=(Button) findViewById(R.id.buttonSua);
        btnXoa=(Button) findViewById(R.id.buttonXoa);
        edtMasp=(EditText) findViewById(R.id.editTextMasp);
        edtTensp=(EditText) findViewById(R.id.editTextTensp);
        edtSoluong=(EditText) findViewById(R.id.editTextSoluong);

        arraySanpham = new ArrayList<>();

        arraySanpham.add(new sanpham("MH0012345678","San pham 1",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 2",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 3",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 4",10));
        arraySanpham.add(new sanpham("MH0012345678","San pham 5",10));
    }
}
