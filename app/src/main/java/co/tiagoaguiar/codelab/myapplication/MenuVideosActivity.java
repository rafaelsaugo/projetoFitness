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

public class MenuVideosActivity extends AppCompatActivity {

    //  private View btnImc;
    //   private View btnCronometer;
    private RecyclerView rvMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_videos);

        rvMenu = findViewById(R.id.rv_menu);

        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.ic_abd_perna_elevada_curta, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(2, R.drawable.ic_abd_remador, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(3, R.drawable.ic_abd_russian_twist, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(4, R.drawable.ic_abd_infra, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(5, R.drawable.ic_abd_remador, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(6, R.drawable.ic_abd_roda, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(7, R.drawable.ic_abd_reto, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(8, R.drawable.ic_afundo_agachamento_avanco, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(9, R.drawable.ic_afundo_alternado_remada_simultanea, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(10, R.drawable.ic_abdc_miniband, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(11, R.drawable.ic_abdc_gluteo_miniband, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(12, R.drawable.ic_abdc_joelho_miniband, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(13, R.drawable.ic_afundo_desenvolvimento, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(14, R.drawable.ic_afundo_elevacao_joelho, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(15, R.drawable.ic_afundo_elevacao_joelho_remada, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(16, R.drawable.ic_afundo_remada_alternado, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(17, R.drawable.ic_afundo_remada_simultanea, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(18, R.drawable.ic_afundo_pliometrico, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(19, R.drawable.ic_afundo_pliometrico_alternado, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(20, R.drawable.ic_afundo_reverso, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(21, R.drawable.ic_afundo_reverso_unilateral, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(22, R.drawable.ic_agachamento_afundo_reverso, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(23, R.drawable.ic_agachamento_biceps, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(24, R.drawable.ic_agachamento_peso, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(25, R.drawable.ic_agachamento_peso_frontal, R.string.label_icq, Color.WHITE));
        mainItems.add(new MainItem(26, R.drawable.ic_agachamento_peso_frontal, R.string.label_icq, Color.BLUE));



        //Definir exibicao do layout (mosaico / grid / linear vertical ou horizontal)
        rvMenu.setLayoutManager(new GridLayoutManager(this, 3));
        MenuAdapter adapter = new MenuAdapter(mainItems);

        adapter.setListener(id -> {
            switch (id) {
                case 1:
                    startActivity(new Intent(MenuVideosActivity.this, Video.class));
                    break;
                case 2:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbcRemador.class));
                    break;
                case 3:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbdRussian.class));
                    break;
                case 4:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbdInfra.class));
                    break;
                case 5:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbcRemadorE.class));
                    break;
                case 6:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbcRoda.class));
                    break;
                case 7:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbdReto.class));
                    break;
                case 8:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoAgachamentoAvanco.class));
                    break;
                case 9:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoAlternadoRemadaSimultanea.class));
                    break;
                case 10:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbdcMiniband.class));
                    break;
                case 11:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbdcGluteoMiniband.class));
                    break;
                case 12:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAbdcJoelhoMiniband.class));
                    break;
                case 13:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoDesenvolvimento.class));
                    break;
                case 14:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoelevacaoJoelho.class));
                    break;
                case 15:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoElevacaoJoelhoRemada.class));
                    break;
                case 16:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoRemadaAlternada.class));
                    break;
                case 17:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoRemadaSimultanea.class));
                    break;
                case 18:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoPliometrico.class));
                    break;
                case 19:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoPliometricoAlternado.class));
                    break;
                case 20:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoReverso.class));
                    break;
                case 21:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoReversoUni.class));
                    break;
                case 22:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAgachamentoAfundoReverso.class));
                    break;
                case 23:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAgachamentoBiceps.class));
                    break;
                case 24:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAgachamentoPeso.class));
                    break;
                case 25:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAgachamentoPesoFrontal.class));
                    break;
                case 26:
                    startActivity(new Intent(MenuVideosActivity.this, VideoAfundoTeste.class));
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