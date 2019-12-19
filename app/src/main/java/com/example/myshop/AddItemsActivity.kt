package com.example.myshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_items.*

class AddItemsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_items)

        btn_Save.setOnClickListener {

            //get name,desc,cost
            var name = edt_name.text.toString()
            var desc = edt_desc.text.toString()
            var cost = edt_cost.text.toString()

            //sve on sql

            //get instance of the database
            Thread({
                AppDatabase.invoke(this)
                    .productsDao()
                    .insertProduct(
                        ProductItem( 0,name, cost.toInt(), desc))
            }).start()

            finish()





        }
    }


}
