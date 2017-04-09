package sergeylysyi.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainLogActivity extends AppCompatActivity {

    public static final String TAG = "MainLogActivity";
    public Logger logger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.textView)).setText(R.string.parent_activity_log);

        logger = ((MyApplication) getApplicationContext()).logger();

        final ArrayAdapter<Logger.MessagePair> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, logger.getAll(MainActivity.TAG));

        ((ListView) findViewById(R.id.listView)).setAdapter(adapter);

        logger.addListener(MainActivity.TAG, new Logger.onChangeListener() {
            @Override
            public void onChange(Logger.MessagePair changedMessagePair) {
                adapter.notifyDataSetChanged();
            }
        });

        Button newInstanceButton = (Button) findViewById(R.id.button);
        newInstanceButton.setText(R.string.this_list_log);
        newInstanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logger.i(TAG, "Button pressed");
                newInstance();
            }
        });
    }

    private void newInstance() {
        Intent intent = new Intent(this, ViewGroupLogActivity.class);
        startActivity(intent);
    }
}
