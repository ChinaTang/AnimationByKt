package com.example.administrator.animationproject.singletone

/**
 * Created by Administrator on 2017/6/20.
 * companion object 关键字包裹着类里面可以允许静态访问的代码，包括方法和属性
 */
class SingleTone{
    companion object{
        fun get(): SingleTone{
            return test._instance
        }
    }

    private object test {
        val _instance = SingleTone()
    }
}