package com.qq.atar.qqmusic.moudle;

import java.util.List;

/**
 * Created by Atar on 2018/4/24.
 */

public class RecommendJson extends CommonResult<RecommendJson.RecommendData> {
    public class RecommendData {
        private List<SliderBean> slider;
        private List<RadioListBean> radioList;
        private List<SongBean> songList;


        public List<SliderBean> getSlider() {
            return slider;
        }

        public void setSlider(List<SliderBean> slider) {
            this.slider = slider;
        }

        public List<RadioListBean> getRadioList() {
            return radioList;
        }

        public void setRadioList(List<RadioListBean> radioList) {
            this.radioList = radioList;
        }

        public List<SongBean> getSongList() {
            return songList;
        }

        public void setSongList(List<SongBean> songList) {
            this.songList = songList;
        }
    }

    public class RadioListBean {
        private String picUrl;
        private String Ftitle;
        private int radioid;

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getFtitle() {
            return Ftitle;
        }

        public void setFtitle(String ftitle) {
            Ftitle = ftitle;
        }

        public int getRadioid() {
            return radioid;
        }

        public void setRadioid(int radioid) {
            this.radioid = radioid;
        }
    }

    public class SongBean {
        private String songListDesc;
        private String picUrl;
        private String id;
        private long accessnum;
        private String songListAuthor;
        private String pic_mid;

        public String getSongListDesc() {
            return songListDesc;
        }

        public void setSongListDesc(String songListDesc) {
            this.songListDesc = songListDesc;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getAccessnum() {
            return accessnum;
        }

        public void setAccessnum(int accessnum) {
            this.accessnum = accessnum;
        }

        public String getSongListAuthor() {
            return songListAuthor;
        }

        public void setSongListAuthor(String songListAuthor) {
            this.songListAuthor = songListAuthor;
        }

        public String getPic_mid() {
            return pic_mid;
        }

        public void setPic_mid(String pic_mid) {
            this.pic_mid = pic_mid;
        }
    }
}
