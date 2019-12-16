package com.it.crudlistviewsanpham;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSanpham;
    ArrayList<sanpham> arraySanpham;
    sanphamAdapter adapter;
    Button btnThem,btnXoa,btnSua;
    EditText edtMasp,edtTensp,edtSoluong;
    int vitri = -1;
    public static final String TAG = "Check";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load();

        adapter = new sanphamAdapter(this,R.layout.sanpham_view, arraySanpham);
        lvSanpham.setAdapter((adapter));
        addsanpham();

        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        lvSanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sanpham sp  = (sanpham) adapter.getItem(position);

                edtMasp.setText(sp.getMasp());
                edtTensp.setText(sp.getTensp());
                edtSoluong.setText(String.valueOf(sp.getSoluong()));
                vitri  =position;
                Log.d(TAG, "vi tri chon item list view " + vitri+"   "+adapter.getItemId(position));
                //Toast.makeText(MainActivity.this,vitri,Toast.LENGTH_LONG).show();
            }

        });
        xoasanpham();
        suasanpham();
        //

    }

    private void suasanpham() {
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanpham editsp = new  sanpham(edtMasp.getText().toString(),edtTensp.getText().toString()
                        ,Integer.parseInt(edtSoluong.getText().toString()));
                arraySanpham.set(vitri,editsp);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void xoasanpham() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arraySanpham.remove(vitri);
                adapter.notifyDataSetChanged();
            }
        });
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
