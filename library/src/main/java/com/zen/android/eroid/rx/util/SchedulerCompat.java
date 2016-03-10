package com.zen.android.eroid.rx.util;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SchedulerCompat {

    private static final Observable.Transformer computationTransformer =
            observable -> ((Observable) observable).subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread());

    private static final Observable.Transformer ioTransformer =
            observable -> ((Observable) observable).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());

    private static final Observable.Transformer newTransformer =
            observable -> ((Observable) observable).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());

    private static final Observable.Transformer trampolineTransformer =
            observable -> ((Observable) observable).subscribeOn(Schedulers.trampoline())
                    .observeOn(AndroidSchedulers.mainThread());

    private static final Observable.Transformer mainThreadTransformer =
            observable -> ((Observable) observable).observeOn(AndroidSchedulers.mainThread());

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applyComputationSchedulers() {
        return (Observable.Transformer<T, T>) computationTransformer;
    }

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applyIoSchedulers() {
        return (Observable.Transformer<T, T>) ioTransformer;
    }

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applyNewSchedulers() {
        return (Observable.Transformer<T, T>) newTransformer;
    }

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applyTrampolineSchedulers() {
        return (Observable.Transformer<T, T>) trampolineTransformer;
    }

    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> observeOnMainThread() {
        return (Observable.Transformer<T, T>) mainThreadTransformer;
    }
}
