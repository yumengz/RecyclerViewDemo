package zhouyumeng.recyclerviewdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import zhouyumeng.recyclerviewtest.R;

/**
 * Created by yumengz on 1/25/16.
 */
public class FeedListActivity extends Activity {

    private static final String TAG = "RecyclerViewExample";

    private List<FeedItem> feedItemList = new ArrayList<FeedItem>();

    private RecyclerView mRecyclerView;

    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Allow activity to show indeterminate progressbar */
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        setContentView(R.layout.activity_feeds_list);

        /* Initialize recyclerview */
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        new AsyncHttpTask().execute();
    }

    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            setProgressBarIndeterminateVisibility(true);
        }

        @Override
        protected Integer doInBackground(String... params) {

            Integer result = 0;

            for(int i=0;i<99;i++)
            {
                FeedItem hehe=new FeedItem();
                hehe.setTitle("nidaye");
                feedItemList.add(hehe);
            }

            result=1;
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {

            setProgressBarIndeterminateVisibility(false);

            if (result == 1) {
                adapter = new MyRecyclerAdapter(FeedListActivity.this, feedItemList);
                mRecyclerView.setAdapter(adapter);
            } else {
                Log.e(TAG, "Failed to fetch data!");
            }
        }
    }



}
