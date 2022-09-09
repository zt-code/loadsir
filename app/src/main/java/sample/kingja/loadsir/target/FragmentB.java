package sample.kingja.loadsir.target;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import sample.kingja.loadsir.callback.EmptyCallback;
import sample.kingja.loadsir.callback.LoadingCallback;

import sample.kingja.loadsir.PostUtil;
import sample.kingja.loadsir.R;
import sample.kingja.loadsir.base.BaseFragment;

/**
 * Description:TODO
 * Create Time:2017/9/5 13:27
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class FragmentB extends BaseFragment {
    @BindView(R.id.tv_result_b)
    TextView mTvResultB;
    @Override
    protected int onCreateFragmentView() {
        return R.layout.fragment_b_content;
    }

    @Override
    protected void loadNet() {
        // do net here...
        // call back
        PostUtil.postCallbackDelayed(mBaseLoadService, EmptyCallback.class);
    }
    @Override
    protected void onNetReload(View v) {
        mTvResultB.setText("Oh, Yes too.");
        Toast.makeText(getContext(),"reload in Fragment B",Toast.LENGTH_SHORT).show();
        mBaseLoadService.showCallback(LoadingCallback.class);
        //do retry logic...

        //callback
        PostUtil.postSuccessDelayed(mBaseLoadService);
    }
}