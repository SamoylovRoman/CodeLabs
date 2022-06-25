package com.codelabs.javarx_base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import com.codelabs.javarx_base.databinding.ActivityMainBinding
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.mainText
        setContentView(binding.root)

/*        val dispose = dataSource()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                binding.mainText.text = "Next int $it"
                Log.d(TAG, "next int $it")
            }, {

            }, {

            })*/

/*        val disposeSingle = dataSourceSingle()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "List from dataSourceSingle:\n ${it.toString()}")
                binding.mainText.text = "$it"
            }, {
                Log.d(TAG, "${it.message}")
                binding.mainText.text = "${it.message}"
            })*/

/*        val disposeCompletable = dataSourceCompletable()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "result success")
                binding.mainText.text = "result success"
            }, {
                Log.d(TAG, "${it.message}")
                binding.mainText.text = "${it.message}"
            })*/

        val disposeSingle = dataSourceMayBe()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "List from dataSourceMayBe:\n ${it.toString()}")
                binding.mainText.text = "$it"
            }, {
                Log.d(TAG, "${it.message}")
                binding.mainText.text = "${it.message}"
            }, {
                Log.d(TAG, "result complete")
                binding.mainText.text = "result complete"
            })


        binding.buttonText.setOnClickListener {
            Log.d(TAG, "click click")
        }
    }

/*    private fun dataSource(): Observable<Int> {
        return Observable.create { subscriber ->
            for (i in 0..100) {
                Thread.sleep(3000)
                subscriber.onNext(i)
            }
        }
    }*/

    private fun dataSourceFlowable(): Flowable<Int> {
        return Flowable.create({ subscriber ->
            for (i in 0..100000) {
//                Thread.sleep(10)
                subscriber.onNext(i)
            }
            subscriber.onComplete()
        }, BackpressureStrategy.LATEST)
    }

    private fun dataSourceSingle(): Single<List<Int>> {
        return Single.create { subscriber ->
            val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
//            subscriber.onSuccess(list)
            subscriber.onError(Throwable("Error in dataSourceCompletable"))
        }
    }

    private fun dataSourceCompletable(): Completable {
        return Completable.create { subscriber ->
            val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
//            subscriber.onComplete()
            subscriber.onError(Throwable("Error in dataSourceCompletable"))
        }
    }

    private fun dataSourceMayBe(): Maybe<List<Int>> {
        return Maybe.create { subscriber ->
            val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
            subscriber.onSuccess(list)
            subscriber.onComplete()
        }
    }
}

