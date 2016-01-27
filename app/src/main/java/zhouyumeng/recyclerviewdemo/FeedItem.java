package zhouyumeng.recyclerviewdemo;

/**
 * Created by yumengz on 1/27/16.
 */

import java.util.ArrayList;

/**
 * Created by yumengz on 1/25/16.
 */
public class FeedItem {
    public ArrayList<String> myList=new ArrayList<>();

    public void setMyList(ArrayList<String> myList) {
        this.myList = myList;
    }

//    private String title;
//    private String thumbnail;
//    public String getTitle(){return this.title;}
//    public void setTitle(String title){this.title=title;}
//    public String getThumbnail() {return this.thumbnail;}
//    public void setThumbnail(String thumbnail) {this.thumbnail=thumbnail;}

    public String getTitle() {
        return myList.get(0);
    }

    public void setTitle(String title) {
        this.myList.add(0,title);
    }

    public String getThumbnail() {
        return myList.get(1);
    }

    public void setThumbnail(String thumbnail) {
        this.myList.add(1,thumbnail);
    }
}
