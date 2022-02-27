package com.example.temperature_converter;

import androidx.appcompat.app.AppCompatActivity;
import com.example.temperature_converter.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.View;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String r = "32";
                String fi = "5";
                String ni = "9";
                String lowfrac = "";
                String highfrac = "1.8";


                BigDecimal five = new BigDecimal(fi);
                BigDecimal nine = new BigDecimal(ni);
                BigDecimal lowfraction = new BigDecimal(lowfrac);
                lowfraction = five.divide(nine);
                BigDecimal highfraction = new BigDecimal(highfrac);


                BigDecimal rounder = new BigDecimal(r);
                String c = String.valueOf(binding.celEdit.getText());
                BigDecimal farenheit = new BigDecimal(c);
                String f = String.valueOf(binding.farenEdit.getText());
                BigDecimal celsius = new BigDecimal(f);


                if (c.isEmpty() && f.isEmpty()){
                    binding.celEdit.setText("");
                    binding.farenEdit.setText("");
                }
                else if (!Character.isDigit(Integer.parseInt(c)) ){
                    binding.celEdit.setText("");
                    binding.farenEdit.setText("");

                }
                else{

                    BigDecimal farenTocelsius = lowfraction.multiply((farenheit.subtract(rounder)));
                    BigDecimal celisusTofaren = rounder.add(celsius.multiply(highfraction));


                    binding.celEdit.setText(String.valueOf(farenTocelsius));
                    binding.farenEdit.setText(String.valueOf(celisusTofaren));

                }
            }
        });

    }
}