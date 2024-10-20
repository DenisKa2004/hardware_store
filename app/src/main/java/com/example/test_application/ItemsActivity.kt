package com.example.test_application

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "headphones","Беспроводные наушники","Легкие и стильные наушники","Эти наушники обеспечивают высококачественное звучание и комфорт при носке. Идеальны для повседневного использования и спорта.",4999))
        items.add(Item(2, "watch","Смарт-часы","Умные часы с сенсорным экраном","Смарт-часы с широким набором функций, включая мониторинг здоровья, GPS и уведомления с вашего смартфона.",12999))
        items.add(Item(3, "keyboard","Игровая клавиатура","Механическая клавиатура для игр","Механическая клавиатура с RGB-подсветкой и программируемыми клавишами для комфортной и эффективной игры.",6999))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}