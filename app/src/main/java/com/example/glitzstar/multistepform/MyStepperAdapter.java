package com.example.glitzstar.multistepform;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class MyStepperAdapter extends AbstractFragmentStepAdapter {


    private static final String CURRENT_STEP_POSITION_KEY = "current_step_position_key";
    public MyStepperAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        try {
            final StepFragmentSample step = new StepFragmentSample();
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);
            step.setArguments(b);
            return step;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("archana", "/Exception due to" + e.toString());
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {


        StepViewModel.Builder builder = new StepViewModel.Builder(context)
                .setTitle("Multi Step Form");
        switch (position) {
            case 0:
                builder
                        .setEndButtonLabel("This way")
                        .setBackButtonLabel("Cancel")
                        .setNextButtonEndDrawableResId(R.mipmap.outline_arrow_back_ios_black_48)
                        .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
                break;
            case 1:
                builder
                        .setEndButtonLabel("Go to Summary")
                        .setBackButtonLabel("Go to first")
                        .setBackButtonStartDrawableResId(R.mipmap.outline_arrow_back_ios_black_48);
                break;
            case 2:
                builder
                        .setBackButtonLabel("Go back")
                        .setEndButtonLabel("I'm done!");
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return new StepViewModel.Builder(context)
                .setTitle("Welcome to OnTime Job") //can be a CharSequence instead
                .create();
    }
}