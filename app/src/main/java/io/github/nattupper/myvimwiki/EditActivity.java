package io.github.nattupper.myvimwiki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Button buttonCut, buttonCopy, buttonPaste,
                buttonSave, buttonPreview;
        final EditText editor = findViewById(R.id.editText_editor);

        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("textData", editor.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
