package comp3350.rose.Presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import comp3350.rose.R;

public class AddInstructions extends AppCompatActivity {
    ArrayList<String> instructionsList = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_instructions);
        instructionsList = getIntent().getStringArrayListExtra("InstructionsList");

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, instructionsList);
        lv = (ListView)findViewById(R.id.recipeInstructionsListView);
        lv.setAdapter(myArrayAdapter);
    }

    public void addInstruction(View view){
        String recipeInstruction = ((EditText)findViewById(R.id.recipeInstructionText)).getText().toString();
        instructionsList.add(recipeInstruction);
        refreshInstructionsList();
        ((EditText)findViewById(R.id.recipeInstructionText)).setText("");
    }

    public void clearInstructionsList(View view){
        instructionsList.clear();
        refreshInstructionsList();
        ((EditText)findViewById(R.id.recipeInstructionText)).setText("");
    }

    public void saveInstructionsList(View view){
        Intent myIntent = new Intent();
        myIntent.putStringArrayListExtra("InstructionsResult", instructionsList);
        setResult(RESULT_OK, myIntent);
        finish();
    }

    public void cancelInstructionsButton(View view){
        finish();
    }

    private void refreshInstructionsList(){
        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, instructionsList);
        lv = (ListView)findViewById(R.id.recipeInstructionsListView);
        lv.setAdapter(myArrayAdapter);
    }
}
