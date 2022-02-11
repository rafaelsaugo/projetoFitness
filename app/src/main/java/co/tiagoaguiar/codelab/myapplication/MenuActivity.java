package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    //  private View btnImc;
    //   private View btnCronometer;
    private RecyclerView rvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ///    btnImc = findViewById(R.id.btn_imc);
        rvMenu = findViewById(R.id.rv_menu);

        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.ic_imc1, R.string.label_imc, Color.WHITE));
        mainItems.add(new MainItem(2, R.drawable.ic_tmb1, R.string.label_tmb, Color.WHITE));
        mainItems.add(new MainItem(3, R.drawable.ic_crono, R.string.label_chronometer, Color.WHITE));
        mainItems.add(new MainItem(4, R.drawable.ic_icq1, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(5, R.drawable.ic_academia1, R.string.label_videos, Color.WHITE));
        mainItems.add(new MainItem(6, R.drawable.ic_agua1, R.string.Beber_agua, Color.WHITE));
        mainItems.add(new MainItem(7, R.drawable.ic_sobre, R.string.Sobre, Color.WHITE));
        mainItems.add(new MainItem(8, R.drawable.ic_treino, R.string.Treino, Color.WHITE));

        //Definir exibicao do layout (mosaico / grid / linear vertical ou horizontal)
        rvMenu.setLayoutManager(new GridLayoutManager(this, 2));
        MenuAdapter adapter = new MenuAdapter(mainItems);

        adapter.setListener(id -> {
            switch (id) {
                case 1:
                    startActivity(new Intent(MenuActivity.this, ImcActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MenuActivity.this, TmbActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MenuActivity.this, CronometerActivity.class));
                    break;
                case 4:
                    startActivity(new Intent(MenuActivity.this, IcqActivity.class));
                    break;
                case 5:
                    startActivity(new Intent(MenuActivity.this, MenuVideosActivity.class));
                    break;
                case 6:
                    startActivity(new Intent(MenuActivity.this, BeberAgua.class));
                    break;
                case 7:
                    startActivity(new Intent(MenuActivity.this, SobreActivity.class));
                    break;
            }

        });
        rvMenu.setAdapter(adapter);

    }

    private class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

        private List<MainItem> mainItems;

        //pacote criado para acões onClikc
        private OnItemClickListener listener;

        public MenuAdapter(List<MainItem> mainItems) {
            this.mainItems = mainItems;
        }

        public void setListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        @NonNull
        @Override
        public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MenuViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }

        private class MenuViewHolder extends RecyclerView.ViewHolder {

            public MenuViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            public void bind(MainItem item) {
                TextView text_text = itemView.findViewById(R.id.text_teste);
                ImageView imgIcon = itemView.findViewById(R.id.img_icon);
                LinearLayout btnImc = (LinearLayout) itemView;

                btnImc.setOnClickListener(view -> {
                    listener.onClick(item.getId());
                });

                text_text.setText(item.getTextStringId());
                imgIcon.setImageResource(item.getDrawableId());
                btnImc.setBackgroundColor(item.getColor());

            }
        }

    }


}