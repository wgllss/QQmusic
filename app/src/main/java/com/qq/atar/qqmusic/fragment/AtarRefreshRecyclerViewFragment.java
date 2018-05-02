package com.qq.atar.qqmusic.fragment;


import android.common.CommonHandler;
import android.fragment.CommonFragment;
import android.interfaces.NetWorkCallListener;
import android.os.Bundle;
import android.reflection.NetWorkMsg;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qq.atar.qqmusic.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AtarRefreshRecyclerViewFragment extends CommonFragment implements OnRefreshListener, OnLoadMoreListener, NetWorkCallListener {
    private View rootView;
    @Bind(R.id.refreshLayout)
    RefreshLayout refreshLayout;
    @Bind(R.id.rv_recyclerview_data)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_atar_refresh_recycler_view, container, false);
            ButterKnife.bind(this, rootView);
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
    }

    @Override
    public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
    }

    @Override
    public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
    }

    @Override
    public void NetWorkCall(NetWorkMsg msg) {

    }
}
