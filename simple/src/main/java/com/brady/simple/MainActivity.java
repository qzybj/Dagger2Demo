package com.brady.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.brady.simple.module.animal.AnimalModule;
import com.brady.simple.module.animal.DaggerAnimalComponent;
import com.brady.simple.module.animal.DaggerExtraComponent;
import com.brady.simple.module.animal.DaggerFoodComponent;
import com.brady.simple.module.animal.ExtraComponent;
import com.brady.simple.module.animal.ExtraModule;
import com.brady.simple.module.animal.FoodComponent;
import com.brady.simple.module.animal.FoodModule;
import com.brady.simple.module.animal.interfaces.IAnimal;
import com.brady.simple.module.animal.interfaces.IExtra;
import com.brady.simple.module.injectframe.Injector;
import com.brady.simple.module.injectframe.annotation.InjectView;
import javax.inject.Inject;
import javax.inject.Named;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Named("Sheep")
    @Inject
    IAnimal animal_a;

    @Named("Tiger")
    @Inject
    IAnimal animal_b;

    @InjectView(R.id.tv_msg)
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Injector.inject(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);


        FoodComponent  foodComponent = DaggerFoodComponent.builder().foodModule(new FoodModule()).build();
        ExtraComponent extraComponent = DaggerExtraComponent.builder().extraModule(new ExtraModule()).build();
        DaggerAnimalComponent.builder()
                .animalModule(new AnimalModule(this.getApplicationContext()))
                .foodComponent(foodComponent)
                .extraComponent(extraComponent)
                .build().inject(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_one:
                testMethod1();
                break;
            case R.id.btn_two:
                testMethod2();
                break;
        }
    }

    private void testMethod1() {
        showLog(animal_a);
    }
    private void testMethod2() {
        showLog(animal_b);
    }

    private void showLog(Object obj){
        StringBuilder sb = new StringBuilder();
        if(obj instanceof IAnimal){
            IAnimal animal =  (IAnimal)obj;
            sb.append("I'm "+animal.getName());
            sb.append(" eat "+(animal.getFood()!=null?animal.getFood():"unknown"));
            if(animal.getExtra()!=null){
                IExtra extra =  animal.getExtra();
                sb.append(" height "+extra.getHeight());
                sb.append(" Weight "+extra.getWeight());
                sb.append(" Speed "+extra.getSpeed());
                sb.append(" Strength "+extra.getStrength());
            }
        }

        String msg =sb.toString();
        Log.i("dagger",msg);
        txt.setText(msg);
    }
}