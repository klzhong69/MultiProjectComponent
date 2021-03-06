package com.jaydroid.conponent_base.network.default_net;

import android.content.Context;

import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by taufiqotulfaidah on 10/30/17.
 */

public class RxUtil {

    private static final FlowableTransformer threadFlowableTransformer =
            observable -> (observable)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
    private static final ObservableTransformer threadObservableTransformer =
            observable -> (observable)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
    private static final FlowableTransformer threadTransformerWithDb =
            observable -> (observable)
                    .subscribeOn(Schedulers.newThread());
    private static Context staticContext;


    private RxUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void init(Context context) {
        staticContext = context;
    }

    @SuppressWarnings("unchecked")
    public static <T> FlowableTransformer<T, T> applyFlowableTransformer() {
        return (FlowableTransformer<T, T>) threadFlowableTransformer;
    }

    @SuppressWarnings("unchecked")
    public static <T> ObservableTransformer<T, T> applyObservableTransformer() {
        return (ObservableTransformer<T, T>) threadObservableTransformer;
    }


    @SuppressWarnings("unchecked")
    public static <T> FlowableTransformer<T, T> applyThreadTransformerWithDb() {
        return (FlowableTransformer<T, T>) threadTransformerWithDb;
    }


}
