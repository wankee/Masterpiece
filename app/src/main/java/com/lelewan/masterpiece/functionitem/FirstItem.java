package com.lelewan.masterpiece.functionitem;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ann.chen on 2015/4/15.
 */
public class FirstItem extends FunctionItem implements FunctionItem.OnClickBehavior {

    public FirstItem(Activity context, int id, String intentStr, String intentType, View view) {
        super(context, id, intentStr, intentType, view);
        mOnClickBehavior=this;
    }

    @Override
    public void secondStep() {
        Toast.makeText(mContext, "FirstItem", Toast.LENGTH_LONG).show();
    }
}
