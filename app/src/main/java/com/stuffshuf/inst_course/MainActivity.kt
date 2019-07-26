package com.stuffshuf.inst_course

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_new.view.*

class MainActivity : AppCompatActivity() {

    val language= arrayOf<String>(
        "C","C++","Java",".Net","Kotlin","Ruby","Rails","Python","Java Script","Php","Ajax","Perl","Hadoop")


    val description= arrayOf<String>(
        "C programming is considered as the base for other programming languages",
        "C++ is an object-oriented programming language.",
        "Java is a programming language and a platform.",
        ".NET is a framework which is used to develop software applications.",
        "Kotlin is a open-source programming language, used to develop Android apps and much more.",
        "Ruby is an open-source and fully object-oriented programming language.",
        "Ruby on Rails is a server-side web application development framework written in Ruby language.",
        "Python is interpreted scripting  and object-oriented programming language.",
        "JavaScript is an object-based scripting language.",
        "PHP is an interpreted language, i.e., there is no need for compilation.",
        "AJAX allows you to send and receive data asynchronously without reloading the web page.",
        "Perl is a cross-platform environment used to create network and server-side applications.",
        "Hadoop is an open source framework from Apache written in Java."
    )

    val image= arrayOf<Int>(
     R.drawable.c,
        R.drawable.cplus,
        R.drawable.java,
        R.drawable.dot_net,
        R.drawable.kotlin,
        R.drawable.ruby,
        R.drawable.rails,
        R.drawable.python,
        R.drawable.java,
        R.drawable.js,
        R.drawable.php,
        R.drawable.ajax,
        R.drawable.perl,
        R.drawable.hadoop

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myCustomAdapter=MyCustomAdaptor(this, language, description, image)
        lvView.adapter=myCustomAdapter

        lvView.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this,
                "Clicked On $position : ${view.tvLang.text}",
                Toast.LENGTH_LONG).show()

        }


    }



    class MyCustomAdaptor(val context: Context, val lang:Array<String>, val desc:Array<String>, val img:Array<Int>):BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


            val layoutInflater=LayoutInflater.from(context)
            val textView=layoutInflater.inflate(R.layout.list_new, parent, false)


           textView.imgView.setImageResource(img[position])

            val textlang=lang[position]
            val textdesc=desc[position]


            textView.tvLang.text=textlang
            textView.tvDesc.text=textdesc


            return textView
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return lang.size
        }
    }
}
