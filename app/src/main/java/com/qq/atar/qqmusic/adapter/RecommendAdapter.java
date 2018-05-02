package com.qq.atar.qqmusic.adapter;

import android.activity.CommonActivity;
import android.adapter.CommonRecyclerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.utils.ScreenUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qq.atar.qqmusic.R;
import com.qq.atar.qqmusic.moudle.RecommendJson;
import com.qq.atar.qqmusic.moudle.RecommendJson.SongBean;
import com.qq.atar.qqmusic.moudle.SliderBean;
import com.qq.atar.qqmusic.utils.NumberUtils;
import com.qq.atar.qqmusic.utils.ViewPagerIndicatorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Atar on 2018/4/24.
 */

public class RecommendAdapter extends CommonRecyclerAdapter<SongBean> {
    private final int ITEM_TYPE_HEADER = 0;
    private List<SliderBean> headerlist = new ArrayList<SliderBean>();
    private BannerAdapter mBannerAdapter = new BannerAdapter(headerlist);
    private int columnWidth;
    private List<RecommendJson.RadioListBean> radioList = new ArrayList<RecommendJson.RadioListBean>();

    public void setWidthAndHeight(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public RecommendAdapter(List list) {
        super(list);
    }

    public void setHeaderlist(List<SliderBean> headerlist, List<RecommendJson.RadioListBean> radioList) {
        if (headerlist != null && headerlist.size() > 0) {
            this.headerlist.clear();
            this.headerlist.addAll(headerlist);
        }
        if (radioList != null && radioList.size() > 0) {
            this.radioList.clear();
            this.radioList.addAll(radioList);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return position == 0 ? ITEM_TYPE_HEADER : 1;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        setContext(parent.getContext());
        switch (viewType) {
            case ITEM_TYPE_HEADER:
                return new ViewHolderHeader(LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.adapter_recommend_header_item, parent,
                        false));
            default:
                return new ViewHolder(LayoutInflater.from(
                        parent.getContext()).inflate(R.layout.adapter_recommend_item, parent,
                        false));
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            mBannerAdapter.notifyDataSetChanged();
            ((ViewHolderHeader) holder).view_pager_header.setAdapter(mBannerAdapter);
            ViewPagerIndicatorUtils.initIndicator(getContext(), headerlist.size(), ((ViewHolderHeader) holder).view_pager_header, ((ViewHolderHeader) holder).ad_indicator);
            if (radioList != null && radioList.size() > 1) {
                ((CommonActivity) getContext()).LoadImageView(radioList.get(0).getPicUrl(), ((ViewHolderHeader) holder).img_left, 0, null, 0);
                ((CommonActivity) getContext()).LoadImageView(radioList.get(1).getPicUrl(), ((ViewHolderHeader) holder).img_right, 0, null, 0);
                ((ViewHolderHeader) holder).txt_left.setText(radioList.get(0).getFtitle());
                ((ViewHolderHeader) holder).txt_right.setText(radioList.get(1).getFtitle());
            }
        } else {
            final int newPosition = position - 1;
            int padding = (int) ScreenUtils.getIntToDip(5);
            if (newPosition % 2 == 0) {
                ((ViewHolder) holder).itemView.setPadding(3 * padding, 0, 0, 2 * padding);
            } else {
                ((ViewHolder) holder).itemView.setPadding(padding, 0, 0, 2 * padding);
            }

            SongBean info = getList().get(newPosition);
            ((ViewHolder) holder).txt_title.setText(info.getSongListDesc());
            ((ViewHolder) holder).txt_athor.setText(info.getSongListAuthor());
            ((ViewHolder) holder).txt_accessnum.setText("试听:" + NumberUtils.formatTosepara(info.getAccessnum()));
            ((CommonActivity) getContext()).LoadImageView(info.getPicUrl(), ((ViewHolder) holder).img_song_pic, 0, null, 0);
        }
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {
        ViewPager view_pager_header;
        LinearLayout ad_indicator;
        ImageView img_left, img_right;
        TextView txt_left, txt_right;
        View itemView;

        public ViewHolderHeader(View itemView) {
            super(itemView);
            this.itemView = itemView;
            view_pager_header = (ViewPager) itemView.findViewById(R.id.view_pager_header);
            ad_indicator = (LinearLayout) itemView.findViewById(R.id.ad_indicator);
            img_left = (ImageView) itemView.findViewById(R.id.img_left);
            img_right = (ImageView) itemView.findViewById(R.id.img_right);
            txt_left = (TextView) itemView.findViewById(R.id.txt_left);
            txt_right = (TextView) itemView.findViewById(R.id.txt_right);
            ViewPagerIndicatorUtils.setAutoPlay(view_pager_header);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(columnWidth, columnWidth);
            img_left.setLayoutParams(lp);
            RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(columnWidth, columnWidth);
            lp1.addRule(RelativeLayout.RIGHT_OF, R.id.view_center);
            img_right.setLayoutParams(lp1);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_song_pic, img_play;
        TextView txt_title, txt_athor, txt_accessnum;

        public ViewHolder(View itemView) {
            super(itemView);
            img_song_pic = (ImageView) itemView.findViewById(R.id.img_song_pic);
            img_play = (ImageView) itemView.findViewById(R.id.img_play);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_athor = (TextView) itemView.findViewById(R.id.txt_athor);
            txt_accessnum = (TextView) itemView.findViewById(R.id.txt_accessnum);
            img_song_pic.setLayoutParams(new RelativeLayout.LayoutParams(columnWidth, columnWidth));
        }
    }
}
