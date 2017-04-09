package sergeylysyi.lifecycle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;


public class MyListView extends ListView {

    public static final String TAG = "MyListView";

    public Logger logger = new Logger() {
        @Override
        void i(String tag, String message) {
        }
    };

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (context instanceof MainLogActivity) {
            logger = ((MyApplication) context.getApplicationContext()).logger();
        }
    }

    @Override
    public void onViewAdded(View child) {
        logger.i(TAG, "onViewAdded called");
        super.onViewAdded(child);
    }

    @Override
    public void onViewRemoved(View child) {
        logger.i(TAG, "onViewRemoved called");
        super.onViewRemoved(child);
    }

    @Override
    protected void onFinishInflate() {
        logger.i(TAG, "onFinishInflate called");
        super.onFinishInflate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        logger.i(TAG, "onMeasure called");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        logger.i(TAG, "onLayout called");
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        logger.i(TAG, "onTouchEvent called");
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        logger.i(TAG, "onFocusChanged called");
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }

    @Override
    protected void onAttachedToWindow() {
        logger.i(TAG, "onAttachedToWindow called");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        logger.i(TAG, "onDetachedFromWindow called");
        super.onDetachedFromWindow();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        logger.i(TAG, "onWindowVisibilityChanged called");
        super.onWindowVisibilityChanged(visibility);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        logger.i(TAG, "onDraw called");
        super.onDraw(canvas);
    }
}
