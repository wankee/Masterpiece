package com.lelewan.masterpiece.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.lelewan.masterpiece.BooksInfo;
import com.lelewan.masterpiece.MainActivity;
import com.lelewan.masterpiece.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ann.chen on 2015/4/18.
 * A placeholder fragment containing a simple view.
 */
public class BookshelfFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private static final String TAG = "BookshelfFragment";

    private static final String ARG_SECTION_NUMBER = "section_number";

    private static final int BOOK_AMOUNTS_IN_EACH_LINE = 3;

    private final int mBookAmounts;

    private int mLayers;

    private TableLayout mTableLayout;

    private Context mContext;

    private BooksInfo mBooksInfo;

    public BookshelfFragment() {
        mBooksInfo = new BooksInfo();
        mBookAmounts = mBooksInfo.getBookAmounts();
        if (mBookAmounts % BOOK_AMOUNTS_IN_EACH_LINE == 0) {
            mLayers = mBookAmounts / BOOK_AMOUNTS_IN_EACH_LINE;
        } else {
            mLayers = mBookAmounts / BOOK_AMOUNTS_IN_EACH_LINE + 1;
        }
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BookshelfFragment newInstance(int sectionNumber) {
        BookshelfFragment fragment = new BookshelfFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mContext = getActivity();
        Log.d(TAG, "mContext:" + mContext);
        WindowManager wm=getActivity().getWindowManager();
        Log.d(TAG,"WM:==>"+wm);
        wm.getDefaultDisplay().getWidth();
        mTableLayout = (TableLayout) rootView.findViewById(R.id.tablelayout);

        for (int i = 0; i < mLayers; i++) {
            TableRow tr = new TableRow(mContext);
            TableLayout.LayoutParams lp=new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT);
            tr.setLayoutParams(lp);
            mTableLayout.addView(tr);

            for (int j = 0; j < BOOK_AMOUNTS_IN_EACH_LINE; j++) {
                tr.addView(generateBookView(mBooksInfo.getBookName(getId(i, j))));
            }
        }

        return rootView;
    }

    private int getId(int i, int j) {
        if(i * BOOK_AMOUNTS_IN_EACH_LINE + j+1>mBookAmounts) {
            return 42;
        }
        return i * BOOK_AMOUNTS_IN_EACH_LINE + j;
    }

    private View generateBookView(String bookName) {
        TextView tv = new TextView(mContext);
        if (TextUtils.isEmpty(bookName)) {
            bookName = "default";
        }
        TableRow.LayoutParams lp=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        lp.setMargins(5,5,5,5);
        tv.setLayoutParams(lp);
        tv.setBackgroundColor(Color.BLUE);
        tv.setPadding(50, 50, 50, 50);
        tv.setGravity(Gravity.CENTER);
        tv.setText(bookName);
        return tv;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}

