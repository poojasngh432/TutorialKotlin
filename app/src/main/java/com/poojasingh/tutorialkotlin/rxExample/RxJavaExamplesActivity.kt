package com.poojasingh.tutorialkotlin.rxExample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.poojasingh.tutorialkotlin.R
import com.poojasingh.tutorialkotlin.data.model.Items
import com.poojasingh.tutorialkotlin.data.model.Repo
import com.sun.tools.javac.comp.Todo
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class RxJavaExamplesActivity : AppCompatActivity() {

    /**
     * Observable{ //The work you need to do
    }
    .subscribeOn(Schedulers.io) //thread you need the work to perform on
    .observeOn(AndroidSchedulers.mainThread()) //thread you need to handle the result on
    .subscribeWith(Observer{
    //handle the result here
    })
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java_examples)

        val animals = ArrayList<String>()
        animals.add("Tiger")
        animals.add("Lion")
        animals.add("Elephant")

        Observable.just(animals)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<ArrayList<String>> {
                override fun onNext(arrayList: ArrayList<String>) {
                    //handling the result
//                    adapter.updateList(animals)
//                    adapter.notifyDataSetChanged()
                }

                override fun onError(e: Throwable) {
                    //error handling made simple
                }

                override fun onComplete() {
                    //cleaning up tasks
                }

                override fun onSubscribe(d: Disposable) {

                }
            })


    }

    fun exampleUses() {
        val todoObservable: Observable<Items?>? = Observable.create(
            ObservableOnSubscribe<Items?> { emitter: ObservableEmitter<Items?> ->
                try {
                    val items: List<Items>? = getTodos()
                    if (items != null) {
                        for (item in items) {
                            emitter.onNext(item)
                        }
                    }
                    emitter.onComplete()
                } catch (e: Exception) {
                    emitter.onError(e)
                }
            })

        //Using Lambdas
        val todoObservable2: Observable<Items?>? = Observable.create(
            ObservableOnSubscribe<Items?> { emitter: ObservableEmitter<Items?> ->
                try {
                    val todos: List<Items>? = getTodos()
                    if (todos != null) {
                        for (todo in todos) {
                            emitter.onNext(todo)
                        }
                    }
                    emitter.onComplete()
                } catch (e: java.lang.Exception) {
                    emitter.onError(e)
                }
            })

        //Crybaby
        val todoMaybe: Maybe<List<Items>?>? =
            Maybe.create(MaybeOnSubscribe<List<Items>?> { emitter: MaybeEmitter<List<Items>?> ->
                try {
                    val todos: List<Items>? = getTodos()
                    if (todos != null && !todos.isEmpty()) {
                        emitter.onSuccess(todos)
                    } else {
                        emitter.onComplete()
                    }
                } catch (e: java.lang.Exception) {
                    emitter.onError(e)
                }
            })


    }

    private fun getTodos(): List<Items>? {
        val result: List<Items>? = null
        return result
    }

}