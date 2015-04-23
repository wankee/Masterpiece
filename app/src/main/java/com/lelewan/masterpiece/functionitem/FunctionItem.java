package com.lelewan.masterpiece.functionitem;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by ann.chen on 2015/4/15.
 */
public class FunctionItem {
    protected LinearLayout mItem;
    protected String mIntentStr;
    protected String mIntentType;
    protected Context mContext;

    protected OnClickBehavior mOnClickBehavior=null;
    public FunctionItem(Activity context, int id, String intentStr, String intentType,View view) {
        this.mContext=context;
        this.mIntentStr=intentStr;
        this.mIntentType=intentType;
        this.mItem=(LinearLayout)view.findViewById(id);
        mItem.setOnClickListener(new ItemOnClickListener());
    }

    private class ItemOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            firstStep();
            //Log.d("davis",mOnClickBehavior.toString());
            if (mOnClickBehavior != null) {
                Log.d("davis","this is on click behavior===>"+mOnClickBehavior);
                mOnClickBehavior.secondStep();
            } else {
                Toast.makeText(mContext,"mOnClickBehavior is null",Toast.LENGTH_LONG).show();
            }

            //Toast.makeText(mContext,mIntentStr,Toast.LENGTH_LONG).show();
        }
    }

    private void firstStep() {
        Toast.makeText(mContext,"in first step!",Toast.LENGTH_SHORT).show();
    }

    public interface OnClickBehavior {
        public abstract void secondStep();
    }
}
