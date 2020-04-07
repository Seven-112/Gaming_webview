package org.webview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.webview.Model.Adapter;

public class CategoryActivity extends AppCompatActivity {

    private String webSiteUrl = "";

    RecyclerView recyclerView;

    private String[] urlList = {
            "https://games.cdn.famobi.com/html5games/k/kumba-karate/v2/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=ce37f0e5-f7ce-4bdd-bdb5-98ab489c92b8&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=645&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/c/cartoon-flight/v050/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=502d5c85-faa2-49a3-9516-696822db1a84&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=708&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/s/street-ball-star/v090/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=c893b0c6-fefb-4218-b63e-97a976d20401&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=708&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/s/sushi-ninja-dash/v010/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=3aa309af-44ec-4eac-8f1e-3da0136236ca&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=712&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/w/wild-west-solitaire/v7/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=5ab38046-93b4-45cf-a0d6-708db40722bb&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=638&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/k/klondike-solitaire/v070/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=67ca6f89-9287-40f7-8620-3b591cecf5d7&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=636&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/f/fit-it-quick/v060/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=539654fd-5ea8-4c05-b648-f4fa3666f0c2&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=638&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/m/mahjong-relax/v7/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=2363495f-0e53-4ee3-a90f-bb03fa687ff1&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=661&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/m/mahjong-mania/v020/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=fd0d8698-39d7-4ab5-82bb-60d9878cc331&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=649&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/m/magic-mahjong/v1/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=390fa7ca-c965-475d-98d3-3ac1b576cbf2&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=648&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/l/lovetester3/v110/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=672fcb00-3841-4d80-8698-54d6635932b3&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=651&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/r/rm-maria/v050/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=d22b8e80-9a2b-4607-ba34-8666e0719f54&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=650&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://defly.io/indexFamobi.html?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=da7010c7-6f03-460c-891d-8737c569603f&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=652&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://om.forgeofempires.com/foe/?ref=famobi_ww_ww&pid=A-GPSNV&fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=f0e180b8-d315-40fe-841a-c2bbc75c50b7&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=651&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/m/mini-putt-garden/v2/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=c39ad499-9100-4667-aacd-d1cf848b9a2b&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=665&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/m/mini-putt-forest/v2/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=ce25ec06-9a07-498f-9133-abcc47cc7bd3&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=652&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/j/jelly-collapse/v020/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=2457cf73-a186-4462-b931-9c56898eac22&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=654&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/s/stones-of-pharaoh/v2/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=dff54b5d-6deb-49c4-8cbb-572d73b52abc&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=653&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/t/tiny-rifles/v040/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=738c6e89-7249-4e5a-8b6c-36899b1683c1&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=651&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/s/swooop/v1/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=89459199-3905-4687-b993-158f437a0e11&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=655&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/s/sprint-club-nitro/v080/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=22d54936-998a-4d6d-82c1-895792f1c573&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=655&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/b/burnin-rubber/v140/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=d55c9a5f-59ef-44c9-9fd9-b8b60cdb6b92&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=656&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/m/my-little-dragon/v2/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=5a345e1f-04bd-465b-aaf5-df161a28854f&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=656&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://om.forgeofempires.com/foe/?ref=famobi_ww_ww&pid=A-GPSNV&fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=f0e180b8-d315-40fe-841a-c2bbc75c50b7&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=656&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/s/smarty-bubbles/v190/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=d8f24956-dc91-4902-9096-a46cb1353b6f&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=654&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/o/orange-bubbles/v1/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=9531d789-e13e-4fcc-a41b-7c63392c8803&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=658&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/k/kids-color-book/v180/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=8d9894fd-fcf9-45e7-a56f-4014bbf74e7d&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=657&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/m/match-the-animal/v060/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=a1c22d72-d8ee-4e66-a382-bf87533d8e1a&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=656&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/d/dont-crash/v030/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=9320bd31-c1fa-4dda-9a89-6e3946399a84&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=657&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/p/parking-passion/v020/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=33f3ee40-0b23-446f-b4a2-ef8892535c6a&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=659&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/n/nut-rush/v070/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=4f474a79-47ab-47fc-9079-3b93efd3ce8d&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=660&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/n/nut-rush2/v060/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=690e3baf-9c33-485d-b3d3-cc74f929f2ae&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=660&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/q/quick-quiz/v060/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=277f1bb4-ccce-47f7-8b23-bb74be3578fb&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=661&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html",
            "https://games.cdn.famobi.com/html5games/w/wordguess-2-easy/v140/?fg_domain=play.famobi.com&fg_aid=A-GPSNV&fg_uid=78e953ac-d52a-4575-a2f0-10ce5ede514a&fg_pid=ae82924a-54c1-4c80-b806-fd9b6104e488&fg_beat=661&original_ref=http%3A%2F%2Fliteoffersapps-eu.s3.eu-central-1.amazonaws.com%2Fm.html"

    };

    private Integer[] imgid = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z,
            R.drawable.z_a,
            R.drawable.z_b,
            R.drawable.z_c,
            R.drawable.z_d,
            R.drawable.z_e,
            R.drawable.z_f,
            R.drawable.z_g,
            R.drawable.z_h,
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView = findViewById(R.id.recycleView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        Adapter adapter = new Adapter(CategoryActivity.this, imgid);
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void OnItemClicked(int position, View v) {
                Log.v(":", String.valueOf(position));
                webSiteUrl = urlList[position];
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                intent.putExtra("URL", webSiteUrl);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}
