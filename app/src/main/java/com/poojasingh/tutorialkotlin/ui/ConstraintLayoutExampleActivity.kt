package com.poojasingh.tutorialkotlin.ui

import android.animation.*
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.ui.customviews.*


class ConstraintLayoutExampleActivity : AppCompatActivity() {
    lateinit var pulsatingLayout: CustomPulsatingLayout
    lateinit var imageView: ImageView
    lateinit var shareIV: ImageView
    lateinit var customView: RoundedCornerRectCustomView
    lateinit var customView2: RoundedCornerCustomView2
    lateinit var clBounce: ConstraintLayout
    lateinit var animSquareToCircleCV: SquareToCircleCV
    lateinit var morphView: MorphView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout_example)

        pulsatingLayout = findViewById(R.id.ripple)
        imageView = findViewById(R.id.iv_bounce)
        customView = findViewById(R.id.custom_view_one)
        customView2 = findViewById(R.id.custom_view)
        //clBounce = findViewById(R.id.cl_bounce)
        animSquareToCircleCV = findViewById(R.id.anim_square_circle)
        morphView = findViewById(R.id.morphView)
        shareIV = findViewById(R.id.ic_share)

        pulsatingLayout.startAnimation()

        val myAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce_anim)
        val interpolator = MyBounceInterpolator(0.2, 10.0)
        myAnim.interpolator = interpolator
        imageView.startAnimation(myAnim)
        customView.startAnimation(myAnim)
        customView2.startAnimation(myAnim)
        //clBounce.startAnimation(myAnim)

        animSquareToCircleCV.startAnimation()

        //glowing button effect

        //glowing button effect
        val relativelayout = findViewById<View>(R.id.relative_layout_id) as RelativeLayout

        val fadeOut = ObjectAnimator.ofFloat(relativelayout, "alpha", .5f, .1f)
        fadeOut.duration = 300
        val fadeIn = ObjectAnimator.ofFloat(relativelayout, "alpha", .1f, .5f)
        fadeIn.duration = 300

        val mAnimationSet = AnimatorSet()
        mAnimationSet.play(fadeIn).after(fadeOut)

        mAnimationSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                mAnimationSet.start()
            }
        })

        mAnimationSet.start()

        //shareIV.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_share, null));

        val myAnim2 = AnimationUtils.loadAnimation(
            this,
            R.anim.bounce_anim
        )
        val interpolator2 = MyBounceInterpolator(0.2, 20.0)
        myAnim2.interpolator = interpolator2
        shareIV.startAnimation(myAnim2)

        myAnim2.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                shareIV.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_share, null));
                Log.d("TEST", "onAnimationStart")
            }

            override fun onAnimationEnd(animation: Animation) {
//                shareIV.setImageDrawable(
//                    ResourcesCompat.getDrawable(
//                        resources,
//                        R.drawable.ic_share_filled_green,
//                        null
//                    )
//                )
                Handler().postDelayed({
                    shareIV.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_share_filled_green,
                            null
                        )
                    )
                }, 1000)
                shareIV.startAnimation(myAnim2)
                Log.d("TEST", "onAnimationEnd")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Handler().postDelayed({
                    shareIV.setImageDrawable(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.ic_share_filled_green,
                            null
                        )
                    )
                }, 1000)
                Log.d("TEST", "onAnimationRepeat")
            }
        })

    }

    override fun onResume() {
        super.onResume()

        morphView.showAvdFirst()
//        morphView.morph()
        //        morphView.showAvdSecond()
    }
}
