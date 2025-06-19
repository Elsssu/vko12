package com.elssu.vko12;

import static android.text.TextUtils.replace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.elssu.vko12.fragments.BossFightFragment;
import com.elssu.vko12.fragments.ShowMonsterFragment;

public class FightMonstersActivity extends AppCompatActivity {
    private Button BossFight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fight_monsters);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button ShowMonster = findViewById(R.id.ShowMonsterFragmentButton);
        BossFight = findViewById(R.id.BossFightFragmentButton);
        Button ReturnFromFight = findViewById(R.id.ReturnFromFightButton);

        ShowMonster.setOnClickListener(listener);
        BossFight.setOnClickListener(listener);
        ReturnFromFight.setOnClickListener(listener);
        if(GameManager.getInstance().getPlayer().getScore()<= 100) {
            BossFight.setEnabled(false);
        }
    }
    public void enableBossFight(){
        BossFight.setEnabled(true);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;

            if(view.getId() == R.id.ShowMonsterFragmentButton) {
                fragment = new ShowMonsterFragment();
            }else if (view.getId() == R.id.BossFightFragmentButton) {
                fragment = new BossFightFragment();
            }else if (view.getId() == R.id.ReturnFromFightButton){
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                return;
            }
            if (fragment != null) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FightMonstersFrame, fragment)
                        .commit();

            }
        }
    };
}