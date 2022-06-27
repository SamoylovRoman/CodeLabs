package com.codelabs.javarx_base_2

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.codelabs.javarx_base_2.databinding.ActivityMainBinding
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.RxThreadFactory
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding

    private val disposeBag = CompositeDisposable()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()

/*        val result: Disposable = Observable.just(1, 2, 3, 4, 5, 6)
            .delay(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "value is - $it")
            }, {

            })*/

        // map
/*        val result: Disposable = Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля")
            .map {
                if (it.lowercase().contains('а')) {
                    "$it Нефрология"
                } else {
                    "$it Кардиология"
                }
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "it - $it")
            }, {

            })*/

        //flatMap
/*        val result: Disposable = Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля")
            .flatMap {
                val delay = Random.nextInt(10)
                Log.d(TAG, "delay $delay")
                Observable.just(it).delay(delay.toLong(), TimeUnit.SECONDS)
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "it - $it")
            }, {

            })*/

        //switchMap
/*        val result: Disposable = Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля")
            .switchMap {
                val delay = Random.nextInt(10)
                Log.d(TAG, "delay $delay")
                Observable.just(it).delay(delay.toLong(), TimeUnit.SECONDS)
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "it - $it")
            }, {

            })*/

        //concatMap
/*        val result: Disposable = Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля")
            .concatMap {
                val delay = Random.nextInt(10)
                Log.d(TAG, "delay $delay")
                Observable.just(it).delay(delay.toLong(), TimeUnit.SECONDS)
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "it - $it")
            }, {

            })*/

        //buffer
/*        val result: Disposable = Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася")
            .buffer(2)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "count ${it.count()}")
                it.forEach {
                    Log.d(TAG, "it - $it")
                }
            }, {

            })*/

        //groupBy
/*        val result: Disposable =
            Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася")
                .groupBy {
                    it.lowercase().contains("о")
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ groupedObs ->
                    Log.d(TAG, "key =  ${groupedObs.key}")
*//*                    it.forEach {
                        Log.d(TAG, "value =  $it")
                    }*//*
                    val disp = groupedObs.subscribeOn(Schedulers.trampoline())
                        .subscribe { name ->
                            Log.d(TAG, "value =  $name")
                        }
                }, {

                })*/

        //scan
/*        val result: Disposable =
            Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася")
                .scan { t1, t2 ->
                    "$t1 $t2"
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "result $it")
                }, {

                })*/

        //debounce
/*        val result: Disposable =
            Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася")
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "result $it")
                }, {

                })*/

        //distinct
/*        val result: Disposable =
            Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася", "Рома", "Ваня")
                .distinct()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "result $it")
                }, {

                })*/

        //filter
/*        val result: Disposable =
            Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася", "Рома", "Ваня")
                .filter {
                    it.contains("о")
                }
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "result $it")
                }, {

                })*/

        //elementAt
/*        val result: Disposable =
            Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася", "Рома", "Ваня")
                .elementAt(3)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "result $it")
                }, {

                })*/

        //ignoreElements
        Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася", "Рома", "Ваня")
            .ignoreElements()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete {
                Log.d(TAG, "Completed") // doesn't call
            }

        //sample
/*        val result =
            Observable.create<String> { emmiter ->
                (0..7).forEach {
                    emmiter.onNext(it.toString())
                    Thread.sleep(400)
                }
            }
                .delay(600, TimeUnit.MILLISECONDS)
                .sample(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "result $it")
                }, {

                })*/

        //skip, skipLast, take, takeLast
        val result: Disposable =
            Observable.just("Ваня", "Петя", "Вова", "Степа", "Рома", "Коля", "Вася", "Рома", "Ваня")
//                .skip(3)
//                .skipLast(3)
//                .take(3)
                .takeLast(4)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "result $it")
                }, {

                })

        disposeBag.add(result)

/*        Handler().postDelayed({
            Log.d(TAG, "Disposed")
            result.dispose()
        }, 4000)*/
    }

    private fun initListeners() {
/*        RxTextView.textChanges(binding.inputText)
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(rx.schedulers.Schedulers.newThread())
            .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, it.toString())
            }*/
        binding.inputText.textChanges()
            .debounce(700, TimeUnit.MILLISECONDS)
            .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.newThread())
            .observeOn(io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, it.toString())
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposeBag.clear()
    }


}