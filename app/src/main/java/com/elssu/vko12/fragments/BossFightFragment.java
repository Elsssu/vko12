package com.elssu.vko12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elssu.vko12.GameManager;
import com.elssu.vko12.Monster;
import com.elssu.vko12.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BossFightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class BossFightFragment extends Fragment {
    private boolean bossHealed = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);
        ImageView BossImage = view.findViewById(R.id.BossImage);
        TextView BossText = view.findViewById(R.id.BossText);
        int[] bossHealth = {100};
        String bossText = "Olio-Ohjelmointi: " + bossHealth[0] + "/100";
        BossText.setText(bossText);
        ImageView AttackBoss = view.findViewById(R.id.AttackBossButton);
        AttackBoss.setOnClickListener(v -> {
            int dmg = GameManager.getInstance().getPlayer().getDamage();
            bossHealth[0] -= dmg;
            if (bossHealth[0] < 0) bossHealth[0] = 0;
            updateUI(bossHealth, BossText);
            String bossText1 ="Olio-Ohjelmointi: " + bossHealth[0] + "/100";
            if(bossHealth[0] <= 49 && !bossHealed){
                bossHealed = true;
                bossHealth[0] = 100;
                updateUI(bossHealth, BossText);
            }

        });

        return view;
    }
    private void updateUI(int[] bossHealth, TextView Bosstext) {
        String life= "Olio-Ohjelmointi: " + bossHealth[0] + "/100";
        Bosstext.setText(life);
    }
}