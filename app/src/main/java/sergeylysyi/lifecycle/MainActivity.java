package sergeylysyi.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.textView)).setText(R.string.application_log);

        logger = ((MyApplication) getApplicationContext()).logger();

        final ArrayAdapter<Logger.MessagePair> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, logger.getAll(MyApplication.TAG));

        ((ListView) findViewById(R.id.listView)).setAdapter(adapter);

        logger.addListener(MyApplication.TAG, new Logger.onChangeListener() {
            @Override
            public void onChange(Logger.MessagePair changedMessagePair) {
                adapter.notifyDataSetChanged();
            }
        });

        Button actionButton = (Button) findViewById(R.id.button);
        actionButton.setText(R.string.this_activity_log);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logger.i(TAG, "Button pressed");
                newInstance();
            }
        });
    }

    private void newInstance() {
        Intent intent = new Intent(this, MainLogActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        logger.i(TAG, "onRestoreInstanceState called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logger.i(TAG, "onSaveInstanceState called");
    }


    protected void onStart() {
        super.onStart();
        logger.i(TAG, "onStart called");
    }

    @Override
    protected void onRestart() {
        logger.i(TAG, "onRestart called");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        logger.i(TAG, "onResume called");
        super.onResume();
    }

    @Override
    protected void onPause() {
        logger.i(TAG, "onPause called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        logger.i(TAG, "onStop called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        logger.i(TAG, "onDestroy called");
        super.onDestroy();
    }


}