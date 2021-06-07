package me.nyu19.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView textView;
    private EditText outputField;

    public void generatePassword(View v){
        Switch upper = findViewById(R.id.upper);
        Switch lower = findViewById(R.id.lower);
        Switch nums = findViewById(R.id.numeric);
        Switch spChar = findViewById(R.id.spchar);
        try{
            outputField.setText(new PasswordGenerator3000().makePassword(seekBar.getProgress(),
                    upper.isChecked(),
                    lower.isChecked(),
                    nums.isChecked(),
                    spChar.isChecked()
            ));
        }catch (NullPointerException nl){
            Toast.makeText(this,"Please select atleast 1 option",Toast.LENGTH_SHORT).show();
        }
    }
    public void copyToClipboard(View v){
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("nyuPasswordGen",outputField.getText());
        clipboard.setPrimaryClip(clipData);
        Toast.makeText(this,"Copied to Clipboard!",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textViewSeekBar);
        outputField = findViewById(R.id.outputField);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(progress+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}