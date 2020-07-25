package com.t3h.mp3music.ui.screen;

import com.t3h.mp3music.models.BaseModel;
import com.t3h.mp3music.ui.base.BaseBindingAdapter;

public interface MediaListener<T extends BaseModel>
        extends BaseBindingAdapter.BaseBindingListener {
    void onItemMediaClicked(T item);
}
