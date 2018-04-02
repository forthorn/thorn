package com.forthorn.thorn_core.util.image.glideprogress;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;

import java.io.InputStream;

/**
 * Created by: Forthorn
 * Date: 3/20/2018.
 * Description:
 */

public class ProgressModelLoader implements ModelLoader<Key, InputStream> {

    @Nullable
    @Override
    public LoadData<InputStream> buildLoadData(@NonNull Key key, int width, int height, @NonNull Options options) {
        return new LoadData<InputStream>(key, new ProgressDataFetcher("", null));
    }

    @Override
    public boolean handles(@NonNull Key key) {
        return false;
    }
}
