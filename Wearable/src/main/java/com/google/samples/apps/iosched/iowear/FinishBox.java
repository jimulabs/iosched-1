package com.google.samples.apps.iosched.iowear;

import android.view.View;
import android.view.animation.BounceInterpolator;

import com.google.samples.apps.iosched.R;
import com.jimulabs.mirrorsandbox.MirrorSandboxBase;
import com.jimulabs.motionkit.MirrorView;
import com.jimulabs.motionkit.MotionKit;

/**
 * Created by lintonye on 15-03-10.
 */
public class FinishBox extends MirrorSandboxBase {
    public FinishBox(View rootView) {
        super(rootView);
    }

    @Override
    public void $onLayoutDone(View view) {
        MirrorView<View> ok = v(R.id.ok);
        /*
         Start Mirror and toggle the lines below to quickly try different animations
         */
        ok.scale(0, 1).start();
//        ok.animator("rotation", 0, 180, 0).start();

//        MotionKit.together(
//                ok.scale(0, 5, 1).interpolator(new BounceInterpolator()).duration(1000),
//                ok.alpha(0, 1).duration(2000)
//        ).start();
    }

    private MirrorView<View> v(int id) {
        return new MirrorView<>(mRootView.findViewById(id));
    }
}
