package com.example.esemkarestoran

import android.app.job.JobScheduler
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.esemkarestoran.databinding.ActivityLoginStaffBinding
import org.json.JSONObject

class LoginStaffActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginStaffBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginStaffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAsStaffStaff.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

  /*  private inner class postAccunt(binding: ActivityLoginStaffBinding):AsyncTask<String,String,String>(){
        override fun doInBackground(vararg p0: String?): String {
            var result=""
            var jsonObject:JSONObject()
            jsonObject.put("name")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }*/
}