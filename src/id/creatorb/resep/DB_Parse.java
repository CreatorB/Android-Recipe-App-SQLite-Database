package id.creatorb.resep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

public class DB_Parse extends Activity {
	ImageView Im;
	TextView tv_nama, tv_bahan, tv_cara, id;
	Gallery gallery;
	ImageSwitcher imageSwitcher;
	Integer[] imageIDs = new Integer[3];
	int msg_im;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resep);

		Intent iIdentifikasi = getIntent();
		msg_im = iIdentifikasi.getIntExtra("dataIM", 0);
		String msg_nama = iIdentifikasi.getStringExtra("dataNama");
		String msg_bahan = iIdentifikasi.getStringExtra("dataBahan");
		String msg_cara = iIdentifikasi.getStringExtra("dataCara");
		Im = (ImageView) findViewById(R.id.iv_detail);
		tv_nama = (TextView) findViewById(R.id.tvNama);
		tv_bahan = (TextView) findViewById(R.id.tvBahan);
		tv_cara = (TextView) findViewById(R.id.tvCara);
		Im.setImageResource(msg_im);
		tv_nama.setText(msg_nama);
		tv_bahan.setText(msg_bahan);
		tv_cara.setText(msg_cara);
	}
}