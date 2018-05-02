package com.qq.atar.qqmusic.fragment;

import android.common.CommonHandler;
import android.os.Bundle;
import android.reflection.NetWorkMsg;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.utils.DeviceManager;
import android.utils.ScreenUtils;
import android.view.View;

import com.qq.atar.qqmusic.adapter.RecommendAdapter;
import com.qq.atar.qqmusic.enums.EnumMsgWhat;
import com.qq.atar.qqmusic.moudle.RecommendJson;
import com.qq.atar.qqmusic.moudle.RecommendJson.SongBean;
import com.qq.atar.qqmusic.net.NetWorkInterfaces;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends AtarRefreshRecyclerViewFragment {

    private List<SongBean> list = new ArrayList<SongBean>();
    private RecommendAdapter mRecommendAdapter = new RecommendAdapter(list);

    private int spanCount = 2;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int widthAndHeight = (DeviceManager.getScreenWidth(getActivity()) - (int) ScreenUtils.getIntToDip(40)) / 2;
        mRecommendAdapter.setWidthAndHeight(widthAndHeight);
        final GridLayoutManager gridManager = new GridLayoutManager(getActivity(), spanCount);
        gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position) {
                    case 0:
                        return spanCount;
                    default:
                        return 1;
                }
            }
        });
        ;
        recyclerView.setLayoutManager(gridManager);
        recyclerView.setAdapter(mRecommendAdapter);
        refreshLayout.autoRefresh();
    }

    @Override
    public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
        request();
    }

    @Override
    public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
        request();
    }

    private void request() {
        NetWorkInterfaces.getRecommendList(getActivity(), this);
    }

    @Override
    public void NetWorkCall(NetWorkMsg msg) {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        switch (msg.what) {
            case EnumMsgWhat.EInterface_RecommendList:
                if (msg != null) {
                    RecommendJson mRecommendJson = (RecommendJson) msg.obj;
                    if (mRecommendJson != null) {
                        if (mRecommendJson.getCode() == 0) {
                            if (mRecommendJson.getData() != null) {
                                mRecommendAdapter.setHeaderlist(mRecommendJson.getData().getSlider(), mRecommendJson.getData().getRadioList());
                                if (mRecommendJson.getData().getSongList() != null && mRecommendJson.getData().getSongList().size() > 0) {
                                    list.clear();
                                    list.addAll(mRecommendJson.getData().getSongList());
                                    mRecommendAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                }
                break;
        }
    }
}
