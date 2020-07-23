package com.watom.ireader.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadUtil {
    private static final String TAG = "ReadUtil";

    /**
     * 获取assets目录下的图片
     *
     * @param context  上下文
     * @param fileName 文件名
     * @return Bitmap图片
     */
    public static Bitmap getImageFromAssetsFile(Context context, String fileName) {
        Bitmap bitmap = null;
        AssetManager assetManager = context.getAssets();
        try {
            InputStream is = assetManager.open(fileName);
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 获取assets目录下的单个文件
     * 这种方式只能用于webview加载
     * 读取文件夹，直接取路径是不行的
     *
     * @param context  上下文
     * @param fileName 文件夹名
     * @return File
     */
    public static File getFileFromAssetsFile(Context context, String fileName) {
        String path = "file:///android_asset/" + fileName;
        File file = new File(path);
        return file;
    }

    /**
     * 获取assets目录下所有文件
     *
     * @param context 上下文
     * @param path    文件地址
     * @return files[] 文件列表
     */
    public static String[] getFilesFromAssets(Context context, String path) {
        AssetManager assetManager = context.getAssets();
        String files[] = null;
        try {
            files = assetManager.list(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String str : files) {
            Log.v(TAG, "assets files -- " + str);
        }

        return files;
    }


    public static String getFromAssets(Context context, String fileName, String filepath, int pageSize, int startIndex) {
        String text = null;
        try {
            AssetManager assets = context.getResources().getAssets();
            InputStream is = assets.open(fileName);
            String code = getCode(is);
            is = assets.open(fileName);
            Reader reader = null;
            reader = new InputStreamReader(is, code);

            char[] container = new char[pageSize];
            reader.skip(startIndex);
            reader.read(container, 0, pageSize);
            reader.close();
            text = new String(container);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static String getFromAssets01(Context context, String fileName) {
        StringBuffer buf = new StringBuffer();
        try {
            AssetManager assets = context.getResources().getAssets();
            InputStream is = assets.open(fileName);
            String code = getCode(is);
            is = assets.open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, code));
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                buf.append(line + "\n");
                line = br.readLine();
                if (i++ == 200) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String getCode(InputStream is) {
        try {
            BufferedInputStream bin = new BufferedInputStream(is);
            int p;
            p = (bin.read() << 8) + bin.read();
            String code = null;
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                default:
                    code = "GBK";
            }
            is.close();
            return code;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
