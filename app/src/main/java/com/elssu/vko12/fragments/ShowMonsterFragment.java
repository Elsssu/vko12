package com.elssu.vko12.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elssu.vko12.FightMonstersActivity;
import com.elssu.vko12.GameManager;
import com.elssu.vko12.Monster;
import com.elssu.vko12.R;
import com.elssu.vko12.Skeleton;
import com.elssu.vko12.Vampire;


public class ShowMonsterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);

        TextView MonsterLifeText = view.findViewById(R.id.MonsterLifeText);
        TextView MonsterNameText = view.findViewById(R.id.MonsterNameText);
        ImageView MonsterImage = view.findViewById(R.id.MonsterImage);
        ImageView AttackMonsterButton = view.findViewById(R.id.AttackMonsterButton);

        Monster[] monster = {GameManager.getInstance().generateMonster()};


        MonsterNameText.setText(monster[0].getName());
        String lifeStuff = monster[0].getLife() + "/" + monster[0].getMaxLife();
        MonsterLifeText.setText("Elämä: " + lifeStuff);
        setMonsterImage(monster[0], MonsterImage);


        AttackMonsterButton.setOnClickListener(v -> {
            int dmg = GameManager.getInstance().getPlayer().getDamage();
            monster[0].takeDamage(dmg);
            updateUI(monster[0], MonsterLifeText);
            if(monster[0].getLife() <= 0){
                GameManager.getInstance().getPlayer().addScore(10);
                if (GameManager.getInstance().getPlayer().getScore() >= 100) {
                    if (getActivity() instanceof FightMonstersActivity) {
                        FightMonstersActivity activity = (FightMonstersActivity) getActivity();
                        activity.enableBossFight();
                    }
                }
                Monster newmonster = GameManager.getInstance().generateMonster();
                monster[0] = newmonster;
                updateUI(newmonster, MonsterLifeText);
                setMonsterImage(newmonster, MonsterImage);
            }


        });
        return view;

    }
    public void setMonsterImage(Monster monster, ImageView MonsterImage){
        if (monster instanceof Skeleton) {
            MonsterImage.setImageResource(R.drawable.skeleton1);
        } else if (monster instanceof Vampire) {
            MonsterImage.setImageResource(R.drawable.vampire1);
        }
    }
    private void updateUI(Monster monster, TextView MonsterLifeText) {
        String lifeStuff = monster.getLife() + "/" + monster.getMaxLife();
        MonsterLifeText.setText("Elämä: " + lifeStuff);
    }
}