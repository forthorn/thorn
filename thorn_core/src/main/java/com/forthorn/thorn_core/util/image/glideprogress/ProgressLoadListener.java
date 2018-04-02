package com.forthorn.thorn_core.util.image.glideprogress;

/**
 * 通知图片加载进度
 * modified by soulrelay
 */
public interface ProgressLoadListener {

    void update(int bytesRead, int contentLength);

    void onException();

    void onResourceReady();
}
