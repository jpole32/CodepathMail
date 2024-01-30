package com.example.codepathmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rViewer = findViewById<RecyclerView>(R.id.emailsRv)
        val emails = EmailFetcher.getEmails()
        val adapter = EmailAdapter(emails)
        rViewer.adapter = adapter
        rViewer.layoutManager = LinearLayoutManager(this)
        val loadButton = findViewById<Button>(R.id.submit)
        loadButton.setOnClickListener {
            // Fetch next 5 emails and display in RecyclerView
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            adapter.notifyDataSetChanged()
        }
    }
}