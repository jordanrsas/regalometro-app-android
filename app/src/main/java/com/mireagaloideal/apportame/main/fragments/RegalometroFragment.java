package com.mireagaloideal.apportame.main.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.mireagaloideal.apportame.App;
import com.mireagaloideal.apportame.GenericFragment;
import com.mireagaloideal.apportame.R;
import com.mireagaloideal.apportame.data.RegaloFromWS;
import com.mireagaloideal.apportame.utils.Constants;
import com.mireagaloideal.apportame.utils.Preferencias;
import com.mireagaloideal.apportame.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jordán Rosas on 12/12/2017.
 */

public class RegalometroFragment extends GenericFragment {

    //@BindView(R.id.chart_progress)
    //BarChart mBarChartProgress;
    @BindView(R.id.chart_redenciones)
    PieChart mPieChartProgress;
    @BindView(R.id.regaloName)
    TextView regaloName;
    @BindView(R.id.regaloImage)
    ImageView regaloImage;
    @BindView(R.id.regaloTitle)
    TextView regaloTitle;

    private int typeDensity;
    private Typeface mTfLight;
    private RegaloFromWS regaloFromWS;

    public static RegalometroFragment newInstance() {
        RegalometroFragment fragment = new RegalometroFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_regalometro, container, false);
        mTfLight = Typeface.createFromAsset(getActivity().getAssets(), "fonts/DK_Bupkis.otf");//"fonts/Gotham/Gotham-Black.otf");
        setDisplayMetrics();
        initViews();
        return rootview;
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this, rootview);

        if (DisplayMetrics.DENSITY_HIGH == typeDensity) {
            mPieChartProgress.setCenterTextSize(15);
        }

        int[] redenciones;

        regaloFromWS = Preferencias.getInstance().getRegalo();
        if (regaloFromWS != null) {
            redenciones = new int[]{60, 100};
            regaloName.setText(regaloFromWS.getName());
            Glide.with(App.getContext()).load(regaloFromWS.getUrl_image()).placeholder(R.drawable.regalo).error(R.drawable.regalo).dontAnimate().into(regaloImage);
        } else {
            redenciones = new int[]{1, 100};
            regaloTitle.setText("Aun no eliges un regalo");
        }
        mPieChartProgress.setData(getDataPieChart(redenciones));
        initCharts();
    }

    private void initCharts() {
        mPieChartProgress.setRotationEnabled(true);
        mPieChartProgress.getDescription().setEnabled(false);
        //mPieChartBonificaciones.setExtraOffsets(5, 10, 5, 5);
        mPieChartProgress.setDragDecelerationFrictionCoef(Constants.DECELARATION_FRICTION_COEF);
        mPieChartProgress.setCenterTextTypeface(mTfLight);
        String text = regaloFromWS != null ? "$1500.00" + "\n60% del total" : "$0.00" + "\n0% del total";
        mPieChartProgress.setCenterText(generateCenterSpannableText(text));
        mPieChartProgress.setDrawHoleEnabled(true);
        mPieChartProgress.setTransparentCircleRadius(Constants.TANSPARENT_CIRCLE_RADIUS);
        mPieChartProgress.setHoleRadius(Constants.HOLE_RADIUS);
        mPieChartProgress.setDrawCenterText(true);
        mPieChartProgress.setRotationAngle(Constants.ROTATION_ANGLE_1);
        mPieChartProgress.getLegend().setEnabled(false);
        mPieChartProgress.animateY(Constants.ANIMATE_CHART_TIME, Easing.EasingOption.EaseInOutQuad);

    }

    private PieData getDataPieChart(int[] arr) {
        ArrayList<PieEntry> yVals1 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            yVals1.add(new PieEntry(arr[i], i));
        }
        //yVals1.add(new PieEntry(33,1));
        //yVals1.add(new PieEntry(67,2));

        PieDataSet data = new PieDataSet(yVals1, "");
        data.setDrawValues(false);

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
        colors.add(ContextCompat.getColor(getActivity(), R.color.colorGradient));
        data.setColors(colors);

        PieData pieData = new PieData(data);

        return pieData;
    }

    private void setDisplayMetrics() {
        DisplayMetrics metrics = new DisplayMetrics();
        typeDensity = Utils.getDensityDpi(getActivity().getWindowManager().getDefaultDisplay(), metrics);
    }

    private SpannableString generateCenterSpannableText(String text) {
        int sLength = text.length();
        int nLength = text.indexOf("\n");
        int dLength = sLength - nLength;

        SpannableString s = new SpannableString(text);
        s.setSpan(new RelativeSizeSpan(3f), 0, s.length() - dLength, 0);
        s.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)), 0, s.length() - dLength, 0);
        s.setSpan(new RelativeSizeSpan(2f), s.length() - dLength, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), s.length() - dLength, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.colorPrimary)), s.length() - dLength, s.length(), 0);
        return s;
    }

}
