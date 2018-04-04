package com.forthorn.thorn_core.util.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.support.annotation.NonNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by forthorn on 2018/1/5.
 * 将普通Bitmap转换成.9的Drawable
 * <p>
 * 我们的需求是将横幅广播的背景图中间部位拉伸
 * 参考文档：http://dev.qq.com/topic/57c7ff5d53bbcffd68c64411
 */

public class NinePatchUtils {

    /**
     * 拉伸横向Bitmap
     * FIXME : 本处的代码实际为拉伸中心点的代码
     *
     * @param bitmap 原bitmap
     * @return .9的Drawable
     */
    public static NinePatchDrawable convertAcross(@NonNull Bitmap bitmap) {
        int[] xRegions = new int[]{bitmap.getWidth() / 2, bitmap.getWidth() / 2 + 1};
        int[] yRegions = new int[]{bitmap.getWidth() / 2, bitmap.getWidth() / 2 + 1};
        int NO_COLOR = 0x00000001;
        int colorSize = 9;
        int bufferSize = xRegions.length * 4 + yRegions.length * 4 + colorSize * 4 + 32;
        ByteBuffer byteBuffer = ByteBuffer.allocate(bufferSize).order(ByteOrder.nativeOrder());
        // 第一个byte，要不等于0
        byteBuffer.put((byte) 1);
        //mDivX length
        byteBuffer.put((byte) 2);
        //mDivY length
        byteBuffer.put((byte) 2);
        //mColors length
        byteBuffer.put((byte) colorSize);
        //skip
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        //padding 先设为0
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        //skip
        byteBuffer.putInt(0);
        // mDivX
        byteBuffer.putInt(xRegions[0]);
        byteBuffer.putInt(xRegions[1]);
        // mDivY
        byteBuffer.putInt(yRegions[0]);
        byteBuffer.putInt(yRegions[1]);
        // mColors
        for (int i = 0; i < colorSize; i++) {
            byteBuffer.putInt(NO_COLOR);
        }
        byte[] chunk = byteBuffer.array();
        return new NinePatchDrawable(bitmap, chunk, new Rect(), null);
    }

}
