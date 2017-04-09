package sergeylysyi.lifecycle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class MyButton extends android.support.v7.widget.AppCompatButton {

    public static final String TAG = "MyButton";

    public Logger logger = new Logger() {
        @Override
        void i(String tag, String message) {
        }
    };

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (context instanceof ViewGroupLogActivity) {
            logger = ((MyApplication) context.getApplicationContext()).logger();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        logger.i(TAG, "onFinishInflate called");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        logger.i(TAG, "onMeasure called");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        logger.i(TAG, "onLayout called");
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = super.onTouchEvent(ev);
        logger.i(TAG, "onTouchEvent called");
        return result;
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        logger.i(TAG, "onFocusChanged called");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        logger.i(TAG, "onAttachedToWindow called");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        logger.i(TAG, "onDetachedFromWindow called");
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        logger.i(TAG, "onWindowVisibilityChanged called");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        logger.i(TAG, "onDraw called");
    }
}
