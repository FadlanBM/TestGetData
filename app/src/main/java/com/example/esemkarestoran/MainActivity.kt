package com.example.esemkarestoran

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.esemkarestoran.Util.BaseApi
import com.example.esemkarestoran.databinding.ActivityMainBinding
import org.json.JSONObject
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Stream

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAsCustomerLogin.setOnClickListener {
            startActivity(Intent(this,LoginStaffActivity::class.java))
        }
        binding.btnLoginLogin.setOnClickListener {
            postAccunt(binding).execute()
        }

    }

    private  inner class postAccunt(binding: ActivityMainBinding):AsyncTask<String,String,String>(){

        override fun doInBackground(vararg p0: String?): String {
            var result=""
            var jsonObject=JSONObject()
            jsonObject.put("email",binding.lbEmailLogin.text)
            jsonObject.put("password",binding.tbPasswordLogin.text)
            var jsonObjectString=jsonObject.toString()
            Log.e("GetList",jsonObjectString)
            var httpURLConnection:HttpURLConnection?=null
            try {
                var url=URL("https://192.168.2.129:5001/Api/Auth")
                httpURLConnection=url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod="POST"
                httpURLConnection.setRequestProperty("Content-Type","application/json")
                httpURLConnection.setRequestProperty("Accept","text/plain")

                var outputStream=httpURLConnection.outputStream
                var outputStreamWriter=OutputStreamWriter(outputStream)
                outputStreamWriter.write(jsonObjectString)
                outputStreamWriter.flush()

                var inputStream=httpURLConnection.inputStream
                var inputStreamReader=InputStreamReader(inputStream)
                var data=inputStreamReader.read()

                Log.e("ErrorData",data.toString())
                while (data!=-1){
                    result+=data.toChar()
                    data=inputStreamReader.read()
                }

                var jsonresult=JSONObject(result)
                Log.e("DataToken",jsonresult.toString())

            }catch (e:Exception){
                Log.e("Error Http","Error $e")
            }
            return result
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }
}