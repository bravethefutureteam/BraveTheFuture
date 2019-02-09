//package com.example.myapplication;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.content.res.AssetManager;
//import android.graphics.BitmapFactory;
//import java.io.InputStream;
//
//import com.google.vr.sdk.widgets.pano.VrPanoramaView;
//
//public class ConnectedCampus extends Fragment {
//
//    private VrPanoramaView mVRPanoramaView1;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.campusconnected, container, false);
//        mVRPanoramaView1 = (VrPanoramaView) view.findViewById(R.id.vrPanoramaViewTest1);
//        loadPhotoSphere();
//        return view;
//    }
//    private void loadPhotoSphere() {
//        VrPanoramaView.Options options = new VrPanoramaView.Options();
//        InputStream inputStream = null;
//
//        AssetManager assetManager = getActivity().getAssets();
//        try {
//            inputStream = assetManager.open("polonsky.JPG");
//            options.inputType = VrPanoramaView.Options.TYPE_MONO;
//            mVRPanoramaView1.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
//            inputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
