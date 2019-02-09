package com.example.myapplication;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.InputStream;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class VirtualTour extends Fragment {

    private VrPanoramaView mVRPanoramaView1;
    private VrPanoramaView mVRPanoramaView2;
    private VrPanoramaView mVRPanoramaView3;
    private VrPanoramaView mVRPanoramaView4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.virtual_tour, container, false);
        mVRPanoramaView1 = (VrPanoramaView) view.findViewById(R.id.vrPanoramaViewTest1);
        mVRPanoramaView2 = (VrPanoramaView) view.findViewById(R.id.vrPanoramaViewTest2);
        mVRPanoramaView3 = (VrPanoramaView) view.findViewById(R.id.vrPanoramaViewTest3);
        mVRPanoramaView4 = (VrPanoramaView) view.findViewById(R.id.vrPanoramaViewTest4);
        loadPhotoSphere();

        return view;
    }

    private void loadPhotoSphere() {
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        InputStream inputStream = null;

        AssetManager assetManager = getActivity().getAssets();
        try {
            inputStream = assetManager.open("vrtest.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            mVRPanoramaView1.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
            inputStream = assetManager.open("vrtest2.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            mVRPanoramaView2.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
            inputStream = assetManager.open("vrtest3.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            mVRPanoramaView3.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
            inputStream = assetManager.open("vrtest4.jpg");
            options.inputType = VrPanoramaView.Options.TYPE_MONO;
            mVRPanoramaView4.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
