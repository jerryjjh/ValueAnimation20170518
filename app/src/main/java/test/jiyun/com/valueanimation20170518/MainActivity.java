package test.jiyun.com.valueanimation20170518;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imagview);
        ListView lv = (ListView) findViewById(R.id.listview);
        String[] strings = new String[]{"平移动画", "旋转动画", "缩放动画", "动画集合"};
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        Toast.makeText(MainActivity.this, "tosi", Toast.LENGTH_SHORT).show();
                        ObjectAnimator translationUp = ObjectAnimator.ofFloat(iv, "translationX",
                                15, 500, 300);
                        translationUp.setInterpolator(new DecelerateInterpolator());
                        translationUp.setDuration(1500);
                        translationUp.start();
                        break;
                    case 1:
                        ObjectAnimator xuanzhuan = ObjectAnimator.ofFloat(iv, "rotation", 0, 270, 0);

                        xuanzhuan.setDuration(2000);
                        xuanzhuan.start();
                        break;
                    case 2:
                        ObjectAnimator animator2 = ObjectAnimator.ofFloat(iv, "scaleX", 1, 2, 1);
                        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, "scaleY", 1, 2, 1);
                        animator.setDuration(2000);
                        animator2.setDuration(2000);
                        animator.start();
                        animator2.start();
                        break;
                    case 3:
                        AnimatorSet set = new AnimatorSet();
                        ObjectAnimator anim = ObjectAnimator.ofFloat(iv, "rotationX", 0f, 180f);
                        anim.setDuration(2000);
                        ObjectAnimator anim2 = ObjectAnimator.ofFloat(iv, "rotationX", 180f, 0f);
                        anim2.setDuration(2000);
                        ObjectAnimator anim3 = ObjectAnimator.ofFloat(iv, "rotationY", 0f, 180f);
                        anim3.setDuration(2000);
                        ObjectAnimator anim4 = ObjectAnimator.ofFloat(iv, "rotationY", 180f, 0f);
                        anim4.setDuration(2000);
                        ObjectAnimator anim5 = ObjectAnimator.ofFloat(iv, "alpha", 1f, 0f, 1f);
                        anim5.setDuration(2000);

                        set.play(anim).before(anim2).with(anim5); //先执行anim动画之后在执行anim2
                        set.play(anim3).before(anim4).with(anim5);
                        set.start();
                        break;
                }
            }
        });

    }
}
